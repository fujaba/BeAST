package de.uks.beast.model;

import java.util.ArrayList;
import java.util.List;

public class Service {

	private String serviceName;
	private String serviceType;
	private List<Service> relations;
	
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
	
	public List<Service> getRelations() {
		return relations;
	}
	
	public void addToRelations(Service service) {
		if (this.relations == null) {
			this.relations = new ArrayList<Service>();
		}
		this.relations.add(service);
	}
	@Override
	public String toString() {
		return "Servicename:" + serviceName + ", Servicetype: " + serviceType;
	}
	
}
