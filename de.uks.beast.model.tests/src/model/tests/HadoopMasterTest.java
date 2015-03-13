/**
 */
package model.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import model.HadoopMaster;
import model.ModelFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Hadoop Master</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class HadoopMasterTest extends TestCase
{

	/**
	 * The fixture for this Hadoop Master test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HadoopMaster fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args)
	{
		TestRunner.run(HadoopMasterTest.class);
	}

	/**
	 * Constructs a new Hadoop Master test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HadoopMasterTest(String name)
	{
		super(name);
	}

	/**
	 * Sets the fixture for this Hadoop Master test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(HadoopMaster fixture)
	{
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Hadoop Master test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HadoopMaster getFixture()
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
		setFixture(ModelFactory.eINSTANCE.createHadoopMaster());
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

} //HadoopMasterTest
