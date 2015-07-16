package de.uks.beast.editor.property.popup;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import de.uks.beast.editor.service.job.Job;
import de.uks.beast.editor.service.job.JobBuilder;

public class InfoContainer
{
	private List<InputFileContainer>	inputFileContaineList	= null;
	private Path						jobFilePath				= null;
	private Path						jobOutputFilePath		= null;
	
	
	
	protected InfoContainer()
	{
		this.inputFileContaineList = new ArrayList<InputFileContainer>();
	}
	
	
	
	public Path getJobFilePath()
	{
		return jobFilePath;
	}
	
	
	
	public Path getJobOuputFilePath()
	{
		return jobOutputFilePath;
	}
	
	
	
	public List<InputFileContainer> getList()
	{
		return inputFileContaineList;
	}
	
	
	
	public void add(final InputFileContainer container)
	{
		if (container != null)
		{
			inputFileContaineList.add(container);
		}
	}
	
	
	
	public InputFileContainer getLastAddedInputFileContainer()
	{
		return inputFileContaineList.get(inputFileContaineList.size() - 1);
	}
	
	
	
	protected Job getBuildedJob()
	{
		final JobBuilder builder = Job.builder();
		
//		builder.setName(propertyView.getNameInput());
//		
//		final JobInterface jobFile = new JobFile(getJobFilePath().getFileName().toString(), getJobFilePath(), Paths.get(""));
//		final JobInterface jobOuputFile = new JobFile(jobOutputFilePath.getFileName().toString(), jobOutputFilePath,
//				Paths.get(""));
//		
//		builder.setJobFile(jobFile);
//		builder.setOutputFile(jobOuputFile);
//		
//		for (final InputFileContainer container : getInputFileContaineList())
//		{
//			for (final Path p : container.getInputPaths())
//			{
//				final JobInterface inputFile = new JobFile(p.getFileName().toString(), p, container.getUnzipToPath());
//				builder.addInputFiles(inputFile);
//			}
//		}
		
		return builder.build();
	}
	
	
	
	public void setJobFilePath(Path jobFilePath)
	{
		this.jobFilePath = jobFilePath;
	}
	
//	@Override
//	public void update(Observable o, Object arg)
//	{
//		
//		if (arg instanceof InputFileContainer)
//		{
//			final InputFileContainer ifc = (InputFileContainer) arg;
//			
//			for (final Path p : ifc.getInputPaths())
//			{
//				System.out.println(ifc + " -> " + p + " -> " + ifc.getUnzipToPath());
//			}
//			
//			for (final InputFileContainer c : this.inputFileContaineList)
//			{
//				for (final Path p : c.getInputPaths())
//				{
//					System.out.println("vorher: " + c + " -> " + p);
//				}
//			}
//			
//
//			inputFileContaineList.add(ifc);
////			System.out.println(ifc);
////			for(final Path p : ifc.getInputPaths()) {
////				System.out.println("input: " + p + " -> " + ifc.getUnzipToPath());
////			}
//////			for (final InputFileContainer c : inputFileContaineList)
//////			{
//////				System.out.println("#: " + c.getInputPaths().get(0) + " -> " + c.getUnzipToPath());
////////				if (c.equals(ifc))
////////				{
////////					return;
////////				}
//////			}
//			//inputFileContaineList.add(ifc);
////			
////			for (final InputFileContainer c : inputFileContaineList)
////			{
////				System.out.println("#: " + c.getInputPaths().get(0) + " -> " + c.getUnzipToPath());
////			}
//			
//			for (final InputFileContainer c : this.inputFileContaineList)
//			{
//				for (final Path p : c.getInputPaths())
//				{
//					System.out.println("nachher: " + c + " -> " + p);
//				}
//			}
//			
//		}
//		
//	}
	
}
