package de.uks.beast.server.environment.model;

import de.uks.beast.model.Configuration;
import de.uks.beast.model.Server;

/**
 * Created by valentyn on 11/12/14.
 */
public class OpenstackConfiguration extends Configuration {

    private String network;
    private String id;
	private String host;
	private int cpu;
	private int ram;
	private int diskSpace;
	
	public OpenstackConfiguration(String networkID, String flavorID, Server server) {
		this.network = networkID;
		this.id = flavorID;
		this.host = server.getHost();
		this.cpu = server.getCpu();
		this.ram = server.getRam();
		this.diskSpace = server.getDiskSpace();
	}
	
	public String getNetwork() {
		return network;
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
