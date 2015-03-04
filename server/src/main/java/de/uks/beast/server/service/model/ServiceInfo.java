package de.uks.beast.server.service.model;


public class ServiceInfo {

	protected String serviceName;
	
	protected ServiceInfo(ServiceInfo orig) {
		this(orig.getServiceName());
	}
	
	public ServiceInfo(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceName() {
		return serviceName;
	}
	
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
}
