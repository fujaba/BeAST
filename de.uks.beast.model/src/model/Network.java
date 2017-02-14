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
 *   <li>{@link model.Network#getIp <em>Ip</em>}</li>
 *   <li>{@link model.Network#getSubnetmask <em>Subnetmask</em>}</li>
 *   <li>{@link model.Network#getGateway <em>Gateway</em>}</li>
 *   <li>{@link model.Network#getDns <em>Dns</em>}</li>
 *   <li>{@link model.Network#getName <em>Name</em>}</li>
 *   <li>{@link model.Network#getServices <em>Services</em>}</li>
 * </ul>
 *
 * @see model.ModelPackage#getNetwork()
 * @model
 * @generated
 */
public interface Network extends EObject
{
	/**
	 * Returns the value of the '<em><b>Ip</b></em>' attribute.
	 * The default value is <code>"0.0.0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ip</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ip</em>' attribute.
	 * @see #setIp(String)
	 * @see model.ModelPackage#getNetwork_Ip()
	 * @model default="0.0.0.0"
	 * @generated
	 */
	String getIp();

	/**
	 * Sets the value of the '{@link model.Network#getIp <em>Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ip</em>' attribute.
	 * @see #getIp()
	 * @generated
	 */
	void setIp(String value);

	/**
	 * Returns the value of the '<em><b>Subnetmask</b></em>' attribute.
	 * The default value is <code>"0.0.0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subnetmask</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subnetmask</em>' attribute.
	 * @see #setSubnetmask(String)
	 * @see model.ModelPackage#getNetwork_Subnetmask()
	 * @model default="0.0.0.0"
	 * @generated
	 */
	String getSubnetmask();

	/**
	 * Sets the value of the '{@link model.Network#getSubnetmask <em>Subnetmask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subnetmask</em>' attribute.
	 * @see #getSubnetmask()
	 * @generated
	 */
	void setSubnetmask(String value);

	/**
	 * Returns the value of the '<em><b>Gateway</b></em>' attribute.
	 * The default value is <code>"0.0.0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gateway</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gateway</em>' attribute.
	 * @see #setGateway(String)
	 * @see model.ModelPackage#getNetwork_Gateway()
	 * @model default="0.0.0.0"
	 * @generated
	 */
	String getGateway();

	/**
	 * Sets the value of the '{@link model.Network#getGateway <em>Gateway</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gateway</em>' attribute.
	 * @see #getGateway()
	 * @generated
	 */
	void setGateway(String value);

	/**
	 * Returns the value of the '<em><b>Dns</b></em>' attribute.
	 * The default value is <code>"0.0.0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dns</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dns</em>' attribute.
	 * @see #setDns(String)
	 * @see model.ModelPackage#getNetwork_Dns()
	 * @model default="0.0.0.0"
	 * @generated
	 */
	String getDns();

	/**
	 * Sets the value of the '{@link model.Network#getDns <em>Dns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dns</em>' attribute.
	 * @see #getDns()
	 * @generated
	 */
	void setDns(String value);

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

} // Network
