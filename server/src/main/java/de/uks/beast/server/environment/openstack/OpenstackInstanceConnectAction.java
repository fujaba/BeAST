package de.uks.beast.server.environment.openstack;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import de.uks.beast.server.environment.model.ConnectionInfo;
import de.uks.beast.server.kafka.KafkaRemoteLogger;
import de.uks.beast.server.vm.InstanceConnection;

public class OpenstackInstanceConnectAction extends Thread {

	private KafkaRemoteLogger remoteLogger;
	private ConnectionInfo connectionInfo;
	private String kafkabroker;
	private String topic;
	private List<ConnectionInfo> connectionInfos;
	
	private CountDownLatch latch;

	public OpenstackInstanceConnectAction(KafkaRemoteLogger remoteLogger,
			ConnectionInfo connectionInfo, String kafkabroker, String topic,
			List<ConnectionInfo> connectionInfos, CountDownLatch latch) {
		this.remoteLogger = remoteLogger;
		this.connectionInfo = connectionInfo;
		this.kafkabroker = kafkabroker;
		this.topic = topic;
		this.connectionInfos = connectionInfos;
		this.latch = latch;
	}

	@Override
	public void run() {
		InstanceConnection con = new InstanceConnection(remoteLogger, connectionInfo);
		con.authenticate();
		con.copyBeastFiles();
		con.executeService(kafkabroker, topic, connectionInfos);
		con.disconnect();
		latch.countDown();
	}
	
}
