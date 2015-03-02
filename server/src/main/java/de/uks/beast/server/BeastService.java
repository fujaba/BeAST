package de.uks.beast.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Properties;

import de.uks.beast.server.akka.AkkaServer;
import de.uks.beast.server.environment.CloudEnvironment;
import de.uks.beast.server.environment.OpenstackEnvironment;
import de.uks.beast.server.kafka.KafkaRemoteLogger;
import de.uks.beast.server.service.JujuEnvironment;
import de.uks.beast.server.service.ServiceEnvironment;

public class BeastService {

	private Properties props;
	private HashMap<String, CloudEnvironment> cloudEnvironments;
	private HashMap<String, ServiceEnvironment> serviceEnvironments;
	private CloudEnvironment cloudEnvironment;
	private ServiceEnvironment serviceEnvironment;
	private KafkaRemoteLogger remoteLogger;
	
	public static void main(String[] args) {
		new BeastService().startService();
	}
	
	public BeastService() {
		this.cloudEnvironments = new HashMap<String, CloudEnvironment>();
		this.serviceEnvironments = new HashMap<String, ServiceEnvironment>(); 
	}
	
	private void setCloudEnvironments() {
		this.cloudEnvironments.put("openstack", new OpenstackEnvironment(this));
	}
	
	private void setServiceEnvironments() {
		this.serviceEnvironments.put("juju", new JujuEnvironment(this));
	}
	
	private void startService() {
		this.props = new Properties();
		
		String pathToConf = "";
		
		try {
			String full = new File(BeastService.class.getProtectionDomain().getCodeSource()
					.getLocation().toURI().getPath()).getAbsolutePath();
			pathToConf = full.substring(0, full.lastIndexOf("/")) + "/conf/config.properties";
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		try {
			this.props.load(new FileInputStream(new File(pathToConf)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setCloudEnvironments();
		setServiceEnvironments();
		
		this.cloudEnvironment = cloudEnvironments.get(get("environment"));
		this.serviceEnvironment = serviceEnvironments.get(get("service"));
		
		AkkaServer server = new AkkaServer(this, getIP(), Integer.parseInt(get("port")));
		server.start();
	}

	private String getIP() {
		try {
			return InetAddress.getLocalHost().toString().split("/")[1];
		} catch (UnknownHostException e) {
			return get("ip");
		}
	}
	
	public String get(String key) {
		return props.getProperty(key);
	}
	
	public CloudEnvironment getCloudEnvironment() {
		return cloudEnvironment;
	}
	
	public ServiceEnvironment getServiceEnvironment() {
		return serviceEnvironment;
	}
	
	public void setRemoteLogger(KafkaRemoteLogger remoteLogger){
		this.remoteLogger = remoteLogger;
	}
	
	public KafkaRemoteLogger getRemoteLogger() {
		return this.remoteLogger;
	}
	
}
