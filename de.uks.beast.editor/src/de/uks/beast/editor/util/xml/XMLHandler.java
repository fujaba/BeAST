package de.uks.beast.editor.util.xml;

import java.nio.file.Path;

import de.uks.beast.editor.job.Job;

public class XMLHandler
{
	private XMLHandler()
	{
		
	}
	
	
	
	public static void writeXml(final Job job)
	{
		XMLWriter.writeXml(job);
	}
	
	
	
	public static Data readXml(final Path configXml)
	{
		return XMLReader.readXml(configXml);
	}
	
}
