package de.uks.beast.editor.job;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;

public class Result implements IJobChangeListener
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

	@Override
	public void aboutToRun(IJobChangeEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void awake(IJobChangeEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void done(IJobChangeEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void running(IJobChangeEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scheduled(IJobChangeEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sleeping(IJobChangeEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
	
	
}
