package de.uks.beast.vmservice.service.model;

public class StringDoublePair extends HasKey<Double> {

	private static final long serialVersionUID = 3859581843390277641L;
	
	private Double value;

	public StringDoublePair(String key, Double value) {
		this.key = key;
		this.value = value;
	}
	
	public Double getValue() {
		return value;
	}
	
}
