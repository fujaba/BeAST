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
	 * @return the jobFile
	 */
	public String getJobFileName()
	{
		return jobFile.getValue();
	}
	
	
	
	/**
	 * @return the inputFiles
	 */
	public List<ExtendedItem> getInputFiles()
	{
		return inputFiles;
	}
	
	
	
	/**
	 * @return the outputFile
	 */
	public Item getOutputFile()
	{
		return outputFile;
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
	 * @return the name
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
