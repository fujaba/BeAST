/**
 */
package model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Network</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.Network#getRange <em>Range</em>}</li>
 *   <li>{@link model.Network#getSubnetmask <em>Subnetmask</em>}</li>
 *   <li>{@link model.Network#getGateway <em>Gateway</em>}</li>
 *   <li>{@link model.Network#getDns <em>Dns</em>}</li>
 *   <li>{@link model.Network#getRouter <em>Router</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getNetwork()
 * @model
 * @generated
 */
public interface Network extends EObject
{
	/**
	 * Returns the value of the '<em><b>Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Range</em>' attribute.
	 * @see #setRange(String)
	 * @see model.ModelPackage#getNetwork_Range()
	 * @model
	 * @generated
	 */
	String getRange();
	
	
	
	/**
	 * Sets the value of the '{@link model.Network#getRange <em>Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range</em>' attribute.
	 * @see #getRange()
	 * @generated
	 */
	void setRange(String value);
	
	
	
	/**
	 * Returns the value of the '<em><b>Subnetmask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subnetmask</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subnetmask</em>' attribute.
	 * @see #setSubnetmask(String)
	 * @see model.ModelPackage#getNetwork_Subnetmask()
	 * @model
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
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gateway</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gateway</em>' attribute.
	 * @see #setGateway(String)
	 * @see model.ModelPackage#getNetwork_Gateway()
	 * @model
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
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dns</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dns</em>' attribute.
	 * @see #setDns(String)
	 * @see model.ModelPackage#getNetwork_Dns()
	 * @model
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
	 * Returns the value of the '<em><b>Router</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link model.RoutingComponent#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Router</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Router</em>' reference.
	 * @see #setRouter(RoutingComponent)
	 * @see model.ModelPackage#getNetwork_Router()
	 * @see model.RoutingComponent#getNetwork
	 * @model opposite="network"
	 * @generated
	 */
	RoutingComponent getRouter();
	
	
	
	/**
	 * Sets the value of the '{@link model.Network#getRouter <em>Router</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Router</em>' reference.
	 * @see #getRouter()
	 * @generated
	 */
	void setRouter(RoutingComponent value);
	
} // Network
