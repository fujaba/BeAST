package de.uks.beast.editor.util;

public enum StringConstants
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
	CPU_STAT					("cpuStat",			""),
	RAM_STAT					("ramStat",			""),
	
	
	//Editor objects
	SERVER_ROOM					("Server room",		"This is a Serverroom"),
	SERVER_RACK					("Server rack",		"Rack has many Server"),
	SERVER						("Server", 			"Server representing hardware"),
	NETWORK						("Network", 		"This is a network"),
	ROUTER						("Router", 			"This is a router"),
	CONNECTION					("Connection",		"This is a connection between two objects"),
	HADOOP_MASTER				("HadoopMaster",	"This is a HadoopMaster"),
	HADOOP_SLAVE				("HadoopSlave",		"This is a HadoopSlave"),
	HADOOP_CONNECTION			("HadoopConnection","This is a connection between HadoopMaster and HadoopSlave"),
	
	
	// Service Palette
	SERVICE_HADOOP					("Service: Hadoop",		"This entry provides Juju service Hadoop"),	
	
	
	//Properties/ Labels
	IP_LABEL					("IP: ", 				""),
	CPU_AMOUNT_LABEL			("CPU amount: ", 		""),
	CPU_TYPE_LABEL				("CPU type: ", 			""),
	RAM_LABEL					("RAM [mb]: ", 			""),
	DISKSPACE_LABEL				("Disk space [mb]: ", 	""),
	ID_LABEL					("ID: ", 				""),
	EXTERNAL_GATEWAY_LABEL		("External gateway: ", 	""),
	SUBNET_MASK_LABEL			("Subnet mask: ", 		""),
	GATEWAY_LABEL				("Gateway: ", 			""),
	DNS_LABEL					("DNS: ", 				""),
	SUBMIT						("submit",				""),
	
	
	// warnings
	EMPTY_NAME_WARNING			("Please enter any text as class name!",	 		""),
	WRONG_SYMBOL_WARNING		("Spaces are not allowed in class names!", 			""),
	LINE_BREAK_WARNING			("Line breakes are not allowed in class names!", 	""),
	
	//images
	HADOOP_MASTER_IMAGE		("icons/hadoop_master.png",		"de.uks.beast.editor.hadoop_master"),
	HADOOP_SLAVE_IMAGE		("icons/hadoop_slave.png",		"de.uks.beast.editor.hadoop_slave"),
	MYSQL_IMAGE				("icons/mysql.png",				"de.uks.beast.editor.mysql"),
	MONGO_DB_IMAGE			("icons/mongo_db_png",			"de.uks.beast.editor.mongo_db"),
	WORDPRESS_IMAGE			("icons/wordpress.png",			"de.uks.beast.editor.wordpress"),
	CASSANDRA_IMAGE			("icons/cassandra.png",			"de.uks.beast.editor.cassandra")		
	;//@formatter:on
	
	private final String	text;
	private final String	description;
	
	
	
	private StringConstants(final String text, final String description)
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
	
	
	
	public String getImageID()
	{
		return description();
	}
	
	
	
	public String getImagePath()
	{
		return text();
	}
	
}
