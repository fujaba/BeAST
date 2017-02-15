package de.uks.beast.editor.util;

public enum Strings
{
	//@formatter:off
	// Main
	PLUGIN_ID					("de.uks.beast.editor",		""),
	DIAGRAM_TYPEID				("beast", 	""),
	
	
	//Wizard
	WIZARD_PAGE_NAME			("wizardPage",							""),
	WIZARD_TITLE				("BeAST Diagram File",	""),
	WIZARD_DESCRIPTION			("",									"This wizard creates a new file with *.diagram extension that can be opened by a multi-page editor."),
	BROWSE_BUTTON_TEXT			("Browse...",							""),
	FILE_LABEL					("File name:",							""),
	CONTAINER_LABEL				("Container:",							""),
	FILE_ENDING					(".diagram", 							""),
	FILE_TYPE					("diagram", 							""),
	DEFAULT_FILENAME			("new_file",							""),	
	
	
	// True reasons
	NAME_TRUE_REASON			("Name is out of date!", 				""),
	ATTR_0_TRUE_REASON				("Attr_0 is out of date!", 					""),
	ATTR_1_TRUE_REASON				("Attr_1 is out of date!", 				""),
	
	
	//Editor objects
	NETWORK						("Network", 			"This is a network"),
	CONNECTION					("Connection",			"This is a connection between two objects"),
	HADOOP						("Hadoop",				"This is a Hadoop charm"),
	
	HADOOP_MASTER				("HadoopMaster",		"hadoop", 	"hadoop-master",	"This is a Hadoop charm - HadoopMaster"),
	HADOOP_SLAVE				("HadoopSlave",			"hadoop", 	"hadoop-slave",		"This is a Hadoop charm - HadoopSlave"),
	
	EMPTY						("",					""),			

	
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
