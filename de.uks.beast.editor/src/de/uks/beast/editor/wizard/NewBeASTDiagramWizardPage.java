package de.uks.beast.editor.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class NewBeASTDiagramWizardPage extends WizardNewFileCreationPage  {

	public NewBeASTDiagramWizardPage(String pageName, IStructuredSelection selection) {
		super(pageName, selection);
		setTitle("BeAST Diagram");
		setDescription("Create a new BeAST Diagram");
		setFileExtension("diagram");
	}

}