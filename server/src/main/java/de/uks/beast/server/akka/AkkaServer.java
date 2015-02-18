package de.uks.beast.server.akka;

import akka.actor.ActorSystem;
import akka.actor.Props;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import de.uks.beast.server.BeastService;
import de.uks.beast.server.util.AkkaUtil;

public class AkkaServer {

	private ActorSystem actorSystem;
	private Config cfg;
	private BeastService service;
	
	public AkkaServer(BeastService service, String ip, int port) {
		this.service = service;
		this.cfg = ConfigFactory.parseString(AkkaUtil.remoteConfig(ip, port));
	}
	
	public ActorSystem getActorSystem() {
		return actorSystem;
	}

	public void start() {
		this.actorSystem = ActorSystem.create("AkkaServer", cfg);
		actorSystem.actorOf(Props.create(HardwareConfigProcessingActor.class, service), "ServerActor");
	}
	
}
