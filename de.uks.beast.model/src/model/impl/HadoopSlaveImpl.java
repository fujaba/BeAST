/**
 */
package model.impl;

import java.util.Collection;

import model.HadoopMaster;
import model.HadoopSlave;
import model.ModelPackage;
import model.Network;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hadoop Slave</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link model.impl.HadoopSlaveImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.impl.HadoopSlaveImpl#getNetwork <em>Network</em>}</li>
 *   <li>{@link model.impl.HadoopSlaveImpl#getLimitCpu <em>Limit Cpu</em>}</li>
 *   <li>{@link model.impl.HadoopSlaveImpl#getLimitMem <em>Limit Mem</em>}</li>
 *   <li>{@link model.impl.HadoopSlaveImpl#getReservationCpu <em>Reservation Cpu</em>}</li>
 *   <li>{@link model.impl.HadoopSlaveImpl#getReservationMem <em>Reservation Mem</em>}</li>
 *   <li>{@link model.impl.HadoopSlaveImpl#getHadoopMasters <em>Hadoop Masters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HadoopSlaveImpl extends MinimalEObjectImpl.Container implements HadoopSlave
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "hadoop";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNetwork() <em>Network</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetwork()
	 * @generated
	 * @ordered
	 */
	protected Network network;

	/**
	 * The default value of the '{@link #getLimitCpu() <em>Limit Cpu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLimitCpu()
	 * @generated
	 * @ordered
	 */
	protected static final String LIMIT_CPU_EDEFAULT = "0";

	/**
	 * The cached value of the '{@link #getLimitCpu() <em>Limit Cpu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLimitCpu()
	 * @generated
	 * @ordered
	 */
	protected String limitCpu = LIMIT_CPU_EDEFAULT;

	/**
	 * The default value of the '{@link #getLimitMem() <em>Limit Mem</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLimitMem()
	 * @generated
	 * @ordered
	 */
	protected static final String LIMIT_MEM_EDEFAULT = "0";

	/**
	 * The cached value of the '{@link #getLimitMem() <em>Limit Mem</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLimitMem()
	 * @generated
	 * @ordered
	 */
	protected String limitMem = LIMIT_MEM_EDEFAULT;

	/**
	 * The default value of the '{@link #getReservationCpu() <em>Reservation Cpu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReservationCpu()
	 * @generated
	 * @ordered
	 */
	protected static final String RESERVATION_CPU_EDEFAULT = "0";

	/**
	 * The cached value of the '{@link #getReservationCpu() <em>Reservation Cpu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReservationCpu()
	 * @generated
	 * @ordered
	 */
	protected String reservationCpu = RESERVATION_CPU_EDEFAULT;

	/**
	 * The default value of the '{@link #getReservationMem() <em>Reservation Mem</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReservationMem()
	 * @generated
	 * @ordered
	 */
	protected static final String RESERVATION_MEM_EDEFAULT = "0";

	/**
	 * The cached value of the '{@link #getReservationMem() <em>Reservation Mem</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReservationMem()
	 * @generated
	 * @ordered
	 */
	protected String reservationMem = RESERVATION_MEM_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHadoopMasters() <em>Hadoop Masters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHadoopMasters()
	 * @generated
	 * @ordered
	 */
	protected EList<HadoopMaster> hadoopMasters;

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
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.HADOOP_SLAVE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Network getNetwork()
	{
		if (network != null && network.eIsProxy())
		{
			InternalEObject oldNetwork = (InternalEObject)network;
			network = (Network)eResolveProxy(oldNetwork);
			if (network != oldNetwork)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.HADOOP_SLAVE__NETWORK, oldNetwork, network));
			}
		}
		return network;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Network basicGetNetwork()
	{
		return network;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNetwork(Network newNetwork, NotificationChain msgs)
	{
		Network oldNetwork = network;
		network = newNetwork;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.HADOOP_SLAVE__NETWORK, oldNetwork, newNetwork);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNetwork(Network newNetwork)
	{
		if (newNetwork != network)
		{
			NotificationChain msgs = null;
			if (network != null)
				msgs = ((InternalEObject)network).eInverseRemove(this, ModelPackage.NETWORK__SERVICES, Network.class, msgs);
			if (newNetwork != null)
				msgs = ((InternalEObject)newNetwork).eInverseAdd(this, ModelPackage.NETWORK__SERVICES, Network.class, msgs);
			msgs = basicSetNetwork(newNetwork, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.HADOOP_SLAVE__NETWORK, newNetwork, newNetwork));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLimitCpu()
	{
		return limitCpu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLimitCpu(String newLimitCpu)
	{
		String oldLimitCpu = limitCpu;
		limitCpu = newLimitCpu;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.HADOOP_SLAVE__LIMIT_CPU, oldLimitCpu, limitCpu));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLimitMem()
	{
		return limitMem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLimitMem(String newLimitMem)
	{
		String oldLimitMem = limitMem;
		limitMem = newLimitMem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.HADOOP_SLAVE__LIMIT_MEM, oldLimitMem, limitMem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReservationCpu()
	{
		return reservationCpu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReservationCpu(String newReservationCpu)
	{
		String oldReservationCpu = reservationCpu;
		reservationCpu = newReservationCpu;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.HADOOP_SLAVE__RESERVATION_CPU, oldReservationCpu, reservationCpu));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReservationMem()
	{
		return reservationMem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReservationMem(String newReservationMem)
	{
		String oldReservationMem = reservationMem;
		reservationMem = newReservationMem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.HADOOP_SLAVE__RESERVATION_MEM, oldReservationMem, reservationMem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HadoopMaster> getHadoopMasters()
	{
		if (hadoopMasters == null)
		{
			hadoopMasters = new EObjectWithInverseResolvingEList.ManyInverse<HadoopMaster>(HadoopMaster.class, this, ModelPackage.HADOOP_SLAVE__HADOOP_MASTERS, ModelPackage.HADOOP_MASTER__HADOOP_SLAVES);
		}
		return hadoopMasters;
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
			case ModelPackage.HADOOP_SLAVE__NETWORK:
				if (network != null)
					msgs = ((InternalEObject)network).eInverseRemove(this, ModelPackage.NETWORK__SERVICES, Network.class, msgs);
				return basicSetNetwork((Network)otherEnd, msgs);
			case ModelPackage.HADOOP_SLAVE__HADOOP_MASTERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getHadoopMasters()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.HADOOP_SLAVE__NETWORK:
				return basicSetNetwork(null, msgs);
			case ModelPackage.HADOOP_SLAVE__HADOOP_MASTERS:
				return ((InternalEList<?>)getHadoopMasters()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.HADOOP_SLAVE__NAME:
				return getName();
			case ModelPackage.HADOOP_SLAVE__NETWORK:
				if (resolve) return getNetwork();
				return basicGetNetwork();
			case ModelPackage.HADOOP_SLAVE__LIMIT_CPU:
				return getLimitCpu();
			case ModelPackage.HADOOP_SLAVE__LIMIT_MEM:
				return getLimitMem();
			case ModelPackage.HADOOP_SLAVE__RESERVATION_CPU:
				return getReservationCpu();
			case ModelPackage.HADOOP_SLAVE__RESERVATION_MEM:
				return getReservationMem();
			case ModelPackage.HADOOP_SLAVE__HADOOP_MASTERS:
				return getHadoopMasters();
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
			case ModelPackage.HADOOP_SLAVE__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.HADOOP_SLAVE__NETWORK:
				setNetwork((Network)newValue);
				return;
			case ModelPackage.HADOOP_SLAVE__LIMIT_CPU:
				setLimitCpu((String)newValue);
				return;
			case ModelPackage.HADOOP_SLAVE__LIMIT_MEM:
				setLimitMem((String)newValue);
				return;
			case ModelPackage.HADOOP_SLAVE__RESERVATION_CPU:
				setReservationCpu((String)newValue);
				return;
			case ModelPackage.HADOOP_SLAVE__RESERVATION_MEM:
				setReservationMem((String)newValue);
				return;
			case ModelPackage.HADOOP_SLAVE__HADOOP_MASTERS:
				getHadoopMasters().clear();
				getHadoopMasters().addAll((Collection<? extends HadoopMaster>)newValue);
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
			case ModelPackage.HADOOP_SLAVE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.HADOOP_SLAVE__NETWORK:
				setNetwork((Network)null);
				return;
			case ModelPackage.HADOOP_SLAVE__LIMIT_CPU:
				setLimitCpu(LIMIT_CPU_EDEFAULT);
				return;
			case ModelPackage.HADOOP_SLAVE__LIMIT_MEM:
				setLimitMem(LIMIT_MEM_EDEFAULT);
				return;
			case ModelPackage.HADOOP_SLAVE__RESERVATION_CPU:
				setReservationCpu(RESERVATION_CPU_EDEFAULT);
				return;
			case ModelPackage.HADOOP_SLAVE__RESERVATION_MEM:
				setReservationMem(RESERVATION_MEM_EDEFAULT);
				return;
			case ModelPackage.HADOOP_SLAVE__HADOOP_MASTERS:
				getHadoopMasters().clear();
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
			case ModelPackage.HADOOP_SLAVE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.HADOOP_SLAVE__NETWORK:
				return network != null;
			case ModelPackage.HADOOP_SLAVE__LIMIT_CPU:
				return LIMIT_CPU_EDEFAULT == null ? limitCpu != null : !LIMIT_CPU_EDEFAULT.equals(limitCpu);
			case ModelPackage.HADOOP_SLAVE__LIMIT_MEM:
				return LIMIT_MEM_EDEFAULT == null ? limitMem != null : !LIMIT_MEM_EDEFAULT.equals(limitMem);
			case ModelPackage.HADOOP_SLAVE__RESERVATION_CPU:
				return RESERVATION_CPU_EDEFAULT == null ? reservationCpu != null : !RESERVATION_CPU_EDEFAULT.equals(reservationCpu);
			case ModelPackage.HADOOP_SLAVE__RESERVATION_MEM:
				return RESERVATION_MEM_EDEFAULT == null ? reservationMem != null : !RESERVATION_MEM_EDEFAULT.equals(reservationMem);
			case ModelPackage.HADOOP_SLAVE__HADOOP_MASTERS:
				return hadoopMasters != null && !hadoopMasters.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", limitCpu: ");
		result.append(limitCpu);
		result.append(", limitMem: ");
		result.append(limitMem);
		result.append(", reservationCpu: ");
		result.append(reservationCpu);
		result.append(", reservationMem: ");
		result.append(reservationMem);
		result.append(')');
		return result.toString();
	}

} //HadoopSlaveImpl
