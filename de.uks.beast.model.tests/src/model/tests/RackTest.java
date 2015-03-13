/**
 */
package model.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import model.ModelFactory;
import model.Rack;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Rack</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RackTest extends TestCase
{

	/**
	 * The fixture for this Rack test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Rack fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args)
	{
		TestRunner.run(RackTest.class);
	}

	/**
	 * Constructs a new Rack test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RackTest(String name)
	{
		super(name);
	}

	/**
	 * Sets the fixture for this Rack test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Rack fixture)
	{
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Rack test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Rack getFixture()
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
		setFixture(ModelFactory.eINSTANCE.createRack());
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

} //RackTest
