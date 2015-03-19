package de.uks.beast.editor.util;

public enum ToolTips
{
	//@formatter:off
	TRANSFER_BTN_TIP			("Transfer data to the backend"),
	IP_PROP_TIP					("Configure the object with a unique IP adress"),
	CPU_CORES_PROP_TIP			("Configure the server hardware. Choose the number of cpu cores"),
	MAX_RAM_PROP_TIP			("Configure the server hardware. Choose the number of maximum RAM"),
	DISK_SPACE_PROP_TIP			("Configure the server hardware. Choose the number of maximum disk space"),
	SUBNET_MASK_PROP_TIP		("Configure the network with a subnet mask"),
	GATEWAY_PROP_TIP			("Configure the network with an adress of the gateway"),
	DNS_PROP_TIP				("Configure the router with a DNS area"),
	EXT_GATEWAY_PROP_TIP		("Configure the router with an adress of the external gateway"),
	ID_PROP_TIP					("Configure the router with a unique ID"),
	;//@formatter:on
	
	private final String	text;
	
	
	
	private ToolTips(final String text)
	{
		this.text = text;
	}
	
	
	
	/**
	 * @return the text
	 */
	public final String getToolTip()
	{
		return text;
	}
	
}
