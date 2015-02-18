package de.uks.beast.api.kafka;

import java.io.Serializable;

public class InstanceInformation implements Serializable {

	private static final long serialVersionUID = 894967266810935918L;
	
	private String host;
	private String key;
	private String value;

	public InstanceInformation() {}
	
	public InstanceInformation(String host, String key, String value) {
		this.host = host;
		this.key = key;
		this.value = value;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getHost() {
		return host;
	}
	
	public String getKey() {
		return key;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return host + " " + key + " " + value;
	}
	
}