package de.uks.beast.connection;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

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
	public static final String NO_ROUTE_TO_HOST = "java.net.NoRouteToHostException: No route to host";
	public static final String CONNECTION_REFUSED = "java.net.ConnectException: Connection refused";

	private Session session;

	private ConnectionInfo connectionInfo;

	public InstanceConnection(ConnectionInfo connectionInfo) {
		this.connectionInfo = connectionInfo;
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
			
			logger.info("[" + connectionInfo.getHostName() + "] Connection established via SSH");
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
						logger.info("[" + connectionInfo.getHostName() + "] Connection established via SSH");
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
	
	/* close SSH session */
	public void disconnect() {
		this.session.disconnect();
	}
	
	public void copyFile(String src, String dest) {
		try {
			Channel c = session.openChannel(SFTP);
			ChannelSftp cs = (ChannelSftp) c;
			cs.connect();
			cs.put(src, dest);
			cs.disconnect();
		} catch (JSchException | SftpException e) {
			logger.error("Unexpected Exception", e);
		}
	}
	
	public void downloadFolder(String src, String dest) {
		try {
			Channel c = session.openChannel(SFTP);
			ChannelSftp cs = (ChannelSftp) c;
			cs.connect();
			new File(dest).mkdirs();
			cs.get(src + "/*", dest);
			cs.disconnect();
		} catch (JSchException | SftpException e) {
			logger.error("Unexpected Exception", e);
		}
	}
	
	public void mkdir(String dest) {
		try {
			Channel c = session.openChannel(EXEC);
		    ChannelExec ce = (ChannelExec) c;
		    ce.setCommand("mkdir -p " + dest);
		    ce.setErrStream(System.err);
		    ce.connect();
		    ce.disconnect();
		} catch (JSchException e) {
			logger.error("Unexpected Exception", e);
		}
	}

	public void execute(String command) {
		try {
			Channel c = session.openChannel(EXEC);
		    ChannelExec copy = (ChannelExec) c;
			copy.setCommand(command);
		    copy.setErrStream(System.err);
		    copy.connect();
		    BufferedReader br = new BufferedReader(new InputStreamReader(copy.getInputStream()));
		    String line1;
		    while ((line1 = br.readLine()) != null) {
		    	logger.debug(line1);
		    }
		    copy.disconnect();
		} catch (Exception e) {
			logger.error("Unexpected Exception", e);
		}
	}
	
	private void execHdfsCommand(String command) {
		execute("sh hadoop-assets/command.sh \"" + command + "\"");
	}
	
	public void hdfsCopyFromLocal(String folder, String dest) {
		execHdfsCommand("/usr/local/hadoop/hadoop-2.2.0/bin/hdfs dfs -copyFromLocal " + folder + " " + dest);
	}
	
	public void hdfsCopyToLocal(String from, String to) {
		execHdfsCommand("/usr/local/hadoop/hadoop-2.2.0/bin/hdfs dfs -copyToLocal " + from + " " + to);
	}
	
	public void runJob(String jar, String name, String input, String output) {
		execHdfsCommand("/usr/local/hadoop/hadoop-2.2.0/bin/yarn jar " + jar + " " + name + " " + input + " " + output);
	}

	public void downloadResults(String results, String output) {
		downloadFolder(results, output);
	}

	
}
