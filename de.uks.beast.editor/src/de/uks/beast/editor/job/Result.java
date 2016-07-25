package de.uks.beast.editor.job;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.core.runtime.IStatus;

public class Result
{
	private IStatus	status;
	private Path	path;

	public Result(final IStatus status, final String path) {
		this.status = status;
		this.path = Paths.get(path);
	}

	public IStatus getStatus()
	{
		return status;
	}

	public Path getPath()
	{
		return path;
	}
	
	
	
}
