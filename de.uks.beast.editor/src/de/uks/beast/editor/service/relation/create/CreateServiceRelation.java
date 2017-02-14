package de.uks.beast.editor.service.relation.create;

import model.HadoopMaster;
import model.HadoopSlave;
import model.Service;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;

public class CreateServiceRelation extends AbstractCreateConnectionFeature
{
	
	public CreateServiceRelation(final IFeatureProvider fp, final String name, final String description)
	{
		super(fp, name, description);
	}
	
	
	
	@Override
	public boolean canCreate(final ICreateConnectionContext context)
	{
		final Object source = getBusinessObjectForPictogramElement(context.getSourcePictogramElement());
		final Object target = getBusinessObjectForPictogramElement(context.getTargetPictogramElement());
		
		if (source instanceof Service && target instanceof Service)
		{
			return true;
		}
		
		return false;
	}
	
	
	
	@Override
	public Connection create(final ICreateConnectionContext context)
	{
		Connection newConnection = null;
		
		final Object source = getBusinessObjectForPictogramElement(context.getSourcePictogramElement());
		final Object target = getBusinessObjectForPictogramElement(context.getTargetPictogramElement());
		
		if (source != null && target != null)
		{
			final AddConnectionContext addContext = new AddConnectionContext(context.getSourceAnchor(),
					context.getTargetAnchor());
			addContext.setNewObject(null);
			
			if (source instanceof HadoopMaster && target instanceof HadoopSlave)
			{
				final HadoopMaster sourceService = (HadoopMaster) source;
				final HadoopSlave targetService = (HadoopSlave) target;
				
				sourceService.getHadoopSlaves().add(targetService);
				targetService.setHadoopMaster(sourceService);
			}
			else if (source instanceof HadoopSlave && target instanceof HadoopMaster)
			{
				final HadoopSlave sourceService = (HadoopSlave) source;
				final HadoopMaster targetService = (HadoopMaster) target;
				
				sourceService.setHadoopMaster(targetService);
				targetService.getHadoopSlaves().add(sourceService);
			}
			
			newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);
			
		}
		
		return newConnection;
	}
	
	
	
	@Override
	public boolean canStartConnection(final ICreateConnectionContext context)
	{
		final Object source = getBusinessObjectForPictogramElement(context.getSourcePictogramElement());
		
		if (source instanceof Service || source instanceof Service)
		{
			return true;
		}
		
		return false;
	}
	
}
