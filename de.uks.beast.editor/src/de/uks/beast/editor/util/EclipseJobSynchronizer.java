package de.uks.beast.editor.util;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import de.uks.beast.editor.job.Result;
import de.uks.beast.editor.property.data.ZipStateInterface;

public class EclipseJobSynchronizer
{
	private final de.uks.beast.editor.job.Job	beastJob;
	private final Shell							shell;
	
	
	
	public EclipseJobSynchronizer(final Shell shell, final de.uks.beast.editor.job.Job beastJob)
	{
		this.shell = shell;
		this.beastJob = beastJob;
	}
	
	
	
	public void initAndRun(final ZipStateInterface stateInterface)
	{
		
		final Job eclipseJob = new Job(beastJob.getName() + ".zip" + "...") {
			@Override
			protected IStatus run(final IProgressMonitor monitor)
			{
				final Path zipFile = Paths.get(System.getProperty("java.io.tmpdir"), beastJob.getName() + ".zip");
				FileUtil.createZipFromJob(beastJob, zipFile, monitor);
				
				if (monitor.isCanceled())
				{
					syncWithUiWithError();
					stateInterface.tell(new Result(Status.CANCEL_STATUS, zipFile));
					return Status.CANCEL_STATUS;
				}
				else
				{
					syncWithUiWithSuccess();
					stateInterface.tell(new Result(Status.OK_STATUS, zipFile));
					return Status.OK_STATUS;
				}
				
				// use this to open a Shell in the UI thread
			}
			
		};
	
		eclipseJob.setUser(true);
		eclipseJob.schedule();
	}
	
	
	
	private void syncWithUiWithError()
	{
		Display.getDefault().asyncExec(new Runnable() {
			public void run()
			{
				MessageDialog.openInformation(shell, "BeAST Zipper ", "Zipping was canceled!");
			}
		});
	}
	
	
	
	private void syncWithUiWithSuccess()
	{
		Display.getDefault().asyncExec(new Runnable() {
			public void run()
			{
				MessageDialog.openInformation(shell, "BeAST Zipper ", "Zipping of " + beastJob.getName() + ".zip"
						+ " has finished.");
			}
		});
		
	}
}
