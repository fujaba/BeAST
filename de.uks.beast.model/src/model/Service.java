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
 *   <li>{@link model.Service#getAtribute_0 <em>Atribute 0</em>}</li>
 *   <li>{@link model.Service#getAtribute_1 <em>Atribute 1</em>}</li>
 *   <li>{@link model.Service#getNetwork <em>Network</em>}</li>
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
	 * Returns the value of the '<em><b>Atribute 0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atribute 0</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atribute 0</em>' attribute.
	 * @see #setAtribute_0(String)
	 * @see model.ModelPackage#getService_Atribute_0()
	 * @model
	 * @generated
	 */
	String getAtribute_0();

	/**
	 * Sets the value of the '{@link model.Service#getAtribute_0 <em>Atribute 0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atribute 0</em>' attribute.
	 * @see #getAtribute_0()
	 * @generated
	 */
	void setAtribute_0(String value);

	/**
	 * Returns the value of the '<em><b>Atribute 1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atribute 1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atribute 1</em>' attribute.
	 * @see #setAtribute_1(String)
	 * @see model.ModelPackage#getService_Atribute_1()
	 * @model
	 * @generated
	 */
	String getAtribute_1();

	/**
	 * Sets the value of the '{@link model.Service#getAtribute_1 <em>Atribute 1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atribute 1</em>' attribute.
	 * @see #getAtribute_1()
	 * @generated
	 */
	void setAtribute_1(String value);

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

} // Service
