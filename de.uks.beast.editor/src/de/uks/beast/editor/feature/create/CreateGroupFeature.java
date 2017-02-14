package de.uks.beast.editor.feature.create;

import model.Group;
import model.ModelFactory;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class CreateGroupFeature extends AbstractCreateFeature
{
	
	public CreateGroupFeature(final IFeatureProvider fp, final String type, final String description)
	{
		super(fp, type, description);
	}
	
	
	
	@Override
	public boolean canCreate(final ICreateContext context)
	{
		if (getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof Group)
		{
			return true;
		}
		else if (context.getTargetContainer() instanceof Diagram)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	@Override
	public Object[] create(final ICreateContext context)
	{
		final Group group = ModelFactory.eINSTANCE.createGroup();
		
		if (context.getTargetContainer() instanceof Diagram)
		{
			getDiagram().eResource().getContents().add(group);
		}
		else if (getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof Group)
		{
			final Group parentGroup = (Group) getBusinessObjectForPictogramElement(context.getTargetContainer());
			parentGroup.getGroups().add(group);
		}
		
		addGraphicalRepresentation(context, group);
		getFeatureProvider().getDirectEditingInfo().setActive(true);
		
		return new Object[] { group };
	}
	
}
