package de.uks.beast.editor.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PropertyUtilTest
{
	@Test
	public void validPredefinedValueTest()
	{
		boolean valid = PropertyUtil.validateIp("0");
		assertEquals(true, valid);
	}
	
	
	
	@Test
	public void inValidPredefinedValueTest()
	{
		boolean valid = PropertyUtil.validateIp("1");
		assertEquals(false, valid);
	}
	
	
	
	@Test
	public void ValidIPAddressTest()
	{
		boolean valid = PropertyUtil.validateIp("1.1.1.1");
		assertEquals(true, valid);
		
		valid = PropertyUtil.validateIp("255.255.255.255");
		assertEquals(true, valid);
		
		valid = PropertyUtil.validateIp("192.168.1.1");
		assertEquals(true, valid);
		
		valid = PropertyUtil.validateIp("10.10.1.1");
		assertEquals(true, valid);
		
		valid = PropertyUtil.validateIp("132.254.111.10");
		assertEquals(true, valid);
		
		valid = PropertyUtil.validateIp("26.10.2.10");
		assertEquals(true, valid);
		
		valid = PropertyUtil.validateIp("127.0.0.1");
		assertEquals(true, valid);
	}
	
	
	
	@Test
	public void InValidIPAddressTest()
	{
		boolean valid = PropertyUtil.validateIp("10.10.10");
		assertEquals(false, valid);
		
		valid = PropertyUtil.validateIp("10.10");
		assertEquals(false, valid);
		
		valid = PropertyUtil.validateIp("10");
		assertEquals(false, valid);
		
		valid = PropertyUtil.validateIp("a.a.a.a");
		assertEquals(false, valid);
		
		valid = PropertyUtil.validateIp("10.0.0.a");
		assertEquals(false, valid);
		
		valid = PropertyUtil.validateIp("10.10.10.256");
		assertEquals(false, valid);
		
		valid = PropertyUtil.validateIp("222.222.2.999");
		assertEquals(false, valid);
		
		valid = PropertyUtil.validateIp("999.10.10.20");
		assertEquals(false, valid);
		
		valid = PropertyUtil.validateIp("2222.22.22.22");
		assertEquals(false, valid);
		
		valid = PropertyUtil.validateIp("22.2222.22.2");
		assertEquals(false, valid);
	}
	
	@Test
	public void updateNeededTest() {
		assertTrue(PropertyUtil.updateNeeded("eins", "zwei"));
		
		assertFalse(PropertyUtil.updateNeeded("eins", "eins"));
	}
}
