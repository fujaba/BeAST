package de.uks.beast.editor.util;

public enum Properties
{
	//@formatter:off
	//tpyes
	TYPE_NETWORK				("Network"),
	TYPE_SERVER					("Server"),
	TYPE_ROUTER					("Router"),	
	
	// keys
	NAME						("name"),
	IP							("ip"),
	CPU_CORES					("cpucores"),
	RAM							("ram"),
	DISKSPACE					("diskspace"),
	ID							("id"),
	EXTERNAL_GATEWAY			("externalgateway"),
	SUBNET_MASK					("subnetmask"),
	GATEWAY						("gateway"),
	DNS							("dns"),
	CPU_STAT					("cpuStat"),
	RAM_STAT					("ramStat"),
	STAT_LABEL					("stats"),
	
	
	//Properties/ Labels
	IP_LABEL					("IP: "),
	CPU_CORES_LABEL				("CPU cores: "),
	RAM_LABEL					("max. RAM [mb]: "),
	DISKSPACE_LABEL				("Diskspace [mb]: "),
	ID_LABEL					("ID: "),
	EXTERNAL_GATEWAY_LABEL		("External gateway: "),
	SUBNET_MASK_LABEL			("Subnet mask: "),
	GATEWAY_LABEL				("Gateway: "),
	DNS_LABEL					("DNS: "),
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
	public String getProperty()
	{
		return property;
	}
	
}
