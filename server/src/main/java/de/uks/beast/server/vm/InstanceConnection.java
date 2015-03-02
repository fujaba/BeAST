package de.uks.beast.server.vm;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

import de.uks.beast.server.environment.model.ConnectionInfo;
import de.uks.beast.server.kafka.KafkaRemoteLogger;
import de.uks.beast.server.util.ShellCommands;

public class InstanceConnection {
	
	private static Logger logger = LogManager.getLogger(InstanceConnection.class);
	
	public static final String STRICT_HOST_KEY_CHECKING = "StrictHostKeyChecking";
	public static final String SSH_USER = "ubuntu";
	public static final String YES = "yes";
	public static final String NO = "no";
	public static final String EXEC = "exec";
	public static final String SHELL = "shell";
	public static final String SFTP = "sftp";
	public static final String BEAST_SERVICE_LOCAL = "/util/bservice.jar";
	public static final String BEAST_SERVICE_REMOTE = "/tmp/beast/util/bservice.jar";
	public static final String SCRIPT_LOCAL = "/util/install_java.sh";
	public static final String SCRIPT_REMOTE = "/tmp/beast/util/install_java.sh";
	public static final String LIB_DIR_LOCAL = "/util/libs";
	public static final String LIB_DIR_REMOTE = "/tmp/beast/util";
	public static final String NO_ROUTE_TO_HOST = "java.net.NoRouteToHostException: No route to host";
	public static final String CONNECTION_REFUSED = "java.net.ConnectException: Connection refused";

	private ConnectionInfo connectionInfo;
	private Session session;
	private KafkaRemoteLogger remoteLogger;

	public InstanceConnection(KafkaRemoteLogger remoteLogger, ConnectionInfo connectionInfo) {
		this.connectionInfo = connectionInfo;
		this.remoteLogger = remoteLogger;
	}

	public void authenticate() {
		JSch jsch = new JSch();
		
		try {
			JSch.setConfig(STRICT_HOST_KEY_CHECKING, NO);
			jsch.addIdentity(connectionInfo.getPrivateKeyFile().getAbsolutePath());
			session = jsch.getSession(SSH_USER, connectionInfo.getIp(), 22);
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
				filelocation = new File(InstanceConnection.class.getProtectionDomain().getCodeSource()
						.getLocation().toURI().getPath()).getAbsolutePath();
				filelocation = filelocation.substring(0, filelocation.lastIndexOf("/") + 1);
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			
			logger.info("Deploying beast service on VM ...");
			remoteLogger.info("Deploying BeAST service on instance " + connectionInfo.getHostName());

			/* create temporary directory for service */
			Channel c = session.openChannel(EXEC);
		    ChannelExec ce = (ChannelExec) c;
		    ce.setCommand(ShellCommands.createDirectory(LIB_DIR_REMOTE));
		    ce.setErrStream(System.err);
		    ce.connect();
		    ce.disconnect();
			
			c = session.openChannel(SFTP);
			ChannelSftp cs = (ChannelSftp) c;
			cs.connect();
			cs.put(filelocation + BEAST_SERVICE_LOCAL, BEAST_SERVICE_REMOTE);
			cs.put(filelocation + SCRIPT_LOCAL, SCRIPT_REMOTE);
			copyFolder(filelocation + LIB_DIR_LOCAL, LIB_DIR_REMOTE);
			ce.disconnect();
		} catch (JSchException | SftpException e) {
			logger.error("Unexpected Exception", e);
		}
	}
	
	private void copyFolder(String src, String dest) {
		try {
		    Channel c = session.openChannel(SFTP);
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
			
			Channel c = session.openChannel(EXEC);
		    ChannelExec edit_host = (ChannelExec) c;
		    edit_host.setCommand(ShellCommands.addToHostsFile(hostname.replace(":", "\t")));
		    edit_host.setErrStream(System.err);
		    edit_host.connect();
		    edit_host.disconnect();
			
			//install script
			c = session.openChannel(EXEC);
		    ChannelExec install_java = (ChannelExec) c;
		    install_java.setCommand(ShellCommands.executeScript(SCRIPT_REMOTE));
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
			Channel channel = session.openChannel(SHELL);
			OutputStream ops = channel.getOutputStream();
			PrintStream ps = new PrintStream(ops, true);

			channel.connect();

			ps.println(ShellCommands.executeBeastService(connectionInfo.getHostName(), kafkabroker, topic));
			
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
	
	public void insertKeyToAuthorizedKeys(String publicKeyFilePath) {
		try {
			byte[] encoded = Files.readAllBytes(Paths.get(publicKeyFilePath));
			String publicKey = new String(encoded, Charset.defaultCharset());
		
			Channel c = session.openChannel(EXEC);
		    ChannelExec edit_key = (ChannelExec) c;
		    edit_key.setCommand(ShellCommands.appendToFile("/home/" + SSH_USER + "/.ssh/authorized_keys", publicKey));
		    edit_key.setErrStream(System.err);
		    edit_key.connect();
		    edit_key.disconnect();
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
			Channel c = session.openChannel(EXEC);
		    ChannelExec ce = (ChannelExec) c;
		    ce.setCommand(ShellCommands.createDirectory(dest));
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
