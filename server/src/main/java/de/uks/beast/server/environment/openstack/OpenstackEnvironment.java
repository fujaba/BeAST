package de.uks.beast.server.environment.openstack;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openstack4j.api.Builders;
import org.openstack4j.api.OSClient;
import org.openstack4j.model.compute.Flavor;
import org.openstack4j.model.compute.Keypair;
import org.openstack4j.model.identity.Tenant;
import org.openstack4j.model.network.AttachInterfaceType;
import org.openstack4j.model.network.IPVersionType;
import org.openstack4j.model.network.Network;
import org.openstack4j.model.network.Router;
import org.openstack4j.model.network.Subnet;
import org.openstack4j.openstack.OSFactory;

import de.uks.beast.model.Hardware;
import de.uks.beast.server.BeastService;
import de.uks.beast.server.environment.CloudEnvironment;
import de.uks.beast.server.environment.model.Configuration;
import de.uks.beast.server.environment.model.ConnectionInfo;
import de.uks.beast.server.environment.model.OpenstackConfiguration;
import de.uks.beast.server.service.model.ServiceInfo;

public class OpenstackEnvironment extends CloudEnvironment {

	private static final Logger logger = LogManager.getLogger(OpenstackEnvironment.class);
	
	private OSClient os;
	private Object floatingIPLock = new Object();

	public OpenstackEnvironment(BeastService service) {
		super(service);
	}

	/**
	 * Authenticate
	 * Authorized OSClient allows you to invoke Compute, Identity, Neutron operations.
	 * Version 2 Authentication.
	 * @return
	 */
	@Override
	public boolean authenticate() {
		logger.info("Authentication against keystone ...");
		try {
			this.os = OSFactory.builder()
					.endpoint(service.get("keystone"))
					.credentials(service.get("user"), service.get("password"))
					.tenantName(service.get("tenantName"))
					.authenticate();
		} catch (Exception e) {
			if (e.getMessage().equals("java.net.ConnectException: Connection refused")) {
				logger.error("Could not connect to keystone", e);
			}
			return false;
		}
		
		logger.info("Authenthication successfull");
		return true;
	}


	/**
	 * Setup the virtual networks and servers
	 * @param hwconf
	 * @return
	 */
	public List<? extends Configuration> createHardwareDefiniton(Hardware hwconf) {
		List<OpenstackConfiguration> configs = new ArrayList<OpenstackConfiguration>();

		for (de.uks.beast.model.Network network : hwconf.getNetworks()) {
			
			Network openstacknetwork = getOrCreateNetwork(network);
			
			for (de.uks.beast.model.Server server : network.getServers()) {
				String flavorID = "";
				boolean flavorExists = false;

				for (Flavor flavor : os.compute().flavors().list()) {
					if (flavor.getName().equals(server.buildFlavor())) {
						flavorExists = true;
						flavorID = flavor.getId();
						logger.info("Using flavor with name " + server.buildFlavor() + " (" + flavorID + ")");
					}
				}
				
				if (!flavorExists) {
					Flavor f = Builders.flavor()
							.name(server.buildFlavor())
							.ram(server.getRam())
							.vcpus(server.getCpu())
							.disk(server.getDiskSpace())
							.rxtxFactor(1.0f)
							.build();
					os.compute().flavors().create(f);
					
					for (Flavor flavor : os.compute().flavors().list()) {
						if (flavor.getName().equals(server.buildFlavor())) {
							flavorID = flavor.getId();
						}
					}
					
					logger.info("Created new Flavor with name " + server.buildFlavor()
							+ " (" + flavorID + ")");
				}
				
				OpenstackConfiguration config = new OpenstackConfiguration(openstacknetwork.getId(), flavorID, server);
				
				if (server.getService() != null) {
					config.setServiceInfo(new ServiceInfo(server.getService()));
				}
				
				configs.add(config);
			}
			
		}
		
		return configs;
	}

	@Override
	public List<String> startVirtualMachine(List<? extends Configuration> configs) {
		logger.info("Creating keypair for VM(s) ...");
		
		os.compute().keypairs().delete("beast-keypair");
		Keypair kp = os.compute().keypairs().create("beast-keypair", null);
		System.out.println(kp.getPrivateKey());
		
		final CountDownLatch latch = new CountDownLatch(configs.size());
		
		for (Configuration configuration : configs) {
			OpenstackInstanceBootAction bootAction = new OpenstackInstanceBootAction((OpenstackConfiguration) configuration, kp, service, 
					os.getAccess(), latch, floatingIPLock);
		
			bootAction.start();
		}
		
		try {
			latch.await(); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		logger.info("All instances started successfully");
		
		return null; //TODO
	}
	
	@Override
	public void establishConnection(String kafkabroker, String topic, List<? extends Configuration> configs) {
		final CountDownLatch latch = new CountDownLatch(configs.size());
		
		for (Configuration configuration : configs) {
			OpenstackInstanceConnectAction connectAction = new OpenstackInstanceConnectAction(service.getRemoteLogger(), configuration.getConnectionInfo(), 
					kafkabroker, topic, getConnectionInfos(configs), latch);
			
			connectAction.start();
		}
		
		try {
			latch.await(); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void shutdownAll() {
		//os.compute().servers().delete(serverId)
	}

	@Override
	public boolean isAuthenticated() {
		return os != null;
	}
	
	
	/*
	 * helper methods
	 */
	
	private Network getOrCreateNetwork(de.uks.beast.model.Network network) {
		List<? extends Network> existing = os.networking().network().list();
		
		Network openstacknetwork = null;
		for (Network n : existing) {
			if (n.getName().equals(network.getName())) {
				openstacknetwork = n;
			}
		}
		
		if (openstacknetwork == null) {

			String tenantId = "";
			for (Tenant tenant : os.identity().tenants().list()) {
				if (tenant.getName().equals(service.get("tenantName"))) {
					tenantId = tenant.getId();
				}
			}
					
			openstacknetwork = os.networking().network().create(
					Builders.network()
						.name(network.getName())
						.tenantId(tenantId)
						.adminStateUp(true)
						.build());
			
			try {
				Subnet subnet = os.networking().subnet().create(
						Builders.subnet()
							.name(network.getName() + "-subnet")
							.tenantId(tenantId)
							.gateway(network.getGateway())
							.networkId(openstacknetwork.getId())
							.addPool(getStartOfPool(network.getIp()), getEndOfPool(network.getIp()))
							.addDNSNameServer(network.getDns())
							.ipVersion(IPVersionType.V4)
							.cidr(network.getIp() + "/" + 
									convertNetmaskToCIDR(InetAddress.getByName(network.getSubnetmask())))
							.enableDHCP(true)
							.build());
				
				Router router = os.networking().router().create(
						Builders.router()
							.name(network.getName() + "-router")
							.adminStateUp(true)
							.externalGateway(service.get("external-net"))
							.build());
				
				os.networking().router().attachInterface(router.getId(), AttachInterfaceType.SUBNET, subnet.getId());
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			
		}
		
		return openstacknetwork;
	}
	
	private List<ConnectionInfo> getConnectionInfos(List<? extends Configuration> configs) {
		List<ConnectionInfo> infos = new ArrayList<ConnectionInfo>();
		
		for (Configuration config : configs) {
			infos.add(config.getConnectionInfo());
		}
		
		return infos;
	}
	
	private static String getStartOfPool(String ip) {
		return ip.substring(0, ip.lastIndexOf(".")) + ".2";
	}
	
	private static String getEndOfPool(String ip) {
		return ip.substring(0, ip.lastIndexOf(".")) + ".254";
	}
	
	public static int convertNetmaskToCIDR(InetAddress netmask){
        byte[] netmaskBytes = netmask.getAddress();
        int cidr = 0;
        boolean zero = false;
        for(byte b : netmaskBytes){
            int mask = 0x80;

            for(int i = 0; i < 8; i++){
                int result = b & mask;
                if(result == 0){
                    zero = true;
                }else if(zero){
                    throw new IllegalArgumentException("Invalid netmask.");
                } else {
                    cidr++;
                }
                mask >>>= 1;
            }
        }
        return cidr;
    }

}
