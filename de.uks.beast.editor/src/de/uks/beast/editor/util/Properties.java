package de.uks.beast.editor.util;

public enum Properties
{
	//@formatter:off
	//types
	TYPE_NETWORK				("Network"),
	TYPE_HADOOP_MASTER			("HadoopMaster"),
	TYPE_HADOOP_SLAVE			("HadoopSlave"),
	TYPE_CONTROL_CENTER			("ControlCenter"),
	
	// keys
	NAME						("name"),
	LIMIT_CPU					("limit_cpu"),
	RESERVATION_CPU				("reservation_cpu"),
	LIMIT_MEM					("limit_mem"),
	RESERVATION_MEM				("reservation_mem"),
	
	//Properties/ Labels
	LIMIT_CPU_LABEL				("Limit Cpu: "),
	RESERVATION_CPU_LABEL		("Reservation Cpu: "),
	LIMIT_MEM_LABEL				("Limit Mem: "),
	RESERVATION_MEM_LABEL		("Reservation Mem: "),
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
