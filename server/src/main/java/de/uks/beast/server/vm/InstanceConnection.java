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

/**
 * Class to connect to an instance via (JSCH) SSH and execute needed commands
 * for BeAST VM service
 * @author kassem
 *
 */
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
	public static final String SCRIPT_LOCAL = "/util/postinstall.sh";
	public static final String SCRIPT_REMOTE = "/tmp/beast/util/postinstall.sh";
	public static final String JDK_LOCAL = "/util/jdk-8u40-linux-x64.tar.gz";
	public static final String JDK_REMOTE = "/tmp/beast/util/jdk-8u40-linux-x64.tar.gz";
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

	/**
	 * Authenticates via SSH to an instance given as the connctionInfo parameter
	 * in the constructor InstanceConnection(KafkaRemoteLogger remoteLogger, ConnectionInfo connectionInfo)
	 * Saves a JSCH session in private field session
	 */
	public void authenticate() {
		JSch jsch = new JSch();
		
		try {
			JSch.setConfig(STRICT_HOST_KEY_CHECKING, NO);
			jsch.addIdentity(connectionInfo.getKey().getAbsolutePath());
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
	
	/**
	 * Copies files for BeAST VM service to the instance
	 * Includes: 
	 * 		BeAST VM service
	 * 		post install script
	 * 		Java (8u40) JDK 
	 * 		libraries for VM service
	 */
	public void copyBeastFiles() {
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
			cs.put(filelocation + JDK_LOCAL, JDK_REMOTE);
			copyFolder(filelocation + LIB_DIR_LOCAL, LIB_DIR_REMOTE);
			ce.disconnect();
		} catch (JSchException | SftpException e) {
			logger.error("Unexpected Exception", e);
		}
	}
	
	/**
	 * Executes the BeAST VM service on the instance
	 * @param kafkabroker The kafka broker the VM service is going to send information 
	 * @param topic the kafka topic the VM service is writing to
	 */
	public void executeService(String kafkabroker, String topic) {
		try {
			/* edit /etc/hosts file (adding ip and hostname of instance) */
			String instanceEntry = connectionInfo.getPrivateIP() + "\t" + connectionInfo.getHostName();
			logger.info("Adding " + instanceEntry);
			Channel c = session.openChannel(EXEC);
		    ChannelExec add_instance_to_hosts = (ChannelExec) c;
		    add_instance_to_hosts.setCommand(ShellCommands.addToHostsFile(instanceEntry));
		    add_instance_to_hosts.setErrStream(System.err);
		    add_instance_to_hosts.connect();
		    add_instance_to_hosts.disconnect();
			
			/* edit /etc/hosts file (adding ip and hostname of kafka broker) */
			String hostname = getHostname(kafkabroker);
			kafkabroker = kafkabroker.substring(kafkabroker.indexOf("/") + 1);
			
			/*c = session.openChannel(EXEC);
		    ChannelExec edit_host = (ChannelExec) c;
		    edit_host.setCommand(ShellCommands.addToHostsFile(hostname));
		    edit_host.setErrStream(System.err);
		    edit_host.connect();
		    edit_host.disconnect();*/
			
			/* execute postinstall script */
			c = session.openChannel(EXEC);
		    ChannelExec postinstallExec = (ChannelExec) c;
		    postinstallExec.setCommand(ShellCommands.executeScript(SCRIPT_REMOTE));
		    postinstallExec.setErrStream(System.err);
		    postinstallExec.connect();
		    BufferedReader install_java_reader = new BufferedReader(new InputStreamReader(postinstallExec.getInputStream()));
		    String line1;
		    while ((line1 = install_java_reader.readLine()) != null) {
		    	logger.debug("postinstall.sh - " + line1);
		    }
		    postinstallExec.disconnect();
		    
		    /* start BeAST VM service */
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
	
	/* insert a public key to .ssh/authorized_keys */
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
	
	/* close SSH session */
	public void disconnect() {
		this.session.disconnect();
	}
	
	/* helper methods */
	private String getHostname(String kafkabroker) {
		String host = kafkabroker.substring(0, kafkabroker.indexOf("/"));
		String ip = kafkabroker.substring(kafkabroker.indexOf("/") + 1, kafkabroker.indexOf(":"));
		return ip + "\t" + host;
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

}
