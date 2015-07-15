package de.uks.beast.editor.property.popup;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import de.uks.beast.editor.property.section.HadoopPropertyView;
import de.uks.beast.editor.service.job.Job;
import de.uks.beast.editor.service.job.JobInterface;
import de.uks.beast.editor.util.EclipseJobSynchronizer;
import de.uks.beast.editor.util.FileBrowser;
import de.uks.beast.editor.util.FileUtil;

public class JobInformationController extends Observable
{
	private static final Logger			LOG				= LogManager.getLogger(JobInformationController.class);
	private static final String			FILE_SEPARATOR	= FileUtil.getSpecificFileSeparator();
	private final InfoContainer			infoContainer	= new InfoContainer();
	private final PopupView				popupView;
	private final HadoopPropertyView	propertyView;
	private final List<Path>			tmpList			= new ArrayList<>();
	private final Shell					mainShell;
	
	
	
	public JobInformationController(final Display display, final Composite parent, final TabbedPropertySheetWidgetFactory factory)
	{
		this.popupView = new PopupView(display);
		this.propertyView = new HadoopPropertyView(parent, factory);
		this.mainShell = parent.getShell();
		
		init();
	}
	
	
	
	private void init()
	{
		addObservers();
		setListenerToPropertyView();
		setListenerToPopupView();
	}
	
	
	
	private void addObservers()
	{
		this.addObserver(infoContainer);
		this.addObserver(popupView);
		this.addObserver(propertyView);
	}
	
	
	
	private void update(final InputFileContainer container)
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
	
	
	
	private void setListenerToPopupView()
	{
		popupView.setFileBrowserBtnListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent event)
			{
				if (!tmpList.isEmpty())
				{
					tmpList.clear();
				}
				
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
				if (popupView.getTextfldInput() != null && !popupView.getTextfldInput().isEmpty())
				{
					final Path unzipToPath = Paths.get(popupView.getTextfldInput());
					update(new InputFileContainer(tmpList, unzipToPath));
					
				}
				update(Instruction.HIDE);
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
//				final FileBrowser fb = new FileBrowser();
//				fb.openFileDialog();
//				
//				if (fb.getFileList().size() == 1)
//				{
//					infoContainer.setJobFilePath(fb.getFileList().get(0));
//					infoContainer.setJobFileChanged(true);
//					changeRequest(infoContainer);
//				}
//				else
//				{
//					//clearChanged();
//					throw new RuntimeException("It is just allowd to select ONE jobFile!");
//				}
			}
			
			
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0)
			{
				// TODO Auto-generated method stub
				
			}
		});
		
		propertyView.addHandlerToInputFilesBtn(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				update(Instruction.OPEN);
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
					final Job job = infoContainer.getBuildedJob();
					
					printJob(job);
					
					final EclipseJobSynchronizer jobSynchronizer = new EclipseJobSynchronizer(mainShell, job);
					jobSynchronizer.initAndRun();
					
					update(Instruction.CLOSE);
				}
				catch (final Exception e)
				{
					throw new RuntimeException("Error while building or zipping!", e);
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
				update(Instruction.CLEAR);
			}
			
			
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0)
			{
				// Nothing to do!
				
			}
		});
		
	}
	
	
	
	private void printJob(final Job job)
	{
		LOG.debug("############### <buildedJob> ###############");
		LOG.debug("Name: " + job.getName() + " with " + job.getFileCount() + " files");
		LOG.debug("JobFile: " + job.getJobFile().getPath() + FILE_SEPARATOR + job.getJobFile().getName());
		for (final JobInterface inputFile : job.getInputFiles())
		{
			LOG.debug("InputFile: " + inputFile.getPath() + FILE_SEPARATOR + inputFile.getName() + " with unzipTarget: "
					+ inputFile.unzipTo());
		}
		LOG.debug("outputFile: " + job.getOutputFile().getPath() + FILE_SEPARATOR + job.getOutputFile().getName());
		LOG.debug("############### </buildedJob> ###############");
	}
	
}
