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
	 * The feature id for the '<em><b>Cpu Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				SERVER__CPU_AMOUNT					= 1;
	
	/**
	 * The feature id for the '<em><b>Cpu Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				SERVER__CPU_TYPE					= 2;
	
	/**
	 * The feature id for the '<em><b>Ram</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				SERVER__RAM							= 3;
	
	/**
	 * The feature id for the '<em><b>Disk Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				SERVER__DISK_SPACE					= 4;
	
	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__NAME = 5;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__NETWORK = 6;

	/**
	 * The feature id for the '<em><b>Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__SERVICE = 7;

	/**
	 * The number of structural features of the '<em>Server</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				SERVER_FEATURE_COUNT				= 8;
	
	/**
	 * The number of operations of the '<em>Server</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				SERVER_OPERATION_COUNT				= 0;
	
	/**
	 * The meta object id for the '{@link model.impl.RackImpl <em>Rack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.RackImpl
	 * @see model.impl.ModelPackageImpl#getRack()
	 * @generated
	 */
	int				RACK								= 1;
	
	/**
	 * The feature id for the '<em><b>Server</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				RACK__SERVER						= 0;
	
	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RACK__ID = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RACK__NAME = 2;

	/**
	 * The number of structural features of the '<em>Rack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				RACK_FEATURE_COUNT					= 3;
	
	/**
	 * The number of operations of the '<em>Rack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				RACK_OPERATION_COUNT				= 0;
	
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
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__ID = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__NAME = 6;

	/**
	 * The feature id for the '<em><b>Server</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__SERVER = 7;

	/**
	 * The number of structural features of the '<em>Network</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				NETWORK_FEATURE_COUNT				= 8;
	
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
	int				ROUTER								= 4;
	
	/**
	 * The meta object id for the '{@link model.impl.RoomImpl <em>Room</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.RoomImpl
	 * @see model.impl.ModelPackageImpl#getRoom()
	 * @generated
	 */
	int ROOM = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOM__NAME = 0;

	/**
	 * The feature id for the '<em><b>Racks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOM__RACKS = 1;

	/**
	 * The number of structural features of the '<em>Room</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOM_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Room</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOM_OPERATION_COUNT = 0;

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
	 * The meta object id for the '{@link model.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.ServiceImpl
	 * @see model.impl.ModelPackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 5;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = 0;

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
	int HADOOP_MASTER = 6;

	/**
	 * The feature id for the '<em><b>Slave</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_MASTER__SLAVE = SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Hadoop Master</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_MASTER_FEATURE_COUNT = SERVICE_FEATURE_COUNT + 1;

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
	int HADOOP_SLAVE = 7;

	/**
	 * The feature id for the '<em><b>Master</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_SLAVE__MASTER = SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Hadoop Slave</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_SLAVE_FEATURE_COUNT = SERVICE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Hadoop Slave</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_SLAVE_OPERATION_COUNT = SERVICE_OPERATION_COUNT + 0;



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
	 * Returns the meta object for the attribute '{@link model.Server#getCpuAmount <em>Cpu Amount</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cpu Amount</em>'.
	 * @see model.Server#getCpuAmount()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_CpuAmount();
	
	
	
	/**
	 * Returns the meta object for the attribute '{@link model.Server#getCpuType <em>Cpu Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cpu Type</em>'.
	 * @see model.Server#getCpuType()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_CpuType();
	
	
	
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
	 * Returns the meta object for class '{@link model.Rack <em>Rack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rack</em>'.
	 * @see model.Rack
	 * @generated
	 */
	EClass getRack();
	
	
	
	/**
	 * Returns the meta object for the containment reference list '{@link model.Rack#getServer <em>Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Server</em>'.
	 * @see model.Rack#getServer()
	 * @see #getRack()
	 * @generated
	 */
	EReference getRack_Server();
	
	
	
	/**
	 * Returns the meta object for the attribute '{@link model.Rack#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see model.Rack#getId()
	 * @see #getRack()
	 * @generated
	 */
	EAttribute getRack_Id();



	/**
	 * Returns the meta object for the attribute '{@link model.Rack#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see model.Rack#getName()
	 * @see #getRack()
	 * @generated
	 */
	EAttribute getRack_Name();



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
	 * Returns the meta object for the attribute '{@link model.Network#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see model.Network#getId()
	 * @see #getNetwork()
	 * @generated
	 */
	EAttribute getNetwork_Id();



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
	 * Returns the meta object for class '{@link model.HadoopMaster <em>Hadoop Master</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hadoop Master</em>'.
	 * @see model.HadoopMaster
	 * @generated
	 */
	EClass getHadoopMaster();



	/**
	 * Returns the meta object for the reference list '{@link model.HadoopMaster#getSlave <em>Slave</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Slave</em>'.
	 * @see model.HadoopMaster#getSlave()
	 * @see #getHadoopMaster()
	 * @generated
	 */
	EReference getHadoopMaster_Slave();



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
	 * Returns the meta object for the reference '{@link model.HadoopSlave#getMaster <em>Master</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Master</em>'.
	 * @see model.HadoopSlave#getMaster()
	 * @see #getHadoopSlave()
	 * @generated
	 */
	EReference getHadoopSlave_Master();



	/**
	 * Returns the meta object for class '{@link model.Room <em>Room</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Room</em>'.
	 * @see model.Room
	 * @generated
	 */
	EClass getRoom();



	/**
	 * Returns the meta object for the attribute '{@link model.Room#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see model.Room#getName()
	 * @see #getRoom()
	 * @generated
	 */
	EAttribute getRoom_Name();



	/**
	 * Returns the meta object for the containment reference list '{@link model.Room#getRacks <em>Racks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Racks</em>'.
	 * @see model.Room#getRacks()
	 * @see #getRoom()
	 * @generated
	 */
	EReference getRoom_Racks();



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
		 * The meta object literal for the '<em><b>Cpu Amount</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute	SERVER__CPU_AMOUNT			= eINSTANCE.getServer_CpuAmount();
		
		/**
		 * The meta object literal for the '<em><b>Cpu Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute	SERVER__CPU_TYPE			= eINSTANCE.getServer_CpuType();
		
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
		 * The meta object literal for the '{@link model.impl.RackImpl <em>Rack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.RackImpl
		 * @see model.impl.ModelPackageImpl#getRack()
		 * @generated
		 */
		EClass		RACK						= eINSTANCE.getRack();
		
		/**
		 * The meta object literal for the '<em><b>Server</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference	RACK__SERVER				= eINSTANCE.getRack_Server();
		
		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RACK__ID = eINSTANCE.getRack_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RACK__NAME = eINSTANCE.getRack_Name();

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
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NETWORK__ID = eINSTANCE.getNetwork_Id();

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
		 * The meta object literal for the '{@link model.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.ServiceImpl
		 * @see model.impl.ModelPackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

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
		 * The meta object literal for the '<em><b>Slave</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HADOOP_MASTER__SLAVE = eINSTANCE.getHadoopMaster_Slave();

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
		 * The meta object literal for the '<em><b>Master</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HADOOP_SLAVE__MASTER = eINSTANCE.getHadoopSlave_Master();

		/**
		 * The meta object literal for the '{@link model.impl.RoomImpl <em>Room</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.RoomImpl
		 * @see model.impl.ModelPackageImpl#getRoom()
		 * @generated
		 */
		EClass ROOM = eINSTANCE.getRoom();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROOM__NAME = eINSTANCE.getRoom_Name();

		/**
		 * The meta object literal for the '<em><b>Racks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOM__RACKS = eINSTANCE.getRoom_Racks();
		
	}
	
} //ModelPackage
