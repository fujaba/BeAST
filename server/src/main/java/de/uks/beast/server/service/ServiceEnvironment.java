package de.uks.beast.server.service;

import java.util.List;

import de.uks.beast.server.BeastService;
import de.uks.beast.server.environment.model.Configuration;

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
	public abstract void setupInstances(List<? extends Configuration> cons);
	
	/**
	 * Installs and starts the services on the given machines
	 * @param cons The configurations for the instances
	 */
	public abstract void startServices(List<? extends Configuration> cons);
	
}
