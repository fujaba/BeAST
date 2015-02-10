package de.uks.beast.editor.services.hadoop.create;

import model.HadoopMaster;
import model.HadoopSlave;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;

public class CreateHadoopConnection extends AbstractCreateConnectionFeature
{
	
	public CreateHadoopConnection(final IFeatureProvider fp, final String name, final String description)
	{
		super(fp, name, description);
	}
	
	
	
	@Override
	public boolean canCreate(final ICreateConnectionContext context)
	{
		final Object source = getBusinessObjectForPictogramElement(context.getSourcePictogramElement());
		final Object target = getBusinessObjectForPictogramElement(context.getTargetPictogramElement());
		
		if (source instanceof HadoopMaster && target instanceof HadoopSlave)
		{
			return true;
		}
		else if (target instanceof HadoopMaster && source instanceof HadoopSlave)
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
			final AddConnectionContext addContext = new AddConnectionContext(context.getSourceAnchor(), context.getTargetAnchor());
			addContext.setNewObject(null);
			
			if (source instanceof HadoopMaster && target instanceof HadoopSlave)
			{
				((HadoopMaster) source).getSlave().add(((HadoopSlave) target));
			}
			else if (source instanceof HadoopSlave && target instanceof HadoopMaster)
			{
				((HadoopSlave) source).setMaster(((HadoopMaster) target));
			}
			
			newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);
			
		}
		
		return newConnection;
	}
	
	
	
	@Override
	public boolean canStartConnection(final ICreateConnectionContext context)
	{
		final Object source = getBusinessObjectForPictogramElement(context.getSourcePictogramElement());
		if (source instanceof HadoopMaster || source instanceof HadoopSlave)
		{
			return true;
		}
		
		return false;
	}
	
}
