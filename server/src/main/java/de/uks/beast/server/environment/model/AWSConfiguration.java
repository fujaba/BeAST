package de.uks.beast.server.environment.model;

public class AWSConfiguration extends Configuration {

	private String imageId;
	private String instanceType;
	private String name;
	
	public AWSConfiguration(String imageId, String instanceType) {
		super();
		this.imageId = imageId;
		this.instanceType = instanceType;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getInstanceType() {
		return instanceType;
	}

	public void setInstanceType(String instanceType) {
		this.instanceType = instanceType;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
