package de.uks.beast.editor.service.job;

import java.nio.file.Path;

public class JobOutputFile extends JobFile
{
	private final Path	externalFilePath;
	
	
	
	protected JobOutputFile(final String name, final Path homePath, final Path externalPath)
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
	
}
