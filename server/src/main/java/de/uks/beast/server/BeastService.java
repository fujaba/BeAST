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

public class BeastService {

	private Properties props;
	private CloudEnvironment environment;
	private HashMap<String, CloudEnvironment> environments;
	
	public static void main(String[] args) {
		new BeastService().startService();
	}
	
	public BeastService() {
		this.environments = new HashMap<String, CloudEnvironment>();
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
		
		setEnvironments();
		this.environment = environments.get(get("environment"));
		
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

	private void setEnvironments() {
		this.environments.put("openstack", new OpenstackEnvironment(this));
	}
	
	public String get(String key) {
		return props.getProperty(key);
	}
	
	public CloudEnvironment getEnvironment() {
		return environment;
	}

	public void setRemoteLogger(KafkaRemoteLogger remoteLogger) {
		this.environment.setRemoteLogger(remoteLogger);
	}
	
}
