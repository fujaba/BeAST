/**
 */
package model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String			eNAME								= "model";
	
	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String			eNS_URI								= "http://www.example.org/model";
	
	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String			eNS_PREFIX							= "model";
	
	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage	eINSTANCE							= model.impl.ModelPackageImpl.init();
	
	/**
	 * The meta object id for the '{@link model.impl.ServerImpl <em>Server</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.ServerImpl
	 * @see model.impl.ModelPackageImpl#getServer()
	 * @generated
	 */
	int				SERVER								= 0;
	
	/**
	 * The feature id for the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				SERVER__IP							= 0;
	
	/**
	 * The feature id for the '<em><b>Cpu Cores</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__CPU_CORES = 1;

	/**
	 * The feature id for the '<em><b>Ram</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				SERVER__RAM							= 2;
	
	/**
	 * The feature id for the '<em><b>Disk Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				SERVER__DISK_SPACE					= 3;
	
	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__NAME = 4;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__NETWORK = 5;

	/**
	 * The feature id for the '<em><b>Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__SERVICE = 6;

	/**
	 * The number of structural features of the '<em>Server</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				SERVER_FEATURE_COUNT				= 7;
	
	/**
	 * The number of operations of the '<em>Server</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				SERVER_OPERATION_COUNT				= 0;
	
	/**
	 * The meta object id for the '{@link model.impl.GroupImpl <em>Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.GroupImpl
	 * @see model.impl.ModelPackageImpl#getGroup()
	 * @generated
	 */
	int GROUP = 1;

	/**
	 * The feature id for the '<em><b>Server</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__SERVER = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__ID = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__NAME = 2;

	/**
	 * The feature id for the '<em><b>Group</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__GROUP = 3;

	/**
	 * The number of structural features of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link model.impl.NetworkImpl <em>Network</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.NetworkImpl
	 * @see model.impl.ModelPackageImpl#getNetwork()
	 * @generated
	 */
	int				NETWORK								= 2;
	
	/**
	 * The feature id for the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__IP = 0;

	/**
	 * The feature id for the '<em><b>Subnetmask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				NETWORK__SUBNETMASK					= 1;
	
	/**
	 * The feature id for the '<em><b>Gateway</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				NETWORK__GATEWAY					= 2;
	
	/**
	 * The feature id for the '<em><b>Dns</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				NETWORK__DNS						= 3;
	
	/**
	 * The feature id for the '<em><b>Router</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__ROUTER = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__NAME = 5;

	/**
	 * The feature id for the '<em><b>Server</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__SERVER = 6;

	/**
	 * The number of structural features of the '<em>Network</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				NETWORK_FEATURE_COUNT				= 7;
	
	/**
	 * The number of operations of the '<em>Network</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				NETWORK_OPERATION_COUNT				= 0;
	
	/**
	 * The meta object id for the '{@link model.impl.RouterImpl <em>Router</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.RouterImpl
	 * @see model.impl.ModelPackageImpl#getRouter()
	 * @generated
	 */
	int				ROUTER								= 3;
	
	/**
	 * The feature id for the '<em><b>Network</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				ROUTER__NETWORK						= 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER__ID = 1;

	/**
	 * The feature id for the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				ROUTER__IP							= 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER__NAME = 3;

	/**
	 * The feature id for the '<em><b>External Gateway</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER__EXTERNAL_GATEWAY = 4;

	/**
	 * The number of structural features of the '<em>Router</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				ROUTER_FEATURE_COUNT				= 5;

	/**
	 * The number of operations of the '<em>Router</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				ROUTER_OPERATION_COUNT				= 0;



	/**
	 * The meta object id for the '{@link model.Service <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.Service
	 * @see model.impl.ModelPackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Service Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SERVICE_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SERVICE_NAME = 2;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__RELATIONS = 3;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link model.impl.HadoopMasterImpl <em>Hadoop Master</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.HadoopMasterImpl
	 * @see model.impl.ModelPackageImpl#getHadoopMaster()
	 * @generated
	 */
	int HADOOP_MASTER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_MASTER__NAME = SERVICE__NAME;

	/**
	 * The feature id for the '<em><b>Service Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_MASTER__SERVICE_TYPE = SERVICE__SERVICE_TYPE;

	/**
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_MASTER__SERVICE_NAME = SERVICE__SERVICE_NAME;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_MASTER__RELATIONS = SERVICE__RELATIONS;

	/**
	 * The number of structural features of the '<em>Hadoop Master</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_MASTER_FEATURE_COUNT = SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Hadoop Master</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_MASTER_OPERATION_COUNT = SERVICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link model.impl.HadoopSlaveImpl <em>Hadoop Slave</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.HadoopSlaveImpl
	 * @see model.impl.ModelPackageImpl#getHadoopSlave()
	 * @generated
	 */
	int HADOOP_SLAVE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_SLAVE__NAME = SERVICE__NAME;

	/**
	 * The feature id for the '<em><b>Service Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_SLAVE__SERVICE_TYPE = SERVICE__SERVICE_TYPE;

	/**
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_SLAVE__SERVICE_NAME = SERVICE__SERVICE_NAME;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_SLAVE__RELATIONS = SERVICE__RELATIONS;

	/**
	 * The number of structural features of the '<em>Hadoop Slave</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_SLAVE_FEATURE_COUNT = SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Hadoop Slave</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_SLAVE_OPERATION_COUNT = SERVICE_OPERATION_COUNT + 0;



	/**
	 * The meta object id for the '{@link model.impl.MySQLImpl <em>My SQL</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.MySQLImpl
	 * @see model.impl.ModelPackageImpl#getMySQL()
	 * @generated
	 */
	int MY_SQL = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SQL__NAME = SERVICE__NAME;

	/**
	 * The feature id for the '<em><b>Service Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SQL__SERVICE_TYPE = SERVICE__SERVICE_TYPE;

	/**
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SQL__SERVICE_NAME = SERVICE__SERVICE_NAME;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SQL__RELATIONS = SERVICE__RELATIONS;

	/**
	 * The number of structural features of the '<em>My SQL</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SQL_FEATURE_COUNT = SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>My SQL</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SQL_OPERATION_COUNT = SERVICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link model.impl.WordPressImpl <em>Word Press</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.WordPressImpl
	 * @see model.impl.ModelPackageImpl#getWordPress()
	 * @generated
	 */
	int WORD_PRESS = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_PRESS__NAME = SERVICE__NAME;

	/**
	 * The feature id for the '<em><b>Service Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_PRESS__SERVICE_TYPE = SERVICE__SERVICE_TYPE;

	/**
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_PRESS__SERVICE_NAME = SERVICE__SERVICE_NAME;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_PRESS__RELATIONS = SERVICE__RELATIONS;

	/**
	 * The number of structural features of the '<em>Word Press</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_PRESS_FEATURE_COUNT = SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Word Press</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_PRESS_OPERATION_COUNT = SERVICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link model.impl.CassandraImpl <em>Cassandra</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.CassandraImpl
	 * @see model.impl.ModelPackageImpl#getCassandra()
	 * @generated
	 */
	int CASSANDRA = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASSANDRA__NAME = SERVICE__NAME;

	/**
	 * The feature id for the '<em><b>Service Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASSANDRA__SERVICE_TYPE = SERVICE__SERVICE_TYPE;

	/**
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASSANDRA__SERVICE_NAME = SERVICE__SERVICE_NAME;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASSANDRA__RELATIONS = SERVICE__RELATIONS;

	/**
	 * The number of structural features of the '<em>Cassandra</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASSANDRA_FEATURE_COUNT = SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Cassandra</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASSANDRA_OPERATION_COUNT = SERVICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link model.impl.MongoDBImpl <em>Mongo DB</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.MongoDBImpl
	 * @see model.impl.ModelPackageImpl#getMongoDB()
	 * @generated
	 */
	int MONGO_DB = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONGO_DB__NAME = SERVICE__NAME;

	/**
	 * The feature id for the '<em><b>Service Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONGO_DB__SERVICE_TYPE = SERVICE__SERVICE_TYPE;

	/**
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONGO_DB__SERVICE_NAME = SERVICE__SERVICE_NAME;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONGO_DB__RELATIONS = SERVICE__RELATIONS;

	/**
	 * The number of structural features of the '<em>Mongo DB</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONGO_DB_FEATURE_COUNT = SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mongo DB</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONGO_DB_OPERATION_COUNT = SERVICE_OPERATION_COUNT + 0;



	/**
	 * The meta object id for the '{@link model.impl.UbuntuImpl <em>Ubuntu</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.UbuntuImpl
	 * @see model.impl.ModelPackageImpl#getUbuntu()
	 * @generated
	 */
	int UBUNTU = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UBUNTU__NAME = SERVICE__NAME;

	/**
	 * The feature id for the '<em><b>Service Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UBUNTU__SERVICE_TYPE = SERVICE__SERVICE_TYPE;

	/**
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UBUNTU__SERVICE_NAME = SERVICE__SERVICE_NAME;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UBUNTU__RELATIONS = SERVICE__RELATIONS;

	/**
	 * The number of structural features of the '<em>Ubuntu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UBUNTU_FEATURE_COUNT = SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Ubuntu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UBUNTU_OPERATION_COUNT = SERVICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link model.impl.Apache2Impl <em>Apache2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.Apache2Impl
	 * @see model.impl.ModelPackageImpl#getApache2()
	 * @generated
	 */
	int APACHE2 = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APACHE2__NAME = SERVICE__NAME;

	/**
	 * The feature id for the '<em><b>Service Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APACHE2__SERVICE_TYPE = SERVICE__SERVICE_TYPE;

	/**
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APACHE2__SERVICE_NAME = SERVICE__SERVICE_NAME;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APACHE2__RELATIONS = SERVICE__RELATIONS;

	/**
	 * The number of structural features of the '<em>Apache2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APACHE2_FEATURE_COUNT = SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Apache2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APACHE2_OPERATION_COUNT = SERVICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link model.impl.JenkinsImpl <em>Jenkins</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.JenkinsImpl
	 * @see model.impl.ModelPackageImpl#getJenkins()
	 * @generated
	 */
	int JENKINS = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JENKINS__NAME = SERVICE__NAME;

	/**
	 * The feature id for the '<em><b>Service Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JENKINS__SERVICE_TYPE = SERVICE__SERVICE_TYPE;

	/**
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JENKINS__SERVICE_NAME = SERVICE__SERVICE_NAME;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JENKINS__RELATIONS = SERVICE__RELATIONS;

	/**
	 * The number of structural features of the '<em>Jenkins</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JENKINS_FEATURE_COUNT = SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Jenkins</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JENKINS_OPERATION_COUNT = SERVICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link model.impl.MediaWikiImpl <em>Media Wiki</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.MediaWikiImpl
	 * @see model.impl.ModelPackageImpl#getMediaWiki()
	 * @generated
	 */
	int MEDIA_WIKI = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_WIKI__NAME = SERVICE__NAME;

	/**
	 * The feature id for the '<em><b>Service Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_WIKI__SERVICE_TYPE = SERVICE__SERVICE_TYPE;

	/**
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_WIKI__SERVICE_NAME = SERVICE__SERVICE_NAME;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_WIKI__RELATIONS = SERVICE__RELATIONS;

	/**
	 * The number of structural features of the '<em>Media Wiki</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_WIKI_FEATURE_COUNT = SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Media Wiki</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_WIKI_OPERATION_COUNT = SERVICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link model.impl.TomcatImpl <em>Tomcat</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.TomcatImpl
	 * @see model.impl.ModelPackageImpl#getTomcat()
	 * @generated
	 */
	int TOMCAT = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT__NAME = SERVICE__NAME;

	/**
	 * The feature id for the '<em><b>Service Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT__SERVICE_TYPE = SERVICE__SERVICE_TYPE;

	/**
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT__SERVICE_NAME = SERVICE__SERVICE_NAME;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT__RELATIONS = SERVICE__RELATIONS;

	/**
	 * The number of structural features of the '<em>Tomcat</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_FEATURE_COUNT = SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tomcat</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_OPERATION_COUNT = SERVICE_OPERATION_COUNT + 0;



	/**
	 * Returns the meta object for class '{@link model.Server <em>Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server</em>'.
	 * @see model.Server
	 * @generated
	 */
	EClass getServer();
	
	
	
	/**
	 * Returns the meta object for the attribute '{@link model.Server#getIp <em>Ip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ip</em>'.
	 * @see model.Server#getIp()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_Ip();
	
	
	
	/**
	 * Returns the meta object for the attribute '{@link model.Server#getCpuCores <em>Cpu Cores</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cpu Cores</em>'.
	 * @see model.Server#getCpuCores()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_CpuCores();



	/**
	 * Returns the meta object for the attribute '{@link model.Server#getRam <em>Ram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ram</em>'.
	 * @see model.Server#getRam()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_Ram();
	
	
	
	/**
	 * Returns the meta object for the attribute '{@link model.Server#getDiskSpace <em>Disk Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Disk Space</em>'.
	 * @see model.Server#getDiskSpace()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_DiskSpace();
	
	
	
	/**
	 * Returns the meta object for the attribute '{@link model.Server#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see model.Server#getName()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_Name();



	/**
	 * Returns the meta object for the reference '{@link model.Server#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see model.Server#getNetwork()
	 * @see #getServer()
	 * @generated
	 */
	EReference getServer_Network();



	/**
	 * Returns the meta object for the containment reference '{@link model.Server#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Service</em>'.
	 * @see model.Server#getService()
	 * @see #getServer()
	 * @generated
	 */
	EReference getServer_Service();



	/**
	 * Returns the meta object for class '{@link model.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group</em>'.
	 * @see model.Group
	 * @generated
	 */
	EClass getGroup();



	/**
	 * Returns the meta object for the containment reference list '{@link model.Group#getServer <em>Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Server</em>'.
	 * @see model.Group#getServer()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_Server();



	/**
	 * Returns the meta object for the attribute '{@link model.Group#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see model.Group#getId()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_Id();



	/**
	 * Returns the meta object for the attribute '{@link model.Group#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see model.Group#getName()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_Name();



	/**
	 * Returns the meta object for the containment reference list '{@link model.Group#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Group</em>'.
	 * @see model.Group#getGroup()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_Group();



	/**
	 * Returns the meta object for class '{@link model.Network <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Network</em>'.
	 * @see model.Network
	 * @generated
	 */
	EClass getNetwork();
	
	
	
	/**
	 * Returns the meta object for the attribute '{@link model.Network#getIp <em>Ip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ip</em>'.
	 * @see model.Network#getIp()
	 * @see #getNetwork()
	 * @generated
	 */
	EAttribute getNetwork_Ip();



	/**
	 * Returns the meta object for the attribute '{@link model.Network#getSubnetmask <em>Subnetmask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Subnetmask</em>'.
	 * @see model.Network#getSubnetmask()
	 * @see #getNetwork()
	 * @generated
	 */
	EAttribute getNetwork_Subnetmask();
	
	
	
	/**
	 * Returns the meta object for the attribute '{@link model.Network#getGateway <em>Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gateway</em>'.
	 * @see model.Network#getGateway()
	 * @see #getNetwork()
	 * @generated
	 */
	EAttribute getNetwork_Gateway();
	
	
	
	/**
	 * Returns the meta object for the attribute '{@link model.Network#getDns <em>Dns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dns</em>'.
	 * @see model.Network#getDns()
	 * @see #getNetwork()
	 * @generated
	 */
	EAttribute getNetwork_Dns();
	
	
	
	/**
	 * Returns the meta object for the reference list '{@link model.Network#getServer <em>Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Server</em>'.
	 * @see model.Network#getServer()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_Server();



	/**
	 * Returns the meta object for the reference list '{@link model.Network#getRouter <em>Router</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Router</em>'.
	 * @see model.Network#getRouter()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_Router();



	/**
	 * Returns the meta object for the attribute '{@link model.Network#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see model.Network#getName()
	 * @see #getNetwork()
	 * @generated
	 */
	EAttribute getNetwork_Name();



	/**
	 * Returns the meta object for class '{@link model.Router <em>Router</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Router</em>'.
	 * @see model.Router
	 * @generated
	 */
	EClass getRouter();
	
	
	
	/**
	 * Returns the meta object for the reference list '{@link model.Router#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Network</em>'.
	 * @see model.Router#getNetwork()
	 * @see #getRouter()
	 * @generated
	 */
	EReference getRouter_Network();



	/**
	 * Returns the meta object for the attribute '{@link model.Router#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see model.Router#getId()
	 * @see #getRouter()
	 * @generated
	 */
	EAttribute getRouter_Id();



	/**
	 * Returns the meta object for the attribute '{@link model.Router#getIp <em>Ip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ip</em>'.
	 * @see model.Router#getIp()
	 * @see #getRouter()
	 * @generated
	 */
	EAttribute getRouter_Ip();



	/**
	 * Returns the meta object for the attribute '{@link model.Router#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see model.Router#getName()
	 * @see #getRouter()
	 * @generated
	 */
	EAttribute getRouter_Name();



	/**
	 * Returns the meta object for the attribute '{@link model.Router#getExternalGateway <em>External Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External Gateway</em>'.
	 * @see model.Router#getExternalGateway()
	 * @see #getRouter()
	 * @generated
	 */
	EAttribute getRouter_ExternalGateway();



	/**
	 * Returns the meta object for class '{@link model.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see model.Service
	 * @generated
	 */
	EClass getService();



	/**
	 * Returns the meta object for the attribute '{@link model.Service#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see model.Service#getName()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Name();



	/**
	 * Returns the meta object for the reference list '{@link model.Service#getRelations <em>Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Relations</em>'.
	 * @see model.Service#getRelations()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Relations();



	/**
	 * Returns the meta object for the attribute '{@link model.Service#getServiceName <em>Service Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Name</em>'.
	 * @see model.Service#getServiceName()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_ServiceName();



	/**
	 * Returns the meta object for the attribute '{@link model.Service#getServiceType <em>Service Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Type</em>'.
	 * @see model.Service#getServiceType()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_ServiceType();



	/**
	 * Returns the meta object for class '{@link model.HadoopMaster <em>Hadoop Master</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hadoop Master</em>'.
	 * @see model.HadoopMaster
	 * @generated
	 */
	EClass getHadoopMaster();



	/**
	 * Returns the meta object for class '{@link model.HadoopSlave <em>Hadoop Slave</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hadoop Slave</em>'.
	 * @see model.HadoopSlave
	 * @generated
	 */
	EClass getHadoopSlave();



	/**
	 * Returns the meta object for class '{@link model.MySQL <em>My SQL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>My SQL</em>'.
	 * @see model.MySQL
	 * @generated
	 */
	EClass getMySQL();



	/**
	 * Returns the meta object for class '{@link model.WordPress <em>Word Press</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Word Press</em>'.
	 * @see model.WordPress
	 * @generated
	 */
	EClass getWordPress();



	/**
	 * Returns the meta object for class '{@link model.Cassandra <em>Cassandra</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cassandra</em>'.
	 * @see model.Cassandra
	 * @generated
	 */
	EClass getCassandra();



	/**
	 * Returns the meta object for class '{@link model.MongoDB <em>Mongo DB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mongo DB</em>'.
	 * @see model.MongoDB
	 * @generated
	 */
	EClass getMongoDB();



	/**
	 * Returns the meta object for class '{@link model.Ubuntu <em>Ubuntu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ubuntu</em>'.
	 * @see model.Ubuntu
	 * @generated
	 */
	EClass getUbuntu();



	/**
	 * Returns the meta object for class '{@link model.Apache2 <em>Apache2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Apache2</em>'.
	 * @see model.Apache2
	 * @generated
	 */
	EClass getApache2();



	/**
	 * Returns the meta object for class '{@link model.Jenkins <em>Jenkins</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jenkins</em>'.
	 * @see model.Jenkins
	 * @generated
	 */
	EClass getJenkins();



	/**
	 * Returns the meta object for class '{@link model.MediaWiki <em>Media Wiki</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Media Wiki</em>'.
	 * @see model.MediaWiki
	 * @generated
	 */
	EClass getMediaWiki();



	/**
	 * Returns the meta object for class '{@link model.Tomcat <em>Tomcat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tomcat</em>'.
	 * @see model.Tomcat
	 * @generated
	 */
	EClass getTomcat();



	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();
	
	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link model.impl.ServerImpl <em>Server</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.ServerImpl
		 * @see model.impl.ModelPackageImpl#getServer()
		 * @generated
		 */
		EClass		SERVER						= eINSTANCE.getServer();
		
		/**
		 * The meta object literal for the '<em><b>Ip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute	SERVER__IP					= eINSTANCE.getServer_Ip();
		
		/**
		 * The meta object literal for the '<em><b>Cpu Cores</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__CPU_CORES = eINSTANCE.getServer_CpuCores();

		/**
		 * The meta object literal for the '<em><b>Ram</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute	SERVER__RAM					= eINSTANCE.getServer_Ram();
		
		/**
		 * The meta object literal for the '<em><b>Disk Space</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute	SERVER__DISK_SPACE			= eINSTANCE.getServer_DiskSpace();
		
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__NAME = eINSTANCE.getServer_Name();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVER__NETWORK = eINSTANCE.getServer_Network();

		/**
		 * The meta object literal for the '<em><b>Service</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVER__SERVICE = eINSTANCE.getServer_Service();

		/**
		 * The meta object literal for the '{@link model.impl.GroupImpl <em>Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.GroupImpl
		 * @see model.impl.ModelPackageImpl#getGroup()
		 * @generated
		 */
		EClass GROUP = eINSTANCE.getGroup();

		/**
		 * The meta object literal for the '<em><b>Server</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__SERVER = eINSTANCE.getGroup_Server();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP__ID = eINSTANCE.getGroup_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP__NAME = eINSTANCE.getGroup_Name();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__GROUP = eINSTANCE.getGroup_Group();

		/**
		 * The meta object literal for the '{@link model.impl.NetworkImpl <em>Network</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.NetworkImpl
		 * @see model.impl.ModelPackageImpl#getNetwork()
		 * @generated
		 */
		EClass		NETWORK						= eINSTANCE.getNetwork();
		
		/**
		 * The meta object literal for the '<em><b>Ip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NETWORK__IP = eINSTANCE.getNetwork_Ip();

		/**
		 * The meta object literal for the '<em><b>Subnetmask</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute	NETWORK__SUBNETMASK			= eINSTANCE.getNetwork_Subnetmask();
		
		/**
		 * The meta object literal for the '<em><b>Gateway</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute	NETWORK__GATEWAY			= eINSTANCE.getNetwork_Gateway();
		
		/**
		 * The meta object literal for the '<em><b>Dns</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute	NETWORK__DNS				= eINSTANCE.getNetwork_Dns();
		
		/**
		 * The meta object literal for the '<em><b>Server</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__SERVER = eINSTANCE.getNetwork_Server();

		/**
		 * The meta object literal for the '<em><b>Router</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__ROUTER = eINSTANCE.getNetwork_Router();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NETWORK__NAME = eINSTANCE.getNetwork_Name();

		/**
		 * The meta object literal for the '{@link model.impl.RouterImpl <em>Router</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.RouterImpl
		 * @see model.impl.ModelPackageImpl#getRouter()
		 * @generated
		 */
		EClass		ROUTER						= eINSTANCE.getRouter();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUTER__NETWORK = eINSTANCE.getRouter_Network();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUTER__ID = eINSTANCE.getRouter_Id();

		/**
		 * The meta object literal for the '<em><b>Ip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUTER__IP = eINSTANCE.getRouter_Ip();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUTER__NAME = eINSTANCE.getRouter_Name();

		/**
		 * The meta object literal for the '<em><b>External Gateway</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUTER__EXTERNAL_GATEWAY = eINSTANCE.getRouter_ExternalGateway();

		/**
		 * The meta object literal for the '{@link model.Service <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.Service
		 * @see model.impl.ModelPackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__NAME = eINSTANCE.getService_Name();

		/**
		 * The meta object literal for the '<em><b>Relations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__RELATIONS = eINSTANCE.getService_Relations();

		/**
		 * The meta object literal for the '<em><b>Service Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__SERVICE_NAME = eINSTANCE.getService_ServiceName();

		/**
		 * The meta object literal for the '<em><b>Service Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__SERVICE_TYPE = eINSTANCE.getService_ServiceType();

		/**
		 * The meta object literal for the '{@link model.impl.HadoopMasterImpl <em>Hadoop Master</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.HadoopMasterImpl
		 * @see model.impl.ModelPackageImpl#getHadoopMaster()
		 * @generated
		 */
		EClass HADOOP_MASTER = eINSTANCE.getHadoopMaster();

		/**
		 * The meta object literal for the '{@link model.impl.HadoopSlaveImpl <em>Hadoop Slave</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.HadoopSlaveImpl
		 * @see model.impl.ModelPackageImpl#getHadoopSlave()
		 * @generated
		 */
		EClass HADOOP_SLAVE = eINSTANCE.getHadoopSlave();

		/**
		 * The meta object literal for the '{@link model.impl.MySQLImpl <em>My SQL</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.MySQLImpl
		 * @see model.impl.ModelPackageImpl#getMySQL()
		 * @generated
		 */
		EClass MY_SQL = eINSTANCE.getMySQL();

		/**
		 * The meta object literal for the '{@link model.impl.WordPressImpl <em>Word Press</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.WordPressImpl
		 * @see model.impl.ModelPackageImpl#getWordPress()
		 * @generated
		 */
		EClass WORD_PRESS = eINSTANCE.getWordPress();

		/**
		 * The meta object literal for the '{@link model.impl.CassandraImpl <em>Cassandra</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.CassandraImpl
		 * @see model.impl.ModelPackageImpl#getCassandra()
		 * @generated
		 */
		EClass CASSANDRA = eINSTANCE.getCassandra();

		/**
		 * The meta object literal for the '{@link model.impl.MongoDBImpl <em>Mongo DB</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.MongoDBImpl
		 * @see model.impl.ModelPackageImpl#getMongoDB()
		 * @generated
		 */
		EClass MONGO_DB = eINSTANCE.getMongoDB();

		/**
		 * The meta object literal for the '{@link model.impl.UbuntuImpl <em>Ubuntu</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.UbuntuImpl
		 * @see model.impl.ModelPackageImpl#getUbuntu()
		 * @generated
		 */
		EClass UBUNTU = eINSTANCE.getUbuntu();

		/**
		 * The meta object literal for the '{@link model.impl.Apache2Impl <em>Apache2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.Apache2Impl
		 * @see model.impl.ModelPackageImpl#getApache2()
		 * @generated
		 */
		EClass APACHE2 = eINSTANCE.getApache2();

		/**
		 * The meta object literal for the '{@link model.impl.JenkinsImpl <em>Jenkins</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.JenkinsImpl
		 * @see model.impl.ModelPackageImpl#getJenkins()
		 * @generated
		 */
		EClass JENKINS = eINSTANCE.getJenkins();

		/**
		 * The meta object literal for the '{@link model.impl.MediaWikiImpl <em>Media Wiki</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.MediaWikiImpl
		 * @see model.impl.ModelPackageImpl#getMediaWiki()
		 * @generated
		 */
		EClass MEDIA_WIKI = eINSTANCE.getMediaWiki();

		/**
		 * The meta object literal for the '{@link model.impl.TomcatImpl <em>Tomcat</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.TomcatImpl
		 * @see model.impl.ModelPackageImpl#getTomcat()
		 * @generated
		 */
		EClass TOMCAT = eINSTANCE.getTomcat();
		
	}
	
} //ModelPackage
