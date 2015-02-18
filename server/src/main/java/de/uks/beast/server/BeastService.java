package de.uks.beast.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Properties;

import de.uks.beast.server.akka.AkkaServer;
import de.uks.beast.server.environment.BeastEnvironment;
import de.uks.beast.server.environment.OpenstackEnvironment;
import de.uks.beast.server.kafka.KafkaRemoteLogger;

public class BeastService {

	private Properties props;
	private BeastEnvironment environment;
	private HashMap<String, BeastEnvironment> environments;
	
	public static void main(String[] args) {
		new BeastService().startService();
	}
	
	public BeastService() {
		this.environments = new HashMap<String, BeastEnvironment>();
	}
	
	private void startService() {
		this.props = new Properties();
		
		InputStream in = BeastService.class.getResourceAsStream("/config.properties");
		
		try {
			this.props.load(in);
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
	
	public BeastEnvironment getEnvironment() {
		return environment;
	}

	public void setRemoteLogger(KafkaRemoteLogger remoteLogger) {
		this.environment.setRemoteLogger(remoteLogger);
	}
	
}
