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
 * </p>
 * <ul>
 *   <li>{@link model.HadoopMaster#getHadoopSlaves <em>Hadoop Slaves</em>}</li>
 * </ul>
 *
 * @see model.ModelPackage#getHadoopMaster()
 * @model
 * @generated
 */
public interface HadoopMaster extends Service
{
	/**
	 * Returns the value of the '<em><b>Hadoop Slaves</b></em>' reference list.
	 * The list contents are of type {@link model.HadoopSlave}.
	 * It is bidirectional and its opposite is '{@link model.HadoopSlave#getHadoopMasters <em>Hadoop Masters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hadoop Slaves</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hadoop Slaves</em>' reference list.
	 * @see model.ModelPackage#getHadoopMaster_HadoopSlaves()
	 * @see model.HadoopSlave#getHadoopMasters
	 * @model opposite="hadoopMasters"
	 * @generated
	 */
	EList<HadoopSlave> getHadoopSlaves();

} // HadoopMaster
