package de.uks.beast.api;

import java.io.File;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import de.uks.beast.api.akka.AkkaRemoteController;
import de.uks.beast.api.util.XMLParser;
import de.uks.beast.model.Hardware;

public class BeastTestScenario {
	
	private static Logger logger = LogManager.getLogger(BeastTestScenario.class); 

	private BeastTestCollection tests;
	private TestEnvironment environment;
	private String srvconfig;

	public BeastTestScenario() {
		this.tests = new BeastTestCollection();
		this.environment = new TestEnvironment(null, -1, null);
	}

	public void executeEnvironment(File modelFile) {
		if (environment.getHost() == null && 
				environment.getPort() == -1) {
			logger.fatal("Could not determine host/port to" +
							" contact supervisor service. Set explicitly via useEnvironment method.");
		} else {
			
			if (environment.getDiagramPath() == null) {
				
				if (srvconfig == null && modelFile == null) {
					logger.fatal("Could not find any .srvconfig file");
				}
			} else {
				srvconfig = environment.getDiagramPath();
			}
			
			logger.info("Parsing hardware configuration");
			
			Hardware hwconf = null;
			
			if (srvconfig != null) {
				hwconf = XMLParser.parseHardwareConfig(srvconfig);
			} else if (modelFile != null) {
				hwconf = XMLParser.parseHardwareConfig(modelFile);
			}
			
			logger.info("Connecting to akka remote server ...");
			
			AkkaRemoteController akkaControllerActor = new AkkaRemoteController(
					"akka.tcp://AkkaServer@" + environment.getHost() + ":" 
					+ environment.getPort() + "/user/ServerActor"
			);
			
			akkaControllerActor.send(hwconf);
			
			logger.info("Configuration sent successfully. Executing environment ...");
		}
	}

	public void setEnvironment(TestEnvironment environment) {
		this.environment = environment;
	}
	
}
