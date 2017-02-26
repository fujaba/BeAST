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
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link model.impl.NetworkImpl <em>Network</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.NetworkImpl
	 * @see model.impl.ModelPackageImpl#getNetwork()
	 * @generated
	 */
	int NETWORK = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__NAME = 0;

	/**
	 * The feature id for the '<em><b>Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__SERVICES = 1;

	/**
	 * The number of structural features of the '<em>Network</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Network</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link model.Service <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.Service
	 * @see model.impl.ModelPackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__NETWORK = 1;

	/**
	 * The feature id for the '<em><b>Limit Cpu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__LIMIT_CPU = 2;

	/**
	 * The feature id for the '<em><b>Limit Mem</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__LIMIT_MEM = 3;

	/**
	 * The feature id for the '<em><b>Reservation Cpu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__RESERVATION_CPU = 4;

	/**
	 * The feature id for the '<em><b>Reservation Mem</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__RESERVATION_MEM = 5;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = 6;

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
	int HADOOP_MASTER = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_MASTER__NAME = SERVICE__NAME;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_MASTER__NETWORK = SERVICE__NETWORK;

	/**
	 * The feature id for the '<em><b>Limit Cpu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_MASTER__LIMIT_CPU = SERVICE__LIMIT_CPU;

	/**
	 * The feature id for the '<em><b>Limit Mem</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_MASTER__LIMIT_MEM = SERVICE__LIMIT_MEM;

	/**
	 * The feature id for the '<em><b>Reservation Cpu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_MASTER__RESERVATION_CPU = SERVICE__RESERVATION_CPU;

	/**
	 * The feature id for the '<em><b>Reservation Mem</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_MASTER__RESERVATION_MEM = SERVICE__RESERVATION_MEM;

	/**
	 * The feature id for the '<em><b>Hadoop Slaves</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_MASTER__HADOOP_SLAVES = SERVICE_FEATURE_COUNT + 0;

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
	int HADOOP_SLAVE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_SLAVE__NAME = SERVICE__NAME;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_SLAVE__NETWORK = SERVICE__NETWORK;

	/**
	 * The feature id for the '<em><b>Limit Cpu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_SLAVE__LIMIT_CPU = SERVICE__LIMIT_CPU;

	/**
	 * The feature id for the '<em><b>Limit Mem</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_SLAVE__LIMIT_MEM = SERVICE__LIMIT_MEM;

	/**
	 * The feature id for the '<em><b>Reservation Cpu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_SLAVE__RESERVATION_CPU = SERVICE__RESERVATION_CPU;

	/**
	 * The feature id for the '<em><b>Reservation Mem</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_SLAVE__RESERVATION_MEM = SERVICE__RESERVATION_MEM;

	/**
	 * The feature id for the '<em><b>Hadoop Masters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HADOOP_SLAVE__HADOOP_MASTERS = SERVICE_FEATURE_COUNT + 0;

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
	 * The meta object id for the '{@link model.impl.ControlCenterImpl <em>Control Center</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.ControlCenterImpl
	 * @see model.impl.ModelPackageImpl#getControlCenter()
	 * @generated
	 */
	int CONTROL_CENTER = 4;

	/**
	 * The feature id for the '<em><b>Master Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_CENTER__MASTER_NODES = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_CENTER__NAME = 1;

	/**
	 * The number of structural features of the '<em>Control Center</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_CENTER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Control Center</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_CENTER_OPERATION_COUNT = 0;


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
	 * Returns the meta object for the reference list '{@link model.Network#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Services</em>'.
	 * @see model.Network#getServices()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_Services();

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
	 * Returns the meta object for the reference '{@link model.Service#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see model.Service#getNetwork()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Network();

	/**
	 * Returns the meta object for the attribute '{@link model.Service#getLimitCpu <em>Limit Cpu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Limit Cpu</em>'.
	 * @see model.Service#getLimitCpu()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_LimitCpu();

	/**
	 * Returns the meta object for the attribute '{@link model.Service#getLimitMem <em>Limit Mem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Limit Mem</em>'.
	 * @see model.Service#getLimitMem()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_LimitMem();

	/**
	 * Returns the meta object for the attribute '{@link model.Service#getReservationCpu <em>Reservation Cpu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reservation Cpu</em>'.
	 * @see model.Service#getReservationCpu()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_ReservationCpu();

	/**
	 * Returns the meta object for the attribute '{@link model.Service#getReservationMem <em>Reservation Mem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reservation Mem</em>'.
	 * @see model.Service#getReservationMem()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_ReservationMem();

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
	 * Returns the meta object for the reference list '{@link model.HadoopMaster#getHadoopSlaves <em>Hadoop Slaves</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Hadoop Slaves</em>'.
	 * @see model.HadoopMaster#getHadoopSlaves()
	 * @see #getHadoopMaster()
	 * @generated
	 */
	EReference getHadoopMaster_HadoopSlaves();

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
	 * Returns the meta object for the reference list '{@link model.HadoopSlave#getHadoopMasters <em>Hadoop Masters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Hadoop Masters</em>'.
	 * @see model.HadoopSlave#getHadoopMasters()
	 * @see #getHadoopSlave()
	 * @generated
	 */
	EReference getHadoopSlave_HadoopMasters();

	/**
	 * Returns the meta object for class '{@link model.ControlCenter <em>Control Center</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control Center</em>'.
	 * @see model.ControlCenter
	 * @generated
	 */
	EClass getControlCenter();

	/**
	 * Returns the meta object for the reference list '{@link model.ControlCenter#getMasterNodes <em>Master Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Master Nodes</em>'.
	 * @see model.ControlCenter#getMasterNodes()
	 * @see #getControlCenter()
	 * @generated
	 */
	EReference getControlCenter_MasterNodes();

	/**
	 * Returns the meta object for the attribute '{@link model.ControlCenter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see model.ControlCenter#getName()
	 * @see #getControlCenter()
	 * @generated
	 */
	EAttribute getControlCenter_Name();

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
		 * The meta object literal for the '{@link model.impl.NetworkImpl <em>Network</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.NetworkImpl
		 * @see model.impl.ModelPackageImpl#getNetwork()
		 * @generated
		 */
		EClass NETWORK = eINSTANCE.getNetwork();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NETWORK__NAME = eINSTANCE.getNetwork_Name();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__SERVICES = eINSTANCE.getNetwork_Services();

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
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__NETWORK = eINSTANCE.getService_Network();

		/**
		 * The meta object literal for the '<em><b>Limit Cpu</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__LIMIT_CPU = eINSTANCE.getService_LimitCpu();

		/**
		 * The meta object literal for the '<em><b>Limit Mem</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__LIMIT_MEM = eINSTANCE.getService_LimitMem();

		/**
		 * The meta object literal for the '<em><b>Reservation Cpu</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__RESERVATION_CPU = eINSTANCE.getService_ReservationCpu();

		/**
		 * The meta object literal for the '<em><b>Reservation Mem</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__RESERVATION_MEM = eINSTANCE.getService_ReservationMem();

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
		 * The meta object literal for the '<em><b>Hadoop Slaves</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HADOOP_MASTER__HADOOP_SLAVES = eINSTANCE.getHadoopMaster_HadoopSlaves();

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
		 * The meta object literal for the '<em><b>Hadoop Masters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HADOOP_SLAVE__HADOOP_MASTERS = eINSTANCE.getHadoopSlave_HadoopMasters();

		/**
		 * The meta object literal for the '{@link model.impl.ControlCenterImpl <em>Control Center</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.ControlCenterImpl
		 * @see model.impl.ModelPackageImpl#getControlCenter()
		 * @generated
		 */
		EClass CONTROL_CENTER = eINSTANCE.getControlCenter();

		/**
		 * The meta object literal for the '<em><b>Master Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL_CENTER__MASTER_NODES = eINSTANCE.getControlCenter_MasterNodes();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL_CENTER__NAME = eINSTANCE.getControlCenter_Name();

	}

} //ModelPackage
