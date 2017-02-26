package de.uks.beast.editor.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import model.HadoopMaster;
import model.ModelFactory;
import model.Network;
import model.Service;

public class NameCacheTest
{
	@Before
	public void setUp()
	{
		NameCache.clear();
	}
	
	
	
	@Test
	public void testAdd()
	{
		assertTrue(NameCache.size() == 0);
		
		NameCache.add(Network.class, "network_0");
		
		assertTrue(NameCache.size() == 1);
	}
	
	
	
	@Test
	public void testGet()
	{
		assertTrue(NameCache.size() == 0);
		
		NameCache.add(Network.class, "network_0");
		NameCache.add(Network.class, "network_1");
		
		assertTrue(NameCache.get(Network.class).size() == 2);
		assertTrue(NameCache.get(Network.class).contains("network_0"));
		assertTrue(NameCache.get(Network.class).contains("network_1"));
	}
	
	
	
	@Test
	public void testGet_if_cache_has_no_entry()
	{
		assertTrue(NameCache.size() == 0);
		
		final Set<String> set = NameCache.get(Network.class);
		
		assertTrue(NameCache.size() == 1);
		assertTrue(set != null);
		assertTrue(set.isEmpty());
	}
	
	
	
	@Test
	public void testAdd_same_name_but_different_classes()
	{
		assertTrue(NameCache.size() == 0);
		
		NameCache.add(HadoopMaster.class, "test");
		NameCache.add(Network.class, "test");
		
		assertTrue(NameCache.size() == 2);
		assertTrue(NameCache.get(HadoopMaster.class).size() == 1);
		assertTrue(NameCache.get(Network.class).size() == 1);
	}
	
	
	
	@Test
	public void testSize()
	{
		assertTrue(NameCache.size() == 0);
		
		NameCache.add(Network.class, "network_0");
		
		assertTrue(NameCache.size() == 1);
	}
	
	
	
	@Test
	public void testClear()
	{
		assertTrue(NameCache.size() == 0);
		
		NameCache.add(Network.class, "test_0");
		NameCache.add(HadoopMaster.class, "test_1");
		
		assertTrue(NameCache.size() == 2);
		
		NameCache.clear();
		
		assertTrue(NameCache.size() == 0);
	}
	
	
	
	@Test
	public void testRemove()
	{
		assertTrue(NameCache.size() == 0);
		
		NameCache.add(Network.class, "network_0");
		
		assertTrue(NameCache.size() == 1);
		assertTrue(NameCache.get(Network.class).size() == 1);
		
		NameCache.remove(Network.class, "network_0");
		
		assertTrue(NameCache.size() == 1);
		assertTrue(NameCache.get(Network.class).size() == 0);
	}
	
	
	
	@Test
	public void testRemoveAll()
	{
		assertTrue(NameCache.size() == 0);
		
		NameCache.add(Network.class, "network_0");
		NameCache.add(Network.class, "network_1");
		NameCache.add(Network.class, "network_2");
		
		assertTrue(NameCache.size() == 1);
		assertTrue(NameCache.get(Network.class).size() == 3);
		
		NameCache.removeAll(Network.class);
		
		assertTrue(NameCache.size() == 1);
		assertTrue(NameCache.get(Network.class).size() == 0);
	}
	
	
	
	@Test
	public void testIsRegistered()
	{
		assertTrue(NameCache.size() == 0);
		
		NameCache.add(Network.class, "network_0");
		
		assertTrue(NameCache.isRegistered(Network.class, "network_0"));
	}
	
	
	
	@Test
	public void testIsNotRegistered()
	{
		assertTrue(NameCache.size() == 0);
		
		NameCache.add(Network.class, "network_1");
		
		assertFalse(NameCache.isRegistered(Network.class, "network_0"));
	}
	
	
	
	@Test
	public void testAdd_with_interface_as_class()
	{
		assertTrue(NameCache.size() == 0);
		
		final Service hm = ModelFactory.eINSTANCE.createHadoopMaster();
		final Service hs = ModelFactory.eINSTANCE.createHadoopSlave();
		
		NameCache.add(hm.getClass(), "hadoopMaster_0");
		NameCache.add(hs.getClass(), "hadoopSlave_0");
		
		assertTrue(NameCache.size() == 2);
		
		assertTrue(NameCache.isRegistered(hm.getClass(), "hadoopMaster_0"));
		assertTrue(NameCache.isRegistered(hs.getClass(), "hadoopSlave_0"));
	}
}
