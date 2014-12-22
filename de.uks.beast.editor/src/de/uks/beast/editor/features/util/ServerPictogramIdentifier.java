package de.uks.beast.editor.features.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.graphiti.mm.algorithms.Text;

public class ServerPictogramIdentifier
{
	private static Map<String, Text>	textShapes	= new HashMap<String, Text>();
	
	
	
	private ServerPictogramIdentifier()
	{
		
	}
	
	
	
	public static void addToMap(final String identifier, final Text textfield)
	{
		if (identifier != null && !identifier.isEmpty() && textfield != null)
		{
			textShapes.put(identifier, textfield);
		}
	}
	
	
	
	public static Text get(final String key)
	{
		if (key != null && !key.isEmpty())
		{
			return textShapes.get(key);
		}
		else
		{
			return null;
		}
	}
	
	
	
	public static void removeFromnMap(final String identifier, final Text textfield)
	{
		if (identifier != null && !identifier.isEmpty() && textfield != null)
		{
			if (textShapes.containsKey(identifier) && textShapes.containsValue(textfield))
			{
				textShapes.remove(identifier, textfield);
			}
		}
	}
	
	
	
	public static void clearMap()
	{
		if (textShapes != null && !textShapes.isEmpty())
		{
			textShapes.clear();
		}
	}
	
	
	
	public static int getMapSize()
	{
		return textShapes.size();
	}
	
	
	
	public static Map<String, Text> getTextShapes()
	{
		return textShapes;
	}
	
}
