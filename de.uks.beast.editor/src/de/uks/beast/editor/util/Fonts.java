package de.uks.beast.editor.util;

public enum Fonts
{
	//@formatter:off
	HADOOP_MASTER_TITEL		("Arial",		10, 		true,		true),
	HADOOP_SLAVE_TITEL		("Arial",		10, 		true,		true),
	NETWORK_TITEL			("Arial",		10, 		true,		true),
	CONTROL_CENTER_TITEL			("Arial",		10, 		true,		true),
	
	HADOOP_MASTER_PROPERTY	("Arial",		8, 			false,		true),
	HADOOP_SLAVE_PROPERTY	("Arial",		8, 			false,		true),
	NETWORK_PROPERTY		("Arial",		8, 			false,		true),
	CONTROL_CENTER_PROPERTY	("Arial",		8, 			false,		true),
	;//@formatter:on
	
	private final String	name;
	private final int		size;
	private final boolean	italic;
	private final boolean	bold;
	
	
	
	private Fonts(final String name, final int size, final boolean italic, final boolean bold)
	{
		this.name = name;
		this.size = size;
		this.italic = italic;
		this.bold = bold;
	}
	
	
	
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	
	
	
	/**
	 * @return the size
	 */
	public int getSize()
	{
		return size;
	}
	
	
	
	/**
	 * @return the italic
	 */
	public boolean isItalic()
	{
		return italic;
	}
	
	
	
	/**
	 * @return the bold
	 */
	public boolean isBold()
	{
		return bold;
	}
	
}
