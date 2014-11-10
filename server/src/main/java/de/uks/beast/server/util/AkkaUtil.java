package de.uks.beast.server.util;

public class AkkaUtil {

	private static final String AKKA_REMOTE_CFG = 
			"akka { " + "\n" + 
				"actor { " + "\n" + 
					"provider = \"akka.remote.RemoteActorRefProvider\" " + "\n" +  
				"} " + "\n" + 
				"remote {"  + "\n" + 
					"netty.tcp { "  + "\n" + 
						"hostname = \"127.0.0.1\" " + "\n" + 
						"port = <PORT> " + "\n" + 
					"} "  + "\n" + 
				"} " + "\n" + 
			"} " + "\n";
	
	public static String remoteConfig(int port) {
		return AKKA_REMOTE_CFG.replace("<PORT>", "" + port);
	}
	
}
