package de.uks.beast.editor.action;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import de.uks.beast.api.BeastTestScenario;
import de.uks.beast.api.TestEnvironment;

public class BeASTAction implements IObjectActionDelegate {

	private IStructuredSelection selection;
	private Shell shell;

	@Override
	public void run(IAction action) {
		//model lesen und serialisieren
		IFile file = (IFile) selection.getFirstElement();
		File modelFile = new File(file.getLocationURI());
		BeastTestScenario testScenario = new BeastTestScenario();
		testScenario.setEnvironment(new TestEnvironment("11.0.0.11", 9999, null));
		
		//hardware object an den server schicken
		testScenario.executeEnvironment(modelFile);
		
		//kakfa listener -> liest die queue mit VM informationen aus
		
		// (diagram öffnen) diagram aktualiseren
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
