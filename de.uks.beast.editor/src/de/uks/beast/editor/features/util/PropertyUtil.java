package de.uks.beast.editor.features.util;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

import de.uks.beast.editor.util.Constants;

public class PropertyUtil
{
	
	public static final void setAttributeShape(final PictogramElement pe, final Constants constants)
	{
		Graphiti.getPeService().setPropertyValue(pe, constants.text(), constants.text());
	}
	
	
	
	public static boolean isAttributeShape(final PictogramElement pe, final Constants constants)
	{
		return constants.text().equals(Graphiti.getPeService().getPropertyValue(pe, constants.text()));
	}
	
	
	
	public static final void setObjectShape(final PictogramElement pe, final Constants constants)
	{
		setAttributeShape(pe, constants);
	}
	
	
	
	public static boolean isObjectShape(final PictogramElement pe, final Constants constants)
	{
		return isAttributeShape(pe, constants);
	}
	
	
	
	public static boolean updateNeeded(final String pictogramValue, final String businessValue)
	{
		return ((pictogramValue == null && businessValue != null) || (pictogramValue != null && !pictogramValue
				.equals(businessValue)));
	}
}
