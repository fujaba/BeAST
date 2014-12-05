package de.uks.beast.editor.features.create;

import model.ModelFactory;
import model.Network;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class CreateNetworkComponentFeature extends AbstractCreateFeature
{
	
	public CreateNetworkComponentFeature(final IFeatureProvider fp, final String name, final String description)
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
		final Network network = ModelFactory.eINSTANCE.createNetwork();
		getDiagram().eResource().getContents().add(network);
		addGraphicalRepresentation(context, network);
		getFeatureProvider().getDirectEditingInfo().setActive(true);
		
		return new Object[] { network };
	}
	
}
