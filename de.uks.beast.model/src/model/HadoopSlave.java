/**
 */
package model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hadoop Slave</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.HadoopSlave#getMaster <em>Master</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getHadoopSlave()
 * @model
 * @generated
 */
public interface HadoopSlave extends Service
{

	/**
	 * Returns the value of the '<em><b>Master</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link model.HadoopMaster#getSlave <em>Slave</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Master</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Master</em>' reference.
	 * @see #setMaster(HadoopMaster)
	 * @see model.ModelPackage#getHadoopSlave_Master()
	 * @see model.HadoopMaster#getSlave
	 * @model opposite="slave"
	 * @generated
	 */
	HadoopMaster getMaster();

	/**
	 * Sets the value of the '{@link model.HadoopSlave#getMaster <em>Master</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Master</em>' reference.
	 * @see #getMaster()
	 * @generated
	 */
	void setMaster(HadoopMaster value);
} // HadoopSlave
