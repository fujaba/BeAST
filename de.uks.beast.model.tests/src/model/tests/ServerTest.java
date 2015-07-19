/**
 */
package model.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import model.ModelFactory;
import model.Network;
import model.Server;
import model.Service;

import org.junit.Test;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Server</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ServerTest extends TestCase
{
	
	/**
	 * The fixture for this Server test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Server	fixture	= null;
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args)
	{
		TestRunner.run(ServerTest.class);
	}
	
	
	
	/**
	 * Constructs a new Server test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServerTest(String name)
	{
		super(name);
	}
	
	
	
	/**
	 * Sets the fixture for this Server test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Server fixture)
	{
		this.fixture = fixture;
	}
	
	
	
	/**
	 * Returns the fixture for this Server test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Server getFixture()
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
		setFixture(ModelFactory.eINSTANCE.createServer());
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
		final Server r = getFixture();
		final NetworkTest networkTest = new NetworkTest("network_test");
		final Network n = networkTest.getFixture();
		final ServiceTest serviceTest = new ServiceTest("service_test") {};
		final Service s = serviceTest.getFixture();
		
		r.setName("test_network");
		r.setIp("test_ip");
		r.setCpuCores(1);
		r.setDiskSpace(1);
		r.setRam(1);
		r.setNetwork(n);
		r.setService(s);
		
		assertEquals("test_network", r.getName());
		assertEquals("test_ip", r.getIp());
		assertEquals(1, r.getCpuCores());
		assertEquals(1, r.getDiskSpace());
		assertEquals(1, r.getRam());
		assertEquals(n, r.getNetwork());
		assertEquals(s, r.getService());
	}
	
} //ServerTest
