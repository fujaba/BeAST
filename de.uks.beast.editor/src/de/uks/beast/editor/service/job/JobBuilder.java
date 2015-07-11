package de.uks.beast.editor.service.job;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JobBuilder
{
	private static final Path		DEFAULT_PATH	= Paths.get("");
	protected String				name			= "default";
	protected JobInterface			jobFile			= new JobFile("default", DEFAULT_PATH, DEFAULT_PATH);
	protected JobInterface			outputFile		= new JobFile("default", DEFAULT_PATH, DEFAULT_PATH);
	protected List<JobInterface>	inputFiles		= new ArrayList<>();
	
	
	
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
	 * @param jobInterface the jobFile to set
	 */
	public final JobBuilder setJobFile(final JobInterface jobInterface)
	{
		if (jobInterface != null)
		{
			this.jobFile = jobInterface.getFile();
		}
		
		return this;
	}
	
	
	
	/**
	 * @param jobInterface the outputFile to set
	 */
	public final JobBuilder setOutputFile(final JobInterface jobInterface)
	{
		if (jobInterface != null)
		{
			this.outputFile = jobInterface.getFile();
		}
		
		return this;
	}
	
	
	
	/**
	 * @param inputFiles the inputFiles to set
	 */
	public final JobBuilder addInputFiles(final JobInterface... inputFiles)
	{
		for (final JobInterface inputFile : inputFiles)
		{
			if (inputFile != null && Files.exists(inputFile.getPath()) && !exist(inputFile))
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
				final JobFile jobFile = new JobFile(inputFile.getFileName().toString(), inputFile, DEFAULT_PATH);
				
				if (!exist(jobFile))
				{
					inputFiles.add(jobFile);
				}
			}
		}
		
		return this;
	}
	
	
	
	private boolean exist(final JobInterface jobInterface)
	{
		for (final JobInterface ji : inputFiles)
		{
			if (jobInterface.getPath().equals(ji.getPath()))
			{
				return true;
			}
		}
		return false;
	}
	
}
