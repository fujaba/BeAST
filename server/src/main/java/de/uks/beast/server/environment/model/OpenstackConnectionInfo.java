package de.uks.beast.server.environment.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OpenstackConnectionInfo extends ConnectionInfo {

	private String ip;
	private File privateKeyFile;

	public OpenstackConnectionInfo(String floatingIpAddress, String privateKey) {
		this.ip = floatingIpAddress;
		
		try {
			this.privateKeyFile = File.createTempFile("beastkey", ".pem");
			FileWriter fw = new FileWriter(privateKeyFile);
			fw.write(privateKey);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public OpenstackConnectionInfo(String floatingIpAddress, File privateKeyFile) {
		this.ip = floatingIpAddress;
		this.privateKeyFile = privateKeyFile;
	}
	
	public String getIp() {
		return ip;
	}
	
	public File getPrivateKeyFile() {
		return privateKeyFile;
	}

}
