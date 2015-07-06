package de.uks.beast.editor.service.job;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Job
{
	private final String		name;
	private final int			priority;
	private final boolean		runImmediately;
	private final JobFile		jobFile;
	private final JobOutputFile	outputFile;
	private final List<JobFile>	inputFiles;
	private final int			counter;
	
	
	
	protected Job(final JobBuilder builder)
	{
		this.name = builder.name;
		this.priority = builder.priority;
		this.runImmediately = builder.runImmediately;
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
	 * @return the priority
	 */
	public int getPriority()
	{
		return priority;
	}
	
	
	
	/**
	 * @return the runImmediately
	 */
	public boolean isRunImmediately()
	{
		return runImmediately;
	}
	
	
	
	/**
	 * @return the jobFile
	 */
	public JobFile getJobFile()
	{
		return jobFile;
	}
	
	
	
	/**
	 * @return the outputFile
	 */
	public JobOutputFile getOutputFile()
	{
		return outputFile;
	}
	
	
	
	/**
	 * @return the inputFiles
	 */
	public List<JobFile> getInputFiles()
	{
		return inputFiles;
	}
	
	
	
	@Override
	public String toString()
	{
		return "name: " + name + " - prio: " + priority + " - runImmediateliy: " + runImmediately;
	}
	
	
	
	public int getFileCount()
	{
		return counter;
	}
	
}
