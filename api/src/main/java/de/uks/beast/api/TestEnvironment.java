package de.uks.beast.api;

public class TestEnvironment {

	private String host;
	private int port = -1;
	private String diagramPath;

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

	public void setDiagramFile(String diagramPath) {
		this.diagramPath = diagramPath;
	}

	public String getDiagramPath() {
		return diagramPath;
	}
	
}
