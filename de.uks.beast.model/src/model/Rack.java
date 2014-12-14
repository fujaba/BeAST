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
 *   <li>{@link model.Rack#getId <em>Id</em>}</li>
 *   <li>{@link model.Rack#getName <em>Name</em>}</li>
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
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see model.ModelPackage#getRack_Id()
	 * @model
	 * @generated
	 */
	int getId();



	/**
	 * Sets the value of the '{@link model.Rack#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);



	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see model.ModelPackage#getRack_Name()
	 * @model default="0"
	 * @generated
	 */
	String getName();



	/**
	 * Sets the value of the '{@link model.Rack#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);
	
} // Rack
