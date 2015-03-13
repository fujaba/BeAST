package de.uks.beast.editor.property.filter;

import model.Service;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;

import de.uks.beast.editor.util.Strings;

public class ServicePropertyFilter extends AbstractPropertySectionFilter
{
	
	@Override
	protected boolean accept(PictogramElement pictogramElement)
	{
		final Object object = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pictogramElement);
		
		if (object instanceof Service)
		{
			final Service service = (Service) object;
			
			if (Strings.HADOOP_MASTER.text().equals(service.getName()))
			{
				return true;
			}
		}
		
		return false;
	}
	
}
