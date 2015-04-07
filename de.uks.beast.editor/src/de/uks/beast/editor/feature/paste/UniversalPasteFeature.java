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

import de.uks.beast.editor.util.Dimensions;

public class UniversalPasteFeature extends AbstractPasteFeature
{
	
	public UniversalPasteFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	private Server makeDeepCopy(final Server toCopy)
	{
		final Server server = ModelFactory.eINSTANCE.createServer();
		//Server object have to be unique for pasting correctly
		server.setName(toCopy.getName() + "_" + server.hashCode());
		server.setIp(toCopy.getIp());
		server.setCpuCores(toCopy.getCpuCores());
		server.setDiskSpace(toCopy.getDiskSpace());
		server.setNetwork(toCopy.getNetwork());
		server.setRam(toCopy.getRam());
		
		if (toCopy.getService() != null)
		{
			final Service newService = (Service) ModelFactory.eINSTANCE.create(toCopy.getService().eClass());
			newService.setName(toCopy.getService().getName());
			newService.setServiceName(toCopy.getService().getServiceName());
			newService.setServiceType(toCopy.getService().getServiceType());
			
			server.setService(newService);
		}
		
		return server;
	}
	
	
	
	private Network makeDeepCopy(final Network toCopy)
	{
		final Network network = ModelFactory.eINSTANCE.createNetwork();
		
		network.setDns(toCopy.getDns());
		network.setGateway(toCopy.getGateway());
		network.setIp(toCopy.getIp());
		network.setName(toCopy.getName() + "_" + network.hashCode());
		network.setSubnetmask(toCopy.getSubnetmask());
		
		return network;
	}
	
	
	
	private Router makeDeepCopy(final Router toCopy)
	{
		final Router router = ModelFactory.eINSTANCE.createRouter();
		
		router.setExternalGateway(toCopy.getExternalGateway());
		router.setId(toCopy.getId());
		router.setIp(toCopy.getIp());
		router.setName(toCopy.getName() + "_" + router.hashCode());
		
		return router;
	}
	
	
	
	private void updateGuiWithService(final Server newServer)
	{
		final AddContext ac = new AddContext();
		ac.setNewObject(newServer.getService());
		final ContainerShape parentShape = (ContainerShape) Graphiti.getLinkService()
				.getPictogramElements(getDiagram(), newServer).get(0);
		ac.setTargetContainer(parentShape);
		ac.setLocation(parentShape.getGraphicsAlgorithm().getWidth() - Dimensions.SERVICE_ICON_RESIZE_X,
				Dimensions.SERVICE_ICON_RESIZE_Y);
		
		addGraphicalRepresentation(ac, ac.getNewObject());
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
				ac.setNewObject(newServer);
				ac.setTargetContainer((ContainerShape) pes[0]);
				addGraphicalRepresentation(ac, ac.getNewObject());
				
				updateGuiWithService(newServer);
				
			}
			else if (object instanceof Router)
			{
				final Router newRouter = makeDeepCopy((Router) object);
				final AddContext ac = new AddContext();
				ac.setNewObject(newRouter);
				ac.setTargetContainer((Diagram) pes[0]);
				addGraphicalRepresentation(ac, ac.getNewObject());
			}
			else if (object instanceof Network)
			{
				final Network newNetwork = makeDeepCopy((Network) object);
				final AddContext ac = new AddContext();
				ac.setNewObject(newNetwork);
				ac.setTargetContainer((Diagram) pes[0]);
				addGraphicalRepresentation(ac, ac.getNewObject());
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
