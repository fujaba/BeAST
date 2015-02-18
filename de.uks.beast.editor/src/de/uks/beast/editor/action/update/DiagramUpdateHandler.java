package de.uks.beast.editor.action.update;

import org.eclipse.graphiti.mm.pictograms.Diagram;

import de.uks.beast.model.Hardware;
import de.uks.beast.model.InstanceInformation;

public abstract class DiagramUpdateHandler {

	protected Diagram diagram;
	protected Hardware model;

	public DiagramUpdateHandler(Diagram diagram, Hardware model) {
		this.diagram = diagram;
		this.model = model;
	}
	
	public abstract void updateShape(InstanceInformation info);
	
}
