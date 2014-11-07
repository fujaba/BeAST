package de.uks.beast.editor.features.create;

import model.ModelFactory;
import model.Rack;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class CreateRackFeature extends AbstractCreateFeature
{
	
	public CreateRackFeature(final IFeatureProvider fp, final String type, final String description)
	{
		super(fp, type, description);
	}
	
	
	
	@Override
	public boolean canCreate(final ICreateContext context)
	{
		return context.getTargetContainer() instanceof Diagram;
	}
	
	
	
	@Override
	public Object[] create(final ICreateContext context)
	{
		final Rack rack = ModelFactory.eINSTANCE.createRack();
		getDiagram().eResource().getContents().add(rack);
		rack.setType("Rack");;
		addGraphicalRepresentation(context, rack);
		getFeatureProvider().getDirectEditingInfo().setActive(true);
		
		return new Object[] { rack };
	}
	
}
