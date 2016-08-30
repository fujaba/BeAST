package de.uks.beast.server.environment.aws;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.http.IdleConnectionReaper;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.AuthorizeSecurityGroupIngressRequest;
import com.amazonaws.services.ec2.model.CreateKeyPairRequest;
import com.amazonaws.services.ec2.model.CreateKeyPairResult;
import com.amazonaws.services.ec2.model.CreateSecurityGroupRequest;
import com.amazonaws.services.ec2.model.DeleteKeyPairRequest;
import com.amazonaws.services.ec2.model.DescribeKeyPairsResult;
import com.amazonaws.services.ec2.model.DescribeSecurityGroupsResult;
import com.amazonaws.services.ec2.model.IpPermission;
import com.amazonaws.services.ec2.model.KeyPair;
import com.amazonaws.services.ec2.model.KeyPairInfo;
import com.amazonaws.services.ec2.model.SecurityGroup;

import de.uks.beast.model.Hardware;
import de.uks.beast.model.Network;
import de.uks.beast.model.Server;
import de.uks.beast.server.BeastService;
import de.uks.beast.server.environment.CloudEnvironment;
import de.uks.beast.server.environment.model.AWSConfiguration;
import de.uks.beast.server.environment.model.Configuration;
import de.uks.beast.server.environment.model.ConnectionInfo;
import de.uks.beast.server.kafka.KafkaRemoteLogger;
import de.uks.beast.server.service.model.JujuServiceInfo;
import de.uks.beast.server.vm.InstanceConnection;

public class AWSEnvironment extends CloudEnvironment {

	private AmazonEC2Client ec2;
	private KeyPair keyPair;
	
	public AWSEnvironment(BeastService service) {
		super(service);
	}

	@Override
	public boolean authenticate() {
		ec2 = new AmazonEC2Client(
				new BasicAWSCredentials(service.get("access-key"), service.get("secret-key")));
		ec2.setEndpoint("ec2.eu-central-1.amazonaws.com");
		return false;
	}

	@Override
	public boolean isAuthenticated() {
		return ec2 != null;
	}

	@Override
	public List<? extends Configuration> createHardwareDefiniton(Hardware hwconf) {
		createSecurityGroup();
		this.keyPair = createKeyPair();
		
		List<AWSConfiguration> configs = new LinkedList<AWSConfiguration>();
		
		for (Network n : hwconf.getNetworks()) {
			for (Server s : n.getServers()) {
				AWSConfiguration awsc = new AWSConfiguration("ami-26c43149", "");
				if (s.getCpu() == 0) {
					awsc.setInstanceType("t2.micro");
				}
				awsc.setName(s.getHost());
				awsc.setServiceInfo(new JujuServiceInfo(s.getService().getServiceName(), 
						s.getService().getServiceType()));
				configs.add(awsc);
			}
		}
		
		return configs;
	}

	@Override
	public List<String> startVirtualMachine(List<? extends Configuration> configs) {
		List<String> conInfos = new ArrayList<String>();
		
		ExecutorService es = Executors.newFixedThreadPool(4);
		List<Callable<String>> todo = new ArrayList<Callable<String>>(configs.size());

		for (Configuration configuration : configs) {
		    todo.add(new AWSInstanceBootAction(
		    		(AWSConfiguration) configuration, keyPair, service, ec2)); 
		}

		try {
			List<Future<String>> invokeAll = es.invokeAll(todo);
			for (Future<String> future : invokeAll) {
				conInfos.add(future.get());
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		es.shutdown();
		
		return conInfos;
	}

	@Override
	public void establishConnection(String kafkabroker, String topic, List<? extends Configuration> configs) {
		for (Configuration config : configs) {
			InstanceConnection ic = new InstanceConnection(new KafkaRemoteLogger(kafkabroker, topic),
					config.getConnectionInfo());
			ic.authenticate();
			ic.copyBeastFiles();
			ic.setHostnames(kafkabroker, getConnectionInfos(configs));
			ic.insertKeyToAuthorizedKeys(service.get("juju-public-key"));
			ic.executeService(kafkabroker, topic, Collections.<ConnectionInfo>emptyList());
			ic.disconnect();
		}
		
	}

	@Override
	public void shutdownAll() {
		IdleConnectionReaper.shutdown();
	}
	
	private void createSecurityGroup() {
		boolean exists = false;
		DescribeSecurityGroupsResult dsg = ec2.describeSecurityGroups();
		for (SecurityGroup sg : dsg.getSecurityGroups()) {
			if (sg.getGroupName().equals("beast")) {
				exists = true;
			}
		}
		if (!exists) {
			CreateSecurityGroupRequest csgr = new CreateSecurityGroupRequest();
			csgr.withGroupName("beast").withDescription("BeAST security group");
			ec2.createSecurityGroup(csgr);
			
			IpPermission ssh = ipPermission("0.0.0.0/0", "tcp", 22, 22);
			IpPermission hadoopPorts = ipPermission("0.0.0.0/0", "tcp", 0, 65535);
			
			ec2.authorizeSecurityGroupIngress(new AuthorizeSecurityGroupIngressRequest()
					.withGroupName("beast").withIpPermissions(ssh, hadoopPorts));
		}
	}

	private IpPermission ipPermission(String ipRange, String protocol, int from, int to) {
		return new IpPermission().withIpRanges(ipRange).withIpProtocol(protocol)
				.withFromPort(from).withToPort(to);
	}

	private KeyPair createKeyPair() {
		KeyPairInfo kpi = null;
		DescribeKeyPairsResult kps = ec2.describeKeyPairs();
		for (KeyPairInfo kp : kps.getKeyPairs()) {
			if (kp.getKeyName().equals("beast")) {
				kpi = kp;
			}
		}
		if (kpi != null) {
		ec2.deleteKeyPair(new DeleteKeyPairRequest(kpi.getKeyName()));	
		}
		
		CreateKeyPairRequest kpr = new CreateKeyPairRequest();
		kpr.withKeyName("beast");
		CreateKeyPairResult ckpr = ec2.createKeyPair(kpr);
		return ckpr.getKeyPair();
	}
	
	private List<ConnectionInfo> getConnectionInfos(List<? extends Configuration> configs) {
		List<ConnectionInfo> infos = new ArrayList<ConnectionInfo>();
		
		for (Configuration config : configs) {
			infos.add(config.getConnectionInfo());
		}
		
		return infos;
	}
	
}
