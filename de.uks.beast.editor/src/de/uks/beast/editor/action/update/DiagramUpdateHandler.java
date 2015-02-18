package de.uks.beast.editor.action.update;

import org.eclipse.graphiti.mm.pictograms.Diagram;

import de.uks.beast.api.kafka.InstanceInformation;

public abstract class DiagramUpdateHandler {

	protected Diagram diagram;

	public DiagramUpdateHandler(Diagram diagram) {
		this.diagram = diagram;
	}
	
	public abstract void updateShape(InstanceInformation info);
	
}
