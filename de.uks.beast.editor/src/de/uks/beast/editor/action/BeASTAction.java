package de.uks.beast.editor.action;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class BeASTAction implements IObjectActionDelegate
{
	private static final Logger		LOG	= LogManager.getLogger(BeASTAction.class);
	private IStructuredSelection	selection;
	private Shell					shell;
	
	
	
	@Override
	public void run(final IAction action)
	{
		final IFile file = (IFile) selection.getFirstElement();
		LOG.debug("IFile: " + file);
	}
	
	
	
	@Override
	public void selectionChanged(final IAction action, final ISelection selection)
	{
		this.selection = (IStructuredSelection) selection;
	}
	
	
	
	@Override
	public void setActivePart(final IAction action, final IWorkbenchPart targetPart)
	{
		shell = targetPart.getSite().getShell();
	}
	
	
	
	public Shell getShell()
	{
		return shell;
	}
	
}
