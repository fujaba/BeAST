package de.uks.beast.server.akka;

import java.util.List;
import java.util.Properties;
import java.util.UUID;

import kafka.admin.AdminUtils;
import kafka.utils.ZKStringSerializer$;

import org.I0Itec.zkclient.ZkClient;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import akka.actor.UntypedActor;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.uks.beast.model.Hardware;
import de.uks.beast.server.BeastService;
import de.uks.beast.server.environment.model.Configuration;
import de.uks.beast.server.environment.model.ConnectionInfo;
import de.uks.beast.server.kafka.KafkaRemoteLogger;

public class HardwareConfigProcessingActor extends UntypedActor {

	private static Logger logger = LogManager.getLogger(HardwareConfigProcessingActor.class);

	private BeastService service;
	private ObjectMapper objectMapper;

	public HardwareConfigProcessingActor(BeastService service) {
		this.service = service;
		this.objectMapper = new ObjectMapper();
	}

	@Override
	public void onReceive(Object obj) throws Exception {
		if (obj instanceof String) {
			Hardware hw = objectMapper.readValue((String) obj, Hardware.class);
			handleHardware(hw);
		} else if (obj instanceof Hardware) {
			handleHardware((Hardware) obj);
		} else {
			unhandled(obj);
		}

	}

	private void handleHardware(Hardware hw) {
		logger.info("Received new hardware configuration");
		
		/* authenticate against cloud environment if necessary */
		if (!service.getCloudEnvironment().isAuthenticated()) {
			service.getCloudEnvironment().authenticate();
		}

		if (service.getCloudEnvironment().isAuthenticated()) {
			/* generate a topic ID */
			String topic = UUID.randomUUID().toString();
			String zookeeperCon = service.get("zookeeper-portforward");
			
			if (zookeeperCon == null) {
				zookeeperCon = service.get("zookeeper");
			}
			
			/* send metadata to client */
			getSender().tell(topic + " " + zookeeperCon, getSelf());
			
			/* create new Kafka topic */
			ZkClient zkClient = new ZkClient(service.get("zookeeper"), 10000, 10000, ZKStringSerializer$.MODULE$);
			AdminUtils.createTopic(zkClient, topic, 1, 1, new Properties());
			
			/* create kafka writer */
			KafkaRemoteLogger remoteLogger = new KafkaRemoteLogger(service.get("kafkabroker"), topic);
			service.setRemoteLogger(remoteLogger);
			
			/* create hardware definition */
			List<? extends Configuration> configs = service.getCloudEnvironment().createHardwareDefiniton(hw);
			
			/* start the instance(s) */
			List<? extends ConnectionInfo> cons = service.getCloudEnvironment().startVirtualMachine(configs);
			
			/* authenticate against VM(s) and deploy and start crawler service */
			service.getCloudEnvironment().establishConnection(service.get("kafkabroker"), topic, cons);
			
			/* prepare service orchestration */
			service.getServiceEnvironment().setup();
			
			/* prepare the instances */
			service.getServiceEnvironment().setupInstances(cons);
			
			/* install and start the services */
			service.getServiceEnvironment().startService("", null);
			
			
		} else {
			// handle unauthenticated failures
		}
	}

}
