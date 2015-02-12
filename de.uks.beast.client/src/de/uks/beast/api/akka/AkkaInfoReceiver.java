package de.uks.beast.api.akka;

import akka.actor.UntypedActor;

public class AkkaInfoReceiver extends UntypedActor {

	private AkkaRemoteController controller;

	public AkkaInfoReceiver(AkkaRemoteController controller) {
		this.controller = controller;
	}
	
	@Override
	public void onReceive(Object msg) throws Exception {
		if (msg instanceof String) {
			controller.setInfo(msg.toString());
		}
	}

}
