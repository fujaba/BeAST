package de.uks.beast.editor.property.popup;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Display;

import de.uks.beast.editor.service.job.Job;
import de.uks.beast.editor.util.FileBrowser;
import de.uks.beast.editor.util.FileUtil;

public class PopupController
{
	private final PopupModel	popupModel;
	private final PopupView		popupView;
	private String				fileSeparator	= FileUtil.getSpecificFileSeparator();
	
	public enum Status
	{
		SUCCES, FAIL
	}
	
	
	
	public PopupController(final Display display)
	{
		this.popupModel = new PopupModel();
		this.popupView = new PopupView(display);
		
		setListenerToView();
	}
	
	
	
	public void showPopup()
	{
		if (!popupView.isClosed())
		{
			popupView.show();
		}
		else
		{
			popupView.reCreateShellAndShow();
		}
	}
	
	
	
	public Status interactWithFileBrowser()
	{
		final FileBrowser fb = new FileBrowser();
		fb.openFileDialog();
		
		if (fb.getFileList().size() == 1)
		{
			final Path path = fb.getFileList().get(0);
			popupModel.setJobFilePath(path);
			
			return Status.SUCCES;
		}
		else
		{
			throw new RuntimeException("It is just allowd to select ONE jobFile!");
		}
	}
	
	
	
	public String getJobFileInfo()
	{
		return popupModel.getJobFilePath() + fileSeparator + popupModel.getJobFilePath().getFileName();
	}
	
	
	
	public String getJobOuputFileInfo()
	{
		return popupModel.getJobOuputFilePath() + fileSeparator + popupModel.getJobOuputFilePath().getFileName();
	}
	
	
	
	private void setListenerToView()
	{
		popupView.setFileBrowserBtnListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent event)
			{
				final FileBrowser fileBrowser = new FileBrowser();
				fileBrowser.openFileDialog();
				
				for (final Path path : fileBrowser.getFileList())
				{
					popupModel.addInputFilePath(path);
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
				if (!popupView.getTextfldInput().isEmpty())
				{
					final Path unzipToPath = Paths.get(popupView.getTextfldInput());
					
					for (final Path sourcePath : popupModel.getInputFilePaths())
					{
						popupModel.addJobInputsWithSpecificUnzipTarget(sourcePath, unzipToPath);
					}
				}
				popupView.close();
				
			}
			
			
			
			@Override
			public void widgetDefaultSelected(SelectionEvent event)
			{
				// Nothing to do!
				
			}
		});
	}
	
	
	
	public Job getJob()
	{
		return popupModel.getBuildedJob();
	}
}
