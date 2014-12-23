package de.uks.beast.editor.features.util.manager;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.graphiti.mm.algorithms.Text;

import de.uks.beast.editor.features.util.message.Message;

public class NetworkPictogramManager
{
	private static Map<Message, Text>	textShapes	= new HashMap<Message, Text>();
	
	
	
	private NetworkPictogramManager()
	{
	}
	
	
	
	public static void addToMap(final Message key, final Text textfield)
	{
		if (key != null && !key.text().isEmpty() && textfield != null)
		{
			textShapes.put(key, textfield);
		}
	}
	
	
	
	public static Text get(final Message key)
	{
		if (key != null && !key.text().isEmpty())
		{
			return textShapes.get(key);
		}
		else
		{
			return null;
		}
	}
	
	
	
	public static boolean updateNeeded(final String pictogramValue, final String businessValue)
	{
		return ((pictogramValue == null && businessValue != null) || (pictogramValue != null && !pictogramValue
				.equals(businessValue)));
	}
	
	
	
	public static void removeFromnMap(final Message key, final Text textfield)
	{
		if (key != null && !key.text().isEmpty() && textfield != null)
		{
			if (textShapes.containsKey(key) && textShapes.containsValue(textfield))
			{
				textShapes.remove(key, textfield);
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
	
	
	
	public static Map<Message, Text> getTextShapes()
	{
		return textShapes;
	}
}
