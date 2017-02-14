package de.uks.beast.editor.property.filter;

import model.Service;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;

public class ServicePropertyFilter extends AbstractPropertySectionFilter
{
	
	@Override
	protected boolean accept(final PictogramElement pictogramElement)
	{
		final Object object = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pictogramElement);
		
		if (object instanceof Service)
		{
			return true;
		}
		
		return false;
	}
	
}
