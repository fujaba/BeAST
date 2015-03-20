package de.uks.beast.editor.service.job;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JobBuilder
{
	protected String		name			= "default";
	protected int			priority		= 0;
	protected boolean		runImmediately	= false;
	protected JobFile		jobFile			= new JobFile("default", Paths.get(""));
	protected JobOutputFile	outputFile		= new JobOutputFile("default", Paths.get(""), Paths.get(""));
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
		this.jobFile = jobFile;
		
		return this;
	}
	
	
	
	/**
	 * @param outputFile the outputFile to set
	 */
	public final JobBuilder setOutputFile(final JobOutputFile outputFile)
	{
		this.outputFile = outputFile;
		
		return this;
	}
	
	
	
	/**
	 * @param inputFiles the inputFiles to set
	 */
	public final JobBuilder addInputFiles(final JobFile... inputFiles)
	{
		for (final JobFile inputFile : inputFiles)
		{
			if (inputFile != null && Files.exists(inputFile.getPath()))
			{
				this.inputFiles.add(inputFile);
			}
		}
		
		return this;
	}
	
}
