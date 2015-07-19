/**
 */
package model.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import model.ModelFactory;
import model.MongoDB;

import org.junit.Test;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Mongo DB</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MongoDBTest extends TestCase
{
	
	/**
	 * The fixture for this Mongo DB test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MongoDB	fixture	= null;
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args)
	{
		TestRunner.run(MongoDBTest.class);
	}
	
	
	
	/**
	 * Constructs a new Mongo DB test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MongoDBTest(String name)
	{
		super(name);
	}
	
	
	
	/**
	 * Sets the fixture for this Mongo DB test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(MongoDB fixture)
	{
		this.fixture = fixture;
	}
	
	
	
	/**
	 * Returns the fixture for this Mongo DB test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MongoDB getFixture()
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
		setFixture(ModelFactory.eINSTANCE.createMongoDB());
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
		final MongoDB a = getFixture();
		final MongoDB b = getFixture();
		
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
	
} //MongoDBTest
