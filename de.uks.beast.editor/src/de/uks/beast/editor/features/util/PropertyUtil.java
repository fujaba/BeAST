package de.uks.beast.editor.features.util;

import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

import de.uks.beast.editor.util.StringConstants;

public class PropertyUtil
{
	
	public static void setAttributeShape(final PictogramElement pe, final StringConstants stringConstants)
	{
		Graphiti.getPeService().setPropertyValue(pe, stringConstants.text(), stringConstants.text());
	}
	
	
	
	public static boolean isAttributeShape(final PictogramElement pe, final StringConstants stringConstants)
	{
		return stringConstants.text().equals(Graphiti.getPeService().getPropertyValue(pe, stringConstants.text()));
	}
	
	
	
	public static void setObjectShape(final PictogramElement pe, final StringConstants stringConstants)
	{
		setAttributeShape(pe, stringConstants);
	}
	
	
	
	public static boolean isObjectShape(final PictogramElement pe, final StringConstants stringConstants)
	{
		return isAttributeShape(pe, stringConstants);
	}
	
	
	
	public static void setConnection(final Connection connection, final StringConstants stringConstants)
	{
		Graphiti.getPeService().setPropertyValue(connection, stringConstants.text(), stringConstants.text());
	}
	
	
	
	public static boolean isConnection(final Connection connection, final StringConstants stringConstants)
	{
		return stringConstants.text().equals(Graphiti.getPeService().getPropertyValue(connection, stringConstants.text()));
	}
	
	
	
	public static boolean updateNeeded(final String pictogramValue, final String businessValue)
	{
		return ((pictogramValue == null && businessValue != null) || (pictogramValue != null && !pictogramValue
				.equals(businessValue)));
	}
}
