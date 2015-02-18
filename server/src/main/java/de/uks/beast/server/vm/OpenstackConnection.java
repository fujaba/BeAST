package de.uks.beast.server.vm;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
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

import de.uks.beast.server.BeastService;
import de.uks.beast.server.environment.model.OpenstackConnectionInfo;
import de.uks.beast.server.kafka.KafkaRemoteLogger;

public class OpenstackConnection {
	
	private static final String NO_ROUTE_TO_HOST = "java.net.NoRouteToHostException: No route to host";
	private static final String CONNECTION_REFUSED = "java.net.ConnectException: Connection refused";
	private static final String ADD_HOST = "awk '/127.0.0.1/ { print; print \"P_HOST\"; next }1' /etc/hosts > /tmp/hosts && "
			+ "sudo mv /tmp/hosts /etc/hosts";

	private static Logger logger = LogManager.getLogger(OpenstackConnection.class);

	private OpenstackConnectionInfo connectionInfo;
	private Session session;
	private KafkaRemoteLogger remoteLogger;

	public OpenstackConnection(BeastService service, OpenstackConnectionInfo connectionInfo) {
		this.connectionInfo = connectionInfo;
		this.remoteLogger = service.getEnvironment().getRemoteLogger();
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
						remoteLogger.info("Connected to " + connectionInfo.getHostName());
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
			logger.info("Deploying beast service on VM ...");
			remoteLogger.info("Deploying BeAST service on instance " + connectionInfo.getHostName());

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
			copyFolder(filelocation + "/util/libs", "/tmp/beast/util");
			ce.disconnect();
		} catch (JSchException | SftpException e) {
			logger.error("Unexpected Exception", e);
		}
	}
	
	private void copyFolder(String src, String dest) {
		try {
		    Channel c = session.openChannel("sftp");
			ChannelSftp cs = (ChannelSftp) c;
			cs.connect();
			
			recursiveCopy(cs, new File(src), dest);
		} catch (JSchException e) {
			logger.error("Unexpected Exception", e);
		}
	}
	
	private void recursiveCopy(ChannelSftp cs, File file, String curDest) {
		try {
			if (file.isDirectory()) {
				String dest = curDest + "/" + file.getName();
				mkdir(dest);
				
				Thread.sleep(200);
				
				for (File f : file.listFiles()) {
					recursiveCopy(cs, f, dest);
				}
			} else {
				cs.put(file.getAbsolutePath(), curDest + "/" + file.getName());
			}
		} catch (SftpException | InterruptedException e) {
			logger.error("Unexpected Exception", e);
		}
	}

	public void executeService(String kafkabroker, String topic) {
		try {
			//edit /etc/hosts
			String hostname = getHostname(kafkabroker);
			kafkabroker = kafkabroker.substring(kafkabroker.indexOf("/") + 1);
			
			Channel c = session.openChannel("exec");
		    ChannelExec edit_host = (ChannelExec) c;
		    edit_host.setCommand(ADD_HOST.replace("P_HOST", hostname.replace(":", "\t")));
		    edit_host.setErrStream(System.err);
		    edit_host.connect();
		    edit_host.disconnect();
			
			//install java
			c = session.openChannel("exec");
		    ChannelExec install_java = (ChannelExec) c;
		    install_java.setCommand("sudo sh /tmp/beast/util/install_java.sh");
		    install_java.setErrStream(System.err);
		    install_java.connect();
		    BufferedReader install_java_reader = new BufferedReader(new InputStreamReader(install_java.getInputStream()));
		    String line1;
		    while ((line1 = install_java_reader.readLine()) != null) {
		    	logger.debug("[Java Installer] - " + line1);
		    }
		    install_java.disconnect();
		    
		    //start service
		    logger.info("Starting beast service on VM with broker = " + kafkabroker +
					" and topic = " + topic);
			Channel channel = session.openChannel("shell");
			OutputStream ops = channel.getOutputStream();
			PrintStream ps = new PrintStream(ops, true);

			channel.connect();

			ps.println("nohup java -classpath /tmp/beast/util/bservice.jar:/tmp/beast/util/libs/*" +
		    		" -Djava.library.path=/tmp/beast/util/libs/native" +
		    		" de.uks.beast.vmservice.VMService " + connectionInfo.getHostName() + " " + kafkabroker + " " + topic + " &");
			ps.close();

			// wait till executed
			Thread.sleep(2000);

			channel.disconnect();

		    logger.info("Finished with " + connectionInfo.getHostName());
		    remoteLogger.info(connectionInfo.getHostName() + " is alive.");
		} catch (Exception e) {
			logger.error("Unexpected Exception", e);
		}
	}
	
	private String getHostname(String kafkabroker) {
		String host = kafkabroker.substring(0, kafkabroker.indexOf("/"));
		String ip = kafkabroker.substring(kafkabroker.indexOf("/") + 1, kafkabroker.indexOf(":"));
		return ip + ":" + host;
	}

	private void mkdir(String dest) {
		try {
			Channel c = session.openChannel("exec");
		    ChannelExec ce = (ChannelExec) c;
		    ce.setCommand("mkdir -p " + dest);
		    ce.setErrStream(System.err);
		    ce.connect();
		    ce.disconnect();
		} catch (JSchException e) {
			logger.error("Unexpected Exception", e);
		}
	}
	
	public void disconnect() {
		this.session.disconnect();
	}

}
