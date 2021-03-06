package de.uks.beast.api.util;

public class AkkaUtil {

	public static final String AKKA_REMOTE_CFG = 
			"akka { " + "\n" + 
				"actor { " + "\n" + 
					"provider = \"akka.remote.RemoteActorRefProvider\" " + "\n" +  
				"} " + "\n" + 
				"remote {"  + "\n" + 
					"netty.tcp { "  + "\n" + 
						"hostname = \"127.0.0.1\" " + "\n" + 
						"port = 0 " + "\n" + 
					"} "  + "\n" + 
				"} " + "\n" + 
			"} " + "\n";
	
}
