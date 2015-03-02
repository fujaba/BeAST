package de.uks.beast.server.service;

import java.util.List;

import de.uks.beast.server.BeastService;
import de.uks.beast.server.environment.model.ConnectionInfo;

public abstract class ServiceEnvironment {

	protected BeastService service;

	public ServiceEnvironment(BeastService service) {
		this.service = service;
	}
	
	/** Sets up the service environment if needed */
	public abstract void setup();
	
	/**
	 * Prepares the instances for service orchestration if needed 
	 * @param cons List of instances
	 */
	public abstract void setupInstances(List<? extends ConnectionInfo> cons);
	
	/**
	 * Installs and starts a service on a given machine
	 * @param serviceName Service to install and start
	 * @param constraints Optional configuration information for instance
	 */
	public abstract void startService(String serviceName, List<String> constraints);
	
}
