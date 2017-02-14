package de.uks.beast.editor.feature.paste;

import model.HadoopMaster;
import model.HadoopSlave;
import model.ModelFactory;
import model.Network;
import model.Service;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IPasteContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.AbstractPasteFeature;


public class UniversalPasteFeature extends AbstractPasteFeature
{
	
	public UniversalPasteFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	private Service makeDeepCopy(final HadoopMaster toCopy)
	{
		final Service service = ModelFactory.eINSTANCE.createHadoopMaster();
		//Server object have to be unique for pasting correctly
		service.setName(toCopy.getName() + "_" + service.hashCode());
		service.setAtribute_0(toCopy.getAtribute_0());
		service.setAtribute_1(toCopy.getAtribute_1());
		
		return service;
	}
	
	
	
	private Service makeDeepCopy(final HadoopSlave toCopy)
	{
		final Service service = ModelFactory.eINSTANCE.createHadoopSlave();
		//Server object have to be unique for pasting correctly
		service.setName(toCopy.getName() + "_" + service.hashCode());
		service.setAtribute_0(toCopy.getAtribute_0());
		service.setAtribute_1(toCopy.getAtribute_1());
		
		return service;
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
	
	
	
	@Override
	public void paste(final IPasteContext context)
	{
		final PictogramElement[] pes = context.getPictogramElements();
		
		for (final Object object : getFromClipboard())
		{
			if (object instanceof Network)
			{
				final Network newNetwork = makeDeepCopy((Network) object);
				final AddContext ac = new AddContext();
				ac.setNewObject(newNetwork);
				ac.setTargetContainer((Diagram) pes[0]);
				addGraphicalRepresentation(ac, ac.getNewObject());
			}
			else if (object instanceof HadoopMaster)
			{
				final Service service = makeDeepCopy((HadoopMaster) object);
				final AddContext ac = new AddContext();
				ac.setNewObject(service);
				ac.setTargetContainer((Diagram) pes[0]);
				addGraphicalRepresentation(ac, ac.getNewObject());
			}
			else if (object instanceof HadoopSlave)
			{
				final Service service = makeDeepCopy((HadoopSlave) object);
				final AddContext ac = new AddContext();
				ac.setNewObject(service);
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
		
		if (source instanceof Service && target instanceof Diagram)
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
