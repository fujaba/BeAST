package de.uks.beast.editor.feature.paste;

import model.Router;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IPasteContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.AbstractPasteFeature;

public class PasteNetworkFeature extends AbstractPasteFeature
{
	
	public PasteNetworkFeature(final IFeatureProvider fp)
	{
		super(fp);
	}
	
	
	
	@Override
	public void paste(final IPasteContext context)
	{
		// we already verified, that we paste directly in the diagram
		final PictogramElement[] pes = context.getPictogramElements();
		final Diagram diagram = (Diagram) pes[0];
		// get the EClasses from the clipboard without copying them
		// (only copy the pictogram element, not the business object)
		// then create new pictogram elements using the add feature
		final Object[] objects = getFromClipboard();
		
		for (final Object object : objects)
		{
			final AddContext ac = new AddContext();
			// For simplicity paste all objects at the location given in the
			// context (no stacking or similar)
			ac.setLocation(context.getX(), context.getY());
			ac.setTargetContainer(diagram);
			addGraphicalRepresentation(ac, object);
		}
	}
	
	
	
	@Override
	public boolean canPaste(final IPasteContext context)
	{
		// only support pasting directly in the diagram (nothing else selected)
		final PictogramElement[] pes = context.getPictogramElements();
		
		if (pes.length != 1 || !(pes[0] instanceof Diagram))
		{
			return false;
		}
		
		// can paste, if all objects on the clipboard are EClasses
		final Object[] fromClipboard = getFromClipboard();
		if (fromClipboard == null || fromClipboard.length == 0)
		{
			return false;
		}
		for (final Object object : fromClipboard)
		{
			if (!(object instanceof Router))
			{
				return false;
			}
		}
		return true;
	}
	
}
