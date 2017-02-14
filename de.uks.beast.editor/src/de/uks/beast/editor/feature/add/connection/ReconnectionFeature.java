package de.uks.beast.editor.feature.add.connection;

import model.HadoopMaster;
import model.Network;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.impl.DefaultReconnectionFeature;

public class ReconnectionFeature extends DefaultReconnectionFeature
{
	private Network			network;
	private HadoopMaster	hadoopMaster;
	
	
	
	public ReconnectionFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public boolean canReconnect(final IReconnectionContext context)
	{
		final Object start = getBusinessObjectForPictogramElement(context.getConnection().getStart().getParent());
		final Object end = getBusinessObjectForPictogramElement(context.getConnection().getEnd().getParent());
		
		Object oldAnchor = null;
		Object newAnchor = null;
		if (context.getOldAnchor() != null && context.getNewAnchor() != null)
		{
			oldAnchor = getBusinessObjectForPictogramElement(context.getOldAnchor().getParent());
			newAnchor = getBusinessObjectForPictogramElement(context.getNewAnchor().getParent());
		}
		
		if ((start instanceof HadoopMaster || end instanceof HadoopMaster) && oldAnchor instanceof Network
				&& newAnchor instanceof Network)
		{
			hadoopMaster = (start instanceof HadoopMaster) ? (HadoopMaster) start : (HadoopMaster) end;
			if (!hadoopMaster.getNetwork().equals(newAnchor))
			{
				return true;
			}
			
		}
		else if ((start instanceof Network || end instanceof Network) && oldAnchor instanceof HadoopMaster
				&& newAnchor instanceof HadoopMaster)
		{
			network = (start instanceof Network) ? (Network) start : (Network) end;
			if (!network.getServices().contains(newAnchor))
			{
				return true;
			}
			
		}
		
		return false;
	}
	
	
	
	@Override
	public void preReconnect(final IReconnectionContext context)
	{
		final Object oldTarget = getBusinessObjectForPictogramElement(context.getOldAnchor().getParent());
		
		if (network != null && oldTarget instanceof HadoopMaster)
		{
			final HadoopMaster oldRouter = (HadoopMaster) oldTarget;
			
			if (network.getServices().contains(oldRouter))
			{
				network.getServices().remove(oldRouter);
			}
			
		}
		else if (hadoopMaster != null && oldTarget instanceof Network)
		{
			final Network oldNetwork = (Network) oldTarget;
			
			if (hadoopMaster.getNetwork().equals(oldNetwork))
			{
				hadoopMaster.setNetwork(null);
			}
			
		}
		else if (hadoopMaster != null && oldTarget instanceof Network)
		{
			final Network oldNetwork = (Network) oldTarget;
			
			if (oldNetwork.getServices().contains(hadoopMaster))
			{
				oldNetwork.getServices().remove(hadoopMaster);
			}
			
			System.out.println("server has: " + oldNetwork.getName());
			
		}
		else if (network != null && oldTarget instanceof HadoopMaster)
		{
			final HadoopMaster oldServer = (HadoopMaster) oldTarget;
			
			if (network.getServices().contains(oldServer))
			{
				network.getServices().remove(oldServer);
			}
			
		}
		
	}
	
	
	
	@Override
	public void postReconnect(final IReconnectionContext context)
	{
		final Object target = getBusinessObjectForPictogramElement(context.getTargetPictogramElement());
		
		if (network != null && target instanceof HadoopMaster)
		{
			final HadoopMaster newRouter = (HadoopMaster) target;
			
			if (!network.getServices().contains(newRouter))
			{
				network.getServices().add(newRouter);
			}
			
		}
		else if (hadoopMaster != null && target instanceof Network)
		{
			final Network newNetwork = (Network) target;
			
			if (!hadoopMaster.getNetwork().equals(newNetwork))
			{
				hadoopMaster.setNetwork(null);
			}
			
		}
		else if (hadoopMaster != null && target instanceof Network)
		{
			final Network newNetwork = (Network) target;
			
			if (hadoopMaster.getNetwork() == null || !hadoopMaster.getNetwork().equals(newNetwork))
			{
				hadoopMaster.setNetwork(newNetwork);
			}
			
		}
		else if (network != null && target instanceof HadoopMaster)
		{
			final HadoopMaster newServer = (HadoopMaster) target;
			
			if (!network.getServices().contains(newServer))
			{
				network.getServices().add(newServer);
			}
			
		}
		
	}
}
