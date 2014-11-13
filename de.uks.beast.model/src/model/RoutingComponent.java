/**
 */
package model;

import org.eclipse.emf.common.util.EList;
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
 *   <li>{@link model.RoutingComponent#getType <em>Type</em>}</li>
 *   <li>{@link model.RoutingComponent#getServer <em>Server</em>}</li>
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



	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see model.ModelPackage#getRoutingComponent_Type()
	 * @model
	 * @generated
	 */
	String getType();



	/**
	 * Sets the value of the '{@link model.RoutingComponent#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);



	/**
	 * Returns the value of the '<em><b>Server</b></em>' reference list.
	 * The list contents are of type {@link model.Server}.
	 * It is bidirectional and its opposite is '{@link model.Server#getRoutingComponents <em>Routing Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server</em>' reference list.
	 * @see model.ModelPackage#getRoutingComponent_Server()
	 * @see model.Server#getRoutingComponents
	 * @model opposite="routingComponents"
	 * @generated
	 */
	EList<Server> getServer();
	
} // RoutingComponent
