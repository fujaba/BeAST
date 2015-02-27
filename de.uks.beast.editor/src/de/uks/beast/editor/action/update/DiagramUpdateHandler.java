package de.uks.beast.editor.action.update;

import org.eclipse.graphiti.mm.pictograms.Diagram;

import de.uks.beast.model.Hardware;
import de.uks.beast.model.InstanceInformation;

public abstract class DiagramUpdateHandler
{
	
	protected final Diagram		diagram;
	protected final Hardware	model;
	
	
	
	public DiagramUpdateHandler(final Diagram diagram, final Hardware model)
	{
		this.diagram = diagram;
		this.model = model;
	}
	
	
	
	public abstract void updateShape(final InstanceInformation info);
	
}
