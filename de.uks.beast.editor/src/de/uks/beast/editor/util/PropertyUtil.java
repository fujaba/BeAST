package de.uks.beast.editor.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

public class PropertyUtil
{
	private static Pattern		pattern;
	private static final String	IPADDRESS_PATTERN	= "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
															+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
															+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
															+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
	
	static
	{
		pattern = Pattern.compile(IPADDRESS_PATTERN);
	}
	
	
	
	/**
	    * Validate ip address with regular expression
	    * @param ip ip address for validation
	    * @return true valid ip address, false invalid ip address
	 * @throws Exception 
	    */
	public static boolean validateIp(final String ip)
	{
		//Because of predefined default values
		if (ip.equals("0"))
		{
			return true;
		}
		else
		{
			final Matcher matcher = pattern.matcher(ip);
			
			return matcher.matches();
		}
		
	}
	
	
	
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
