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
			String message = msg.toString();
			if (message.startsWith("TOPIC")) {
				controller.getConnection().setInfo(message.replace("TOPIC", ""));
			} else if (message.startsWith("SERVER")) {
				String m = message.replace("SERVER", "");
				String[] split = m.split(":");
				controller.getConnection().addConnectionInfo(split[0], split[1], split[2]);
			}
		}
	}

}
