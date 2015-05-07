package de.uks.beast.server.shutdown;

import de.uks.beast.server.BeastService;

public class BeastServiceTermination extends Thread {

	private BeastService service;

	public BeastServiceTermination(BeastService service) {
		this.service = service;
	}

	@Override
	public void run() {
		System.out.println("stop");
		/* remove port forwarding rules */
		
		/* shutdown all instances */
		service.getCloudEnvironment().shutdownAll();
	}
	
}
