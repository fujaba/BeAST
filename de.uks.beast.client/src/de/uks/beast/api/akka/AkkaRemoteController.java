package de.uks.beast.api.akka;

import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;
import de.uks.beast.api.util.AkkaUtil;

public class AkkaRemoteController {
	
	private ActorSystem actorSystem;
	private ActorSelection sender;
	private BeastConnection connection;
	private ActorRef actor;

	public AkkaRemoteController(String actorPath) {
		this.connection = new BeastConnection();
		this.actorSystem = ActorSystem.create("ClientSystem", ConfigFactory.parseString(AkkaUtil.AKKA_REMOTE_CFG));
		sender = actorSystem.actorSelection(actorPath);
		actor = actorSystem.actorOf(Props.create(AkkaInfoReceiver.class, this), "InfoReceiver");
	}
	
	public void send(Object obj) {
		sender.tell(obj, actor);
	}
	
	public BeastConnection getConnection() {
		return connection;
	}
	
}
