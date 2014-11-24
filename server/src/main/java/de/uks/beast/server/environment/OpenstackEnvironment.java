package de.uks.beast.server.environment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openstack4j.api.Builders;
import org.openstack4j.api.OSClient;
import org.openstack4j.model.compute.Flavor;
import org.openstack4j.model.compute.ServerCreate;
import org.openstack4j.openstack.OSFactory;

import de.uks.beast.model.Hardware;
import de.uks.beast.server.BeastService;
import de.uks.beast.server.environment.model.Configuration;
import de.uks.beast.server.environment.model.CustomFlavor;

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

	public ArrayList<? extends Configuration> createHardwareDefiniton(Hardware hwconf) {
		ArrayList<CustomFlavor> flavors = new ArrayList<CustomFlavor>();
		
		for (de.uks.beast.model.Server server : hwconf.getServers()) {
			List<? extends Flavor> list = os.compute().flavors().list();
			
			//get ID
			String flavorID = "";
			
			boolean flavorExists = false;
			for (Flavor flavor : list) {
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
			flavors.add(new CustomFlavor(flavorID, server));
		}
		
		return flavors;
	}

	@Override
	public void startVirtualMachine(ArrayList<? extends Configuration> configs) {
		for (Configuration configuration : configs) {
			CustomFlavor cf = (CustomFlavor) configuration;
			ServerCreate sc = Builders.server()
					.name(cf.getHost()).flavor(cf.getId())
					.image(service.get("ubuntu-image"))
					.networks(new ArrayList<String>(Arrays.asList(service.get("network-id")))).build();
			os.compute().servers().boot(sc);
			logger.info("Starting VM with hostname " + cf.getHost() + " and flavor " + cf.getId() + " ...");
		}
	}

	@Override
	public boolean isAuthenticated() {
		return os != null;
	}

}
