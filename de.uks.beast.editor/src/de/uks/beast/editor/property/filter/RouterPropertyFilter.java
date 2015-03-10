package de.uks.beast.editor.property.filter;

import model.Router;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;

public class RouterPropertyFilter extends AbstractPropertySectionFilter
{
	
	@Override
	protected boolean accept(PictogramElement pictogramElement)
	{
		final Object object = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pictogramElement);
		
		if (object instanceof Router)
		{
			return true;
		}
		return false;
	}
	
}
