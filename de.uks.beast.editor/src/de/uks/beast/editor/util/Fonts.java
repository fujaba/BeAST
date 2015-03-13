package de.uks.beast.editor.util;

public enum Fonts
{
	//@formatter:off
	GROUP_TITEL				("Arial",		11, 		true,		true),
	SERVER_TITEL			("Arial",		10, 		true,		true),
	ROUTER_TITEL			("Arial",		10, 		true,		true),
	NETWORK_TITEL			("Arial",		10, 		true,		true),
	GROUP_PROPERTY			("Arial",		8, 			false,		true),
	SERVER_PROPERTY			("Arial",		8, 			false,		true),
	NETWORK_PROPERTY		("Arial",		8, 			false,		true),
	ROUTER_PROPERTY			("Arial",		8, 			false,		true),
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
