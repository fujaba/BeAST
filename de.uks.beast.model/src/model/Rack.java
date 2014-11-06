/**
 */
package model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rack</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.Rack#getServer <em>Server</em>}</li>
 *   <li>{@link model.Rack#getRouter <em>Router</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getRack()
 * @model
 * @generated
 */
public interface Rack extends EObject
{
	/**
	 * Returns the value of the '<em><b>Server</b></em>' containment reference list.
	 * The list contents are of type {@link model.Server}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server</em>' containment reference list.
	 * @see model.ModelPackage#getRack_Server()
	 * @model containment="true"
	 * @generated
	 */
	EList<Server> getServer();
	
	
	
	/**
	 * Returns the value of the '<em><b>Router</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Router</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Router</em>' reference.
	 * @see #setRouter(RoutingComponent)
	 * @see model.ModelPackage#getRack_Router()
	 * @model
	 * @generated
	 */
	RoutingComponent getRouter();
	
	
	
	/**
	 * Sets the value of the '{@link model.Rack#getRouter <em>Router</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Router</em>' reference.
	 * @see #getRouter()
	 * @generated
	 */
	void setRouter(RoutingComponent value);
	
} // Rack
