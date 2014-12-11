package de.uks.beast.vmservice.service.model;

public class StringIntPair extends HasKey<Integer> {

	private static final long serialVersionUID = 6542219188857026338L;
	
	private Integer value;

	public StringIntPair(String key, Integer value) {
		this.key = key;
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}
	
}
