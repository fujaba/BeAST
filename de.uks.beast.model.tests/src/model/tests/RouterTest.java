/**
 */
package model.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import model.ModelFactory;
import model.Router;

import org.junit.Test;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Router</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RouterTest extends TestCase
{
	
	/**
	 * The fixture for this Router test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Router	fixture	= null;
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args)
	{
		TestRunner.run(RouterTest.class);
	}
	
	
	
	/**
	 * Constructs a new Router test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RouterTest(String name)
	{
		super(name);
	}
	
	
	
	/**
	 * Sets the fixture for this Router test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Router fixture)
	{
		this.fixture = fixture;
	}
	
	
	
	/**
	 * Returns the fixture for this Router test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Router getFixture()
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
		setFixture(ModelFactory.eINSTANCE.createRouter());
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
		final Router r = getFixture();
		
		r.setName("test_network");
		r.setId("test_id");
		r.setExternalGateway("test_external_gateway");
		r.setIp("test_ip");
		
		assertEquals("test_network", r.getName());
		assertEquals("test_id", r.getId());
		assertEquals("test_external_gateway", r.getExternalGateway());
		assertEquals("test_ip", r.getIp());
	}
	
} //RouterTest
