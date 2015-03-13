/**
 */
package model.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import model.MediaWiki;
import model.ModelFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Media Wiki</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MediaWikiTest extends TestCase
{

	/**
	 * The fixture for this Media Wiki test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MediaWiki fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args)
	{
		TestRunner.run(MediaWikiTest.class);
	}

	/**
	 * Constructs a new Media Wiki test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediaWikiTest(String name)
	{
		super(name);
	}

	/**
	 * Sets the fixture for this Media Wiki test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(MediaWiki fixture)
	{
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Media Wiki test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MediaWiki getFixture()
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
		setFixture(ModelFactory.eINSTANCE.createMediaWiki());
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

} //MediaWikiTest
