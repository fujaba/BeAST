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
		logger.info("Authentication against keystone ...");
		try {
			this.os = OSFactory.builder()
					.endpoint(service.get("keystone"))
					.credentials(service.get("admin"), service.get("password"))
					.tenantName(service.get("tenant"))
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

	public void createHardwareDefiniton(Hardware hwconf) {
		for (Server server : hwconf.getServers()) {
			List<? extends Flavor> list = os.compute().flavors().list();
			
			boolean flavorExists = false;
			for (Flavor flavor : list) {
				if (flavor.getName().equals("b1." + server.getFlavor())) {
					flavorExists = true;
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
				logger.info("Created new Flavor with name b1." + server.getFlavor()
						+ " (" + f.getId() + ")");
			}
		}
		
	}

	public void startVirtualMachine() {

	}

	@Override
	public boolean isAuthenticated() {
		return os != null;
	}

}
