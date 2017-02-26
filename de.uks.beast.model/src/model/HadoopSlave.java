/**
 */
package model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hadoop Slave</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link model.HadoopSlave#getHadoopMasters <em>Hadoop Masters</em>}</li>
 * </ul>
 *
 * @see model.ModelPackage#getHadoopSlave()
 * @model
 * @generated
 */
public interface HadoopSlave extends Service
{
	/**
	 * Returns the value of the '<em><b>Hadoop Masters</b></em>' reference list.
	 * The list contents are of type {@link model.HadoopMaster}.
	 * It is bidirectional and its opposite is '{@link model.HadoopMaster#getHadoopSlaves <em>Hadoop Slaves</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hadoop Masters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hadoop Masters</em>' reference list.
	 * @see model.ModelPackage#getHadoopSlave_HadoopMasters()
	 * @see model.HadoopMaster#getHadoopSlaves
	 * @model opposite="hadoopSlaves"
	 * @generated
	 */
	EList<HadoopMaster> getHadoopMasters();

} // HadoopSlave
