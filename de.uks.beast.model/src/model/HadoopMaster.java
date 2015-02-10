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
 *   <li>{@link model.HadoopMaster#getSlave <em>Slave</em>}</li>
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
	 * Returns the value of the '<em><b>Slave</b></em>' reference list.
	 * The list contents are of type {@link model.HadoopSlave}.
	 * It is bidirectional and its opposite is '{@link model.HadoopSlave#getMaster <em>Master</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slave</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slave</em>' reference list.
	 * @see model.ModelPackage#getHadoopMaster_Slave()
	 * @see model.HadoopSlave#getMaster
	 * @model opposite="master"
	 * @generated
	 */
	EList<HadoopSlave> getSlave();
} // HadoopMaster
