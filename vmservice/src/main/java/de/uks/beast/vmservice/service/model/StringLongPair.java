package de.uks.beast.vmservice.service.model;

public class StringLongPair extends HasKey<Long> {

	private static final long serialVersionUID = 3111413023987380030L;
	
	private Long value;

	public StringLongPair(String key, Long value) {
		this.key = key;
		this.value = value;
	}
	
	public Long getValue() {
		return value;
	}
	
}
