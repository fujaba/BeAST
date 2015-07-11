package de.uks.beast.editor.service.job;

import java.nio.file.Path;

public interface JobInterface
{
	public String getName();
	
	
	
	public Path getPath();
	
	
	
	public JobFile getFile();
	
	
	
	public Path unzipTo();
	
}
