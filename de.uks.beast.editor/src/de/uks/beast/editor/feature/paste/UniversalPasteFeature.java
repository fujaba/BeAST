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
import org.eclipse.graphiti.ui.features.AbstractPasteFeature;

public class UniversalPasteFeature extends AbstractPasteFeature
{
	
	public UniversalPasteFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	private Server makeDeepCopy(final Group parentContainer, final Server toCopy)
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
			final Service service = toCopy.getService();
			final AddContext ac = new AddContext();
			ac.setNewObject(service);
			server.setService(service);
//			server.getService().setName(toCopy.getService().getName());
//			server.getService().setServiceName(toCopy.getService().getServiceName());
//			server.getService().setServiceType(toCopy.getService().getServiceType());
			addGraphicalRepresentation(ac, server);
		}
		
		parentContainer.getServer().add(server);
		
		return server;
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
				final Server newServer = makeDeepCopy(parentContainer, (Server) object);
				
				parentContainer.getServer().add(newServer);
				
				final AddContext ac = new AddContext();
				ac.setNewObject(newServer);
				ac.setTargetContainer((ContainerShape) pes[0]);
				addGraphicalRepresentation(ac, newServer);
			}
			else if (object instanceof Router)
			{
				final AddContext ac = new AddContext();
				ac.setTargetContainer((Diagram) pes[0]);
				addGraphicalRepresentation(ac, object);
			}
			else if (object instanceof Network)
			{
				final AddContext ac = new AddContext();
				ac.setTargetContainer((Diagram) pes[0]);
				addGraphicalRepresentation(ac, object);
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
