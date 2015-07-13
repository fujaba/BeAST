package de.uks.beast.editor.property.popup;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import de.uks.beast.editor.service.job.Job;
import de.uks.beast.editor.service.job.JobFile;
import de.uks.beast.editor.service.job.JobInterface;

public class PopupModel
{
	private final List<Path>			jobInputFilePaths;
	private final List<JobInterface>	jobInputFiles;
	private Path						jobFilePath;
	private Path						jobOutputFilePath;
	private Path						unzipTargetForInputs;
	
	
	
	protected PopupModel()
	{
		this.jobInputFilePaths = new ArrayList<>();
		this.jobInputFiles = new ArrayList<>();
	}
	
	
	
	protected void setJobFilePath(final Path jobFilePath)
	{
		this.jobFilePath = jobFilePath;
	}
	
	
	
	protected void addInputFilePath(final Path jobFilePath)
	{
		this.jobInputFilePaths.add(jobFilePath);
	}
	
	
	
	protected void setJobOutputFilePath(final Path jobOutputFilePath)
	{
		this.jobOutputFilePath = jobOutputFilePath;
	}
	
	
	
	protected Path getJobFilePath()
	{
		return jobFilePath;
	}
	
	
	
	protected Path getJobOuputFilePath()
	{
		return jobOutputFilePath;
	}
	
	
	
	protected List<Path> getInputFilePaths()
	{
		return jobInputFilePaths;
	}
	
	
	
	protected void addJobInputsWithSpecificUnzipTarget(final Path source, final Path target)
	{
		final JobInterface inputFile = new JobFile(source.getFileName().toString(), source, target);
		
		if (inputFile != null && !jobInputFiles.contains(inputFile) && Files.exists(inputFile.getPath()))
		{
			jobInputFiles.add(inputFile);
		}
	}
	
	
	
	protected Job getBuildedJob()
	{
		final JobInterface jobFile = new JobFile(jobFilePath.getFileName().toString(), jobFilePath, Paths.get(""));
		final JobInterface jobOuputFile = new JobFile(jobOutputFilePath.getFileName().toString(), jobOutputFilePath,
				Paths.get(""));
		return Job.builder().setJobFile(jobFile).setOutputFile(jobOuputFile)
				.addInputFilesFromPaths(jobInputFilePaths, unzipTargetForInputs).build();
	}
	
	
	
	/**
	 * @return the unzipTargetForInputs
	 */
	protected Path getUnzipTargetForInputs()
	{
		return unzipTargetForInputs;
	}
	
	
	
	/**
	 * @param unzipTargetForInputs the unzipTargetForInputs to set
	 */
	protected void setUnzipTargetForInputs(final Path unzipTargetForInputs)
	{
		this.unzipTargetForInputs = unzipTargetForInputs;
	}
}
