package de.uks.beast.editor.feature.paste;

import model.Network;
import model.Router;
import model.Server;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IPasteContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.AbstractPasteFeature;

public class PasteRouterFeature extends AbstractPasteFeature
{
	
	public PasteRouterFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public void paste(final IPasteContext context)
	{
		final PictogramElement[] pes = context.getPictogramElements();
		
		for (final Object object : getFromClipboard())
		{
			if (object instanceof Server)
			{
				final Server server = (Server) object;
				final AddContext ac = new AddContext();
				ac.setTargetContainer((ContainerShape) pes[0]);
				addGraphicalRepresentation(ac, server);
			}
			else if (object instanceof Router)
			{
				final Router router = (Router) object;
				final AddContext ac = new AddContext();
				ac.setTargetContainer((Diagram) pes[0]);
				addGraphicalRepresentation(ac, router);
			}
			else if (object instanceof Network)
			{
				final Network network = (Network) object;
				final AddContext ac = new AddContext();
				ac.setTargetContainer((Diagram) pes[0]);
				addGraphicalRepresentation(ac, network);
			}
		}
	}
	
	
	
	@Override
	public boolean canPaste(final IPasteContext context)
	{
		final PictogramElement[] pes = context.getPictogramElements();
		
		if (pes.length != 1)
		{
			return false;
		}
		
		if (getFromClipboard() == null || getFromClipboard().length == 0)
		{
			return false;
		}
		for (final Object object : getFromClipboard())
		{
			if (!(object instanceof EObject))
			{
				return false;
			}
		}
		return true;
	}
	
}
