package de.uks.beast.server.akka;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import akka.actor.UntypedActor;
import de.uks.beast.model.Hardware;
import de.uks.beast.server.BeastService;
import de.uks.beast.server.environment.model.Configuration;
import de.uks.beast.server.environment.model.ConnectionInfo;

public class ReceiveActor extends UntypedActor {

	private static Logger logger = LogManager.getLogger(ReceiveActor.class);

	private BeastService service;

	public ReceiveActor(BeastService service) {
		this.service = service;
	}

	@Override
	public void onReceive(Object obj) throws Exception {
		if (obj instanceof Hardware) {
			if (!service.getEnvironment().isAuthenticated()) {
				service.getEnvironment().authenticate();
			}

			if (service.getEnvironment().isAuthenticated()) {
				logger.info("Received new hardware configuration");
				
				// Create hardware definition
				List<? extends Configuration> configs = service.getEnvironment().createHardwareDefiniton((Hardware) obj);
				
				// start the VM(s)
				List<? extends ConnectionInfo> cons = service.getEnvironment().startVirtualMachine(configs);
				
				// create new Kafka topic
				String kafkabroker = service.get("kafkabroker");
				String topic = UUID.randomUUID().toString();
//				ZkClient zkClient = new ZkClient(kafkabroker, 10000, 10000, ZKStringSerializer$.MODULE$);
//				AdminUtils.createTopic(zkClient, topic, 1, 1, new Properties());
				
//				zkClient.deleteRecursive(ZkUtils.getTopicPath("myTopic"));
				
				// authenticate against VM(s) and deploy and start crawler service
				service.getEnvironment().establishConnection(kafkabroker, topic, cons);
				
			} else {
				// handle unauthenticated failures
			}
		} else {
			unhandled(obj);
		}

	}

}
