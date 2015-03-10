package de.uks.beast.editor.feature.create;

import model.ModelFactory;
import model.Rack;
import model.Room;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

public class CreateRackFeature extends AbstractCreateFeature
{
	
	public CreateRackFeature(final IFeatureProvider fp, final String type, final String description)
	{
		super(fp, type, description);
	}
	
	
	
	@Override
	public boolean canCreate(final ICreateContext context)
	{
		return getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof Room;
	}
	
	
	
	@Override
	public Object[] create(final ICreateContext context)
	{
		final Rack rack = ModelFactory.eINSTANCE.createRack();
		final Room room = (Room) getBusinessObjectForPictogramElement(context.getTargetContainer());
		room.getRacks().add(rack);
		addGraphicalRepresentation(context, rack);
		getFeatureProvider().getDirectEditingInfo().setActive(true);
		
		return new Object[] { rack };
	}
	
}
