/**
 */
package model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Network</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link model.Network#getName <em>Name</em>}</li>
 *   <li>{@link model.Network#getServices <em>Services</em>}</li>
 *   <li>{@link model.Network#getAtribute_0 <em>Atribute 0</em>}</li>
 *   <li>{@link model.Network#getAtribute_1 <em>Atribute 1</em>}</li>
 * </ul>
 *
 * @see model.ModelPackage#getNetwork()
 * @model
 * @generated
 */
public interface Network extends EObject
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"network"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see model.ModelPackage#getNetwork_Name()
	 * @model default="network" id="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link model.Network#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Services</b></em>' reference list.
	 * The list contents are of type {@link model.Service}.
	 * It is bidirectional and its opposite is '{@link model.Service#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Services</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Services</em>' reference list.
	 * @see model.ModelPackage#getNetwork_Services()
	 * @see model.Service#getNetwork
	 * @model opposite="network"
	 * @generated
	 */
	EList<Service> getServices();

	/**
	 * Returns the value of the '<em><b>Atribute 0</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atribute 0</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atribute 0</em>' attribute.
	 * @see #setAtribute_0(String)
	 * @see model.ModelPackage#getNetwork_Atribute_0()
	 * @model default="0"
	 * @generated
	 */
	String getAtribute_0();

	/**
	 * Sets the value of the '{@link model.Network#getAtribute_0 <em>Atribute 0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atribute 0</em>' attribute.
	 * @see #getAtribute_0()
	 * @generated
	 */
	void setAtribute_0(String value);

	/**
	 * Returns the value of the '<em><b>Atribute 1</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atribute 1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atribute 1</em>' attribute.
	 * @see #setAtribute_1(String)
	 * @see model.ModelPackage#getNetwork_Atribute_1()
	 * @model default="0"
	 * @generated
	 */
	String getAtribute_1();

	/**
	 * Sets the value of the '{@link model.Network#getAtribute_1 <em>Atribute 1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atribute 1</em>' attribute.
	 * @see #getAtribute_1()
	 * @generated
	 */
	void setAtribute_1(String value);

} // Network
