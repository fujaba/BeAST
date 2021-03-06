package de.uks.beast.editor.property.data;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import de.uks.beast.editor.job.Job;
import de.uks.beast.editor.job.JobBuilder;
import de.uks.beast.editor.job.JobFile;
import de.uks.beast.editor.job.JobInterface;
import de.uks.beast.editor.property.data.JobFileDataContainer.Type;
import de.uks.beast.editor.util.Configs;

public class JobDataContainer implements Observer
{
	private final List<InputFileDataContainer>	inputFileContaineList	= new ArrayList<>();
	private JobFileDataContainer				jobFileDataContainer;
	private JobFileDataContainer				outputFileDataContainer;
	private String								name;
	
	
	
	protected JobDataContainer()
	{
	}
	
	
	
	protected Job buildJob() throws NullPointerException
	{
		final JobBuilder builder = Job.builder();
		
		builder.setName(name);
		
		final JobInterface jobFile = new JobFile(jobFileDataContainer.getPath().getFileName().toString(),
				jobFileDataContainer.getPath(), Paths.get(""));
		final JobInterface jobOuputFile = new JobFile(Configs.CONFIG_XML.getPath().getFileName().toString(),
				outputFileDataContainer.getPath(), Paths.get(""));
		
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
	
	
	
	protected void setJobFilePath(final Path path)
	{
		if (path != null)
		{
			this.jobFileDataContainer = new JobFileDataContainer(Type.JOBFILE, path);
		}
	}
	
	
	
	protected void setJobOutputPath(final Path path)
	{
		if (path != null)
		{
			this.outputFileDataContainer = new JobFileDataContainer(Type.OUTPUTFILE, path);
		}
	}
	
	
	
	@Override
	public void update(Observable o, Object arg)
	{
		if (arg instanceof JobFileDataContainer)
		{
			final JobFileDataContainer container = (JobFileDataContainer) arg;
			
			if (Type.JOBFILE.equals(container.getType()))
			{
				
				if (container.getPath() != null && !container.getPath().toString().isEmpty())
				{
					this.jobFileDataContainer = container;
				}
			}
			else if (Type.OUTPUTFILE.equals(container.getType()))
			{
				if (container.getPath() != null && !container.getPath().toString().isEmpty())
				{
					this.outputFileDataContainer = container;
				}
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
