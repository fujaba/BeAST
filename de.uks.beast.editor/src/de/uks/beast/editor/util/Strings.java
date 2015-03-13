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
	CPU_CORES_TRUE_REASON		("CPU amount is out of date!", 			""),
	RAM_TRUE_REASON				("RAM is out of date!", 				""),
	DISKSPACE_TRUE_REASON		("Disk space is out of date!", 			""),
	ID_TRUE_REASON				("ID is out of date!", 					""),
	EXT_GATEWAY_TRUE_REASON		("External gateway is out of date!", 	""),
	DNS_TRUE_REASON				("DNS is out of date!", 				""),
	GATEWAY_TRUE_REASON			("Gateway is out of date!", 			""),
	SUBNET_MASK_TRUE_REASON		("Subnet mask is out of date!", 		""),

	
	//Editor objects
	LOCATION					("Location",			"This the provides hardware location"),
	SERVER_GROUP				("Server group",		"Group has many Server oder groups"),
	SERVER						("Server", 				"Server representing hardware"),
	NETWORK						("Network", 			"This is a network"),
	ROUTER						("Router", 				"This is a router"),
	CONNECTION					("Connection",			"This is a connection between two objects"),
	ETHERNET					("Ethernet",			"This provides ethernet connection"),
	HADOOP						("Hadoop",				"This is a Hadoop charm"),
	SERVICE_RELATION			("Service Relation"	,	"Relation",	"Relation",			"This is a relation between services"),
	
	HADOOP_MASTER				("HadoopMaster",		"hadoop", 	"hadoop-master",	"This is a Hadoop charm - HadoopMaster"),
	HADOOP_SLAVE				("HadoopSlave",			"hadoop", 	"hadoop-slave",		"This is a Hadoop charm - HadoopSlave"),
	
	CASSANDRA					("Cassandra",			"This is a Cassandra charm"),
	MYSQL						("MySQL",				"This is a MySQL charm"),
	MONGO_DB					("MongoDB",				"This is a MongoDB charm"),
	WORDPRESS					("WordPress",			"This is a WordPress charm"),
	UBUNTU						("Ubuntu",				"This is a Ubuntu charm"),
	JENKINS						("Jenkins",				"This is a Jenkins charm"),
	MEDIAWIKI					("MediaWiki",			"This is a MediaWiki charm"),
	TOMCAT						("Tomcat",				"This is a Tomcat charm"),
	APACHE2						("Apache2",				"This is a Apache2 charm"),

	
	// warnings
	EMPTY_NAME_WARNING			("Please enter any text as class name!",	 		""),
	WRONG_SYMBOL_WARNING		("Spaces are not allowed in class names!", 			""),
	LINE_BREAK_WARNING			("Line breakes are not allowed in class names!", 	""),
	;//@formatter:on
	
	private final String	text;
	private final String	serviceName;
	private final String	serviceType;
	private final String	description;
	
	
	private Strings(final String text, final String description)
	{
		this.text = text;
		this.serviceName = "";
		this.serviceType = "";
		this.description = description;
	}
	
	private Strings(final String text, final String serviceName, final String serviceType, final String description)
	{
		this.text = text;
		this.serviceName = serviceName;
		this.serviceType = serviceType;
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
	
	public String serviceName() 
	{
		return serviceName;
	}
	
	public String serviceType() 
	{
		return serviceType;
	}
	
}
