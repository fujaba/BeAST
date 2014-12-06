package de.uks.beast.editor.properties.filter;

import model.Server;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;

public class ServerPropertyFilter extends AbstractPropertySectionFilter
{
	
	@Override
	protected boolean accept(final PictogramElement pictogramElement)
	{
		final Object object = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pictogramElement);
		if (object instanceof Server)
		{
			return true;
		}
		
		return false;
	}
	
}
