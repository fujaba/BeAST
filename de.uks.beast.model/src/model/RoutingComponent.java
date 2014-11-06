/**
 */
package model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Routing Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.RoutingComponent#getIp <em>Ip</em>}</li>
 *   <li>{@link model.RoutingComponent#getGateway <em>Gateway</em>}</li>
 *   <li>{@link model.RoutingComponent#getNetwork <em>Network</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getRoutingComponent()
 * @model
 * @generated
 */
public interface RoutingComponent extends EObject
{
	/**
	 * Returns the value of the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ip</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ip</em>' attribute.
	 * @see #setIp(String)
	 * @see model.ModelPackage#getRoutingComponent_Ip()
	 * @model
	 * @generated
	 */
	String getIp();
	
	
	
	/**
	 * Sets the value of the '{@link model.RoutingComponent#getIp <em>Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ip</em>' attribute.
	 * @see #getIp()
	 * @generated
	 */
	void setIp(String value);
	
	
	
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
	 * @see model.ModelPackage#getRoutingComponent_Gateway()
	 * @model
	 * @generated
	 */
	String getGateway();
	
	
	
	/**
	 * Sets the value of the '{@link model.RoutingComponent#getGateway <em>Gateway</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gateway</em>' attribute.
	 * @see #getGateway()
	 * @generated
	 */
	void setGateway(String value);
	
	
	
	/**
	 * Returns the value of the '<em><b>Network</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link model.Network#getRouter <em>Router</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Network</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Network</em>' reference.
	 * @see #setNetwork(Network)
	 * @see model.ModelPackage#getRoutingComponent_Network()
	 * @see model.Network#getRouter
	 * @model opposite="router"
	 * @generated
	 */
	Network getNetwork();
	
	
	
	/**
	 * Sets the value of the '{@link model.RoutingComponent#getNetwork <em>Network</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Network</em>' reference.
	 * @see #getNetwork()
	 * @generated
	 */
	void setNetwork(Network value);
	
} // RoutingComponent
