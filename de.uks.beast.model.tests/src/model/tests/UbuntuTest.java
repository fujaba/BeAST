/**
 */
package model.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import model.ModelFactory;
import model.Ubuntu;

import org.junit.Test;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Ubuntu</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class UbuntuTest extends TestCase
{
	
	/**
	 * The fixture for this Ubuntu test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Ubuntu	fixture	= null;
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args)
	{
		TestRunner.run(UbuntuTest.class);
	}
	
	
	
	/**
	 * Constructs a new Ubuntu test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UbuntuTest(String name)
	{
		super(name);
	}
	
	
	
	/**
	 * Sets the fixture for this Ubuntu test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Ubuntu fixture)
	{
		this.fixture = fixture;
	}
	
	
	
	/**
	 * Returns the fixture for this Ubuntu test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Ubuntu getFixture()
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
		setFixture(ModelFactory.eINSTANCE.createUbuntu());
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
		final Ubuntu a = getFixture();
		final Ubuntu b = getFixture();
		
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
	
} //UbuntuTest
