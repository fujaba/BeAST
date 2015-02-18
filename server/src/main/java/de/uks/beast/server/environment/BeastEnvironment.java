package de.uks.beast.server.environment;

import java.util.ArrayList;
import java.util.List;

import de.uks.beast.model.Hardware;
import de.uks.beast.server.environment.model.Configuration;
import de.uks.beast.server.environment.model.ConnectionInfo;
import de.uks.beast.server.kafka.KafkaRemoteLogger;

public abstract class BeastEnvironment {

	protected KafkaRemoteLogger remoteLogger;

	public abstract boolean authenticate();
	public abstract List<? extends Configuration> createHardwareDefiniton(Hardware hwconf);
	public abstract boolean isAuthenticated();
	public abstract void establishConnection(String kafkabroker, String topic, List<? extends ConnectionInfo> cons);
	public abstract ArrayList<? extends ConnectionInfo> startVirtualMachine(List<? extends Configuration> configs);
	
	public void setRemoteLogger(KafkaRemoteLogger remoteLogger){
		this.remoteLogger = remoteLogger;
	}
	
	public KafkaRemoteLogger getRemoteLogger() {
		return this.remoteLogger;
	}
	
}
