package de.uks.beast.editor.property.data;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.xml.bind.ValidationException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import de.uks.beast.editor.job.Job;
import de.uks.beast.editor.job.JobInterface;
import de.uks.beast.editor.job.Result;
import de.uks.beast.editor.property.data.JobFileDataContainer.Type;
import de.uks.beast.editor.property.popup.PopupView;
import de.uks.beast.editor.property.section.views.HadoopPropertyView;
import de.uks.beast.editor.util.EclipseJobSynchronizer;
import de.uks.beast.editor.util.FileBrowser;
import de.uks.beast.hds.client.Uploader;

public class JobDataController extends Observable
{
	private static final Logger			LOG					= LogManager.getLogger(JobDataController.class);
	private JobDataContainer			jobDataContainer	= new JobDataContainer();
	private final PopupView				popupView;
	private final HadoopPropertyView	propertyView;
	private final Shell					mainShell;
	
	
	
	public JobDataController(final Display display, final Composite parent, final TabbedPropertySheetWidgetFactory factory)
	{
		this.popupView = new PopupView(display);
		this.propertyView = new HadoopPropertyView(parent, factory);
		this.mainShell = parent.getShell();
	}
	
	
	
	public void execute()
	{
		addObservers();
		setListenerToPropertyView();
	}
	
	
	
	private void addObservers()
	{
		this.addObserver(jobDataContainer);
		this.addObserver(popupView);
		this.addObserver(propertyView);
	}
	
	
	
	private void update(final InputFileDataContainer container)
	{
		if (countObservers() > 0 && container != null)
		{
			setChanged();
			notifyObservers(container);
		}
		
	}
	
	
	
	private void update(final Instruction instruction)
	{
		if (countObservers() > 0 && instruction != null)
		{
			setChanged();
			notifyObservers(instruction);
		}
	}
	
	
	
	private void update(final JobFileDataContainer container)
	{
		if (countObservers() > 0 && container != null)
		{
			setChanged();
			notifyObservers(container);
		}
	}
	
	
	
	private void update(final String string)
	{
		if (countObservers() > 0 && string != null && !string.isEmpty())
		{
			setChanged();
			notifyObservers(string);
		}
	}
	
	
	
	private void update(final JobDataContainer container)
	{
		if (countObservers() > 0 && container != null)
		{
			setChanged();
			notifyObservers(container);
		}
	}
	
	
	
	private void setListenerToPopupView()
	{
		final List<Path> tmpList = new ArrayList<>();
		
		popupView.setFileBrowserBtnListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent event)
			{
				final FileBrowser fileBrowser = new FileBrowser();
				fileBrowser.openFileDialog();
				
				if (fileBrowser.getFileList().size() != 0)
				{
					for (final Path path : fileBrowser.getFileList())
					{
						tmpList.add(path);
					}
				}
				else
				{
					throw new RuntimeException("It is just allowd to select ONE or MORE input files!");
				}
			}
			
			
			
			@Override
			public void widgetDefaultSelected(SelectionEvent event)
			{
				// Nothing to do!
				
			}
		});
		
		popupView.setSaveBtnListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent event)
			{		
				if (!tmpList.isEmpty())
				{
					final Path unzipToPath = Paths.get(popupView.getTextfldInput());
					update(new InputFileDataContainer(tmpList, unzipToPath));
				}
				else
				{
					throw new RuntimeException("Adding input files without files or unzip path are not allowed!");
				}
				update(Instruction.CLOSE);
			}
			
			
			
			@Override
			public void widgetDefaultSelected(SelectionEvent event)
			{
				// Nothing to do!
				
			}
		});
	}
	
	
	
	private void setListenerToPropertyView()
	{
		propertyView.addHandlerToJobFileBtn(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				final FileBrowser fb = new FileBrowser();
				fb.openFileDialog();
				
				if (fb.getFileList().size() == 1)
				{
					update(new JobFileDataContainer(Type.JOBFILE, fb.getFileList().get(0)));
					update(jobDataContainer);
				}
				else
				{
					throw new RuntimeException("It is just allowd to select ONE jobFile!");
				}
			}
			
			
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0)
			{
				// Nothing to do!
				
			}
		});
		
		propertyView.addHandlerToInputFilesBtn(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				update(Instruction.OPEN);
				setListenerToPopupView();
			}
			
			
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0)
			{
				// Nothing to do!
				
			}
		});
		
		propertyView.addHandlerToTransfereBtn(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				try
				{
					update(propertyView.getNameInput());
					update(new JobFileDataContainer(Type.OUTPUTFILE, Paths.get(propertyView.getOutputFileInput())));
					
					final Job job = jobDataContainer.buildJob();
					
					if (validateJob(job))
					{
						printJob(job);
						
						final EclipseJobSynchronizer jobSynchronizer = new EclipseJobSynchronizer(mainShell, job);
						final Result result = jobSynchronizer.initAndRun();
						
						update(Instruction.CLOSE);
						
						/**
						 * start from file upload !!!!!!
						 */
						if(Status.OK_STATUS.equals(result.getStatus())) {
							final Uploader uploader = new Uploader();
							//uploader.upload(result.getPath()); 
						}
					}
					else
					{
						throw new ValidationException("Job validation failed! [validateJob(Job job) -> false]");
					}
				}
				catch (final NullPointerException | ValidationException e)
				{
					LOG.error("Job building or validation failed!", e);
				}
				
			}
			
			
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0)
			{
				// Nothing to do!
				
			}
		});
		
		propertyView.addHandlerToResetBtn(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				update(Instruction.RESET);
				jobDataContainer = new JobDataContainer();
				addObservers();
			}
			
			
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0)
			{
				// Nothing to do!
				
			}
		});
		
	}
	
	
	
	private boolean validateJob(final Job job)
	{
		final boolean nameValid = job.getName() != null && !job.getName().isEmpty();
		final boolean jobFileValid = job.getJobFile() != null && job.getJobFile().getPath() != null
				&& !job.getJobFile().getName().isEmpty();
		final boolean inputFileValid = job.getInputFiles() != null && !job.getInputFiles().isEmpty();
		final boolean outputFileValid = job.getOutputFile() != null && job.getOutputFile().getPath() != null
				&& !job.getOutputFile().getName().isEmpty();
		
		return nameValid && jobFileValid && inputFileValid && outputFileValid;
	}
	
	
	
	private void printJob(final Job job)
	{
		LOG.debug("############### <buildedJob> ###############");
		LOG.debug("Name: " + job.getName() + " with " + job.getFileCount() + " files");
		LOG.debug("JobFile: " + job.getJobFile().getPath());
		for (final JobInterface inputFile : job.getInputFiles())
		{
			LOG.debug("InputFile: " + inputFile.getPath() + " with unzipTarget: " + inputFile.unzipTo());
		}
		LOG.debug("outputFile: " + job.getOutputFile().getPath());
		LOG.debug("############### </buildedJob> ###############");
	}
	
}
