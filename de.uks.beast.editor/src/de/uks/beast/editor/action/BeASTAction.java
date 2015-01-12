package de.uks.beast.editor.action;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class BeASTAction implements IObjectActionDelegate {

	private IStructuredSelection selection;
	private Shell shell;

	@Override
	public void run(IAction action) {
		IFile file = (IFile) selection.getFirstElement();
		System.out.println(file);
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = (IStructuredSelection) selection;
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	public Shell getShell() {
		return shell;
	}
	
}
