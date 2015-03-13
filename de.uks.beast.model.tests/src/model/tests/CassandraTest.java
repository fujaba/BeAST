/**
 */
package model.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import model.Cassandra;
import model.ModelFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Cassandra</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CassandraTest extends TestCase
{

	/**
	 * The fixture for this Cassandra test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Cassandra fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args)
	{
		TestRunner.run(CassandraTest.class);
	}

	/**
	 * Constructs a new Cassandra test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CassandraTest(String name)
	{
		super(name);
	}

	/**
	 * Sets the fixture for this Cassandra test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Cassandra fixture)
	{
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Cassandra test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Cassandra getFixture()
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
		setFixture(ModelFactory.eINSTANCE.createCassandra());
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

} //CassandraTest
