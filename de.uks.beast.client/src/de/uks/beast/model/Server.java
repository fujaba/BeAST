package de.uks.beast.model;

import java.io.Serializable;

public class Server implements Serializable {

	private static final long serialVersionUID = -5998846672406657793L;

	private Network network;
	private String host;
	private String ip;
	private int cpu;
	private int ram;
	private int diskSpace;
	private Service service;


	public Network myGetNetwork() {
		return network;
	}

	public void setNetwork(Network network) {
		this.network = network;
	}

	public String getHost() {
		return host;
	}
	
	public String getIp() {
		return ip;
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
	
	public Service getService() {
		return service;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public void setCpu(int cpu) {
		this.cpu = cpu;
	}
	
	public void setRam(int ram) {
		this.ram = ram;
	}
	
	public void setDiskSpace(int diskSpace) {
		this.diskSpace = diskSpace;
	}
	
	public void setService(Service service) {
		this.service = service;
	}
	
	public String buildFlavor() {
		return "b1.c" + cpu + "r" + ram + "d" + diskSpace;
	}
	
	@Override
	public String toString() {
		return "Host:" + host + ", IP: " + ip + ", CPU: " + cpu + ", RAM: " + ram + ", Disk: " + diskSpace + ", Service: " + service;
	}
	
}
