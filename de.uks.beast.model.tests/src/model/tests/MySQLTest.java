/**
 */
package model.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import model.ModelFactory;
import model.MySQL;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>My SQL</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MySQLTest extends TestCase
{

	/**
	 * The fixture for this My SQL test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MySQL fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args)
	{
		TestRunner.run(MySQLTest.class);
	}

	/**
	 * Constructs a new My SQL test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MySQLTest(String name)
	{
		super(name);
	}

	/**
	 * Sets the fixture for this My SQL test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(MySQL fixture)
	{
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this My SQL test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MySQL getFixture()
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
		setFixture(ModelFactory.eINSTANCE.createMySQL());
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

} //MySQLTest
