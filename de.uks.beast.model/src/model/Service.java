/**
 */
package model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link model.Service#getName <em>Name</em>}</li>
 *   <li>{@link model.Service#getNetwork <em>Network</em>}</li>
 *   <li>{@link model.Service#getLimitCpu <em>Limit Cpu</em>}</li>
 *   <li>{@link model.Service#getLimitMem <em>Limit Mem</em>}</li>
 *   <li>{@link model.Service#getReservationCpu <em>Reservation Cpu</em>}</li>
 *   <li>{@link model.Service#getReservationMem <em>Reservation Mem</em>}</li>
 * </ul>
 *
 * @see model.ModelPackage#getService()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Service extends EObject
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"service"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see model.ModelPackage#getService_Name()
	 * @model default="service" id="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link model.Service#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Network</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link model.Network#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Network</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Network</em>' reference.
	 * @see #setNetwork(Network)
	 * @see model.ModelPackage#getService_Network()
	 * @see model.Network#getServices
	 * @model opposite="services"
	 * @generated
	 */
	Network getNetwork();

	/**
	 * Sets the value of the '{@link model.Service#getNetwork <em>Network</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Network</em>' reference.
	 * @see #getNetwork()
	 * @generated
	 */
	void setNetwork(Network value);

	/**
	 * Returns the value of the '<em><b>Limit Cpu</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Limit Cpu</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Limit Cpu</em>' attribute.
	 * @see #setLimitCpu(String)
	 * @see model.ModelPackage#getService_LimitCpu()
	 * @model default="0"
	 * @generated
	 */
	String getLimitCpu();

	/**
	 * Sets the value of the '{@link model.Service#getLimitCpu <em>Limit Cpu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Limit Cpu</em>' attribute.
	 * @see #getLimitCpu()
	 * @generated
	 */
	void setLimitCpu(String value);

	/**
	 * Returns the value of the '<em><b>Limit Mem</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Limit Mem</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Limit Mem</em>' attribute.
	 * @see #setLimitMem(String)
	 * @see model.ModelPackage#getService_LimitMem()
	 * @model default="0"
	 * @generated
	 */
	String getLimitMem();

	/**
	 * Sets the value of the '{@link model.Service#getLimitMem <em>Limit Mem</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Limit Mem</em>' attribute.
	 * @see #getLimitMem()
	 * @generated
	 */
	void setLimitMem(String value);

	/**
	 * Returns the value of the '<em><b>Reservation Cpu</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reservation Cpu</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reservation Cpu</em>' attribute.
	 * @see #setReservationCpu(String)
	 * @see model.ModelPackage#getService_ReservationCpu()
	 * @model default="0"
	 * @generated
	 */
	String getReservationCpu();

	/**
	 * Sets the value of the '{@link model.Service#getReservationCpu <em>Reservation Cpu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reservation Cpu</em>' attribute.
	 * @see #getReservationCpu()
	 * @generated
	 */
	void setReservationCpu(String value);

	/**
	 * Returns the value of the '<em><b>Reservation Mem</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reservation Mem</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reservation Mem</em>' attribute.
	 * @see #setReservationMem(String)
	 * @see model.ModelPackage#getService_ReservationMem()
	 * @model default="0"
	 * @generated
	 */
	String getReservationMem();

	/**
	 * Sets the value of the '{@link model.Service#getReservationMem <em>Reservation Mem</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reservation Mem</em>' attribute.
	 * @see #getReservationMem()
	 * @generated
	 */
	void setReservationMem(String value);

} // Service
