package de.uks.beast.editor.feature.create;

import model.ModelFactory;
import model.Room;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class CreateRoomFeature extends AbstractCreateFeature
{
	
	public CreateRoomFeature(final IFeatureProvider fp, final String name, final String description)
	{
		super(fp, name, description);
	}
	
	
	
	@Override
	public boolean canCreate(final ICreateContext context)
	{
		return context.getTargetContainer() instanceof Diagram;
	}
	
	
	
	@Override
	public Object[] create(final ICreateContext context)
	{
	    final Room room = ModelFactory.eINSTANCE.createRoom();
	    getDiagram().eResource().getContents().add(room);	 
	    addGraphicalRepresentation(context, room);	 
	    getFeatureProvider().getDirectEditingInfo().setActive(true);
	 
	    return new Object[] { room };
	}
}
