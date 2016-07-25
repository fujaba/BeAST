package de.uks.beast.editor.job;

import java.nio.file.Path;

import org.eclipse.core.runtime.IStatus;

public class Result
{
	private IStatus	status;
	private Path	path;

	public Result(final IStatus status, final Path path) {
		this.status = status;
		this.path = path;
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
