package de.uks.beast.api;

public class TestEnvironment {

	private String host;
	private int port = -1;

	public TestEnvironment(String host, int port) {
		super();
		this.host = host;
		this.port = port;
	}

	public void setHost(String host, int port) {
		this.host = host;
		this.port = port;
	}
	
	public String getHost() {
		return host;
	}
	
	public int getPort() {
		return port;
	}

}
