package de.uks.beast.vmservice.service.model;

import java.io.Serializable;

public abstract class HasKey<T> implements Serializable {

	private static final long serialVersionUID = 58428735421743218L;

	protected String key;
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}
	
	public abstract T getValue();
	
	@Override
	public String toString() {
		return "[" + getKey() + "]:[" + getValue() + "]";
	}
	
}
