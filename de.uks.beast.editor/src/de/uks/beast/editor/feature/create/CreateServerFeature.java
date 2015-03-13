package de.uks.beast.editor.feature.create;

import model.Group;
import model.ModelFactory;
import model.Server;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

public class CreateServerFeature extends AbstractCreateFeature
{
	
	public CreateServerFeature(final IFeatureProvider fp, final String type, final String description)
	{
		super(fp, type, description);
	}
	
	
	
	@Override
	public boolean canCreate(final ICreateContext context)
	{
		return getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof Group;
	}
	
	
	
	@Override
	public Object[] create(final ICreateContext context)
	{
		final Server server = ModelFactory.eINSTANCE.createServer();
		final Group parentGroup = (Group) getBusinessObjectForPictogramElement(context.getTargetContainer());
		parentGroup.getServer().add(server);
		addGraphicalRepresentation(context, server);
		getFeatureProvider().getDirectEditingInfo().setActive(true);
		
		return new Object[] { server };
	}
	
}
