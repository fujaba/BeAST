package de.uks.beast.editor.features;

import model.ModelFactory;
import model.Server;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class CreateServerFeature extends AbstractCreateFeature
{
	
	public CreateServerFeature(IFeatureProvider fp, String name, String description)
	{
		super(fp, name, description);
	}
	
	
	
	@Override
	public boolean canCreate(ICreateContext context)
	{
		return context.getTargetContainer() instanceof Diagram;
	}
	
	
	
	@Override
	public Object[] create(ICreateContext context)
	{
		Server server = ModelFactory.eINSTANCE.createServer();
		getDiagram().eResource().getContents().add(server);
		server.setHost("Server");
		addGraphicalRepresentation(context, server);
		getFeatureProvider().getDirectEditingInfo().setActive(true);
		return new Object[] { server };
	}
	
}
