package de.uks.beast.api.akka;

import com.typesafe.config.ConfigFactory;

import de.uks.beast.api.util.AkkaUtil;
import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;

public class AkkaRemoteController {
	
	private ActorSystem actorSystem;
	private ActorSelection sender;

	public AkkaRemoteController(String actorPath) {
		this.actorSystem = ActorSystem.create("ClientSystem", ConfigFactory.parseString(AkkaUtil.AKKA_REMOTE_CFG));
		sender = actorSystem.actorSelection(actorPath);
	}
	
	public void send(Object obj) {
		sender.tell(obj, ActorRef.noSender());
	}
	
}
