package de.uks.beast.editor.property.popup;

import java.nio.file.Path;

public class JobFileDataContainer
{
	private final Path	path;
	private final Type	type;
	
	
	
	public JobFileDataContainer(final Type type, final Path path)
	{
		this.type = type;
		this.path = path;
	}
	
	
	
	/**
	 * @return the jobFilePath
	 */
	public Path getPath()
	{
		return path;
	}
	
	
	
	/**
	 * @return the type
	 */
	public Type getType()
	{
		return type;
	}
	
	public static enum Type
	{
		JOBFILE, OUTPUTFILE
	}
}
