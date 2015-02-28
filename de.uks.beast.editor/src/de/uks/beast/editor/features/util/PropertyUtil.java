package de.uks.beast.editor.features.util;

import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

import de.uks.beast.editor.util.Properties;

public class PropertyUtil
{
	
	public static void setAttributeShape(final PictogramElement pe, final Properties property)
	{
		Graphiti.getPeService().setPropertyValue(pe, property.getProperty(), property.getProperty());
	}
	
	
	
	public static boolean isAttributeShape(final PictogramElement pe, final Properties property)
	{
		return property.getProperty().equals(Graphiti.getPeService().getPropertyValue(pe, property.getProperty()));
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
		Graphiti.getPeService().setPropertyValue(connection, property.getProperty(), property.getProperty());
	}
	
	
	
	public static boolean isConnection(final Connection connection, final Properties property)
	{
		return property.getProperty().equals(Graphiti.getPeService().getPropertyValue(connection, property.getProperty()));
	}
	
	
	
	public static boolean updateNeeded(final String pictogramValue, final String businessValue)
	{
		return ((pictogramValue == null && businessValue != null) || (pictogramValue != null && !pictogramValue
				.equals(businessValue)));
	}
}
