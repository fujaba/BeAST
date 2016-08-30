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
//		String key = "-----BEGIN RSA PRIVATE KEY-----\n" + 
//				"MIIEpAIBAAKCAQEAiH4h8TxayJ5f928tqD2/wx2wUiyYpJzDUeBm2Y6U10enoh9x+8Qe7J2aQ1t3\n" + 
//				"kxr2Z0825An3u5OW3FBFnEfYMzjdn8ktVjspG4tJOwbsHYxkoCP3UyVu2wKHaWDUq7HgpNLrD9VC\n" +  
//				"aR68HiGBTEssVAPM0I4UMKccCTgQtrSFC2YtEnENqwMQTSHyR5BjGmnJnkT7/kN74x3exEBL3VbE\n" +  
//				"Pgx7xszKP2PLIsXrpzuLoAYRsEXCvuJREzkhoeP9k340mJa5oFAHWs6azzJTBHF3smYuRXQ1J0bd\n" +  
//				"x2grnx4zry0FBb2yLTyxa/Bwrx5OhaN9d0ZH6aQrX0dwOErmir8fgwIDAQABAoIBAAtqSRpsysbm\n" + 
//				"f+4orS/Z4jTGQd3NfwKdXbR2SQO+6fHLO1jSumys7U0qrSEfADQcWCkxtcyCjOZyJHbOe9PjKlC2\n" + 
//				"W8qmP5Vrozd7gadfH9YkzLGb8G5Svh+w6XRFteOaH8iJH0GWu1QhTuhSMwcXbmCkZLe4ejXLdAvN\n" +  
//				"VZCCLnJSfNya0uLUqDfRc7NfnKj0TRMUd8bnLipCy2Ni3ssSAfNzYy+BsW8a/5xG9PiN/lf1OSmf\n" +  
//				"bIQP/+HZAyLAO2zQmo1I59auFj1C6wIC3w9hzeaNCb8t3FHIgaccv4EMzr8tWC9j2jOOQLcHHhRy\n" +  
//				"zGj4UPhQ5bfO2nCbgwcCljuwZwECgYEAzndWwqxZzPr7PEJoslXOv/8BwSOGS598FjjWgqXTS8kr\n" + 
//				"IHrx9MSEK5ZkVD2hRx4V3psQ1BrunX9jhpERZzYIinKVZfpSmTc5K2h55e9eQHWZfY9Lk3ems88g\n" + 
//				"n9g0oNTyWMdkOS8WJamUmarAiEoBmHH67H2FQNW+ELcEAeNZZ4ECgYEAqT0wpIBLPWnkyJIl9fYF\n" +  
//				"8rfOGI3oh33sh9jjQxPitGgdEJ34lsMb13GLhce37mHq6oH1o1OLpCvett4I/hlEL1yJkJLMBKik\n" + 
//				"4e39LNk//pDIAXUdTiTqII2JI+kWVAhTFWSZwqFeoM+VqGyHNbufMDxeLanXKbXFLMHMCvy/aQMC\n" + 
//				"gYEAscqcYKkv707VV8/L/n3buwOqDBo+RBLDNROezQRlDqbdx2t3vZIYSryICu7DWc1zgazAchX7\n" + 
//				"Eo8nMjLr7JfgBPCk7BsCU8P1LAccqT9WR2W9Vh02NHfdios7icoRj8mwI3kYOhHtHWOJfkZG41Xv\n" +  
//				"R8onDM0OGYW11Qj0n3eafoECgYAz7voRUOlF1EwHnImXm8Khg/PzpwB3K5Y87bp3qA+Givh4U/Gn\n" + 
//				"2gGeMFK/X9U6isO66NyHHSkZ3PiAJ0ydJQW+fugb/GAtAc9vIUfyzkwMA0PM5rJye3N5P9WYtntK\n" +  
//				"mC9evjtM9ZYDRRBI2dz4CTZFaBECdD75prT2EhZaPMtEHwKBgQCsx7fOtAeknM6HGali+m6Dmx9j\n" +  
//				"Tzwbu7XbeadD82OZpPxxPuUGY3hm3qFeGxL7xlcctHmBAluqCYJC8shrZyfbzWyjP4L81DR1seYg\n" +  
//				"Suyc/BhnRVuU2z15WLT/CDM4wsXtwrwJDmCdf8Vgf/UYXy+pbvCLmAYhJ9kvrxAHtKQErg==\n" +  
//				"-----END RSA PRIVATE KEY-----";
//		Info i = new Info("52.29.209.139", key);
		InstanceConnection ic = new InstanceConnection(new ConnectionInfo("", info.getIp(), "", info.getKey()));
//		InstanceConnection ic = new InstanceConnection(new ConnectionInfo("", i.getIp(), "", i.getKey()));

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
