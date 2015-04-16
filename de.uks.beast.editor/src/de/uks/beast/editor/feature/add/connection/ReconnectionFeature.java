package de.uks.beast.editor.feature.add.connection;

import model.Network;
import model.Router;
import model.Server;
import model.Service;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.impl.DefaultReconnectionFeature;

public class ReconnectionFeature extends DefaultReconnectionFeature
{
	
	public ReconnectionFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public boolean canReconnect(final IReconnectionContext context)
	{
		super.canReconnect(context); //delete this
		
		final Object source = getBusinessObjectForPictogramElement(context.getConnection().getStart().getParent());
		final Object target = getBusinessObjectForPictogramElement(context.getTargetPictogramElement());
		
		if (source instanceof Server && target instanceof Network)
		{
			return false;
		}
		else if (source instanceof Network && target instanceof Router)
		{
			return false;
		}
		else if (source instanceof Service && target instanceof Service)
		{
			return false;
		}
		else
		{
			return false;
		}
	}
	
	
	
	@Override
	public void preReconnect(final IReconnectionContext context)
	{
		super.preReconnect(context); // delete this
		
	}
	
	
	
	@Override
	public void postReconnect(final IReconnectionContext context)
	{
		super.postReconnect(context); //delete this
	}
	
}
