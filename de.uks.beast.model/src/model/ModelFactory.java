/**
 */
package model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see model.ModelPackage
 * @generated
 */
public interface ModelFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelFactory	eINSTANCE	= model.impl.ModelFactoryImpl.init();
	
	
	
	/**
	 * Returns a new object of class '<em>Server</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Server</em>'.
	 * @generated
	 */
	Server createServer();
	
	
	
	/**
	 * Returns a new object of class '<em>Rack</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rack</em>'.
	 * @generated
	 */
	Rack createRack();
	
	
	
	/**
	 * Returns a new object of class '<em>Network</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Network</em>'.
	 * @generated
	 */
	Network createNetwork();
	
	
	
	/**
	 * Returns a new object of class '<em>Router</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Router</em>'.
	 * @generated
	 */
	Router createRouter();
	
	
	
	/**
	 * Returns a new object of class '<em>Hadoop Master</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hadoop Master</em>'.
	 * @generated
	 */
	HadoopMaster createHadoopMaster();



	/**
	 * Returns a new object of class '<em>Hadoop Slave</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hadoop Slave</em>'.
	 * @generated
	 */
	HadoopSlave createHadoopSlave();



	/**
	 * Returns a new object of class '<em>Room</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Room</em>'.
	 * @generated
	 */
	Room createRoom();



	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelPackage getModelPackage();
	
} //ModelFactory
