package de.uks.beast.editor.service.job;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Job
{
	private final String				name;
	private final JobInterface			jobFile;
	private final JobInterface			outputFile;
	private final List<JobInterface>	inputFiles;
	private final int					counter;
	
	
	
	protected Job(final JobBuilder builder)
	{
		this.name = builder.name;
		this.jobFile = builder.jobFile;
		this.outputFile = builder.outputFile;
		this.inputFiles = builder.inputFiles;
		this.counter = countFiles();
	}
	
	
	
	private int countFiles()
	{
		final AtomicInteger counter = new AtomicInteger(0);
		
		if (jobFile != null)
		{
			counter.incrementAndGet();
		}
		if (outputFile != null)
		{
			counter.incrementAndGet();
		}
		if (!inputFiles.isEmpty())
		{
			counter.set(counter.get() + inputFiles.size());
		}
		
		return counter.get();
	}
	
	
	
	public static JobBuilder builder()
	{
		return new JobBuilder();
	}
	
	
	
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	
	
	
	/**
	 * @return the jobFile
	 */
	public JobInterface getJobFile()
	{
		return jobFile;
	}
	
	
	
	/**
	 * @return the outputFile
	 */
	public JobInterface getOutputFile()
	{
		return outputFile;
	}
	
	
	
	/**
	 * @return the inputFiles
	 */
	public List<JobInterface> getInputFiles()
	{
		return inputFiles;
	}
	
	
	
	public int getFileCount()
	{
		return counter;
	}
	
}
