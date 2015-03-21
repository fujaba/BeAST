package de.uks.beast.editor.util;

import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

public class PropertyUtil
{
	
	public static void setAttributeShape(final PictogramElement pe, final Properties property)
	{
		Graphiti.getPeService().setPropertyValue(pe, property.get(), property.get());
	}
	
	
	
	public static boolean isAttributeShape(final PictogramElement pe, final Properties property)
	{
		return property.get().equals(Graphiti.getPeService().getPropertyValue(pe, property.get()));
	}
	
	
	
	public static void setObjectShape(final PictogramElement pe, final Properties property)
	{
		setAttributeShape(pe, property);
	}
	
	
	
	public static boolean isObjectShape(final PictogramElement pe, final Properties property)
	{
		return isAttributeShape(pe, property);
	}
	
	
	
	public static void setConnection(final Connection connection, final Properties property)
	{
		Graphiti.getPeService().setPropertyValue(connection, property.get(), property.get());
	}
	
	
	
	public static boolean isConnection(final Connection connection, final Properties property)
	{
		return property.get().equals(Graphiti.getPeService().getPropertyValue(connection, property.get()));
	}
	
	
	
	public static boolean updateNeeded(final String pictogramValue, final String businessValue)
	{
		return ((pictogramValue == null && businessValue != null) || (pictogramValue != null && !pictogramValue
				.equals(businessValue)));
	}
}
