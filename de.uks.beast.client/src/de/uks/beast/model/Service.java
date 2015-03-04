package de.uks.beast.model;

public class Service {

	private String serviceName;
	private String serviceType;
	
	public String getServiceName() {
		return serviceName;
	}
	
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	public String getServiceType() {
		return serviceType;
	}
	
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	@Override
	public String toString() {
		return "Servicename:" + serviceName + ", Servicetype: " + serviceType;
	}
	
}
