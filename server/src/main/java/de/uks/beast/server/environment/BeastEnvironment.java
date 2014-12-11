package de.uks.beast.server.environment;

import java.util.ArrayList;
import java.util.List;

import de.uks.beast.model.Hardware;
import de.uks.beast.server.environment.model.Configuration;
import de.uks.beast.server.environment.model.ConnectionInfo;

public interface BeastEnvironment {

	public boolean authenticate();
	public List<? extends Configuration> createHardwareDefiniton(Hardware hwconf);
	public boolean isAuthenticated();
	void establishConnection(String kafkabroker, String topic, List<? extends ConnectionInfo> cons);
	ArrayList<? extends ConnectionInfo> startVirtualMachine(List<? extends Configuration> configs);
	
}
