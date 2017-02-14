/**
 */
package model.util;

import model.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see model.ModelPackage
 * @generated
 */
public class ModelAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelPackage	modelPackage;
	
	
	
	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelAdapterFactory()
	{
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
		}
	}
	
	
	
	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object)
	{
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}
	
	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelSwitch<Adapter>	modelSwitch	= new ModelSwitch<Adapter>() {
			@Override
			public Adapter caseServer(Server object) {
				return createServerAdapter();
			}
			@Override
			public Adapter caseGroup(Group object) {
				return createGroupAdapter();
			}
			@Override
			public Adapter caseNetwork(Network object) {
				return createNetworkAdapter();
			}
			@Override
			public Adapter caseRouter(Router object) {
				return createRouterAdapter();
			}
			@Override
			public Adapter caseService(Service object) {
				return createServiceAdapter();
			}
			@Override
			public Adapter caseHadoopMaster(HadoopMaster object) {
				return createHadoopMasterAdapter();
			}
			@Override
			public Adapter caseHadoopSlave(HadoopSlave object) {
				return createHadoopSlaveAdapter();
			}
			@Override
			public Adapter caseMySQL(MySQL object) {
				return createMySQLAdapter();
			}
			@Override
			public Adapter caseWordPress(WordPress object) {
				return createWordPressAdapter();
			}
			@Override
			public Adapter caseCassandra(Cassandra object) {
				return createCassandraAdapter();
			}
			@Override
			public Adapter caseMongoDB(MongoDB object) {
				return createMongoDBAdapter();
			}
			@Override
			public Adapter caseUbuntu(Ubuntu object) {
				return createUbuntuAdapter();
			}
			@Override
			public Adapter caseApache2(Apache2 object) {
				return createApache2Adapter();
			}
			@Override
			public Adapter caseJenkins(Jenkins object) {
				return createJenkinsAdapter();
			}
			@Override
			public Adapter caseMediaWiki(MediaWiki object) {
				return createMediaWikiAdapter();
			}
			@Override
			public Adapter caseTomcat(Tomcat object) {
				return createTomcatAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};
	
	
	
	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target)
	{
		return modelSwitch.doSwitch((EObject)target);
	}
	
	
	
	/**
	 * Creates a new adapter for an object of class '{@link model.Server <em>Server</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Server
	 * @generated
	 */
	public Adapter createServerAdapter()
	{
		return null;
	}
	
	
	
	/**
	 * Creates a new adapter for an object of class '{@link model.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Group
	 * @generated
	 */
	public Adapter createGroupAdapter()
	{
		return null;
	}



	/**
	 * Creates a new adapter for an object of class '{@link model.Network <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Network
	 * @generated
	 */
	public Adapter createNetworkAdapter()
	{
		return null;
	}
	
	
	
	/**
	 * Creates a new adapter for an object of class '{@link model.Router <em>Router</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Router
	 * @generated
	 */
	public Adapter createRouterAdapter()
	{
		return null;
	}
	
	
	
	/**
	 * Creates a new adapter for an object of class '{@link model.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Service
	 * @generated
	 */
	public Adapter createServiceAdapter()
	{
		return null;
	}



	/**
	 * Creates a new adapter for an object of class '{@link model.HadoopMaster <em>Hadoop Master</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.HadoopMaster
	 * @generated
	 */
	public Adapter createHadoopMasterAdapter()
	{
		return null;
	}



	/**
	 * Creates a new adapter for an object of class '{@link model.HadoopSlave <em>Hadoop Slave</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.HadoopSlave
	 * @generated
	 */
	public Adapter createHadoopSlaveAdapter()
	{
		return null;
	}



	/**
	 * Creates a new adapter for an object of class '{@link model.MySQL <em>My SQL</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.MySQL
	 * @generated
	 */
	public Adapter createMySQLAdapter()
	{
		return null;
	}



	/**
	 * Creates a new adapter for an object of class '{@link model.WordPress <em>Word Press</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.WordPress
	 * @generated
	 */
	public Adapter createWordPressAdapter()
	{
		return null;
	}



	/**
	 * Creates a new adapter for an object of class '{@link model.Cassandra <em>Cassandra</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Cassandra
	 * @generated
	 */
	public Adapter createCassandraAdapter()
	{
		return null;
	}



	/**
	 * Creates a new adapter for an object of class '{@link model.MongoDB <em>Mongo DB</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.MongoDB
	 * @generated
	 */
	public Adapter createMongoDBAdapter()
	{
		return null;
	}



	/**
	 * Creates a new adapter for an object of class '{@link model.Ubuntu <em>Ubuntu</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Ubuntu
	 * @generated
	 */
	public Adapter createUbuntuAdapter()
	{
		return null;
	}



	/**
	 * Creates a new adapter for an object of class '{@link model.Apache2 <em>Apache2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Apache2
	 * @generated
	 */
	public Adapter createApache2Adapter()
	{
		return null;
	}



	/**
	 * Creates a new adapter for an object of class '{@link model.Jenkins <em>Jenkins</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Jenkins
	 * @generated
	 */
	public Adapter createJenkinsAdapter()
	{
		return null;
	}



	/**
	 * Creates a new adapter for an object of class '{@link model.MediaWiki <em>Media Wiki</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.MediaWiki
	 * @generated
	 */
	public Adapter createMediaWikiAdapter()
	{
		return null;
	}



	/**
	 * Creates a new adapter for an object of class '{@link model.Tomcat <em>Tomcat</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Tomcat
	 * @generated
	 */
	public Adapter createTomcatAdapter()
	{
		return null;
	}



	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter()
	{
		return null;
	}
	
} //ModelAdapterFactory
