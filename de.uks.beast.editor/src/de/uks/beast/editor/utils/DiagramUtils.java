package de.uks.beast.editor.utils;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.examples.common.FileService;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramsFactory;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import de.uks.beast.editor.Activator;
import de.uks.beast.editor.provider.EditorDiagramTypeProvider;

public class DiagramUtils {

	public static final String SELECT_DIAGRAM_TITEL = "Select Diagram";
	private static final String BEAST_DIAGRAM_TYPEID = "BeASTEditor";

	public static Diagram newDiagram(IProject project, String name){
		String editorExtension = "diagram"; //$NON-NLS-1$
		
		if(name.endsWith("."+editorExtension)){
			name = name.substring(0, name.length()-("."+editorExtension).length());
		}
		
		if (project == null || !project.isAccessible()) {
			String error = "project == null || !project.isAccessible()"; //$NON-NLS-1$
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, error);
			//ErrorDialog.openError(getShell(), "project == null || !project.isAccessible()", null, status); //$NON-NLS-1$
			return null;
		}

		final Diagram diagram = Graphiti.getPeCreateService().createDiagram(BEAST_DIAGRAM_TYPEID, name, true);
		
		IFolder diagramFolder = project.getFolder("src/diagrams/"); //$NON-NLS-1$

		String diagramTypeProviderId = GraphitiUi.getExtensionManager().getDiagramTypeProviderId(BEAST_DIAGRAM_TYPEID);
		String namingConventionID = diagramTypeProviderId + ".editor"; //$NON-NLS-1$
		IEditorDescriptor specificEditor = PlatformUI.getWorkbench().getEditorRegistry().findEditor(namingConventionID);

		final URI diagramURI  = URI.createPlatformResourceURI(diagramFolder.getFile( name + ".diagram").getFullPath().toString(),true);
		final URI modelURI =  URI.createPlatformResourceURI( diagramFolder.getFile( name + ".beastmodel").getFullPath().toString(),true);
		
//		final MDBDADiagram mdbdaDiagram = ModelFactory.eINSTANCE.createMDBDADiagram();
		FileService.createEmfFileForDiagram(diagramURI, diagram);
		ResourceSet resourceSet = diagram.eResource().getResourceSet();

		Resource diagramResource = resourceSet.getResource(diagramURI,true);						
		diagramResource.setTrackingModification(true);
		diagramResource.getContents().add(diagram);
		
		Resource modelResource = resourceSet.createResource(modelURI);
		modelResource.setTrackingModification(true);
//		modelResource.getContents().add(mdbdaDiagram);
		
		diagram.setLink(PictogramsFactory.eINSTANCE.createPictogramLink());
//		diagram.getLink().getBusinessObjects().add(mdbdaDiagram);
		
//		Workflow wf = ModelFactory.eINSTANCE.createWorkflow();
//		mdbdaDiagram.setRootWorkflow(wf);
//		mdbdaDiagram.setName(name);
//		mdbdaDiagram.setVersion(Calendar.getInstance().getTimeInMillis()+"");
		
		AddContext addContext = new AddContext();
//		addContext.setNewObject(wf);
		addContext.setLocation(10, 10);
		addContext.setTargetContainer(diagram);

		EditorDiagramTypeProvider typeProvider = new  EditorDiagramTypeProvider();
		typeProvider.resourceReloaded(diagram);
		
		try {
			modelResource.save(Collections.<Resource, Map<?, ?>> emptyMap());
			diagramResource.save(Collections.<Resource, Map<?, ?>> emptyMap());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String providerId = GraphitiUi.getExtensionManager().getDiagramTypeProviderId(diagram.getDiagramTypeId());
		DiagramEditorInput editorInput = new DiagramEditorInput(EcoreUtil.getURI(diagram), providerId);
		
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(editorInput, DiagramEditor.DIAGRAM_EDITOR_ID);
		} catch (PartInitException e) {
			e.printStackTrace();
			String error = e.getLocalizedMessage();
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, error, e);
			return null;
		}
		
		return diagram;
	}

}