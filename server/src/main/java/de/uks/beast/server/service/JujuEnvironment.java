package de.uks.beast.server.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import de.uks.beast.server.BeastService;
import de.uks.beast.server.environment.model.Configuration;
import de.uks.beast.server.util.juju.JujuClient;
import de.uks.beast.server.vm.InstanceConnection;

public class JujuEnvironment extends ServiceEnvironment {

	private static final Logger logger = LogManager.getLogger(JujuEnvironment.class);
	
	public JujuEnvironment(BeastService service) {
		super(service);
	}

	@Override
	public void setup() {
		//TODO bootstrap environment if needed
	}

	@Override
	public void setupInstances(List<? extends Configuration> cons) {
		for (Configuration configuration : cons) { //TODO async
			//connect to instance and add juju key
			InstanceConnection con = new InstanceConnection(service.getRemoteLogger(), configuration.getConnectionInfo());
			con.authenticate();
			con.insertKeyToAuthorizedKeys(service.get("juju-public-key"));
			
			//connect to instance and install juju agent
			logger.info("Adding " + configuration.getConnectionInfo().getHostName() + " as manual managed machine to Juju");
			int machineID = JujuClient.addMachine("ubuntu@" + configuration.getConnectionInfo().getIp());
			configuration.getConnectionInfo().setID(machineID);
		}
	}
	
	@Override
	public void startServices(List<? extends Configuration> cons) {
		logger.info("Deploying to machine ... ");
		//JujuClient.deploy(servicename, subservice, machineNumber);
	}

}
