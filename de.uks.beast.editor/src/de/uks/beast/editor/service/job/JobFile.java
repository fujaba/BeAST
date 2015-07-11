package de.uks.beast.editor.service.job;

import java.nio.file.Path;

public class JobFile implements JobInterface
{
	private final String	name;
	private final Path		path;
	private final Path		unzipToPath;
	
	
	
	public JobFile(final String name, final Path path, final Path unzipToPath)
	{
		this.name = name;
		this.path = path;
		this.unzipToPath = unzipToPath;
	}
	
	
	
	/**
	 * @return the path
	 */
	@Override
	public final Path getPath()
	{
		return path;
	}
	
	
	
	/**
	 * @return the name
	 */
	@Override
	public final String getName()
	{
		return name;
	}
	
	
	
	/**
	 * @return the jobFile
	 */
	@Override
	public JobFile getFile()
	{
		return this;
	}
	
	
	
	/**
	 * @return the unzip path
	 */
	@Override
	public Path unzipTo()
	{
		return unzipToPath;
	}
	
}
