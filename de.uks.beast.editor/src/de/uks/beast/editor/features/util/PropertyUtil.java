package de.uks.beast.editor.features.util;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

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
	
	
	
	public static final void setObjectShape(final PictogramElement pe, final Message message)
	{
		setAttributeShape(pe, message);
	}
	
	
	
	public static boolean isObjectShape(final PictogramElement pe, final Message message)
	{
		return isAttributeShape(pe, message);
	}
	
	
	
	public static boolean updateNeeded(final String pictogramValue, final String businessValue)
	{
		return ((pictogramValue == null && businessValue != null) || (pictogramValue != null && !pictogramValue
				.equals(businessValue)));
	}
}
