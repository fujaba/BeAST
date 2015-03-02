package de.uks.beast.server.environment;

import java.util.ArrayList;
import java.util.List;

import de.uks.beast.model.Hardware;
import de.uks.beast.server.BeastService;
import de.uks.beast.server.environment.model.Configuration;
import de.uks.beast.server.environment.model.ConnectionInfo;

public abstract class CloudEnvironment {
	
	protected BeastService service;

	public CloudEnvironment(BeastService service) {
		this.service = service;
	}
	
	/** authenticate against environment */
	public abstract boolean authenticate();
	
	/** checks if beast server is already authenticated agains environment */
	public abstract boolean isAuthenticated();
	
	/**
	 * Creates the hardware definitions for a specific environment 
	 * @param hwconf The hardware config received from beast client
	 * @return list of environment specific configurations (POJO)
	 */
	public abstract List<? extends Configuration> createHardwareDefiniton(Hardware hwconf);
	
	/**
	 * Creates and starts instances in given environment
	 * @param configs Configuations for the instances
	 * @return list of environment specific connection information for the instances
	 */
	public abstract ArrayList<? extends ConnectionInfo> startVirtualMachine(List<? extends Configuration> configs);
	
	/** 
	 * Establishes connections from instances to kafka
	 * @param kafkabroker hostname/IP:port triplet to kafkabroker
	 * @param topic the kafka topic the information are written to
	 * @param cons list of connection information for all instances
	 */
	public abstract void establishConnection(String kafkabroker, String topic, List<? extends ConnectionInfo> cons);
	
}
