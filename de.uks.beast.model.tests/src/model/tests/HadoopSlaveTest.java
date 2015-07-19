/**
 */
package model.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import model.HadoopSlave;
import model.ModelFactory;

import org.junit.Test;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Hadoop Slave</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class HadoopSlaveTest extends TestCase
{
	
	/**
	 * The fixture for this Hadoop Slave test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HadoopSlave	fixture	= null;
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args)
	{
		TestRunner.run(HadoopSlaveTest.class);
	}
	
	
	
	/**
	 * Constructs a new Hadoop Slave test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HadoopSlaveTest(String name)
	{
		super(name);
	}
	
	
	
	/**
	 * Sets the fixture for this Hadoop Slave test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(HadoopSlave fixture)
	{
		this.fixture = fixture;
	}
	
	
	
	/**
	 * Returns the fixture for this Hadoop Slave test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HadoopSlave getFixture()
	{
		return fixture;
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception
	{
		setFixture(ModelFactory.eINSTANCE.createHadoopSlave());
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception
	{
		setFixture(null);
	}
	
	
	
	@Test
	public void testGetterAndSetter()
	{
		final HadoopSlave a = getFixture();
		final HadoopSlave b = getFixture();
		
		a.setName("test_name");
		a.setServiceName("test_service");
		a.setServiceType("test_type");
		
		assertTrue(a.getRelations().isEmpty());
		
		a.getRelations().add(b);
		
		assertEquals("test_name", a.getName());
		assertEquals("test_service", a.getServiceName());
		assertEquals("test_type", a.getServiceType());
		assertTrue(a.getRelations().size() == 1);
		assertEquals(b, a.getRelations().get(0));
	}
} //HadoopSlaveTest
