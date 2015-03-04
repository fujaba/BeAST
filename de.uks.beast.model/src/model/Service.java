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
 * <ul>
 *   <li>{@link model.Service#getServiceName <em>Service Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getService()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Service extends EObject
{

	/**
	 * Returns the value of the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Name</em>' attribute.
	 * @see #setServiceName(String)
	 * @see model.ModelPackage#getService_ServiceName()
	 * @model
	 * @generated
	 */
	String getServiceName();

	/**
	 * Sets the value of the '{@link model.Service#getServiceName <em>Service Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Name</em>' attribute.
	 * @see #getServiceName()
	 * @generated
	 */
	void setServiceName(String value);
} // Service
