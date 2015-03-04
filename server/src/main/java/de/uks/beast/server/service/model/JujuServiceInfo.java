package de.uks.beast.server.service.model;

public class JujuServiceInfo extends ServiceInfo {

	private int machineID;
	
	public JujuServiceInfo(String serviceName) {
		super(serviceName);
	}
	
	public static JujuServiceInfo from(ServiceInfo serviceInfo, int machineID) {
		JujuServiceInfo info = new JujuServiceInfo(serviceInfo.getServiceName());
		info.setMachineID(machineID);
		return info;
	}
	
	public int getMachineID() {
		return machineID;
	}
	
	public void setMachineID(int machineID) {
		this.machineID = machineID;
	}
	
}
