package de.uks.beast.editor.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.emf.ecore.EObject;

public class NameCache
{
	private static final Map<Class<? extends EObject>, String>	CACHE		= new HashMap<>();
	public static final String									DELIMITER	= "_";
	
	
	
	private NameCache()
	{
	}
	
	
	
	public static void add(final Class<? extends EObject> clazz, final String name)
	{
		if (!isRegistered(clazz, name))
		{
			CACHE.put(clazz, name);
		}
	}
	
	
	
	public static void remove(final Class<? extends EObject> clazz, final String name)
	{
		if (isRegistered(clazz, name))
		{
			CACHE.remove(clazz);
		}
	}
	
	
	
	public static boolean isRegistered(final Class<? extends EObject> clazz, final String name)
	{
		return CACHE.get(clazz) != null && CACHE.get(clazz).equals(name);
	}
	
	public static enum NameCounter
	{
		//@formatter:off
		NETWORK			(new AtomicInteger(0)),
		HADOOP_SLAVE	(new AtomicInteger(0)),
		CONTROL_CENTER	(new AtomicInteger(0)),
		HADOOP_MASTER	(new AtomicInteger(0));
		//@formatter:on
		
		private AtomicInteger counter;
		
		
		
		private NameCounter(final AtomicInteger c)
		{
			this.counter = c;
		}
		
		
		
		public Integer getAvailableCounter()
		{
			return this.counter.getAndIncrement();
		}
	}
	
}
