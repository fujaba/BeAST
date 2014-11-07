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
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				SERVER__HOST						= 5;
	
	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__TYPE = 6;

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
	 * The feature id for the '<em><b>Router</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				RACK__ROUTER						= 1;
	
	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RACK__ID = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RACK__TYPE = 3;

	/**
	 * The number of structural features of the '<em>Rack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				RACK_FEATURE_COUNT					= 4;
	
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
	 * The feature id for the '<em><b>Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				NETWORK__RANGE						= 0;
	
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
	 * The feature id for the '<em><b>Router</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				NETWORK__ROUTER						= 4;
	
	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__TYPE = 5;

	/**
	 * The number of structural features of the '<em>Network</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				NETWORK_FEATURE_COUNT				= 6;
	
	/**
	 * The number of operations of the '<em>Network</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				NETWORK_OPERATION_COUNT				= 0;
	
	/**
	 * The meta object id for the '{@link model.impl.RoutingComponentImpl <em>Routing Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.RoutingComponentImpl
	 * @see model.impl.ModelPackageImpl#getRoutingComponent()
	 * @generated
	 */
	int				ROUTING_COMPONENT					= 4;
	
	/**
	 * The feature id for the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				ROUTING_COMPONENT__IP				= 0;
	
	/**
	 * The feature id for the '<em><b>Gateway</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				ROUTING_COMPONENT__GATEWAY			= 1;
	
	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				ROUTING_COMPONENT__NETWORK			= 2;
	
	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTING_COMPONENT__TYPE = 3;

	/**
	 * The number of structural features of the '<em>Routing Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				ROUTING_COMPONENT_FEATURE_COUNT		= 4;
	
	/**
	 * The number of operations of the '<em>Routing Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				ROUTING_COMPONENT_OPERATION_COUNT	= 0;
	
	/**
	 * The meta object id for the '{@link model.impl.SwitchImpl <em>Switch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.SwitchImpl
	 * @see model.impl.ModelPackageImpl#getSwitch()
	 * @generated
	 */
	int				SWITCH								= 3;
	
	/**
	 * The feature id for the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				SWITCH__IP							= ROUTING_COMPONENT__IP;
	
	/**
	 * The feature id for the '<em><b>Gateway</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				SWITCH__GATEWAY						= ROUTING_COMPONENT__GATEWAY;
	
	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				SWITCH__NETWORK						= ROUTING_COMPONENT__NETWORK;
	
	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__TYPE = ROUTING_COMPONENT__TYPE;

	/**
	 * The number of structural features of the '<em>Switch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				SWITCH_FEATURE_COUNT				= ROUTING_COMPONENT_FEATURE_COUNT + 0;
	
	/**
	 * The number of operations of the '<em>Switch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				SWITCH_OPERATION_COUNT				= ROUTING_COMPONENT_OPERATION_COUNT + 0;
	
	/**
	 * The meta object id for the '{@link model.impl.RouterImpl <em>Router</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.RouterImpl
	 * @see model.impl.ModelPackageImpl#getRouter()
	 * @generated
	 */
	int				ROUTER								= 5;
	
	/**
	 * The feature id for the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				ROUTER__IP							= ROUTING_COMPONENT__IP;
	
	/**
	 * The feature id for the '<em><b>Gateway</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				ROUTER__GATEWAY						= ROUTING_COMPONENT__GATEWAY;
	
	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				ROUTER__NETWORK						= ROUTING_COMPONENT__NETWORK;
	
	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER__TYPE = ROUTING_COMPONENT__TYPE;

	/**
	 * The number of structural features of the '<em>Router</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				ROUTER_FEATURE_COUNT				= ROUTING_COMPONENT_FEATURE_COUNT + 0;
	
	/**
	 * The number of operations of the '<em>Router</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int				ROUTER_OPERATION_COUNT				= ROUTING_COMPONENT_OPERATION_COUNT + 0;
	
	
	
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
	 * Returns the meta object for the attribute '{@link model.Server#getHost <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Host</em>'.
	 * @see model.Server#getHost()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_Host();
	
	
	
	/**
	 * Returns the meta object for the attribute '{@link model.Server#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see model.Server#getType()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_Type();



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
	 * Returns the meta object for the reference '{@link model.Rack#getRouter <em>Router</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Router</em>'.
	 * @see model.Rack#getRouter()
	 * @see #getRack()
	 * @generated
	 */
	EReference getRack_Router();
	
	
	
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
	 * Returns the meta object for the attribute '{@link model.Rack#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see model.Rack#getType()
	 * @see #getRack()
	 * @generated
	 */
	EAttribute getRack_Type();



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
	 * Returns the meta object for the attribute '{@link model.Network#getRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Range</em>'.
	 * @see model.Network#getRange()
	 * @see #getNetwork()
	 * @generated
	 */
	EAttribute getNetwork_Range();
	
	
	
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
	 * Returns the meta object for the reference '{@link model.Network#getRouter <em>Router</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Router</em>'.
	 * @see model.Network#getRouter()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_Router();
	
	
	
	/**
	 * Returns the meta object for the attribute '{@link model.Network#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see model.Network#getType()
	 * @see #getNetwork()
	 * @generated
	 */
	EAttribute getNetwork_Type();



	/**
	 * Returns the meta object for class '{@link model.Switch <em>Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch</em>'.
	 * @see model.Switch
	 * @generated
	 */
	EClass getSwitch();
	
	
	
	/**
	 * Returns the meta object for class '{@link model.RoutingComponent <em>Routing Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Routing Component</em>'.
	 * @see model.RoutingComponent
	 * @generated
	 */
	EClass getRoutingComponent();
	
	
	
	/**
	 * Returns the meta object for the attribute '{@link model.RoutingComponent#getIp <em>Ip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ip</em>'.
	 * @see model.RoutingComponent#getIp()
	 * @see #getRoutingComponent()
	 * @generated
	 */
	EAttribute getRoutingComponent_Ip();
	
	
	
	/**
	 * Returns the meta object for the attribute '{@link model.RoutingComponent#getGateway <em>Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gateway</em>'.
	 * @see model.RoutingComponent#getGateway()
	 * @see #getRoutingComponent()
	 * @generated
	 */
	EAttribute getRoutingComponent_Gateway();
	
	
	
	/**
	 * Returns the meta object for the reference '{@link model.RoutingComponent#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see model.RoutingComponent#getNetwork()
	 * @see #getRoutingComponent()
	 * @generated
	 */
	EReference getRoutingComponent_Network();
	
	
	
	/**
	 * Returns the meta object for the attribute '{@link model.RoutingComponent#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see model.RoutingComponent#getType()
	 * @see #getRoutingComponent()
	 * @generated
	 */
	EAttribute getRoutingComponent_Type();



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
		 * The meta object literal for the '<em><b>Host</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute	SERVER__HOST				= eINSTANCE.getServer_Host();
		
		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__TYPE = eINSTANCE.getServer_Type();

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
		 * The meta object literal for the '<em><b>Router</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference	RACK__ROUTER				= eINSTANCE.getRack_Router();
		
		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RACK__ID = eINSTANCE.getRack_Id();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RACK__TYPE = eINSTANCE.getRack_Type();

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
		 * The meta object literal for the '<em><b>Range</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute	NETWORK__RANGE				= eINSTANCE.getNetwork_Range();
		
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
		 * The meta object literal for the '<em><b>Router</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference	NETWORK__ROUTER				= eINSTANCE.getNetwork_Router();
		
		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NETWORK__TYPE = eINSTANCE.getNetwork_Type();

		/**
		 * The meta object literal for the '{@link model.impl.SwitchImpl <em>Switch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.SwitchImpl
		 * @see model.impl.ModelPackageImpl#getSwitch()
		 * @generated
		 */
		EClass		SWITCH						= eINSTANCE.getSwitch();
		
		/**
		 * The meta object literal for the '{@link model.impl.RoutingComponentImpl <em>Routing Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.RoutingComponentImpl
		 * @see model.impl.ModelPackageImpl#getRoutingComponent()
		 * @generated
		 */
		EClass		ROUTING_COMPONENT			= eINSTANCE.getRoutingComponent();
		
		/**
		 * The meta object literal for the '<em><b>Ip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute	ROUTING_COMPONENT__IP		= eINSTANCE.getRoutingComponent_Ip();
		
		/**
		 * The meta object literal for the '<em><b>Gateway</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute	ROUTING_COMPONENT__GATEWAY	= eINSTANCE.getRoutingComponent_Gateway();
		
		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference	ROUTING_COMPONENT__NETWORK	= eINSTANCE.getRoutingComponent_Network();
		
		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUTING_COMPONENT__TYPE = eINSTANCE.getRoutingComponent_Type();

		/**
		 * The meta object literal for the '{@link model.impl.RouterImpl <em>Router</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.RouterImpl
		 * @see model.impl.ModelPackageImpl#getRouter()
		 * @generated
		 */
		EClass		ROUTER						= eINSTANCE.getRouter();
		
	}
	
} //ModelPackage
