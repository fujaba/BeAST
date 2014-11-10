package de.uks.beast.server.environment;

import de.uks.beast.model.Hardware;

public interface BeastEnvironment {

	public boolean authenticate();
	public void createHardwareDefiniton(Hardware hwconf);
	public void startVirtualMachine();
	public boolean isAuthenticated();
	
}
