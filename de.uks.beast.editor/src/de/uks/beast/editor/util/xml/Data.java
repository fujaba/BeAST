package de.uks.beast.editor.util.xml;

import java.util.ArrayList;
import java.util.List;

import de.uks.beast.editor.util.xml.XMLReader.ExtendedItem;
import de.uks.beast.editor.util.xml.XMLReader.Item;

public class Data
{
	private String						name;
	private Item						jobFile;
	private final List<ExtendedItem>	inputFiles	= new ArrayList<>();
	private Item						outputFile;
	
	
	
	protected Data()
	{
		
	}
	
	
	
	/**
	 * @return the jobFile path
	 */
	public String getJobFilePath()
	{
		return jobFile.getValue();
	}
	
	
	
	/**
	 * @return the inputFiles paths
	 */
	public List<String> getInputFilesPaths()
	{
		final List<String> tmp = new ArrayList<>();
		for (final ExtendedItem ei : inputFiles)
		{
			tmp.add(ei.getValue());
		}
		
		return tmp;
	}
	
	
	
	/**
	 * @return the source path for special inputFile
	 */
	public String getSourcePathForItem(final String name)
	{
		for (final ExtendedItem ei : inputFiles)
		{
			if (name.equals(ei.getValue()))
			{
				return ei.getSourcePath().toString();
			}
		}
		return null;
	}
	
	
	
	/**
	 * @return the target path for special inputFile
	 */
	public String getTargetPathForItem(final String name)
	{
		for (final ExtendedItem ei : inputFiles)
		{
			if (name.equals(ei.getValue()))
			{
				return ei.getTargetPath().toString();
			}
		}
		return null;
	}
	
	
	
	/**
	 * @return the outputFile path
	 */
	public String getOutputFilePath()
	{
		return outputFile.getValue();
	}
	
	
	
	/**
	 * @param jobFile the jobFile to set
	 */
	protected void setJobFile(Item jobFile)
	{
		this.jobFile = jobFile;
	}
	
	
	
	/**
	 * @param outputFile the outputFile to set
	 */
	protected void setOutputFile(Item outputFile)
	{
		this.outputFile = outputFile;
	}
	
	
	
	/**
	 * @param inputFile the inputFile to add
	 */
	protected void addInputFile(final ExtendedItem item)
	{
		if (item != null)
		{
			inputFiles.add(item);
		}
	}
	
	
	
	/**
	 * @return the job name
	 */
	public String getName()
	{
		return name;
	}
	
	
	
	/**
	 * @param name the name to set
	 */
	protected void setName(String name)
	{
		this.name = name;
	}
	
}
