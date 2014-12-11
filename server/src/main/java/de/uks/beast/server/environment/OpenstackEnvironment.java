package de.uks.beast.server.environment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openstack4j.api.Builders;
import org.openstack4j.api.OSClient;
import org.openstack4j.model.compute.Flavor;
import org.openstack4j.model.compute.FloatingIP;
import org.openstack4j.model.compute.Keypair;
import org.openstack4j.model.compute.Server;
import org.openstack4j.model.compute.Server.Status;
import org.openstack4j.model.compute.ServerCreate;
import org.openstack4j.model.network.NetFloatingIP;
import org.openstack4j.model.network.Network;
import org.openstack4j.openstack.OSFactory;

import de.uks.beast.model.Hardware;
import de.uks.beast.server.BeastService;
import de.uks.beast.server.environment.model.Configuration;
import de.uks.beast.server.environment.model.ConnectionInfo;
import de.uks.beast.server.environment.model.OpenstackConnectionInfo;
import de.uks.beast.server.environment.model.OpenstackConfiguration;
import de.uks.beast.server.vm.OpenstackConnection;

public class OpenstackEnvironment implements BeastEnvironment {

	private static final Logger logger = LogManager.getLogger(OpenstackEnvironment.class);
	
	private OSClient os;
	private final BeastService service;

	public OpenstackEnvironment(BeastService service) {
		this.service = service;
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
					.credentials(service.get("admin"), service.get("password"))
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
					if (flavor.getName().equals("b1." + server.getFlavor())) {
						flavorExists = true;
						flavorID = flavor.getId();
						logger.info("Using flavor with name b1." + server.getFlavor() + " (" + flavorID + ")");
					}
				}
				
				if (!flavorExists) {
					Flavor f = Builders.flavor()
							.name("b1." + server.getFlavor())
							.ram(server.getRam())
							.vcpus(server.getCpu())
							.disk(server.getDiskSpace())
							.rxtxFactor(1.0f)
							.build();
					os.compute().flavors().create(f);
					
					for (Flavor flavor : os.compute().flavors().list()) {
						if (flavor.getName().equals("b1." + server.getFlavor())) {
							flavorID = flavor.getId();
						}
					}
					
					logger.info("Created new Flavor with name b1." + server.getFlavor()
							+ " (" + flavorID + ")");
				}
				configs.add(new OpenstackConfiguration(openstacknetwork.getId(), flavorID, server));
			}
			
		}
		
		return configs;
	}

	@Override
	public ArrayList<? extends ConnectionInfo> startVirtualMachine(List<? extends Configuration> configs) {
		ArrayList<OpenstackConnectionInfo> cons = new ArrayList<OpenstackConnectionInfo>();
		
		logger.info("Creating keypair for VM(s) ...");
		
		os.compute().keypairs().delete("beast-keypair");
		Keypair kp = os.compute().keypairs().create("beast-keypair", null);
		
		for (Configuration configuration : configs) {
			OpenstackConfiguration cf = (OpenstackConfiguration) configuration;
			ServerCreate sc = Builders.server()
					.name(cf.getHost())
					.flavor(cf.getId())
					.image(service.get("ubuntu-image"))
					.keypairName("beast-keypair")
					.networks(new ArrayList<String>(Arrays.asList(cf.getNetwork()))).build();
			
			Server server = os.compute().servers().boot(sc);
			
			logger.info("Starting VM with hostname " + cf.getHost() + " and flavor " + cf.getId() + " ...");
			
			logger.info("Waiting for VM to become active ...");
			
			while (!os.compute().servers().get(server.getId()).getStatus().equals(Status.ACTIVE)) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			FloatingIP ip = getFloatingIP();
			NetFloatingIP netFloatingIP = os.networking().floatingip().get(ip.getId());
			os.compute().floatingIps().addFloatingIP(server, netFloatingIP.getFloatingIpAddress());

			logger.info("Added floating IP " + netFloatingIP.getFloatingIpAddress() + " to " + cf.getHost());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			cons.add(new OpenstackConnectionInfo(netFloatingIP.getFloatingIpAddress(), kp.getPrivateKey()));
		}
		
		return cons;
	}
	
	@Override
	public void establishConnection(String kafkabroker, String topic, List<? extends ConnectionInfo> cons) {
		for (ConnectionInfo connectionInfo : cons) {
			OpenstackConnection con = new OpenstackConnection((OpenstackConnectionInfo) connectionInfo);
			con.authenticate();
			con.copyCrawlerService();
			con.executeService(kafkabroker, topic);
			con.disconnect();
		}
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
			String tenantId = os.identity().tenants().getByName(service.get("tenantName")).getId();
			openstacknetwork = os.networking().network().create(
					Builders.network().name(network.getName()).tenantId(tenantId).build());
		}
		
		return openstacknetwork;
	}
	
	private FloatingIP getFloatingIP() {
		for (FloatingIP ip : os.compute().floatingIps().list()) {
			if (ip.getFixedIpAddress() == null) {
				return ip;
			}
		}
		return null;
	}

}
