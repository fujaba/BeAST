package de.uks.beast.server.environment;

import de.uks.beast.model.Hardware;

public interface BeastEnvironment {

	public void createHardwareDefiniton(Hardware hwconf);
	public void startVirtualMachine();
	
}
