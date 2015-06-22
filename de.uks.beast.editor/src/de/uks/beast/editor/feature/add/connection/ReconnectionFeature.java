package de.uks.beast.editor.feature.add.connection;

import model.Network;
import model.Router;
import model.Server;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.impl.DefaultReconnectionFeature;

public class ReconnectionFeature extends DefaultReconnectionFeature
{
	private Router	router;
	private Network	network;
	private Server	server;
	
	
	
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
		
		if ((start instanceof Router || end instanceof Router) && oldAnchor instanceof Network && newAnchor instanceof Network)
		{
			router = (start instanceof Router) ? (Router) start : (Router) end;
			if (!router.getNetwork().contains(newAnchor))
			{
				return true;
			}
			
		}
		else if ((start instanceof Network || end instanceof Network) && oldAnchor instanceof Router
				&& newAnchor instanceof Router)
		{
			network = (start instanceof Network) ? (Network) start : (Network) end;
			if (!network.getRouter().contains(newAnchor))
			{
				return true;
			}
			
		}
		else if ((start instanceof Server || end instanceof Server) && oldAnchor instanceof Network
				&& newAnchor instanceof Network)
		{
			server = (start instanceof Server) ? (Server) start : (Server) end;
			if (!server.getNetwork().equals(newAnchor))
			{
				return true;
			}
			
		}
		else if ((start instanceof Network || end instanceof Network) && oldAnchor instanceof Server
				&& newAnchor instanceof Server)
		{
			network = (start instanceof Network) ? (Network) start : (Network) end;
			if (!network.getServer().contains(newAnchor))
			{
				return true;
			}
		}
		
		return false;
	}
	
	
	
	@Override
	public void preReconnect(final IReconnectionContext context)
	{
		System.out.println("PRE");
		final Object oldTarget = getBusinessObjectForPictogramElement(context.getOldAnchor().getParent());
		
		if (network != null && oldTarget instanceof Router)
		{
			final Router oldRouter = (Router) oldTarget;
			
			if (network.getRouter().contains(oldRouter))
			{
				network.getRouter().remove(oldRouter);
			}
			
			for (final Router r : network.getRouter())
			{
				System.out.println(network.getName() + " has: " + r.getName());
			}
			
		}
		else if (router != null && oldTarget instanceof Network)
		{
			final Network oldNetwork = (Network) oldTarget;
			
			if (router.getNetwork().contains(oldNetwork))
			{
				router.getNetwork().remove(oldNetwork);
			}
			
			for (final Network n : router.getNetwork())
			{
				System.out.println(router.getName() + " has: " + n.getName());
			}
			
		}
		else if (server != null && oldTarget instanceof Network)
		{
			final Network oldNetwork = (Network) oldTarget;
			
			if (oldNetwork.getServer().contains(server))
			{
				oldNetwork.getServer().remove(server);
			}
			
			System.out.println("server has: " + oldNetwork.getName());
			
		}
		else if (network != null && oldTarget instanceof Server)
		{
			final Server oldServer = (Server) oldTarget;
			
			if (network.getServer().contains(oldServer))
			{
				network.getServer().remove(oldServer);
			}
			
			for (final Server s : network.getServer())
			{
				System.out.println(network.getName() + " has: " + s.getName());
			}
			
		}
		
	}
	
	
	
	@Override
	public void postReconnect(final IReconnectionContext context)
	{
		System.out.println("POST");
		final Object target = getBusinessObjectForPictogramElement(context.getTargetPictogramElement());
		
		if (network != null && target instanceof Router)
		{
			final Router newRouter = (Router) target;
			
			if (!network.getRouter().contains(newRouter))
			{
				network.getRouter().add(newRouter);
			}
			
			for (final Router r : network.getRouter())
			{
				System.out.println(network.getName() + " has: " + r.getName());
			}
			
		}
		else if (router != null && target instanceof Network)
		{
			final Network newNetwork = (Network) target;
			
			if (!router.getNetwork().contains(newNetwork))
			{
				router.getNetwork().add(newNetwork);
			}
			
			for (final Network n : router.getNetwork())
			{
				System.out.println(router.getName() + " has: " + n.getName());
			}
			
		}
		else if (server != null && target instanceof Network)
		{
			final Network newNetwork = (Network) target;
			
			if (server.getNetwork() == null || !server.getNetwork().equals(newNetwork))
			{
				server.setNetwork(newNetwork);
			}
			
			System.out.println(server.getName() + " has: " + newNetwork.getName());
		}
		else if (network != null && target instanceof Server)
		{
			final Server newServer = (Server) target;
			
			if (!network.getServer().contains(newServer))
			{
				network.getServer().add(newServer);
			}
			
			for (final Server s : network.getServer())
			{
				System.out.println(network.getName() + " has: " + s.getName());
			}
			
		}
		
	}
}
