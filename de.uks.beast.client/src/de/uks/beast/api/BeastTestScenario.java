package de.uks.beast.api;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import de.uks.beast.model.Hardware;

public class BeastTestScenario {
	
	private static Logger logger = LogManager.getLogger(BeastTestScenario.class); 

	private BeastTestCollection tests;
	private TestEnvironment environment;
	private ObjectMapper mapper;

	public BeastTestScenario() {
		this.tests = new BeastTestCollection();
		this.environment = new TestEnvironment(null, -1);
		this.mapper = new ObjectMapper();
	}
	
	public String executeEnvironment(Hardware hw) {
		if (environment.getHost() == null && 
				environment.getPort() == -1) {
			logger.fatal("Could not determine host/port to" +
							" contact supervisor service. Set explicitly via useEnvironment method.");
			return null;
		} else {
			
			logger.info("Connecting to akka remote server ...");
			
			//TODO current workaround, akka 2.3.9 does not provide NAT
			//sending to a server local to akka, which redirects the hardware information
			
			/*AkkaRemoteController akkaControllerActor = new AkkaRemoteController(
					"akka.tcp://AkkaServer@" + environment.getHost() + ":" 
					+ environment.getPort() + "/user/ServerActor"
			);
			
			akkaControllerActor.send(hw);
			
			while (akkaControllerActor.getInfo() == null) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			this.infos = akkaControllerActor.getInfo();*/
			
			String kafakInfos = null;
			
			try {
				String jsonString = mapper.writeValueAsString(hw);
				
				Client client = Client.create();
				WebResource resource = client.resource("http://141.51.169.20:4410/akka/redirect");
				ClientResponse response = resource.accept("text/plain")
		                .post(ClientResponse.class, jsonString);
				kafakInfos = response.getEntity(String.class);
				
				logger.info("Configuration sent successfully. Executing environment ...");
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				return null;
			}
			
			return kafakInfos;
		}
		
	}

	public void setEnvironment(TestEnvironment environment) {
		this.environment = environment;
	}
	
	public BeastTestCollection getTests() {
		return tests;
	}
	
	public static void main(String[] args) {
		
	}
	
}
