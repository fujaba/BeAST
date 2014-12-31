package de.uks.beast.editor.features.util;

public enum Message
{
	//@formatter:off
	// Main
	PLUGIN_ID					("de.uks.beast.editor",		""),
	
	// True reasons
	NAME_TRUE_REASON			("Name is out of date!", 				""),
	IP_TRUE_REASON				("IP is out of date!", 					""),
	CPU_AMOUNT_TRUE_REASON		("CPU amount is out of date!", 			""),
	CPU_TYPE_TRUE_REASON		("CPU type is out of date!", 			""),
	RAM_TRUE_REASON				("RAM is out of date!", 				""),
	DISKSPACE_TRUE_REASON		("Disk space is out of date!", 			""),
	ID_TRUE_REASON				("ID is out of date!", 					""),
	EXT_GATEWAY_TRUE_REASON		("External gateway is out of date!", 	""),
	DNS_TRUE_REASON				("DNS is out of date!", 				""),
	GATEWAY_TRUE_REASON			("Gateway is out of date!", 			""),
	SUBNET_MASK_TRUE_REASON		("Subnet mask is out of date!", 		""),
	
	// keys
	NAME						("name",			""),
	IP							("ip", 				""),
	CPU_AMOUNT					("cpuamount", 		""),
	CPU_TYPE					("cputype", 		""),
	RAM							("ram", 			""),
	DISKSPACE					("diskspace", 		""),
	ID							("id", 				""),
	EXTERNAL_GATEWAY			("externalgateway", ""),
	SUBNET_MASK					("subnetmask", 		""),
	GATEWAY						("gateway", 		""),
	DNS							("dns", 			""),
	
	//Editor objects
	SERVER_ROOM					("Server room",		"This is a Serverroom"),
	SERVER_RACK					("Server rack",		"Rack has many Server"),
	SERVER						("Server", 			"Server representing hardware"),
	NETWORK						("Network", 		"This is a network"),
	ROUTER						("Router", 			"This is a router"),
	CONNECTION					("Connection",		"This is a connection between two objects"),
	
	//Properties
	IP_LABEL					("IP: ", 				""),
	CPU_AMOUNT_LABEL			("CPU amount: ", 		""),
	CPU_TYPE_LABEL				("CPU type: ", 			""),
	RAM_LABEL					("RAM: ", 				""),
	DISKSPACE_LABEL				("Disk space: ", 		""),
	ID_LABEL					("ID: ", 				""),
	EXTERNAL_GATEWAY_LABEL		("External gateway: ", 	""),
	SUBNET_MASK_LABEL			("Subnet mask: ", 		""),
	GATEWAY_LABEL				("Gateway: ", 			""),
	DNS_LABEL					("DNS: ", 				""),
	SUBMIT						("submit",				""),
	
	// warnings
	EMPTY_NAME_WARNING			("Please enter any text as class name!",	 		""),
	WRONG_SYMBOL_WARNING		("Spaces are not allowed in class names!", 			""),
	LINE_BREAK_WARNING			("Line breakes are not allowed in class names!", 	"");	//@formatter:on
	
	private final String	text;
	private final String	description;
	
	
	
	private Message(final String text, final String description)
	{
		this.text = text;
		this.description = description;
	}
	
	
	
	public String text()
	{
		return text;
	}
	
	
	
	public String description()
	{
		return description;
	}
	
}
