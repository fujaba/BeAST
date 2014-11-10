package de.uks.beast.server.environment;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openstack4j.api.Builders;
import org.openstack4j.api.OSClient;
import org.openstack4j.model.compute.Flavor;
import org.openstack4j.openstack.OSFactory;

import de.uks.beast.model.Hardware;
import de.uks.beast.model.Server;
import de.uks.beast.server.BeastService;

public class OpenstackEnvironment implements BeastEnvironment {

	private static Logger logger = LogManager.getLogger(OpenstackEnvironment.class); 
	
	private OSClient os;
	private BeastService service;

	public OpenstackEnvironment(BeastService service) {
		this.service = service;
	}
	
	@Override
	public boolean authenticate() {
		try {
			this.os = OSFactory.builder()
					.endpoint(service.get("keystone"))
					.credentials(service.get("admin"), service.get("password"))
					.tenantName(service.get("tenant"))
					.authenticate();
		} catch (Exception e) {
			if (e.getMessage().equals("java.net.ConnectException: Connection refused")) {
//				LoggingUtil.fatal(e, "Could not connect to keystone authentication service. Exiting.", logger);
				logger.error("Could not connect to keystone", e);
			}
			return false;
		}
		
		return true;
	}

	public void createHardwareDefiniton(Hardware hwconf) {
		List<? extends Flavor> list = os.compute().flavors().list();
		
		for (Server server : hwconf.getServers()) {
			boolean flavorExists = false;
			for (Flavor flavor : list) {
				if (flavor.getName().equals(server.getFlavor())) {
					flavorExists = true;
				}
			}
			if (!flavorExists) {
				Flavor f = Builders.flavor()
						.name(server.getFlavor())
						.ram(server.getRam())
						.vcpus(server.getCpu())
						.disk(server.getDiskSpace())
						.rxtxFactor(1.2f)
						.build();
				os.compute().flavors().create(f);
			}
		}
		
		System.out.println(service);
	}

	public void startVirtualMachine() {

	}

	@Override
	public boolean isAuthenticated() {
		return os != null;
	}

}
