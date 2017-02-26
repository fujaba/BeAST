package de.uks.beast.editor.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;

public class NameCache
{
	private static final Logger										LOG			= LogManager.getLogger(NameCache.class);
	
	private static final Map<Class<? extends EObject>, Set<String>>	CACHE		= new HashMap<>();
	public static final String										DELIMITER	= "_";
	
	
	
	private NameCache()
	{
	}
	
	
	
	private static void initCacheIfEmptyFor(final Class<? extends EObject> clazz)
	{
		if (!CACHE.containsKey(clazz))
		{
			LOG.info("init cache for " + clazz);
			CACHE.put(clazz, new HashSet<String>());
		}
	}
	
	
	
	public static void add(final Class<? extends EObject> clazz, final String name)
	{
		initCacheIfEmptyFor(clazz);
		
		if (!isRegistered(clazz, name))
		{
			LOG.info("add " + name + " to cache for " + clazz);
			CACHE.get(clazz).add(name);
		}
	}
	
	
	
	public static Set<String> get(final Class<? extends EObject> clazz)
	{
		if (CACHE.containsKey(clazz))
		{
			return CACHE.get(clazz);
		}
		
		CACHE.put(clazz, new HashSet<String>());
		return CACHE.get(clazz);
	}
	
	
	
	public static void remove(final Class<? extends EObject> clazz, final String name)
	{
		if (isRegistered(clazz, name))
		{
			LOG.info("remove " + name + " from cache for " + clazz);
			CACHE.get(clazz).remove(name);
		}
	}
	
	
	
	public static void removeAll(final Class<? extends EObject> clazz)
	{
		if (CACHE.containsKey(clazz))
		{
			LOG.info("remove all names from cache for " + clazz);
			CACHE.get(clazz).clear();
		}
	}
	
	
	
	public static int size()
	{
		return CACHE.size();
	}
	
	
	
	public static void clear()
	{
		if (!CACHE.isEmpty())
		{
			CACHE.clear();
		}
	}
	
	
	
	public static boolean isRegistered(final Class<? extends EObject> clazz, final String name)
	{
		return CACHE.containsKey(clazz) && CACHE.get(clazz).contains(name);
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
		
		
		
		public void count()
		{
			getAvailableCounter();
		}
	}
	
}
