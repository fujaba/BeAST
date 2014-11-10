package de.uks.beast.model;

import java.io.Serializable;

public class Server implements Serializable {

	private static final long serialVersionUID = -5998846672406657793L;

	private String host;
	private int cpu;
	private int ram;
	private int diskSpace;
	
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
	
	public void setHost(String host) {
		this.host = host;
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
	
	
	public String getFlavor() {
		return "c" + cpu + "r" + ram + "d" + diskSpace;
	}
	
	@Override
	public String toString() {
		return "Host:" + host + ", CPU: " + cpu + ", RAM: " + ram + "Disk: " + diskSpace;
	}
	
}
