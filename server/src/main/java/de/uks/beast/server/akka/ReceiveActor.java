package de.uks.beast.server.akka;

import de.uks.beast.model.Hardware;
import de.uks.beast.server.BeastService;
import akka.actor.UntypedActor;

public class ReceiveActor extends UntypedActor {

	private BeastService service;
	
	public ReceiveActor(BeastService service) {
		this.service = service;
	}
	
	@Override
	public void onReceive(Object obj) throws Exception {
		if (obj instanceof Hardware) {
			if (!service.getEnvironment().isAuthenticated()) {
				service.getEnvironment().authenticate();
			}

			if (!service.getEnvironment().isAuthenticated()) {
				service.getEnvironment().createHardwareDefiniton((Hardware) obj);
				service.getEnvironment().startVirtualMachine();
			} else {
				// handle unauthenticated failures
			}
		} else {
			unhandled(obj);
		}
		
	}

}
