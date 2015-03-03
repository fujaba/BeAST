/**
 */
package model.impl;

import model.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelFactoryImpl extends EFactoryImpl implements ModelFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModelFactory init()
	{
		try
		{
			ModelFactory theModelFactory = (ModelFactory)EPackage.Registry.INSTANCE.getEFactory(ModelPackage.eNS_URI);
			if (theModelFactory != null)
			{
				return theModelFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModelFactoryImpl();
	}
	
	
	
	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactoryImpl()
	{
		super();
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case ModelPackage.SERVER: return createServer();
			case ModelPackage.RACK: return createRack();
			case ModelPackage.NETWORK: return createNetwork();
			case ModelPackage.ROOM: return createRoom();
			case ModelPackage.ROUTER: return createRouter();
			case ModelPackage.HADOOP_MASTER: return createHadoopMaster();
			case ModelPackage.HADOOP_SLAVE: return createHadoopSlave();
			case ModelPackage.MY_SQL: return createMySQL();
			case ModelPackage.WORD_PRESS: return createWordPress();
			case ModelPackage.CASSANDRA: return createCassandra();
			case ModelPackage.MONGO_DB: return createMongoDB();
			case ModelPackage.UBUNTU: return createUbuntu();
			case ModelPackage.APACHE2: return createApache2();
			case ModelPackage.JENKINS: return createJenkins();
			case ModelPackage.MEDIA_WIKI: return createMediaWiki();
			case ModelPackage.TOMCAT: return createTomcat();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Server createServer()
	{
		ServerImpl server = new ServerImpl();
		return server;
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rack createRack()
	{
		RackImpl rack = new RackImpl();
		return rack;
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Network createNetwork()
	{
		NetworkImpl network = new NetworkImpl();
		return network;
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Router createRouter()
	{
		RouterImpl router = new RouterImpl();
		return router;
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HadoopMaster createHadoopMaster()
	{
		HadoopMasterImpl hadoopMaster = new HadoopMasterImpl();
		return hadoopMaster;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HadoopSlave createHadoopSlave()
	{
		HadoopSlaveImpl hadoopSlave = new HadoopSlaveImpl();
		return hadoopSlave;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MySQL createMySQL()
	{
		MySQLImpl mySQL = new MySQLImpl();
		return mySQL;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WordPress createWordPress()
	{
		WordPressImpl wordPress = new WordPressImpl();
		return wordPress;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Cassandra createCassandra()
	{
		CassandraImpl cassandra = new CassandraImpl();
		return cassandra;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MongoDB createMongoDB()
	{
		MongoDBImpl mongoDB = new MongoDBImpl();
		return mongoDB;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ubuntu createUbuntu()
	{
		UbuntuImpl ubuntu = new UbuntuImpl();
		return ubuntu;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Apache2 createApache2()
	{
		Apache2Impl apache2 = new Apache2Impl();
		return apache2;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Jenkins createJenkins()
	{
		JenkinsImpl jenkins = new JenkinsImpl();
		return jenkins;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediaWiki createMediaWiki()
	{
		MediaWikiImpl mediaWiki = new MediaWikiImpl();
		return mediaWiki;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tomcat createTomcat()
	{
		TomcatImpl tomcat = new TomcatImpl();
		return tomcat;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Room createRoom()
	{
		RoomImpl room = new RoomImpl();
		return room;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelPackage getModelPackage()
	{
		return (ModelPackage)getEPackage();
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModelPackage getPackage()
	{
		return ModelPackage.eINSTANCE;
	}
	
} //ModelFactoryImpl
