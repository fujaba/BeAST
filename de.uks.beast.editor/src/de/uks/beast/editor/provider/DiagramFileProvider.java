package de.uks.beast.editor.provider;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DiagramFileProvider
{
	private static final Logger			LOG			= LogManager.getLogger(DiagramFileProvider.class);
	private static DiagramFileProvider	instance	= null;
	private Path						path;
	private String						diagramName;
	
	
	
	private DiagramFileProvider()
	{
		
	}
	
	
	
	public static DiagramFileProvider getInstance()
	{
		if (instance == null)
		{
			instance = new DiagramFileProvider();
		}
		
		return instance;
	}
	
	
	
	public static void setDiagramFilePath(final String p1, final String... p)
	{
		final Path fullFilePath = Paths.get(p1, p);
		LOG.debug("set diagram file path: " + fullFilePath.toString());
		
		getInstance().path = fullFilePath;
	}
	
	
	
	public static void setDiagramName(final String name)
	{
		LOG.debug("set diagram name: " + name);
		getInstance().diagramName = name;
	}
	
	
	
	public static File getDiagramFile()
	{
		return getInstance().path.toFile();
	}
	
	
	
	public static String getDiagramName()
	{
		return getInstance().diagramName;
	}
	
}
