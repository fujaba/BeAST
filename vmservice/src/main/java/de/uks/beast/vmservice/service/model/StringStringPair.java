package de.uks.beast.vmservice.service.model;

public class StringStringPair extends HasKey<String> {

	private static final long serialVersionUID = 894967266810935918L;
	
	private String value;

	public StringStringPair(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}