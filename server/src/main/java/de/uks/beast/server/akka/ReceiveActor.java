package de.uks.beast.server.akka;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import akka.actor.UntypedActor;
import de.uks.beast.model.Hardware;
import de.uks.beast.server.BeastService;

public class ReceiveActor extends UntypedActor {

	private static Logger logger = LogManager.getLogger(ReceiveActor.class);

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

			if (service.getEnvironment().isAuthenticated()) {
				logger.info("Received new hardware configuration");
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
