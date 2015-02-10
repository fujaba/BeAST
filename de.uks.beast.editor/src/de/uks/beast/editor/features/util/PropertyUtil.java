package de.uks.beast.editor.features.util;

import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

import de.uks.beast.editor.util.Constants;

public class PropertyUtil
{
	
	public static void setAttributeShape(final PictogramElement pe, final Constants constants)
	{
		Graphiti.getPeService().setPropertyValue(pe, constants.text(), constants.text());
	}
	
	
	
	public static boolean isAttributeShape(final PictogramElement pe, final Constants constants)
	{
		return constants.text().equals(Graphiti.getPeService().getPropertyValue(pe, constants.text()));
	}
	
	
	
	public static void setObjectShape(final PictogramElement pe, final Constants constants)
	{
		setAttributeShape(pe, constants);
	}
	
	
	
	public static boolean isObjectShape(final PictogramElement pe, final Constants constants)
	{
		return isAttributeShape(pe, constants);
	}
	
	
	
	public static void setConnection(final Connection connection, final Constants constants)
	{
		Graphiti.getPeService().setPropertyValue(connection, constants.text(), constants.text());
	}
	
	
	
	public static boolean isConnection(final Connection connection, final Constants constants)
	{
		return constants.text().equals(Graphiti.getPeService().getPropertyValue(connection, constants.text()));
	}
	
	
	
	public static boolean updateNeeded(final String pictogramValue, final String businessValue)
	{
		return ((pictogramValue == null && businessValue != null) || (pictogramValue != null && !pictogramValue
				.equals(businessValue)));
	}
}
