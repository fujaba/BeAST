package de.uks.beast.editor.util;

public enum Properties
{
	//@formatter:off
	//types
	TYPE_NETWORK				("Network"),
	TYPE_HADOOP_MASTER			("HadoopMaster"),
	TYPE_HADOOP_SLAVE			("HadoopSlave"),
	
	// keys
	NAME						("name"),
	ATTR_0						("attr_0"),
	ATTR_1						("attr_1"),
	
	//Properties/ Labels
	ATTR_0_LABEL				("Attr_0: "),
	ATTR_1_LABEL				("Attr_1: "),
	TRANSFER					("Transfer"),
	;//@formatter:on
	
	private final String	property;
	
	
	
	private Properties(final String property)
	{
		this.property = property;
	}
	
	
	
	/**
	 * @return the property
	 */
	public String get()
	{
		return property;
	}
	
}
