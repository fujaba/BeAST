package de.uks.beast.editor.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public enum Configs
{
	CONFIG_XML(Paths.get(System.getProperty("java.io.tmpdir"), "config.xml"));
	
	private final Path	path;
	
	
	
	private Configs(final Path path)
	{
		this.path = path;
	}
	
	
	
	public Path getPath()
	{
		return path;
	}
	
}
