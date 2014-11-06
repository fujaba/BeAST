package de.uks.beast.editor.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;

public class EditorDiagramTypeProvider extends AbstractDiagramTypeProvider {

	public EditorDiagramTypeProvider() {
		super();
		setFeatureProvider(new EditorFeatureProvider(this));
	}
}
