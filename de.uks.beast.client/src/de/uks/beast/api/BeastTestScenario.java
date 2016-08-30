package de.uks.beast.api;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import de.uks.beast.api.akka.AkkaRemoteController;
import de.uks.beast.api.akka.BeastConnection;
import de.uks.beast.api.akka.BeastConnection.Info;
import de.uks.beast.connection.ConnectionInfo;
import de.uks.beast.connection.InstanceConnection;
import de.uks.beast.model.Hardware;
import de.uks.beast.model.Job;
import de.uks.beast.model.Network;

public class BeastTestScenario {
	
	private static Logger logger = LogManager.getLogger(BeastTestScenario.class); 

	private BeastTestCollection tests;
	private TestEnvironment environment;

	public BeastTestScenario() {
		this.tests = new BeastTestCollection();
		this.environment = new TestEnvironment(null, -1);
	}
	
	public BeastConnection executeEnvironment(Hardware hw) {
		if (environment.getHost() == null && 
				environment.getPort() == -1) {
			logger.fatal("Could not determine host/port to" +
							" contact supervisor service. Set explicitly via useEnvironment method.");
			return null;
		} else {
			
			logger.info("Connecting to akka remote server ...");
			
			//TODO current workaround, akka 2.3.9 does not provide NAT
			//sending to a server local to akka, which redirects the hardware information
			
			AkkaRemoteController akkaControllerActor = new AkkaRemoteController(
					"akka.tcp://AkkaServer@" + environment.getHost() + ":" 
					+ environment.getPort() + "/user/ServerActor"
			);
			
			akkaControllerActor.send(hw);
			
			int serverCount = 0;
			for (Network n : hw.getNetworks()) {
				serverCount += n.getServers().size();
			}
			
			while (akkaControllerActor.getConnection().getConInfos().size() != serverCount) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			return akkaControllerActor.getConnection();
		}
		
	}

	public void setEnvironment(TestEnvironment environment) {
		this.environment = environment;
	}
	
	public BeastTestCollection getTests() {
		return tests;
	}

	public void executeHadoopJob(String name, Info info, Job job) {
		//connection to instance
		InstanceConnection ic = new InstanceConnection(new ConnectionInfo("", info.getIp(), "", info.getKey()));
		ic.authenticate();
		
		//copy job
		String folder = "/tmp/" + name;
		ic.mkdir(folder);
		ic.mkdir(folder + "/input");
		ic.copyFile(job.getJar(), folder);
		for (String input : job.getInputs()) {
			ic.copyFile(input, folder + "/input");
		}
		
		//import to hdfs
		ic.hdfsCopyFromLocal(folder, "/");
		
		//run job
		ic.runJob(folder + "/" + job.getJarName(), name, "/" + name + "/input", "/" + name + "/output");
		
		//get results
		ic.hdfsCopyToLocal("/" + name + "/output", folder + "/output");
		ic.downloadResults(folder + "/output", job.getOutput());
	}
	
}
