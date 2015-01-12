package de.uks.beast.editor.features.util;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

import de.uks.beast.editor.util.Messages;

public class PropertyUtil
{
	
	public static final void setAttributeShape(final PictogramElement pe, final Messages messages)
	{
		Graphiti.getPeService().setPropertyValue(pe, messages.text(), messages.text());
	}
	
	
	
	public static boolean isAttributeShape(final PictogramElement pe, final Messages messages)
	{
		return messages.text().equals(Graphiti.getPeService().getPropertyValue(pe, messages.text()));
	}
	
	
	
	public static final void setObjectShape(final PictogramElement pe, final Messages messages)
	{
		setAttributeShape(pe, messages);
	}
	
	
	
	public static boolean isObjectShape(final PictogramElement pe, final Messages messages)
	{
		return isAttributeShape(pe, messages);
	}
	
	
	
	public static boolean updateNeeded(final String pictogramValue, final String businessValue)
	{
		return ((pictogramValue == null && businessValue != null) || (pictogramValue != null && !pictogramValue
				.equals(businessValue)));
	}
}
