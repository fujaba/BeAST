package de.uks.beast.editor.properties.filter;

import model.Network;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;

public class NetworkPropertyFilter extends AbstractPropertySectionFilter
{
	
	@Override
	protected boolean accept(final PictogramElement pictogramElement)
	{
		final Object object = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pictogramElement);
		
		if (object instanceof Network)
		{
			return true;
		}
		return false;
	}
	
}
