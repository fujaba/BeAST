package de.uks.beast.server.environment;

import java.util.List;

import de.uks.beast.model.Hardware;
import de.uks.beast.server.environment.model.Configuration;

public interface BeastEnvironment {

	public boolean authenticate();
	public List<? extends Configuration> createHardwareDefiniton(Hardware hwconf);
	public void startVirtualMachine(List<? extends Configuration> configs);
	public boolean isAuthenticated();
	
}
