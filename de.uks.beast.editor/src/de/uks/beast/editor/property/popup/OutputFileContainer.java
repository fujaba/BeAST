package de.uks.beast.editor.property.popup;

import java.nio.file.Path;

public class OutputFileContainer
{
	private final Path	outputFilePath;
	
	
	
	public OutputFileContainer(final Path path)
	{
		this.outputFilePath = path;
	}
	
	
	
	/**
	 * @return the outputFilePath
	 */
	public Path getOutputFilePath()
	{
		return outputFilePath;
	}
}
