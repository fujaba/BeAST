package de.uks.beast.editor.feature.paste;

import model.Group;
import model.ModelFactory;
import model.Network;
import model.Router;
import model.Server;
import model.Service;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IPasteContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.features.AbstractPasteFeature;

public class UniversalPasteFeature extends AbstractPasteFeature
{
	
	public UniversalPasteFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	private Server makeDeepCopy(final Server toCopy)
	{
		final Server server = ModelFactory.eINSTANCE.createServer();
		
		server.setName(toCopy.getName());
		server.setIp(toCopy.getIp());
		server.setCpuCores(toCopy.getCpuCores());
		server.setDiskSpace(toCopy.getDiskSpace());
		server.setNetwork(toCopy.getNetwork());
		server.setRam(toCopy.getRam());
		
		if (toCopy.getService() != null)
		{
			final Service newService = (Service) ModelFactory.eINSTANCE.create(toCopy.getService().eClass());
			
			server.setService(newService);
			server.getService().setName(toCopy.getService().getName());
			server.getService().setServiceName(toCopy.getService().getServiceName());
			server.getService().setServiceType(toCopy.getService().getServiceType());
			
		}
		
		return server;
	}
	
	
	
	private void updateGuiWithService(final Server newServer)
	{
		final AddContext ac = new AddContext();
		//ac.setNewObject(newServer.getService());
		ac.setTargetContainer((ContainerShape) Graphiti.getLinkService().getPictogramElements(getDiagram(), newServer).get(0));
		
		addGraphicalRepresentation(ac, newServer.getService());
	}
	
	
	
	private Network makeDeepCopy(final Network toCopy)
	{
		final Network network = ModelFactory.eINSTANCE.createNetwork();
		
		network.setDns(toCopy.getDns());
		network.setGateway(toCopy.getGateway());
		network.setIp(toCopy.getIp());
		network.setName(toCopy.getName());
		network.setSubnetmask(toCopy.getSubnetmask());
		
		return network;
	}
	
	
	
	private Router makeDeepCopy(final Router toCopy)
	{
		final Router router = ModelFactory.eINSTANCE.createRouter();
		
		router.setExternalGateway(toCopy.getExternalGateway());
		router.setId(toCopy.getId());
		router.setIp(toCopy.getIp());
		router.setName(toCopy.getName());
		
		return router;
	}
	
	
	
	@Override
	public void paste(final IPasteContext context)
	{
		final PictogramElement[] pes = context.getPictogramElements();
		
		for (final Object object : getFromClipboard())
		{
			if (object instanceof Server)
			{
				final Group parentContainer = (Group) getBusinessObjectForPictogramElement(pes[0]);
				final Server newServer = makeDeepCopy((Server) object);
				parentContainer.getServer().add(newServer);
				
				final AddContext ac = new AddContext();
				//ac.setNewObject(newServer);
				ac.setTargetContainer((ContainerShape) pes[0]);
				addGraphicalRepresentation(ac, newServer);
				
				updateGuiWithService(newServer);
				
			}
			else if (object instanceof Router)
			{
				final Router newRouter = makeDeepCopy((Router) object);
				final AddContext ac = new AddContext();
				ac.setNewObject(newRouter);
				ac.setTargetContainer((Diagram) pes[0]);
				addGraphicalRepresentation(ac, newRouter);
			}
			else if (object instanceof Network)
			{
				final Network newNetwork = makeDeepCopy((Network) object);
				final AddContext ac = new AddContext();
				ac.setNewObject(newNetwork);
				ac.setTargetContainer((Diagram) pes[0]);
				addGraphicalRepresentation(ac, newNetwork);
			}
		}
	}
	
	
	
	@Override
	public boolean canPaste(final IPasteContext context)
	{
		if (context.getPictogramElements().length != 1 || getFromClipboard() == null || getFromClipboard().length == 0)
		{
			return false;
		}
		
		final Object source = getFromClipboard()[0];
		Object target;
		if (context.getPictogramElements()[0].getLink() != null)
		{
			target = context.getPictogramElements()[0].getLink().getBusinessObjects().get(0);
		}
		else
		{
			target = context.getPictogramElements()[0];
		}
		
		if (source instanceof Server && target instanceof Group)
		{
			return true;
		}
		else if (source instanceof Router && target instanceof Diagram)
		{
			return true;
		}
		else if (source instanceof Network && target instanceof Diagram)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
