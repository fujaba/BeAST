/**
 */
package model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.Service#getName <em>Name</em>}</li>
 *   <li>{@link model.Service#getServiceType <em>Service Type</em>}</li>
 *   <li>{@link model.Service#getServiceName <em>Service Name</em>}</li>
 *   <li>{@link model.Service#getRelations <em>Relations</em>}</li>
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
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see model.ModelPackage#getService_Name()
	 * @model
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
	 * Returns the value of the '<em><b>Relations</b></em>' reference list.
	 * The list contents are of type {@link model.Service}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relations</em>' reference list.
	 * @see model.ModelPackage#getService_Relations()
	 * @model
	 * @generated
	 */
	EList<Service> getRelations();

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

	/**
	 * Returns the value of the '<em><b>Service Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Type</em>' attribute.
	 * @see #setServiceType(String)
	 * @see model.ModelPackage#getService_ServiceType()
	 * @model
	 * @generated
	 */
	String getServiceType();

	/**
	 * Sets the value of the '{@link model.Service#getServiceType <em>Service Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Type</em>' attribute.
	 * @see #getServiceType()
	 * @generated
	 */
	void setServiceType(String value);
} // Service
