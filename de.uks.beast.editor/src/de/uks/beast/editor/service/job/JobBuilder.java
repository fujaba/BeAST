package de.uks.beast.editor.service.job;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JobBuilder
{
	protected String		name			= "default";
	protected int			priority		= 0;
	protected boolean		runImmediately	= false;
	protected JobFile		jobFile			= new JobFile("default", Paths.get("/test/test"));
	protected JobOutputFile	outputFile		= new JobOutputFile("default", Paths.get("/test/test"), Paths.get("/test/test"));
	protected List<JobFile>	inputFiles		= new ArrayList<>();
	
	
	
	public Job build()
	{
		return new Job(this);
	}
	
	
	
	/**
	 * @param name the name to set
	 */
	public final JobBuilder setName(final String name)
	{
		this.name = name;
		
		return this;
	}
	
	
	
	/**
	 * @param priority the priority to set
	 */
	public final JobBuilder setPriority(final int priority)
	{
		this.priority = priority;
		
		return this;
	}
	
	
	
	/**
	 * @param runImmediately the runImmediately to set
	 */
	public final JobBuilder setRunImmediately(final boolean runImmediately)
	{
		this.runImmediately = runImmediately;
		
		return this;
	}
	
	
	
	/**
	 * @param jobFile the jobFile to set
	 */
	public final JobBuilder setJobFile(final JobFile jobFile)
	{
		if (jobFile != null)
		{
			this.jobFile = jobFile;
		}
		
		return this;
	}
	
	
	
	/**
	 * @param outputFile the outputFile to set
	 */
	public final JobBuilder setOutputFile(final JobOutputFile outputFile)
	{
		if (outputFile != null)
		{
			this.outputFile = outputFile;
		}
		
		return this;
	}
	
	
	
	/**
	 * @param inputFiles the inputFiles to set
	 */
	public final JobBuilder addInputFiles(final JobFile... inputFiles)
	{
		for (final JobFile inputFile : inputFiles)
		{
			if (inputFile != null && Files.exists(inputFile.getPath()) && !isExisting(inputFile))
			{
				this.inputFiles.add(inputFile);
			}
		}
		
		return this;
	}
	
	
	
	/**
	 * @param inputFiles the inputFiles to set
	 */
	public final JobBuilder addInputFilesFromPaths(final List<Path> pathList)
	{
		for (final Path inputFile : pathList)
		{
			if (inputFile != null && Files.exists(inputFile))
			{
				final JobFile jobFile = new JobFile(inputFile.getFileName().toString(), inputFile);
				if (!isExisting(jobFile))
				{
					this.inputFiles.add(jobFile);
				}
			}
		}
		
		return this;
	}
	
	
	
	private boolean isExisting(final JobFile jobFile)
	{
		for (final JobFile jf : this.inputFiles)
		{
			if (jobFile.getPath().equals(jf.getPath()))
			{
				return true;
			}
		}
		return false;
	}
	
}
