package de.uks.beast.editor.wizard;

import org.eclipse.core.internal.resources.Folder;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import de.uks.beast.editor.utils.DiagramUtils;

@SuppressWarnings("restriction")
public class NewBeASTDiagramWizard extends Wizard implements INewWizard {

	public static final String id = "org.mdbda.diagrameditor.wizard.NewBeASTDiagramWizard";
	public static final String PAGE_NAME_NEW_BEAST_DIAGRAM_FILE = "New BeAST Diagram File";

	private String fileName = null;
	private Diagram diagram;
    protected IStructuredSelection selection;
    protected IWorkbench workbench;

	public NewBeASTDiagramWizard() {
		setWindowTitle(PAGE_NAME_NEW_BEAST_DIAGRAM_FILE);
	}
	
	@Override
	public void addPages() {	
		super.addPages();
		addPage(new NewBeASTDiagramWizardPage(PAGE_NAME_NEW_BEAST_DIAGRAM_FILE, selection));
		
	}
	
	public String getFileName() {
		return fileName;
	}
	
	@Override
	public boolean performFinish() {
		NewBeASTDiagramWizardPage filePage = (NewBeASTDiagramWizardPage) getPage(PAGE_NAME_NEW_BEAST_DIAGRAM_FILE);
		final String fileName = filePage.getFileName();
		Object firstElement = selection.getFirstElement();
		IProject project = null;
		if (firstElement instanceof IFile){
			IFile file = (IFile) firstElement;
			project = file.getProject();
		} else if (firstElement instanceof Folder) {
			Folder folder = (Folder) firstElement;
			project = folder.getProject();
		} else if (firstElement instanceof IProject){
			project = (IProject) firstElement;
		} 

		this.diagram =  DiagramUtils.newDiagram(project, fileName);
		this.fileName = fileName;
		
		return true;
	}

	public Diagram getDiagram() {
		return diagram;
	}
	
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		this.workbench = workbench;
	}
	

}