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
 *   <li>{@link model.HadoopSlave#getHadoopMaster <em>Hadoop Master</em>}</li>
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
	 * Returns the value of the '<em><b>Hadoop Master</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link model.HadoopMaster#getHadoopSlave <em>Hadoop Slave</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hadoop Master</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hadoop Master</em>' reference.
	 * @see #setHadoopMaster(HadoopMaster)
	 * @see model.ModelPackage#getHadoopSlave_HadoopMaster()
	 * @see model.HadoopMaster#getHadoopSlave
	 * @model opposite="hadoopSlave"
	 * @generated
	 */
	HadoopMaster getHadoopMaster();

	/**
	 * Sets the value of the '{@link model.HadoopSlave#getHadoopMaster <em>Hadoop Master</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hadoop Master</em>' reference.
	 * @see #getHadoopMaster()
	 * @generated
	 */
	void setHadoopMaster(HadoopMaster value);
} // HadoopSlave
