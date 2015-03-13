/**
 */
package model.impl;

import model.Apache2;
import model.Cassandra;
import model.Group;
import model.HadoopMaster;
import model.HadoopSlave;
import model.Jenkins;
import model.MediaWiki;
import model.ModelFactory;
import model.ModelPackage;
import model.MongoDB;
import model.MySQL;
import model.Network;
import model.Router;
import model.Server;
import model.Service;
import model.Tomcat;
import model.Ubuntu;
import model.WordPress;
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
	private EClass groupEClass = null;

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
	private EClass	routerEClass			= null;
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hadoopMasterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hadoopSlaveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mySQLEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wordPressEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cassandraEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mongoDBEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ubuntuEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass apache2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jenkinsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mediaWikiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tomcatEClass = null;

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
		if (isInited) return (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Obtain or create and register package
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModelPackageImpl());

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
		return (EAttribute)serverEClass.getEStructuralFeatures().get(0);
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_CpuCores()
	{
		return (EAttribute)serverEClass.getEStructuralFeatures().get(1);
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_Ram()
	{
		return (EAttribute)serverEClass.getEStructuralFeatures().get(2);
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_DiskSpace()
	{
		return (EAttribute)serverEClass.getEStructuralFeatures().get(3);
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_Name()
	{
		return (EAttribute)serverEClass.getEStructuralFeatures().get(4);
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServer_Network() {
		return (EReference)serverEClass.getEStructuralFeatures().get(5);
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServer_Service()
	{
		return (EReference)serverEClass.getEStructuralFeatures().get(6);
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGroup()
	{
		return groupEClass;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGroup_Server()
	{
		return (EReference)groupEClass.getEStructuralFeatures().get(0);
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroup_Id()
	{
		return (EAttribute)groupEClass.getEStructuralFeatures().get(1);
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroup_Name()
	{
		return (EAttribute)groupEClass.getEStructuralFeatures().get(2);
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGroup_Group()
	{
		return (EReference)groupEClass.getEStructuralFeatures().get(3);
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
	public EAttribute getNetwork_Ip() {
		return (EAttribute)networkEClass.getEStructuralFeatures().get(0);
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNetwork_Subnetmask()
	{
		return (EAttribute)networkEClass.getEStructuralFeatures().get(1);
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNetwork_Gateway()
	{
		return (EAttribute)networkEClass.getEStructuralFeatures().get(2);
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNetwork_Dns()
	{
		return (EAttribute)networkEClass.getEStructuralFeatures().get(3);
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNetwork_Server() {
		return (EReference)networkEClass.getEStructuralFeatures().get(6);
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNetwork_Router() {
		return (EReference)networkEClass.getEStructuralFeatures().get(4);
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNetwork_Name() {
		return (EAttribute)networkEClass.getEStructuralFeatures().get(5);
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
	public EReference getRouter_Network() {
		return (EReference)routerEClass.getEStructuralFeatures().get(0);
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRouter_Id() {
		return (EAttribute)routerEClass.getEStructuralFeatures().get(1);
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRouter_Ip() {
		return (EAttribute)routerEClass.getEStructuralFeatures().get(2);
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRouter_Name() {
		return (EAttribute)routerEClass.getEStructuralFeatures().get(3);
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRouter_ExternalGateway() {
		return (EAttribute)routerEClass.getEStructuralFeatures().get(4);
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getService()
	{
		return serviceEClass;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Name()
	{
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(0);
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_Relations()
	{
		return (EReference)serviceEClass.getEStructuralFeatures().get(3);
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_ServiceName()
	{
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(2);
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_ServiceType()
	{
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(1);
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHadoopMaster()
	{
		return hadoopMasterEClass;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHadoopSlave()
	{
		return hadoopSlaveEClass;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMySQL()
	{
		return mySQLEClass;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWordPress()
	{
		return wordPressEClass;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCassandra()
	{
		return cassandraEClass;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMongoDB()
	{
		return mongoDBEClass;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUbuntu()
	{
		return ubuntuEClass;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApache2()
	{
		return apache2EClass;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJenkins()
	{
		return jenkinsEClass;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMediaWiki()
	{
		return mediaWikiEClass;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTomcat()
	{
		return tomcatEClass;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactory getModelFactory()
	{
		return (ModelFactory)getEFactoryInstance();
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
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		serverEClass = createEClass(SERVER);
		createEAttribute(serverEClass, SERVER__IP);
		createEAttribute(serverEClass, SERVER__CPU_CORES);
		createEAttribute(serverEClass, SERVER__RAM);
		createEAttribute(serverEClass, SERVER__DISK_SPACE);
		createEAttribute(serverEClass, SERVER__NAME);
		createEReference(serverEClass, SERVER__NETWORK);
		createEReference(serverEClass, SERVER__SERVICE);

		groupEClass = createEClass(GROUP);
		createEReference(groupEClass, GROUP__SERVER);
		createEAttribute(groupEClass, GROUP__ID);
		createEAttribute(groupEClass, GROUP__NAME);
		createEReference(groupEClass, GROUP__GROUP);

		networkEClass = createEClass(NETWORK);
		createEAttribute(networkEClass, NETWORK__IP);
		createEAttribute(networkEClass, NETWORK__SUBNETMASK);
		createEAttribute(networkEClass, NETWORK__GATEWAY);
		createEAttribute(networkEClass, NETWORK__DNS);
		createEReference(networkEClass, NETWORK__ROUTER);
		createEAttribute(networkEClass, NETWORK__NAME);
		createEReference(networkEClass, NETWORK__SERVER);

		routerEClass = createEClass(ROUTER);
		createEReference(routerEClass, ROUTER__NETWORK);
		createEAttribute(routerEClass, ROUTER__ID);
		createEAttribute(routerEClass, ROUTER__IP);
		createEAttribute(routerEClass, ROUTER__NAME);
		createEAttribute(routerEClass, ROUTER__EXTERNAL_GATEWAY);

		serviceEClass = createEClass(SERVICE);
		createEAttribute(serviceEClass, SERVICE__NAME);
		createEAttribute(serviceEClass, SERVICE__SERVICE_TYPE);
		createEAttribute(serviceEClass, SERVICE__SERVICE_NAME);
		createEReference(serviceEClass, SERVICE__RELATIONS);

		hadoopMasterEClass = createEClass(HADOOP_MASTER);

		hadoopSlaveEClass = createEClass(HADOOP_SLAVE);

		mySQLEClass = createEClass(MY_SQL);

		wordPressEClass = createEClass(WORD_PRESS);

		cassandraEClass = createEClass(CASSANDRA);

		mongoDBEClass = createEClass(MONGO_DB);

		ubuntuEClass = createEClass(UBUNTU);

		apache2EClass = createEClass(APACHE2);

		jenkinsEClass = createEClass(JENKINS);

		mediaWikiEClass = createEClass(MEDIA_WIKI);

		tomcatEClass = createEClass(TOMCAT);
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
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		hadoopMasterEClass.getESuperTypes().add(this.getService());
		hadoopSlaveEClass.getESuperTypes().add(this.getService());
		mySQLEClass.getESuperTypes().add(this.getService());
		wordPressEClass.getESuperTypes().add(this.getService());
		cassandraEClass.getESuperTypes().add(this.getService());
		mongoDBEClass.getESuperTypes().add(this.getService());
		ubuntuEClass.getESuperTypes().add(this.getService());
		apache2EClass.getESuperTypes().add(this.getService());
		jenkinsEClass.getESuperTypes().add(this.getService());
		mediaWikiEClass.getESuperTypes().add(this.getService());
		tomcatEClass.getESuperTypes().add(this.getService());

		// Initialize classes, features, and operations; add parameters
		initEClass(serverEClass, Server.class, "Server", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServer_Ip(), ecorePackage.getEString(), "ip", "0", 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServer_CpuCores(), ecorePackage.getEInt(), "cpuCores", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServer_Ram(), ecorePackage.getEInt(), "ram", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServer_DiskSpace(), ecorePackage.getEInt(), "diskSpace", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServer_Name(), ecorePackage.getEString(), "name", "0", 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServer_Network(), this.getNetwork(), this.getNetwork_Server(), "Network", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServer_Service(), this.getService(), null, "Service", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(groupEClass, Group.class, "Group", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGroup_Server(), this.getServer(), null, "Server", null, 0, -1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGroup_Id(), ecorePackage.getEInt(), "id", null, 0, 1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGroup_Name(), ecorePackage.getEString(), "name", "0", 0, 1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGroup_Group(), this.getGroup(), null, "Group", null, 0, -1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(networkEClass, Network.class, "Network", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNetwork_Ip(), ecorePackage.getEString(), "ip", "0", 0, 1, Network.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNetwork_Subnetmask(), ecorePackage.getEString(), "subnetmask", "0", 0, 1, Network.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNetwork_Gateway(), ecorePackage.getEString(), "gateway", "0", 0, 1, Network.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNetwork_Dns(), ecorePackage.getEString(), "dns", "0", 0, 1, Network.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNetwork_Router(), this.getRouter(), this.getRouter_Network(), "Router", null, 1, -1, Network.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNetwork_Name(), ecorePackage.getEString(), "name", "0", 0, 1, Network.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNetwork_Server(), this.getServer(), this.getServer_Network(), "Server", null, 0, -1, Network.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(routerEClass, Router.class, "Router", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRouter_Network(), this.getNetwork(), this.getNetwork_Router(), "Network", null, 1, -1, Router.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRouter_Id(), ecorePackage.getEString(), "id", "0", 0, 1, Router.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRouter_Ip(), ecorePackage.getEString(), "ip", "0", 0, 1, Router.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRouter_Name(), ecorePackage.getEString(), "name", "0", 0, 1, Router.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRouter_ExternalGateway(), ecorePackage.getEString(), "externalGateway", "0", 0, 1, Router.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceEClass, Service.class, "Service", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getService_Name(), ecorePackage.getEString(), "name", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_ServiceType(), ecorePackage.getEString(), "serviceType", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_ServiceName(), ecorePackage.getEString(), "serviceName", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getService_Relations(), this.getService(), null, "relations", null, 0, -1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hadoopMasterEClass, HadoopMaster.class, "HadoopMaster", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(hadoopSlaveEClass, HadoopSlave.class, "HadoopSlave", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mySQLEClass, MySQL.class, "MySQL", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(wordPressEClass, WordPress.class, "WordPress", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cassandraEClass, Cassandra.class, "Cassandra", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mongoDBEClass, MongoDB.class, "MongoDB", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ubuntuEClass, Ubuntu.class, "Ubuntu", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(apache2EClass, Apache2.class, "Apache2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jenkinsEClass, Jenkins.class, "Jenkins", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mediaWikiEClass, MediaWiki.class, "MediaWiki", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tomcatEClass, Tomcat.class, "Tomcat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}
	
} //ModelPackageImpl
