package de.uks.beast.editor.features.util;

import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

import de.uks.beast.editor.util.Strings;

public class PropertyUtil
{
	
	public static void setAttributeShape(final PictogramElement pe, final Strings strings)
	{
		Graphiti.getPeService().setPropertyValue(pe, strings.text(), strings.text());
	}
	
	
	
	public static boolean isAttributeShape(final PictogramElement pe, final Strings strings)
	{
		return strings.text().equals(Graphiti.getPeService().getPropertyValue(pe, strings.text()));
	}
	
	
	
	public static void setObjectShape(final PictogramElement pe, final Strings strings)
	{
		setAttributeShape(pe, strings);
	}
	
	
	
	public static boolean isObjectShape(final PictogramElement pe, final Strings strings)
	{
		return isAttributeShape(pe, strings);
	}
	
	
	
	public static void setConnection(final Connection connection, final Strings strings)
	{
		Graphiti.getPeService().setPropertyValue(connection, strings.text(), strings.text());
	}
	
	
	
	public static boolean isConnection(final Connection connection, final Strings strings)
	{
		return strings.text().equals(Graphiti.getPeService().getPropertyValue(connection, strings.text()));
	}
	
	
	
	public static boolean updateNeeded(final String pictogramValue, final String businessValue)
	{
		return ((pictogramValue == null && businessValue != null) || (pictogramValue != null && !pictogramValue
				.equals(businessValue)));
	}
}
