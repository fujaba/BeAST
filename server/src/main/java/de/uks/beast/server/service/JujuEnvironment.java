package de.uks.beast.server.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import de.uks.beast.server.BeastService;
import de.uks.beast.server.environment.model.Configuration;
import de.uks.beast.server.service.model.JujuServiceInfo;
import de.uks.beast.server.util.juju.JujuClient;
import de.uks.beast.server.vm.InstanceConnection;

public class JujuEnvironment extends ServiceEnvironment {

	private static final Logger logger = LogManager.getLogger(JujuEnvironment.class);
	
	public JujuEnvironment(BeastService service) {
		super(service);
	}

	@Override
	public void setup() {
	}

	@Override
	public void setupInstances(List<? extends Configuration> cons) {
		service.getRemoteLogger().info("Preparing Juju for service orchestration ...");
		for (Configuration configuration : cons) { //TODO async
			//connect to instance and add juju key
			InstanceConnection con = new InstanceConnection(service.getRemoteLogger(), configuration.getConnectionInfo());
			con.authenticate();
			con.insertKeyToAuthorizedKeys(service.get("juju-public-key"));
			
			//connect to instance and install juju agent
			logger.info("Adding " + configuration.getConnectionInfo().getName() + " as a manual managed machine to Juju");
			
			int machineID = JujuClient.addMachine("ubuntu@" + configuration.getConnectionInfo().getIp());
			
			JujuServiceInfo jujuServiceInfo = new JujuServiceInfo(configuration.getServiceInfo());
			jujuServiceInfo.setMachineID(machineID);
			
			configuration.setServiceInfo(jujuServiceInfo);
		}
	}
	
	@Override
	public void startServices(List<? extends Configuration> cons) {
		// deploying juju charms to provisioned machines 
		for (Configuration configuration : cons) {
			JujuServiceInfo serviceInfo = (JujuServiceInfo) configuration.getServiceInfo();
			
			service.getRemoteLogger().info("[" + configuration.getConnectionInfo().getName() + "] Deploying service \"" 
					+ serviceInfo.getServiceType() + "\" ...");
			
			logger.info("Deploying service \"" + serviceInfo.getServiceName() + "\" with type \"" + 
			serviceInfo.getServiceType() + "\" to machine " + serviceInfo.getMachineID());
			
			JujuClient.deploy(serviceInfo.getServiceName(), serviceInfo.getServiceType(), serviceInfo.getMachineID());
			
		}
	}

	@Override
	public void postInstall(List<? extends Configuration> configs) {
		JujuClient.addRelation("hadoop-master:namenode", "hadoop-slave:datanode");
		JujuClient.addRelation("hadoop-master:resourcemanager", "hadoop-slave:nodemanager");
		JujuClient.expose("hadoop-master");
		JujuClient.expose("hadoop-slave");
		
		try {
			Thread.sleep(180000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String namenode = "";
		
		for (Configuration config : configs) {
			if (config.getServiceInfo().getServiceType().equals("hadoop-master")) {
				namenode = config.getConnectionInfo().getHostName();
			}
		}
		
		for (Configuration config : configs) {
			InstanceConnection ic = new InstanceConnection(null, config.getConnectionInfo());
			ic.authenticate();
			ic.copyFolder(service.get("juju-assets") + "hadoop-assets", "/home/ubuntu");
			if (config.getServiceInfo().getServiceType().equals("hadoop-master")) {
				ic.executeScript("/home/ubuntu/hadoop-assets/master.sh " + namenode, false);
			} else if (config.getServiceInfo().getServiceType().equals("hadoop-slave")) {
				ic.executeScript("/home/ubuntu/hadoop-assets/slave.sh " + namenode, false);
			}
			ic.disconnect();
		}
		
		service.getRemoteLogger().info("Finished Juju setup.");
	}

}
