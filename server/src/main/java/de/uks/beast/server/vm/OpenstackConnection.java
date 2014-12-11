package de.uks.beast.server.vm;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

import de.uks.beast.server.environment.model.OpenstackConnectionInfo;

public class OpenstackConnection {
	
	private static final String NO_ROUTE_TO_HOST = "java.net.NoRouteToHostException: No route to host";
	private static final String CONNECTION_REFUSED = "java.net.ConnectException: Connection refused";

	private static Logger logger = LogManager.getLogger(OpenstackConnection.class);

	private OpenstackConnectionInfo connectionInfo;
	private Session session;

	public OpenstackConnection(OpenstackConnectionInfo connectionInfo) {
		this.connectionInfo = connectionInfo;
	}

	public void authenticate() {
		JSch jsch = new JSch();
		
		try {
			JSch.setConfig("StrictHostKeyChecking", "no");
			jsch.addIdentity(connectionInfo.getPrivateKeyFile().getAbsolutePath());
			session = jsch.getSession("ubuntu", connectionInfo.getIp(), 22);
			session.connect();
		} catch (JSchException e) {
			if (e.getMessage().equals(NO_ROUTE_TO_HOST) || e.getMessage().equals(CONNECTION_REFUSED)) {
				logger.info("Waiting for SSH daemon to be up and ready ...");
				int counter = 0;
				while (counter <= 10) {
					try {
						Thread.sleep(6000);
					} catch (InterruptedException ie) {
						logger.error("Unexpected Exception", ie);
					}
					counter++;
					try {
						session.connect();
					} catch (JSchException je) {
					}
					if (session.isConnected()) {
						logger.info("[SSH] Connected to VM");
						break;
					}
				}
				
				if (!session.isConnected()) {
					logger.fatal("Could not connect to VM.", e);
					System.exit(0);
				}
			} else {
				logger.fatal(e.getMessage(), e);
			}
		} 

	}
	
	public void copyCrawlerService() {
		try {
			String filelocation = "";
			try {
				filelocation = new File(OpenstackConnection.class.getProtectionDomain().getCodeSource()
						.getLocation().toURI().getPath()).getAbsolutePath();
				filelocation = filelocation.substring(0, filelocation.lastIndexOf("/") + 1);
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			logger.info(filelocation);
			logger.info("Deploying beast service on VM ...");

			//create tmp dir
			Channel c = session.openChannel("exec");
		    ChannelExec ce = (ChannelExec) c;
		    ce.setCommand("mkdir -p /tmp/beast/util/");
		    ce.setErrStream(System.err);
		    ce.connect();
		    ce.disconnect();
			
			c = session.openChannel("sftp");
			ChannelSftp cs = (ChannelSftp) c;
			cs.connect();
			cs.put(filelocation + "/util/bservice.jar", "/tmp/beast/util/bservice.jar");
			cs.put(filelocation + "/util/install_java.sh", "/tmp/beast/util/install_java.sh");
			copyFolder(filelocation + "/util/libs", "/tmp/beast/util/libs");
			ce.disconnect();
		} catch (JSchException | SftpException e) {
			logger.error("Unexpected Exception", e);
		}
	}
	
	private void copyFolder(String src, String dest) {
		try {
			Channel c = session.openChannel("exec");
		    ChannelExec ce = (ChannelExec) c;
		    ce.setCommand("mkdir -p " + dest);
		    ce.setErrStream(System.err);
		    ce.connect();
		    ce.disconnect();
		    
		    c = session.openChannel("sftp");
			ChannelSftp cs = (ChannelSftp) c;
			cs.connect();
			
			File root = new File(src);
			for (File file : root.listFiles()) {
				recursiveCopy(cs, file);
			}
		    
		    
		} catch (JSchException e) {
			logger.error("Unexpected Exception", e);
		}
	}
	
	private void recursiveCopy(ChannelSftp cs, File file) {
//		cs.put(file, dest);
	}

	public void executeService(String kafkabroker, String topic) {
		logger.info("Starting beast service on VM with args[0] = " + kafkabroker +
				", args[1] = " + topic);
		try {
			Channel c = session.openChannel("exec");
		    ChannelExec ce = (ChannelExec) c;
	
		    ce.setCommand("ls /tmp/beast/util/");
		    ce.setErrStream(System.err);
	
		    ce.connect();
	
		    BufferedReader reader = new BufferedReader(new InputStreamReader(ce.getInputStream()));
		    String line;
		    while ((line = reader.readLine()) != null) {
		      System.out.println(line);
		    }
	
		    ce.disconnect();
		} catch (Exception e) {
			logger.error("Unexpected Exception", e);
		}
	}
	
	public void disconnect() {
		this.session.disconnect();
	}

}
