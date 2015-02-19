/**
 */
package model.impl;

import java.util.Collection;
import model.HadoopMaster;
import model.HadoopSlave;
import model.ModelPackage;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hadoop Master</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.HadoopMasterImpl#getHadoopSlave <em>Hadoop Slave</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HadoopMasterImpl extends ServiceImpl implements HadoopMaster
{
	/**
	 * The cached value of the '{@link #getHadoopSlave() <em>Hadoop Slave</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHadoopSlave()
	 * @generated
	 * @ordered
	 */
	protected EList<HadoopSlave> hadoopSlave;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HadoopMasterImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return ModelPackage.Literals.HADOOP_MASTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HadoopSlave> getHadoopSlave()
	{
		if (hadoopSlave == null)
		{
			hadoopSlave = new EObjectWithInverseResolvingEList<HadoopSlave>(HadoopSlave.class, this, ModelPackage.HADOOP_MASTER__HADOOP_SLAVE, ModelPackage.HADOOP_SLAVE__HADOOP_MASTER);
		}
		return hadoopSlave;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ModelPackage.HADOOP_MASTER__HADOOP_SLAVE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getHadoopSlave()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ModelPackage.HADOOP_MASTER__HADOOP_SLAVE:
				return ((InternalEList<?>)getHadoopSlave()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case ModelPackage.HADOOP_MASTER__HADOOP_SLAVE:
				return getHadoopSlave();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ModelPackage.HADOOP_MASTER__HADOOP_SLAVE:
				getHadoopSlave().clear();
				getHadoopSlave().addAll((Collection<? extends HadoopSlave>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case ModelPackage.HADOOP_MASTER__HADOOP_SLAVE:
				getHadoopSlave().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case ModelPackage.HADOOP_MASTER__HADOOP_SLAVE:
				return hadoopSlave != null && !hadoopSlave.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //HadoopMasterImpl
