package de.uks.beast.editor.provider;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;

public class EditorDiagramTypeProvider extends AbstractDiagramTypeProvider
{
	
	public EditorDiagramTypeProvider(){
		super();
		setFeatureProvider(new EditorFeatureProvider(this));
	}
	
	@Override
	public boolean isAutoUpdateAtStartup() {
		return true;
	}
	
	@Override
	public boolean isAutoUpdateAtRuntimeWhenEditorIsSaved() {
		return true;
	}
	
}
