/**
 */
package model;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hadoop Master</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.HadoopMaster#getHadoopSlave <em>Hadoop Slave</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getHadoopMaster()
 * @model
 * @generated
 */
public interface HadoopMaster extends Service
{

	/**
	 * Returns the value of the '<em><b>Hadoop Slave</b></em>' reference list.
	 * The list contents are of type {@link model.HadoopSlave}.
	 * It is bidirectional and its opposite is '{@link model.HadoopSlave#getHadoopMaster <em>Hadoop Master</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hadoop Slave</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hadoop Slave</em>' reference list.
	 * @see model.ModelPackage#getHadoopMaster_HadoopSlave()
	 * @see model.HadoopSlave#getHadoopMaster
	 * @model opposite="hadoopMaster"
	 * @generated
	 */
	EList<HadoopSlave> getHadoopSlave();
} // HadoopMaster
