package de.uks.beast.editor.features.create;

import model.ModelFactory;
import model.Switch;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class CreateSwitchFeature extends AbstractCreateFeature
{
	
	public CreateSwitchFeature(final IFeatureProvider fp, final String type, final String description)
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
		final Switch s = ModelFactory.eINSTANCE.createSwitch();
		getDiagram().eResource().getContents().add(s);
		s.setType("Switch");;
		addGraphicalRepresentation(context, s);
		getFeatureProvider().getDirectEditingInfo().setActive(true);
		
		return new Object[] { s };
	}
	
}
