package de.uks.beast.editor.feature.create;

import model.ModelFactory;
import model.Service;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class CreateHadoopMasterFeature extends AbstractCreateFeature
{
	
	public CreateHadoopMasterFeature(final IFeatureProvider fp, final String type, final String description)
	{
		super(fp, type, description);
	}
	
	
	
	@Override
	public boolean canCreate(final ICreateContext context)
	{
		if (getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof Service)
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
		final Service service = ModelFactory.eINSTANCE.createHadoopMaster();
		
		if (context.getTargetContainer() instanceof Diagram)
		{
			getDiagram().eResource().getContents().add(service);
		}
		
		addGraphicalRepresentation(context, service);
		getFeatureProvider().getDirectEditingInfo().setActive(true);
		
		return new Object[] { service };
		
	}
	
}
