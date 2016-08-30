package de.uks.beast.server.environment.aws;

import java.util.concurrent.Callable;

import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.KeyPair;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;
import com.amazonaws.services.elasticmapreduce.model.InstanceState;

import de.uks.beast.server.BeastService;
import de.uks.beast.server.environment.model.AWSConfiguration;
import de.uks.beast.server.environment.model.ConnectionInfo;

public class AWSInstanceBootAction implements Callable<String> {

	private AWSConfiguration config;
	private KeyPair keyPair;
	private BeastService service;
	private AmazonEC2Client ec2;

	public AWSInstanceBootAction(AWSConfiguration configuration, KeyPair keyPair,
			BeastService service, AmazonEC2Client ec2) {
		this.config = configuration;
		this.keyPair = keyPair;
		this.service = service;
		this.ec2 = ec2;
	}

	@Override
	public String call() throws Exception {
		
		keyPair.setKeyMaterial("-----BEGIN RSA PRIVATE KEY-----\n" + 
"MIIEpAIBAAKCAQEAiH4h8TxayJ5f928tqD2/wx2wUiyYpJzDUeBm2Y6U10enoh9x+8Qe7J2aQ1t3\n" + 
"kxr2Z0825An3u5OW3FBFnEfYMzjdn8ktVjspG4tJOwbsHYxkoCP3UyVu2wKHaWDUq7HgpNLrD9VC\n" +  
"aR68HiGBTEssVAPM0I4UMKccCTgQtrSFC2YtEnENqwMQTSHyR5BjGmnJnkT7/kN74x3exEBL3VbE\n" +  
"Pgx7xszKP2PLIsXrpzuLoAYRsEXCvuJREzkhoeP9k340mJa5oFAHWs6azzJTBHF3smYuRXQ1J0bd\n" +  
"x2grnx4zry0FBb2yLTyxa/Bwrx5OhaN9d0ZH6aQrX0dwOErmir8fgwIDAQABAoIBAAtqSRpsysbm\n" + 
"f+4orS/Z4jTGQd3NfwKdXbR2SQO+6fHLO1jSumys7U0qrSEfADQcWCkxtcyCjOZyJHbOe9PjKlC2\n" + 
"W8qmP5Vrozd7gadfH9YkzLGb8G5Svh+w6XRFteOaH8iJH0GWu1QhTuhSMwcXbmCkZLe4ejXLdAvN\n" +  
"VZCCLnJSfNya0uLUqDfRc7NfnKj0TRMUd8bnLipCy2Ni3ssSAfNzYy+BsW8a/5xG9PiN/lf1OSmf\n" +  
"bIQP/+HZAyLAO2zQmo1I59auFj1C6wIC3w9hzeaNCb8t3FHIgaccv4EMzr8tWC9j2jOOQLcHHhRy\n" +  
"zGj4UPhQ5bfO2nCbgwcCljuwZwECgYEAzndWwqxZzPr7PEJoslXOv/8BwSOGS598FjjWgqXTS8kr\n" + 
"IHrx9MSEK5ZkVD2hRx4V3psQ1BrunX9jhpERZzYIinKVZfpSmTc5K2h55e9eQHWZfY9Lk3ems88g\n" + 
"n9g0oNTyWMdkOS8WJamUmarAiEoBmHH67H2FQNW+ELcEAeNZZ4ECgYEAqT0wpIBLPWnkyJIl9fYF\n" +  
"8rfOGI3oh33sh9jjQxPitGgdEJ34lsMb13GLhce37mHq6oH1o1OLpCvett4I/hlEL1yJkJLMBKik\n" + 
"4e39LNk//pDIAXUdTiTqII2JI+kWVAhTFWSZwqFeoM+VqGyHNbufMDxeLanXKbXFLMHMCvy/aQMC\n" + 
"gYEAscqcYKkv707VV8/L/n3buwOqDBo+RBLDNROezQRlDqbdx2t3vZIYSryICu7DWc1zgazAchX7\n" + 
"Eo8nMjLr7JfgBPCk7BsCU8P1LAccqT9WR2W9Vh02NHfdios7icoRj8mwI3kYOhHtHWOJfkZG41Xv\n" +  
"R8onDM0OGYW11Qj0n3eafoECgYAz7voRUOlF1EwHnImXm8Khg/PzpwB3K5Y87bp3qA+Givh4U/Gn\n" + 
"2gGeMFK/X9U6isO66NyHHSkZ3PiAJ0ydJQW+fugb/GAtAc9vIUfyzkwMA0PM5rJye3N5P9WYtntK\n" +  
"mC9evjtM9ZYDRRBI2dz4CTZFaBECdD75prT2EhZaPMtEHwKBgQCsx7fOtAeknM6HGali+m6Dmx9j\n" +  
"Tzwbu7XbeadD82OZpPxxPuUGY3hm3qFeGxL7xlcctHmBAluqCYJC8shrZyfbzWyjP4L81DR1seYg\n" +  
"Suyc/BhnRVuU2z15WLT/CDM4wsXtwrwJDmCdf8Vgf/UYXy+pbvCLmAYhJ9kvrxAHtKQErg==\n" +  
"-----END RSA PRIVATE KEY-----");
		
		RunInstancesRequest rir = new RunInstancesRequest();
		rir.withImageId(config.getImageId())
			.withInstanceType(config.getInstanceType())
			.withMinCount(1)
			.withMaxCount(1)
			.withKeyName("perm")
			.withSecurityGroups("beast");
		RunInstancesResult rirr = ec2.runInstances(rir);
		Instance instance = rirr.getReservation().getInstances().get(0);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		boolean booted = false;
		while (!booted) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			DescribeInstancesResult is = ec2.describeInstances();
			for (Reservation rs : is.getReservations()) {
				for (Instance i : rs.getInstances()) {
					if (i.getInstanceId().equals(instance.getInstanceId())) {
						if (i.getState().getName().equalsIgnoreCase(InstanceState.RUNNING.toString())) {
							booted = true;
							instance = i;
						}
					}
				}
			}
		}
		
		config.setConnectionInfo(new ConnectionInfo(config.getName(), instance.getPrivateDnsName(), instance.getPublicIpAddress(),
				instance.getPrivateIpAddress(), keyPair.getKeyMaterial()));
		
		return "SERVER" + config.getConnectionInfo().getName() + ":" + instance.getPublicIpAddress() + ":" + keyPair.getKeyMaterial();
	}

}
