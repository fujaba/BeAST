/**
 */
package model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Room</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.Room#getName <em>Name</em>}</li>
 *   <li>{@link model.Room#getRacks <em>Racks</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getRoom()
 * @model
 * @generated
 */
public interface Room extends EObject
{
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
	 * @see model.ModelPackage#getRoom_Name()
	 * @model default="0"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link model.Room#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Racks</b></em>' containment reference list.
	 * The list contents are of type {@link model.Rack}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Racks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Racks</em>' containment reference list.
	 * @see model.ModelPackage#getRoom_Racks()
	 * @model containment="true"
	 * @generated
	 */
	EList<Rack> getRacks();

} // Room
