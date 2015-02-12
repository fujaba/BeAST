package de.uks.beast.api.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;

import com.typesafe.config.ConfigFactory;

import de.uks.beast.api.util.AkkaUtil;

public class AkkaRemoteController {
	
	private ActorSystem actorSystem;
	private ActorSelection sender;
	private String info;

	public AkkaRemoteController(String actorPath) {
		this.info = null;
		this.actorSystem = ActorSystem.create("ClientSystem", ConfigFactory.parseString(AkkaUtil.AKKA_REMOTE_CFG));
		sender = actorSystem.actorSelection(actorPath);
		actorSystem.actorOf(Props.create(AkkaInfoReceiver.class, this), "InfoReceiver");
	}
	
	public void send(Object obj) {
		sender.tell(obj, ActorRef.noSender());
	}
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
}
