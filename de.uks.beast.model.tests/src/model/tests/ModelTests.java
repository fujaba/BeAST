/**
 */
package model.tests;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>model</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelTests extends TestSuite
{

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args)
	{
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite()
	{
		TestSuite suite = new ModelTests("model Tests");
		
		suite.addTest(new Apache2Test("testGetterAndSetter"));
		suite.addTest(new CassandraTest("testGetterAndSetter"));
		suite.addTest(new GroupTest("testGetterAndSetter"));
		suite.addTest(new HadoopMasterTest("testGetterAndSetter"));
		suite.addTest(new HadoopSlaveTest("testGetterAndSetter"));
		suite.addTest(new JenkinsTest("testGetterAndSetter"));
		suite.addTest(new MediaWikiTest("testGetterAndSetter"));
		suite.addTest(new MongoDBTest("testGetterAndSetter"));
		suite.addTest(new MySQLTest("testGetterAndSetter"));
		suite.addTest(new NetworkTest("testGetterAndSetter"));
		suite.addTest(new RouterTest("testGetterAndSetter"));
		suite.addTest(new ServerTest("testGetterAndSetter"));
		suite.addTest(new TomcatTest("testGetterAndSetter"));
		suite.addTest(new UbuntuTest("testGetterAndSetter"));
		suite.addTest(new WordPressTest("testGetterAndSetter"));
		
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelTests(String name)
	{
		super(name);
	}

} //ModelTests
