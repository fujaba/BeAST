package de.uks.beast.server.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import de.uks.beast.model.Configuration;
import de.uks.beast.server.BeastService;
import de.uks.beast.server.kafka.KafkaRemoteLogger;
import de.uks.beast.server.service.model.JujuServiceInfo;
import de.uks.beast.server.util.juju.JujuClient;
import de.uks.beast.server.vm.InstanceConnection;

public class JujuEnvironment extends ServiceEnvironment {

	private static final Logger logger = LogManager.getLogger(JujuEnvironment.class);
	private KafkaRemoteLogger remoteLogger;
	
	public JujuEnvironment(BeastService service) {
		super(service);
		this.remoteLogger = service.getRemoteLogger();
	}

	@Override
	public void setup() {
		//TODO bootstrap environment if needed
	}

	@Override
	public void setupInstances(List<? extends Configuration> cons) {
		remoteLogger.info("Preparing Juju for service orchestration ...");
		for (Configuration configuration : cons) { //TODO async
			//connect to instance and add juju key
			InstanceConnection con = new InstanceConnection(service.getRemoteLogger(), configuration.getConnectionInfo());
			con.authenticate();
			con.insertKeyToAuthorizedKeys(service.get("juju-public-key"));
			
			//connect to instance and install juju agent
			logger.info("Adding " + configuration.getConnectionInfo().getHostName() + " as a manual managed machine to Juju");
			
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
			
			remoteLogger.info("[" + configuration.getConnectionInfo().getHostName() + "] Deploying service \"" 
					+ serviceInfo.getServiceType() + " ...");
			
			logger.info("Deploying service \"" + serviceInfo.getServiceName() + "\" with type \"" + 
			serviceInfo.getServiceType() + "\" to machine " + serviceInfo.getMachineID());
			
			JujuClient.deploy(serviceInfo.getServiceName(), serviceInfo.getServiceType(), serviceInfo.getMachineID());
			
		}
		
		JujuClient.addRelation("hadoop-master:namenode", "hadoop-slave:datanode");
		JujuClient.addRelation("hadoop-master:resourcemanager", "hadoop-slave:nodemanager");
		
		//juju add-relation hadoop-master:namenode hadoop-slave:datanode
		//juju add-relation hadoop-master:resourcemanager 
		
/*		
//		final Map<JujuServiceInfo, JujuServiceInfo> relations = new HashMap<>();
//		cons.forEach(config -> System.out.println(config.getServiceInfo().getServiceName()));
		
		// Adding relations between services 
		for (Configuration configuration : cons) {
			final JujuServiceInfo serviceInfo = (JujuServiceInfo) configuration
					.getServiceInfo();

			if (serviceInfo.getRelatedService() != null) {
				
//				relations.put(serviceInfo, (JujuServiceInfo) serviceInfo.getRelatedService());
				
				logger.info("Setting relationships between \""
						+ serviceInfo.getServiceType() + "\" and \""
						+ serviceInfo.getRelatedService().getServiceType());

				JujuClient.addRelation(serviceInfo.getServiceType(),
						serviceInfo.getRelatedService().getServiceType());
			}
		}*/
		
		
		logger.info("Services are started and all relations set");
	}

}
