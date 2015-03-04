package de.uks.beast.server.environment.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class ConnectionInfo {

	private String host;
	private String IP;
	private File key;
	
	public ConnectionInfo(String host, String IP) {
		this.host = host;
		this.IP = IP;
	}

	public ConnectionInfo(String host, String IP, String privateKeyAsString) {
		this(host, IP);
		
		/* create private key file for athentication */
		try {
			this.key = File.createTempFile("beastkey", ".pem");
			FileWriter fw = new FileWriter(key);
			fw.write(privateKeyAsString);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public String getHostName() {
		return host;
	}
	
	public String getIp() {
		return IP;
	}
	
	public File getKey() {
		return key;
	}
	
}
