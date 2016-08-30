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
	private AmazonEC2Client ec2;

	public AWSInstanceBootAction(AWSConfiguration configuration, KeyPair keyPair,
			BeastService service, AmazonEC2Client ec2) {
		this.config = configuration;
		this.keyPair = keyPair;
		this.ec2 = ec2;
	}

	@Override
	public String call() throws Exception {
		RunInstancesRequest rir = new RunInstancesRequest();
		rir.withImageId(config.getImageId())
			.withInstanceType(config.getInstanceType())
			.withMinCount(1)
			.withMaxCount(1)
			.withKeyName("beast")
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
