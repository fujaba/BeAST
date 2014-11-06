/**
 */
package model.impl;

import model.ModelFactory;
import model.ModelPackage;
import model.Network;
import model.Rack;
import model.Router;
import model.RoutingComponent;
import model.Server;
import model.Switch;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelPackageImpl extends EPackageImpl implements ModelPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass	serverEClass			= null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass	rackEClass				= null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass	networkEClass			= null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass	switchEClass			= null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass	routingComponentEClass	= null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass	routerEClass			= null;
	
	
	
	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see model.ModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelPackageImpl()
	{
		super(eNS_URI, ModelFactory.eINSTANCE);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean	isInited	= false;
	
	
	
	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModelPackage init()
	{
		if (isInited)
			return (ModelPackage) EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);
		
		// Obtain or create and register package
		ModelPackageImpl theModelPackage = (ModelPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new ModelPackageImpl());
		
		isInited = true;
		
		// Create package meta-data objects
		theModelPackage.createPackageContents();
		
		// Initialize created meta-data
		theModelPackage.initializePackageContents();
		
		// Mark meta-data to indicate it can't be changed
		theModelPackage.freeze();
		
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, theModelPackage);
		return theModelPackage;
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServer()
	{
		return serverEClass;
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_Ip()
	{
		return (EAttribute) serverEClass.getEStructuralFeatures().get(0);
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_CpuAmount()
	{
		return (EAttribute) serverEClass.getEStructuralFeatures().get(1);
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_CpuType()
	{
		return (EAttribute) serverEClass.getEStructuralFeatures().get(2);
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_Ram()
	{
		return (EAttribute) serverEClass.getEStructuralFeatures().get(3);
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_DiskSpace()
	{
		return (EAttribute) serverEClass.getEStructuralFeatures().get(4);
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_Host()
	{
		return (EAttribute) serverEClass.getEStructuralFeatures().get(5);
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRack()
	{
		return rackEClass;
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRack_Server()
	{
		return (EReference) rackEClass.getEStructuralFeatures().get(0);
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRack_Router()
	{
		return (EReference) rackEClass.getEStructuralFeatures().get(1);
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNetwork()
	{
		return networkEClass;
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNetwork_Range()
	{
		return (EAttribute) networkEClass.getEStructuralFeatures().get(0);
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNetwork_Subnetmask()
	{
		return (EAttribute) networkEClass.getEStructuralFeatures().get(1);
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNetwork_Gateway()
	{
		return (EAttribute) networkEClass.getEStructuralFeatures().get(2);
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNetwork_Dns()
	{
		return (EAttribute) networkEClass.getEStructuralFeatures().get(3);
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNetwork_Router()
	{
		return (EReference) networkEClass.getEStructuralFeatures().get(4);
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitch()
	{
		return switchEClass;
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoutingComponent()
	{
		return routingComponentEClass;
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoutingComponent_Ip()
	{
		return (EAttribute) routingComponentEClass.getEStructuralFeatures().get(0);
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoutingComponent_Gateway()
	{
		return (EAttribute) routingComponentEClass.getEStructuralFeatures().get(1);
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoutingComponent_Network()
	{
		return (EReference) routingComponentEClass.getEStructuralFeatures().get(2);
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRouter()
	{
		return routerEClass;
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactory getModelFactory()
	{
		return (ModelFactory) getEFactoryInstance();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean	isCreated	= false;
	
	
	
	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents()
	{
		if (isCreated)
			return;
		isCreated = true;
		
		// Create classes and their features
		serverEClass = createEClass(SERVER);
		createEAttribute(serverEClass, SERVER__IP);
		createEAttribute(serverEClass, SERVER__CPU_AMOUNT);
		createEAttribute(serverEClass, SERVER__CPU_TYPE);
		createEAttribute(serverEClass, SERVER__RAM);
		createEAttribute(serverEClass, SERVER__DISK_SPACE);
		createEAttribute(serverEClass, SERVER__HOST);
		
		rackEClass = createEClass(RACK);
		createEReference(rackEClass, RACK__SERVER);
		createEReference(rackEClass, RACK__ROUTER);
		
		networkEClass = createEClass(NETWORK);
		createEAttribute(networkEClass, NETWORK__RANGE);
		createEAttribute(networkEClass, NETWORK__SUBNETMASK);
		createEAttribute(networkEClass, NETWORK__GATEWAY);
		createEAttribute(networkEClass, NETWORK__DNS);
		createEReference(networkEClass, NETWORK__ROUTER);
		
		switchEClass = createEClass(SWITCH);
		
		routingComponentEClass = createEClass(ROUTING_COMPONENT);
		createEAttribute(routingComponentEClass, ROUTING_COMPONENT__IP);
		createEAttribute(routingComponentEClass, ROUTING_COMPONENT__GATEWAY);
		createEReference(routingComponentEClass, ROUTING_COMPONENT__NETWORK);
		
		routerEClass = createEClass(ROUTER);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean	isInitialized	= false;
	
	
	
	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents()
	{
		if (isInitialized)
			return;
		isInitialized = true;
		
		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);
		
		// Create type parameters
		
		// Set bounds for type parameters
		
		// Add supertypes to classes
		switchEClass.getESuperTypes().add(this.getRoutingComponent());
		routerEClass.getESuperTypes().add(this.getRoutingComponent());
		
		// Initialize classes, features, and operations; add parameters
		initEClass(serverEClass, Server.class, "Server", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServer_Ip(), ecorePackage.getEString(), "ip", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServer_CpuAmount(), ecorePackage.getEInt(), "cpuAmount", null, 0, 1, Server.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServer_CpuType(), ecorePackage.getEString(), "cpuType", null, 0, 1, Server.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServer_Ram(), ecorePackage.getELong(), "ram", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServer_DiskSpace(), ecorePackage.getELong(), "diskSpace", null, 0, 1, Server.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServer_Host(), ecorePackage.getEString(), "host", null, 0, 1, Server.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		
		initEClass(rackEClass, Rack.class, "Rack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRack_Server(), this.getServer(), null, "server", null, 0, -1, Rack.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRack_Router(), this.getRoutingComponent(), null, "router", null, 0, 1, Rack.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		
		initEClass(networkEClass, Network.class, "Network", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNetwork_Range(), ecorePackage.getEString(), "range", null, 0, 1, Network.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNetwork_Subnetmask(), ecorePackage.getEString(), "subnetmask", null, 0, 1, Network.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNetwork_Gateway(), ecorePackage.getEString(), "gateway", null, 0, 1, Network.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNetwork_Dns(), ecorePackage.getEString(), "dns", null, 0, 1, Network.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNetwork_Router(), this.getRoutingComponent(), this.getRoutingComponent_Network(), "router", null, 0, 1,
				Network.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		
		initEClass(switchEClass, Switch.class, "Switch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		
		initEClass(routingComponentEClass, RoutingComponent.class, "RoutingComponent", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRoutingComponent_Ip(), ecorePackage.getEString(), "ip", null, 0, 1, RoutingComponent.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoutingComponent_Gateway(), ecorePackage.getEString(), "gateway", null, 0, 1, RoutingComponent.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoutingComponent_Network(), this.getNetwork(), this.getNetwork_Router(), "network", null, 0, 1,
				RoutingComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		
		initEClass(routerEClass, Router.class, "Router", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		
		// Create resource
		createResource(eNS_URI);
	}
	
} //ModelPackageImpl
