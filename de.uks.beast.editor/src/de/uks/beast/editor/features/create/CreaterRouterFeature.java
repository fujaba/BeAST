package de.uks.beast.editor.features.create;

import model.ModelFactory;
import model.Router;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class CreaterRouterFeature extends AbstractCreateFeature
{
	
	public CreaterRouterFeature(final IFeatureProvider fp, final String name, final String description)
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
		final Router router = ModelFactory.eINSTANCE.createRouter();
		getDiagram().eResource().getContents().add(router);
		addGraphicalRepresentation(context, router);
		getFeatureProvider().getDirectEditingInfo().setActive(true);
		
		return new Object[] { router };
	}
	
}
