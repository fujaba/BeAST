package de.uks.beast.server.service.model;

public class JujuServiceInfo extends ServiceInfo {

	private int machineID;
	
	public JujuServiceInfo(String serviceName) {
		super(serviceName);
	}
	
	public JujuServiceInfo(ServiceInfo info) {
		super(info);
	}
	
	public int getMachineID() {
		return machineID;
	}
	
	public void setMachineID(int machineID) {
		this.machineID = machineID;
	}
	
}
