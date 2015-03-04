package de.uks.beast.model;

public class Service {

	private String serviceName;
	
	public String getServiceName() {
		return serviceName;
	}
	
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	@Override
	public String toString() {
		return "Servicename:" + serviceName;
	}
	
}
