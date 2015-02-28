package de.uks.beast.editor.util;

public enum Strings
{
	//@formatter:off
	// Main
	PLUGIN_ID					("de.uks.beast.editor",		""),
	DIAGRAM_TYPEID				("hardwareComposition", 	""),
	
	
	//Wizard
	WIZARD_PAGE_NAME			("wizardPage",							""),
	WIZARD_TITLE				("Hardware Composition Editor File",	""),
	WIZARD_DESCRIPTION			("",									"This wizard creates a new file with *.diagram extension that can be opened by a multi-page editor."),
	BROWSE_BUTTON_TEXT			("Browse...",							""),
	FILE_LABEL					("File name:",							""),
	CONTAINER_LABEL				("Container:",							""),
	FILE_ENDING					(".diagram", 							""),
	FILE_TYPE					("diagram", 							""),
	DEFAULT_FILENAME			("new_file",							""),	
	
	
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

	
	//Editor objects
	SERVER_ROOM					("Server room",			"This is a Serverroom"),
	SERVER_RACK					("Server rack",			"Rack has many Server"),
	SERVER						("Server", 				"Server representing hardware"),
	NETWORK						("Network", 			"This is a network"),
	ROUTER						("Router", 				"This is a router"),
	CONNECTION					("Connection",			"This is a connection between two objects"),
	HADOOP_MASTER				("HadoopMaster",		"This is a Hadoop service - HadoopMaster"),
	HADOOP_SLAVE				("HadoopSlave",			"This is a Hadoop service - HadoopSlave"),
	HADOOP_CONNECTION			("HadoopConnection",	"This is a connection between HadoopMaster and HadoopSlave"),
	CASSANDRA					("Cassandra",			"This is a Cassandra service"),
	MYSQL						("MySQL",				"This is a MySQL service"),
	MONGO_DB					("MongoDB",				"This is a MongoDB service"),
	WORDPRESS					("WordPress",			"This is a WordPress service"),
	
	
	// Palette Entries
	HARDWARE_LOCATION				("Location",	"This entry provides hardware location"),
	HARDWARE_SERVER					("Server",		"This entry provides hardware server"),
	HARDWARE_NETWORK				("Network",		"This entry provides hardware network"),
	HARDWARE_ETHERNET				("Ethernet",	"This entry provides hardware ethernet"),
	SERVICE_HADOOP					("Hadoop",		"This entry provides Juju service Hadoop"),
	SERVICE_CASSANDRA				("Cassandra",	"This entry provides Juju service Cassandra"),
	SERVICE_MYSQL					("MySQL",		"This entry provides Juju service MySQL"),
	SERVICE_MONGODB					("MongoDB",		"This entry provides Juju service MongoDB"),
	SERVICE_WORDPRESS				("WordPress",	"This entry provides Juju service WordPress"),
	
	
	// warnings
	EMPTY_NAME_WARNING			("Please enter any text as class name!",	 		""),
	WRONG_SYMBOL_WARNING		("Spaces are not allowed in class names!", 			""),
	LINE_BREAK_WARNING			("Line breakes are not allowed in class names!", 	""),
	;//@formatter:on
	
	private final String	text;
	private final String	description;
	
	
	
	private Strings(final String text, final String description)
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
