package de.uks.beast.server.environment.openstack;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openstack4j.api.Builders;
import org.openstack4j.api.OSClient;
import org.openstack4j.model.compute.FloatingIP;
import org.openstack4j.model.compute.Keypair;
import org.openstack4j.model.compute.Server;
import org.openstack4j.model.compute.Server.Status;
import org.openstack4j.model.compute.ServerCreate;
import org.openstack4j.model.identity.Access;
import org.openstack4j.model.network.NetFloatingIP;
import org.openstack4j.openstack.OSFactory;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import de.uks.beast.server.BeastService;
import de.uks.beast.server.environment.model.ConnectionInfo;
import de.uks.beast.server.environment.model.OpenstackConfiguration;

public class OpenstackInstanceBootAction extends Thread {

	private static final Logger logger = LogManager.getLogger(OpenstackInstanceBootAction.class);
	
	private OpenstackConfiguration configuration;
	private Keypair keypair;
	private BeastService service;
	private Access access;
	private OSClient os;
	
	private CountDownLatch latch;
	private Object floatingIPLock;

	public OpenstackInstanceBootAction(OpenstackConfiguration configuration, Keypair keypair, BeastService service,
			Access access, CountDownLatch latch, Object floatingIPLock) {
		this.configuration = configuration;
		this.keypair = keypair;
		this.service = service;
		this.access = access;
		this.latch = latch;
		this.floatingIPLock = floatingIPLock;
	}
	
	@Override
	public void run() {
		this.os = OSFactory.clientFromAccess(access);
		
		OpenstackConfiguration cf = (OpenstackConfiguration) configuration;
		ServerCreate sc = Builders.server()
				.name(cf.getHost())
				.flavor(cf.getId())
				.image(service.get("ubuntu-image"))
				.keypairName("beast-keypair")
				.build();
		
		sc.addNetwork(cf.getNetwork(), cf.getIp());
		
		Server server = os.compute().servers().boot(sc);
		
		logger.info("[" + cf.getHost() + "] Starting instance with flavor " + cf.getId() + " ...");
		service.getRemoteLogger().info("[" + cf.getHost() + "] Starting instance ... ");
		
		while (!os.compute().servers().get(server.getId()).getStatus().equals(Status.ACTIVE)) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		logger.info("[" + cf.getHost() + "] Instance is active");
		
		NetFloatingIP netFloatingIP = null;
		
		synchronized (floatingIPLock) {
			FloatingIP ip = getFloatingIP();
			netFloatingIP = os.networking().floatingip().get(ip.getId());
			os.compute().floatingIps().addFloatingIP(server, netFloatingIP.getFloatingIpAddress());

			logger.info("[" + cf.getHost() + "] Got floating IP " + netFloatingIP.getFloatingIpAddress());
			service.getRemoteLogger().info("[" + cf.getHost() + "] Got public IP address: " + netFloatingIP.getFloatingIpAddress());
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		configuration.setConnectionInfo(new ConnectionInfo(cf.getHost(), netFloatingIP.getFloatingIpAddress(), 
				cf.getIp(), keypair.getPrivateKey()));
		
		//create port forward ?!
		try {
			JSch jsch = new JSch();
			Session session = jsch.getSession("openstack", "localhost", 22);
			session.setPassword("secloud14");
			Properties config = new Properties(); 
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			int lport = 1143;
			String rhost = configuration.getConnectionInfo().getIp();
			int rport = 1143;
			session.connect();

			int assinged_port = session.setPortForwardingL(lport, rhost, rport);
			logger.info("localhost:"+assinged_port+" -> "+rhost+":"+rport);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		latch.countDown();
	}
	
	private FloatingIP getFloatingIP() {
		for (FloatingIP ip : os.compute().floatingIps().list()) {
			if (ip.getFixedIpAddress() == null) {
				return ip;
			}
		}
		return null;
	}
	
}
