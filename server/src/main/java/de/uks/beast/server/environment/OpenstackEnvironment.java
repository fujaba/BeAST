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
import org.openstack4j.model.network.Network;
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
	 * Setup the hardware
	 * @param hwconf
	 * @return
	 */
	public List<? extends Configuration> createHardwareDefiniton(Hardware hwconf) {

		List<CustomFlavor> flavors = new ArrayList<>();

		// Collect all server definitions, to create their instances
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


	//
	// Create Network
	private List<? extends Network> createNetwork(String networkName) {

		List<? extends Network> networks = os.networking().network().list();

		for (Network n : networks) {
			if (n.getName().equals(networkName)) {
				logger.info("The network with provided name (" + networkName + ") already exists.");
				return networks;
			}
		}

		// Assert: network with provided 'networkName' doesn't exist.
		final String tenantId = os.identity().tenants().getByName(service.get("tenantName")).getId();

		final Network network = os.networking().network().create(
				Builders.network().name(networkName).tenantId(tenantId).build());

		networks.addAll(network);

		return networks;
	}

	//
	// Get Network by ID
	public Network getNetworkById(String networkId) {
		return os.networking().network().get(networkId);
	}

	//
	// Delete Network
	public boolean deleteNetwork(String networkId) {
		boolean status = false;
		if(networkId != null && !networkId.isEmpty()) {
			os.networking().network().delete(networkId);
		}
		return status;
	}

	//
	// Check Network Existence
	private void networkIsAlreadyCreated(String networkName) {
		// TODO shoud return tt/ff wether the network with the 'networkName' already created.
	}


	@Override
	public void startVirtualMachine(List<? extends Configuration> configs) {
		for (Configuration configuration : configs) {
			CustomFlavor cf = (CustomFlavor) configuration;
			ServerCreate sc = Builders.server()
					.name(cf.getHost())
					.flavor(cf.getId())
					.image(service.get("ubuntu-image"))
					.networks(new ArrayList<String>(Arrays.asList(service.get("network-id"))))
					.build();
			os.compute().servers().boot(sc);
			logger.info("Starting VM with hostname " + cf.getHost() + " and flavor " + cf.getId() + " ...");
		}
	}

	@Override
	public boolean isAuthenticated() {
		return os != null;
	}

}
