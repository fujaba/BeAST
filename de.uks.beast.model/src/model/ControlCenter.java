/**
 */
package model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Control Center</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link model.ControlCenter#getMasterNodes <em>Master Nodes</em>}</li>
 *   <li>{@link model.ControlCenter#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see model.ModelPackage#getControlCenter()
 * @model
 * @generated
 */
public interface ControlCenter extends EObject
{
	/**
	 * Returns the value of the '<em><b>Master Nodes</b></em>' reference list.
	 * The list contents are of type {@link model.HadoopMaster}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Master Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Master Nodes</em>' reference list.
	 * @see model.ModelPackage#getControlCenter_MasterNodes()
	 * @model
	 * @generated
	 */
	EList<HadoopMaster> getMasterNodes();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"controlCenter"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see model.ModelPackage#getControlCenter_Name()
	 * @model default="controlCenter" unsettable="true" id="true" changeable="false"
	 * @generated
	 */
	String getName();

	/**
	 * Returns whether the value of the '{@link model.ControlCenter#getName <em>Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Name</em>' attribute is set.
	 * @see #getName()
	 * @generated
	 */
	boolean isSetName();

} // ControlCenter
