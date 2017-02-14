/**
 */
package model.util;

import model.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see model.ModelPackage
 * @generated
 */
public class ModelSwitch<T> extends Switch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelPackage	modelPackage;
	
	
	
	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSwitch()
	{
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
		}
	}
	
	
	
	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage)
	{
		return ePackage == modelPackage;
	}
	
	
	
	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID) {
			case ModelPackage.SERVER: {
				Server server = (Server)theEObject;
				T result = caseServer(server);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.GROUP: {
				Group group = (Group)theEObject;
				T result = caseGroup(group);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.NETWORK: {
				Network network = (Network)theEObject;
				T result = caseNetwork(network);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ROUTER: {
				Router router = (Router)theEObject;
				T result = caseRouter(router);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.SERVICE: {
				Service service = (Service)theEObject;
				T result = caseService(service);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.HADOOP_MASTER: {
				HadoopMaster hadoopMaster = (HadoopMaster)theEObject;
				T result = caseHadoopMaster(hadoopMaster);
				if (result == null) result = caseService(hadoopMaster);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.HADOOP_SLAVE: {
				HadoopSlave hadoopSlave = (HadoopSlave)theEObject;
				T result = caseHadoopSlave(hadoopSlave);
				if (result == null) result = caseService(hadoopSlave);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MY_SQL: {
				MySQL mySQL = (MySQL)theEObject;
				T result = caseMySQL(mySQL);
				if (result == null) result = caseService(mySQL);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.WORD_PRESS: {
				WordPress wordPress = (WordPress)theEObject;
				T result = caseWordPress(wordPress);
				if (result == null) result = caseService(wordPress);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CASSANDRA: {
				Cassandra cassandra = (Cassandra)theEObject;
				T result = caseCassandra(cassandra);
				if (result == null) result = caseService(cassandra);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MONGO_DB: {
				MongoDB mongoDB = (MongoDB)theEObject;
				T result = caseMongoDB(mongoDB);
				if (result == null) result = caseService(mongoDB);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.UBUNTU: {
				Ubuntu ubuntu = (Ubuntu)theEObject;
				T result = caseUbuntu(ubuntu);
				if (result == null) result = caseService(ubuntu);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.APACHE2: {
				Apache2 apache2 = (Apache2)theEObject;
				T result = caseApache2(apache2);
				if (result == null) result = caseService(apache2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.JENKINS: {
				Jenkins jenkins = (Jenkins)theEObject;
				T result = caseJenkins(jenkins);
				if (result == null) result = caseService(jenkins);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MEDIA_WIKI: {
				MediaWiki mediaWiki = (MediaWiki)theEObject;
				T result = caseMediaWiki(mediaWiki);
				if (result == null) result = caseService(mediaWiki);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.TOMCAT: {
				Tomcat tomcat = (Tomcat)theEObject;
				T result = caseTomcat(tomcat);
				if (result == null) result = caseService(tomcat);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}
	
	
	
	/**
	 * Returns the result of interpreting the object as an instance of '<em>Server</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Server</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServer(Server object)
	{
		return null;
	}
	
	
	
	/**
	 * Returns the result of interpreting the object as an instance of '<em>Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGroup(Group object)
	{
		return null;
	}



	/**
	 * Returns the result of interpreting the object as an instance of '<em>Network</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Network</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNetwork(Network object)
	{
		return null;
	}
	
	
	
	/**
	 * Returns the result of interpreting the object as an instance of '<em>Router</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Router</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRouter(Router object)
	{
		return null;
	}
	
	
	
	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseService(Service object)
	{
		return null;
	}



	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hadoop Master</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hadoop Master</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHadoopMaster(HadoopMaster object)
	{
		return null;
	}



	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hadoop Slave</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hadoop Slave</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHadoopSlave(HadoopSlave object)
	{
		return null;
	}



	/**
	 * Returns the result of interpreting the object as an instance of '<em>My SQL</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>My SQL</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMySQL(MySQL object)
	{
		return null;
	}



	/**
	 * Returns the result of interpreting the object as an instance of '<em>Word Press</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Word Press</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWordPress(WordPress object)
	{
		return null;
	}



	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cassandra</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cassandra</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCassandra(Cassandra object)
	{
		return null;
	}



	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mongo DB</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mongo DB</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMongoDB(MongoDB object)
	{
		return null;
	}



	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ubuntu</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ubuntu</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUbuntu(Ubuntu object)
	{
		return null;
	}



	/**
	 * Returns the result of interpreting the object as an instance of '<em>Apache2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Apache2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApache2(Apache2 object)
	{
		return null;
	}



	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jenkins</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jenkins</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJenkins(Jenkins object)
	{
		return null;
	}



	/**
	 * Returns the result of interpreting the object as an instance of '<em>Media Wiki</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Media Wiki</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMediaWiki(MediaWiki object)
	{
		return null;
	}



	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tomcat</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tomcat</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTomcat(Tomcat object)
	{
		return null;
	}



	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object)
	{
		return null;
	}
	
} //ModelSwitch
