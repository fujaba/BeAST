package de.uks.beast.editor.service.job;

import java.nio.file.Path;

public class JobOutputFile extends JobFile
{
	private final Path	externalFilePath;
	
	
	
	public JobOutputFile(final String name, final Path homePath, final Path externalPath)
	{
		super(name, homePath);
		this.externalFilePath = externalPath;
	}
	
	
	
	/**
	 * @return the externalFilePath
	 */
	public final Path getExternalFilePath()
	{
		return externalFilePath;
	}
	
	
	
	@Override
	public String toString()
	{
		return "name: " + getName() + " - " + " homePath: " + getPath().toString() + " - " + " extPath: "
				+ externalFilePath.toString();
	}
}
