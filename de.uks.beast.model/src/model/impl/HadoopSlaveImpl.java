/**
 */
package model.impl;

import model.HadoopMaster;
import model.HadoopSlave;
import model.ModelPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hadoop Slave</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.HadoopSlaveImpl#getServiceName <em>Service Name</em>}</li>
 *   <li>{@link model.impl.HadoopSlaveImpl#getHadoopMaster <em>Hadoop Master</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HadoopSlaveImpl extends MinimalEObjectImpl.Container implements HadoopSlave
{
	/**
	 * The default value of the '{@link #getServiceName() <em>Service Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceName()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVICE_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getServiceName() <em>Service Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceName()
	 * @generated
	 * @ordered
	 */
	protected String serviceName = SERVICE_NAME_EDEFAULT;
	/**
	 * The cached value of the '{@link #getHadoopMaster() <em>Hadoop Master</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHadoopMaster()
	 * @generated
	 * @ordered
	 */
	protected HadoopMaster hadoopMaster;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HadoopSlaveImpl()
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
		return ModelPackage.Literals.HADOOP_SLAVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceName(String newServiceName) {
		String oldServiceName = serviceName;
		serviceName = newServiceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.HADOOP_SLAVE__SERVICE_NAME, oldServiceName, serviceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HadoopMaster getHadoopMaster()
	{
		if (hadoopMaster != null && hadoopMaster.eIsProxy()) {
			InternalEObject oldHadoopMaster = (InternalEObject)hadoopMaster;
			hadoopMaster = (HadoopMaster)eResolveProxy(oldHadoopMaster);
			if (hadoopMaster != oldHadoopMaster) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.HADOOP_SLAVE__HADOOP_MASTER, oldHadoopMaster, hadoopMaster));
			}
		}
		return hadoopMaster;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HadoopMaster basicGetHadoopMaster()
	{
		return hadoopMaster;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHadoopMaster(HadoopMaster newHadoopMaster, NotificationChain msgs)
	{
		HadoopMaster oldHadoopMaster = hadoopMaster;
		hadoopMaster = newHadoopMaster;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.HADOOP_SLAVE__HADOOP_MASTER, oldHadoopMaster, newHadoopMaster);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHadoopMaster(HadoopMaster newHadoopMaster)
	{
		if (newHadoopMaster != hadoopMaster) {
			NotificationChain msgs = null;
			if (hadoopMaster != null)
				msgs = ((InternalEObject)hadoopMaster).eInverseRemove(this, ModelPackage.HADOOP_MASTER__HADOOP_SLAVE, HadoopMaster.class, msgs);
			if (newHadoopMaster != null)
				msgs = ((InternalEObject)newHadoopMaster).eInverseAdd(this, ModelPackage.HADOOP_MASTER__HADOOP_SLAVE, HadoopMaster.class, msgs);
			msgs = basicSetHadoopMaster(newHadoopMaster, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.HADOOP_SLAVE__HADOOP_MASTER, newHadoopMaster, newHadoopMaster));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID) {
			case ModelPackage.HADOOP_SLAVE__HADOOP_MASTER:
				if (hadoopMaster != null)
					msgs = ((InternalEObject)hadoopMaster).eInverseRemove(this, ModelPackage.HADOOP_MASTER__HADOOP_SLAVE, HadoopMaster.class, msgs);
				return basicSetHadoopMaster((HadoopMaster)otherEnd, msgs);
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
		switch (featureID) {
			case ModelPackage.HADOOP_SLAVE__HADOOP_MASTER:
				return basicSetHadoopMaster(null, msgs);
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
		switch (featureID) {
			case ModelPackage.HADOOP_SLAVE__SERVICE_NAME:
				return getServiceName();
			case ModelPackage.HADOOP_SLAVE__HADOOP_MASTER:
				if (resolve) return getHadoopMaster();
				return basicGetHadoopMaster();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID) {
			case ModelPackage.HADOOP_SLAVE__SERVICE_NAME:
				setServiceName((String)newValue);
				return;
			case ModelPackage.HADOOP_SLAVE__HADOOP_MASTER:
				setHadoopMaster((HadoopMaster)newValue);
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
		switch (featureID) {
			case ModelPackage.HADOOP_SLAVE__SERVICE_NAME:
				setServiceName(SERVICE_NAME_EDEFAULT);
				return;
			case ModelPackage.HADOOP_SLAVE__HADOOP_MASTER:
				setHadoopMaster((HadoopMaster)null);
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
		switch (featureID) {
			case ModelPackage.HADOOP_SLAVE__SERVICE_NAME:
				return SERVICE_NAME_EDEFAULT == null ? serviceName != null : !SERVICE_NAME_EDEFAULT.equals(serviceName);
			case ModelPackage.HADOOP_SLAVE__HADOOP_MASTER:
				return hadoopMaster != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (serviceName: ");
		result.append(serviceName);
		result.append(')');
		return result.toString();
	}

} //HadoopSlaveImpl
