package de.uks.beast.editor.property.popup;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import de.uks.beast.editor.service.job.Job;
import de.uks.beast.editor.service.job.JobBuilder;
import de.uks.beast.editor.service.job.JobFile;
import de.uks.beast.editor.service.job.JobInterface;

public class InfoContainer implements Observer
{
	private final List<InputFileContainer>	inputFileContaineList	= new ArrayList<>();
	private JobFileContainer				jobFileContainer;
	private OutputFileContainer				outputFileContainer;
	private String							name;
	
	
	
	protected InfoContainer()
	{
	}
	
	
	
	protected Job getBuildedJob()
	{
		final JobBuilder builder = Job.builder();
		
		builder.setName(name);
		
		final JobInterface jobFile = new JobFile(jobFileContainer.getJobFilePath().getFileName().toString(),
				jobFileContainer.getJobFilePath(), Paths.get(""));
		final JobInterface jobOuputFile = new JobFile(outputFileContainer.getOutputFilePath().getFileName().toString(),
				outputFileContainer.getOutputFilePath(), Paths.get(""));
		
		builder.setJobFile(jobFile);
		builder.setOutputFile(jobOuputFile);
		
		for (final InputFileContainer container : inputFileContaineList)
		{
			for (final Path p : container.getInputPaths())
			{
				final JobInterface inputFile = new JobFile(p.getFileName().toString(), p, container.getUnzipToPath());
				builder.addInputFiles(inputFile);
			}
		}
		
		return builder.build();
	}
	
	
	
	public void setJobFilePath(final Path path)
	{
		if (path != null)
		{
			this.jobFileContainer = new JobFileContainer(path);
		}
	}
	
	
	
	public void setJobOutputPath(final Path path)
	{
		if (path != null)
		{
			this.outputFileContainer = new OutputFileContainer(path);
		}
	}
	
	
	
	@Override
	public void update(Observable o, Object arg)
	{
		if (arg instanceof JobFileContainer)
		{
			final JobFileContainer container = (JobFileContainer) arg;
			
			if (container.getJobFilePath() != null && !container.getJobFilePath().toString().isEmpty())
			{
				this.jobFileContainer = container;
			}
			
		}
		else if (arg instanceof OutputFileContainer)
		{
			final OutputFileContainer container = (OutputFileContainer) arg;
			
			if (container.getOutputFilePath() != null && !container.getOutputFilePath().toString().isEmpty())
			{
				this.outputFileContainer = container;
			}
		}
		else if (arg instanceof InputFileContainer)
		{
			final InputFileContainer ifc = (InputFileContainer) arg;
			
			for (final InputFileContainer c : inputFileContaineList)
			{
				if (c.equals(ifc))
				{
					return;
				}
			}
			inputFileContaineList.add(ifc);
		}
		else if (arg instanceof String)
		{
			this.name = (String) arg;
		}
	}
	
}
