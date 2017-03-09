package de.uks.beast.editor.provider;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DiagramFileProvider
{
	private static final Logger			LOG					= LogManager.getLogger(DiagramFileProvider.class);
	private static final String			HOME_PATH_PROPERTY	= System.getProperty("user.home");
	private static final Path			DIAGRAM_ROOT		= Paths.get(HOME_PATH_PROPERTY, "runtime-EclipseApplication");
	
	private static DiagramFileProvider	instance			= null;
	
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
	
	
	
	public static void setInitialInfo(final String p1, final String... p)
	{
		final Path fullFilePath = Paths.get(p1, p);
		getInstance().path = fullFilePath;
		getInstance().diagramName = fullFilePath.getFileName().toString();
		LOG.debug("set diagram initial info: " + fullFilePath.toString());
	}
	
	
	
	public static File getDiagramFile()
	{
		if (getInstance().path != null)
		{
			LOG.info("load diagram from wizard");
			return getInstance().path.toFile();
		}
		else
		{
			LOG.info("load diagram from last active state");
			return lastActiveDiagram();
		}
		
	}
	
	
	
	private static File lastActiveDiagram()
	{
		final Path resourcePath = Paths.get(EditorDiagramTypeProvider.getCurrentDiagram().eResource().getURI().path());
		final Path subpath = resourcePath.subpath(1, resourcePath.getNameCount());
		final Path combinedPath = DIAGRAM_ROOT.resolve(subpath);
		
		return combinedPath.toFile();
	}
	
	
	
	public static String getDiagramName()
	{
		return getInstance().diagramName;
	}
	
}
