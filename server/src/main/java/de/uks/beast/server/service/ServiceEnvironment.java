package de.uks.beast.server.service;

import java.util.List;

public interface ServiceEnvironment {

	public void startService(String serviceName, List<String> constraints);
	
}
