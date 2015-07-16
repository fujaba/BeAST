package de.uks.beast.editor.property.popup;

import java.nio.file.Path;

public class JobFileContainer
{
	private final Path	jobFilePath;
	
	
	
	public JobFileContainer(final Path path)
	{
		this.jobFilePath = path;
	}
	
	
	
	/**
	 * @return the jobFilePath
	 */
	public Path getJobFilePath()
	{
		return jobFilePath;
	}
}
