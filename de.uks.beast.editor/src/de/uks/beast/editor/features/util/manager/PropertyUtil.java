package de.uks.beast.editor.features.util.manager;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

import de.uks.beast.editor.features.util.message.Message;

public class PropertyUtil
{
	
	public static final void setAttributeShape(final PictogramElement pe, final Message message)
	{
		Graphiti.getPeService().setPropertyValue(pe, message.text(), message.text());
	}
	
	
	
	public static boolean isAttributeShape(final PictogramElement pe, final Message message)
	{
		return message.text().equals(Graphiti.getPeService().getPropertyValue(pe, message.text()));
	}
	
	
	
	public static boolean updateNeeded(final String pictogramValue, final String businessValue)
	{
		return ((pictogramValue == null && businessValue != null) || (pictogramValue != null && !pictogramValue
				.equals(businessValue)));
	}
}
