package de.uks.beast.editor.service.job;

import java.nio.file.Path;

public class JobFile
{
	private final String	name;
	private final Path		path;
	
	
	
	public JobFile(final String name, final Path path)
	{
		this.name = name;
		this.path = path;
	}
	
	
	
	/**
	 * @return the path
	 */
	public final Path getPath()
	{
		return path;
	}
	
	
	
	/**
	 * @return the name
	 */
	public final String getName()
	{
		return name;
	}
	
}
