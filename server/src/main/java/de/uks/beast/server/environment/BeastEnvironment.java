package de.uks.beast.server.environment;

import java.util.ArrayList;

import de.uks.beast.model.Hardware;
import de.uks.beast.server.environment.model.Configuration;

public interface BeastEnvironment {

	public boolean authenticate();
	public ArrayList<? extends Configuration> createHardwareDefiniton(Hardware hwconf);
	public void startVirtualMachine(ArrayList<? extends Configuration> configs);
	public boolean isAuthenticated();
	
}
