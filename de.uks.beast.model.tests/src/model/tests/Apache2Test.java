/**
 */
package model.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import model.Apache2;
import model.ModelFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Apache2</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class Apache2Test extends TestCase
{

	/**
	 * The fixture for this Apache2 test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Apache2 fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args)
	{
		TestRunner.run(Apache2Test.class);
	}

	/**
	 * Constructs a new Apache2 test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Apache2Test(String name)
	{
		super(name);
	}

	/**
	 * Sets the fixture for this Apache2 test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Apache2 fixture)
	{
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Apache2 test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Apache2 getFixture()
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
		setFixture(ModelFactory.eINSTANCE.createApache2());
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

} //Apache2Test
