package de.uks.beast.editor.feature.create;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import de.uks.beast.editor.util.NameCache;
import de.uks.beast.editor.util.NameCache.NameCounter;
import model.ModelFactory;
import model.Network;

public class CreateNetworkFeature extends AbstractCreateFeature
{
	
	public CreateNetworkFeature(final IFeatureProvider fp, final String name, final String description)
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
		String newDefaultName = network.getName() + NameCache.DELIMITER + NameCounter.NETWORK.getAvailableCounter();
		while (NameCache.isRegistered(Network.class, newDefaultName))
		{
			newDefaultName = network.getName() + NameCache.DELIMITER + NameCounter.NETWORK.getAvailableCounter();
		}
		NameCache.add(Network.class, newDefaultName);
		network.setName(newDefaultName);
		getDiagram().eResource().getContents().add(network);
		addGraphicalRepresentation(context, network);
		getFeatureProvider().getDirectEditingInfo().setActive(true);
		
		return new Object[] { network };
	}
	
}
