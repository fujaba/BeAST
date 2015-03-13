/**
 */
package model.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import model.Jenkins;
import model.ModelFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Jenkins</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class JenkinsTest extends TestCase
{

	/**
	 * The fixture for this Jenkins test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Jenkins fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args)
	{
		TestRunner.run(JenkinsTest.class);
	}

	/**
	 * Constructs a new Jenkins test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JenkinsTest(String name)
	{
		super(name);
	}

	/**
	 * Sets the fixture for this Jenkins test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Jenkins fixture)
	{
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Jenkins test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Jenkins getFixture()
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
		setFixture(ModelFactory.eINSTANCE.createJenkins());
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

} //JenkinsTest
