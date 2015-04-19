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
		//super.canReconnect(context); //delete this
		
		final Object source = getBusinessObjectForPictogramElement(context.getConnection().getStart().getParent());
		final Object target = getBusinessObjectForPictogramElement(context.getTargetPictogramElement());
		
		if (source instanceof Server && target instanceof Network)
		{
			return false;
		}
		else if (source instanceof Network && target instanceof Router)
		{
			return true;
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
		System.out.println("PRE");
		final Object source = getBusinessObjectForPictogramElement(context.getConnection().getStart().getParent());
		final Object target = getBusinessObjectForPictogramElement(context.getTargetPictogramElement());
		
		final Network network = (Network) source;
		if (getBusinessObjectForPictogramElement(context.getOldAnchor().getParent()) instanceof Router)
		{
			final Router oldRouter = (Router) getBusinessObjectForPictogramElement(context.getOldAnchor().getParent());
			
			
			
			if (oldRouter != null && network.getRouter().contains(oldRouter))
			{
				network.getRouter().remove(oldRouter);
			}
			
			for(final Network n : oldRouter.getNetwork()) {
				System.out.println("##### network " + n.getName());
			}
		}
		
		for (final Router r : network.getRouter())
		{
			System.out.println("##### " + r.getName());
		}
		
	}
	
	
	
	@Override
	public void postReconnect(final IReconnectionContext context)
	{
		System.out.println("POST");
		final Object source = getBusinessObjectForPictogramElement(context.getConnection().getStart().getParent());
		final Object target = getBusinessObjectForPictogramElement(context.getTargetPictogramElement());
		
		final Network network = (Network) source;
		
		if (target instanceof Router)
		{
			final Router newRouter = (Router) target;
			
			if (newRouter != null && !network.getRouter().contains(newRouter))
			{
				network.getRouter().add(newRouter);
			}
		}
		
		for (final Router r : network.getRouter())
		{
			System.out.println("##### " + r.getName());
		}
	}
	
}
