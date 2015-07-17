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

public class JobDataContainer implements Observer
{
	private final List<InputFileDataContainer>	inputFileContaineList	= new ArrayList<>();
	private JobFileDataContainer				jobFileDataContainer;
	private OutputFileDataContainer				outputFileDataContainer;
	private String							name;
	
	
	
	protected JobDataContainer()
	{
	}
	
	
	
	protected Job getBuildedJob()
	{
		final JobBuilder builder = Job.builder();
		
		builder.setName(name);
		
		final JobInterface jobFile = new JobFile(jobFileDataContainer.getJobFilePath().getFileName().toString(),
				jobFileDataContainer.getJobFilePath(), Paths.get(""));
		final JobInterface jobOuputFile = new JobFile(outputFileDataContainer.getOutputFilePath().getFileName().toString(),
				outputFileDataContainer.getOutputFilePath(), Paths.get(""));
		
		builder.setJobFile(jobFile);
		builder.setOutputFile(jobOuputFile);
		
		for (final InputFileDataContainer container : inputFileContaineList)
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
			this.jobFileDataContainer = new JobFileDataContainer(path);
		}
	}
	
	
	
	public void setJobOutputPath(final Path path)
	{
		if (path != null)
		{
			this.outputFileDataContainer = new OutputFileDataContainer(path);
		}
	}
	
	
	
	@Override
	public void update(Observable o, Object arg)
	{
		if (arg instanceof JobFileDataContainer)
		{
			final JobFileDataContainer container = (JobFileDataContainer) arg;
			
			if (container.getJobFilePath() != null && !container.getJobFilePath().toString().isEmpty())
			{
				this.jobFileDataContainer = container;
			}
			
		}
		else if (arg instanceof OutputFileDataContainer)
		{
			final OutputFileDataContainer container = (OutputFileDataContainer) arg;
			
			if (container.getOutputFilePath() != null && !container.getOutputFilePath().toString().isEmpty())
			{
				this.outputFileDataContainer = container;
			}
		}
		else if (arg instanceof InputFileDataContainer)
		{
			final InputFileDataContainer ifc = (InputFileDataContainer) arg;
			
			for (final InputFileDataContainer c : inputFileContaineList)
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
