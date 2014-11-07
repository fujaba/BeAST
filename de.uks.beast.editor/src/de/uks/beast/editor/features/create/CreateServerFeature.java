package de.uks.beast.editor.features.create;

import model.ModelFactory;
import model.Server;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class CreateServerFeature extends AbstractCreateFeature
{
	
	public CreateServerFeature(final IFeatureProvider fp, final String type, final String description)
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
		final Server server = ModelFactory.eINSTANCE.createServer();
		getDiagram().eResource().getContents().add(server);
		server.setType("Server");;
		addGraphicalRepresentation(context, server);
		getFeatureProvider().getDirectEditingInfo().setActive(true);
		
		return new Object[] { server };
	}
	
}