package de.uks.beast.editor.property.popup;

import java.nio.file.Path;

public class OutputFileDataContainer
{
	private final Path	outputFilePath;
	
	
	
	public OutputFileDataContainer(final Path path)
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
