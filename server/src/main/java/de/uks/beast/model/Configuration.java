package de.uks.beast.model;

import de.uks.beast.server.environment.model.ConnectionInfo;
import de.uks.beast.server.service.model.ServiceInfo;

public class Configuration {
	
	public ConnectionInfo connectionInfo;
	public ServiceInfo serviceInfo;
	
	public ConnectionInfo getConnectionInfo() {
		return connectionInfo;
	}
	
	public void setConnectionInfo(ConnectionInfo connectionInfo) {
		this.connectionInfo = connectionInfo;
	}
	
	public ServiceInfo getServiceInfo() {
		return serviceInfo;
	}
	
	public void setServiceInfo(ServiceInfo serviceInfo) {
		this.serviceInfo = serviceInfo;
	}
	
}
