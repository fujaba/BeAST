package de.uks.beast.server.environment.model;

import de.uks.beast.model.Server;

public class OpenstackFlavor {

	private String id;
	private String host;
	private int cpu;
	private int ram;
	private int diskSpace;
	
	public OpenstackFlavor(String flavorID, Server server) {
		this.id = flavorID;
		this.host = server.getHost();
		this.cpu = server.getCpu();
		this.ram = server.getRam();
		this.diskSpace = server.getDiskSpace();
	}
	
	public String getId() {
		return id;
	}

	public String getHost() {
		return host;
	}
	
	public int getCpu() {
		return cpu;
	}
	
	public int getRam() {
		return ram;
	}
	
	public int getDiskSpace() {
		return diskSpace;
	}
	
}
