package de.uks.beast.server;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;

import de.uks.beast.server.akka.AkkaServer;
import de.uks.beast.server.environment.BeastEnvironment;
import de.uks.beast.server.environment.OpenstackEnvironment;

public class BeastService implements Daemon {

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
		
		AkkaServer server = new AkkaServer(this, get("publicip"), Integer.parseInt(get("port")));
		server.start();
	}

	private void setEnvironments() {
		this.environments.put("openstack", new OpenstackEnvironment(this));
	}

	public void destroy() {
		
	}

	public void init(DaemonContext arg0) throws DaemonInitException, Exception {
		
	}

	public void start() throws Exception {
		main(null);
	}

	public void stop() throws Exception {
		
	}
	
	public String get(String key) {
		return props.getProperty(key);
	}
	
	public BeastEnvironment getEnvironment() {
		return environment;
	}
	
}
