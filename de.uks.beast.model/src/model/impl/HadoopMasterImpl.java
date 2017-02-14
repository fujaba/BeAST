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
 * An implementation of the model object '<em><b>Hadoop Master</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link model.impl.HadoopMasterImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.impl.HadoopMasterImpl#getAtribute_0 <em>Atribute 0</em>}</li>
 *   <li>{@link model.impl.HadoopMasterImpl#getAtribute_1 <em>Atribute 1</em>}</li>
 *   <li>{@link model.impl.HadoopMasterImpl#getNetwork <em>Network</em>}</li>
 *   <li>{@link model.impl.HadoopMasterImpl#getHadoopSlaves <em>Hadoop Slaves</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HadoopMasterImpl extends MinimalEObjectImpl.Container implements HadoopMaster
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "service";

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
	 * The default value of the '{@link #getAtribute_0() <em>Atribute 0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtribute_0()
	 * @generated
	 * @ordered
	 */
	protected static final String ATRIBUTE_0_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAtribute_0() <em>Atribute 0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtribute_0()
	 * @generated
	 * @ordered
	 */
	protected String atribute_0 = ATRIBUTE_0_EDEFAULT;

	/**
	 * The default value of the '{@link #getAtribute_1() <em>Atribute 1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtribute_1()
	 * @generated
	 * @ordered
	 */
	protected static final String ATRIBUTE_1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAtribute_1() <em>Atribute 1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtribute_1()
	 * @generated
	 * @ordered
	 */
	protected String atribute_1 = ATRIBUTE_1_EDEFAULT;

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
	 * The cached value of the '{@link #getHadoopSlaves() <em>Hadoop Slaves</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHadoopSlaves()
	 * @generated
	 * @ordered
	 */
	protected EList<HadoopSlave> hadoopSlaves;

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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.HADOOP_MASTER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAtribute_0()
	{
		return atribute_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAtribute_0(String newAtribute_0)
	{
		String oldAtribute_0 = atribute_0;
		atribute_0 = newAtribute_0;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.HADOOP_MASTER__ATRIBUTE_0, oldAtribute_0, atribute_0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAtribute_1()
	{
		return atribute_1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAtribute_1(String newAtribute_1)
	{
		String oldAtribute_1 = atribute_1;
		atribute_1 = newAtribute_1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.HADOOP_MASTER__ATRIBUTE_1, oldAtribute_1, atribute_1));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.HADOOP_MASTER__NETWORK, oldNetwork, network));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.HADOOP_MASTER__NETWORK, oldNetwork, newNetwork);
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.HADOOP_MASTER__NETWORK, newNetwork, newNetwork));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HadoopSlave> getHadoopSlaves()
	{
		if (hadoopSlaves == null)
		{
			hadoopSlaves = new EObjectWithInverseResolvingEList<HadoopSlave>(HadoopSlave.class, this, ModelPackage.HADOOP_MASTER__HADOOP_SLAVES, ModelPackage.HADOOP_SLAVE__HADOOP_MASTER);
		}
		return hadoopSlaves;
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
			case ModelPackage.HADOOP_MASTER__NETWORK:
				if (network != null)
					msgs = ((InternalEObject)network).eInverseRemove(this, ModelPackage.NETWORK__SERVICES, Network.class, msgs);
				return basicSetNetwork((Network)otherEnd, msgs);
			case ModelPackage.HADOOP_MASTER__HADOOP_SLAVES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getHadoopSlaves()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.HADOOP_MASTER__NETWORK:
				return basicSetNetwork(null, msgs);
			case ModelPackage.HADOOP_MASTER__HADOOP_SLAVES:
				return ((InternalEList<?>)getHadoopSlaves()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.HADOOP_MASTER__NAME:
				return getName();
			case ModelPackage.HADOOP_MASTER__ATRIBUTE_0:
				return getAtribute_0();
			case ModelPackage.HADOOP_MASTER__ATRIBUTE_1:
				return getAtribute_1();
			case ModelPackage.HADOOP_MASTER__NETWORK:
				if (resolve) return getNetwork();
				return basicGetNetwork();
			case ModelPackage.HADOOP_MASTER__HADOOP_SLAVES:
				return getHadoopSlaves();
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
			case ModelPackage.HADOOP_MASTER__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.HADOOP_MASTER__ATRIBUTE_0:
				setAtribute_0((String)newValue);
				return;
			case ModelPackage.HADOOP_MASTER__ATRIBUTE_1:
				setAtribute_1((String)newValue);
				return;
			case ModelPackage.HADOOP_MASTER__NETWORK:
				setNetwork((Network)newValue);
				return;
			case ModelPackage.HADOOP_MASTER__HADOOP_SLAVES:
				getHadoopSlaves().clear();
				getHadoopSlaves().addAll((Collection<? extends HadoopSlave>)newValue);
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
			case ModelPackage.HADOOP_MASTER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.HADOOP_MASTER__ATRIBUTE_0:
				setAtribute_0(ATRIBUTE_0_EDEFAULT);
				return;
			case ModelPackage.HADOOP_MASTER__ATRIBUTE_1:
				setAtribute_1(ATRIBUTE_1_EDEFAULT);
				return;
			case ModelPackage.HADOOP_MASTER__NETWORK:
				setNetwork((Network)null);
				return;
			case ModelPackage.HADOOP_MASTER__HADOOP_SLAVES:
				getHadoopSlaves().clear();
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
			case ModelPackage.HADOOP_MASTER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.HADOOP_MASTER__ATRIBUTE_0:
				return ATRIBUTE_0_EDEFAULT == null ? atribute_0 != null : !ATRIBUTE_0_EDEFAULT.equals(atribute_0);
			case ModelPackage.HADOOP_MASTER__ATRIBUTE_1:
				return ATRIBUTE_1_EDEFAULT == null ? atribute_1 != null : !ATRIBUTE_1_EDEFAULT.equals(atribute_1);
			case ModelPackage.HADOOP_MASTER__NETWORK:
				return network != null;
			case ModelPackage.HADOOP_MASTER__HADOOP_SLAVES:
				return hadoopSlaves != null && !hadoopSlaves.isEmpty();
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
		result.append(", atribute_0: ");
		result.append(atribute_0);
		result.append(", atribute_1: ");
		result.append(atribute_1);
		result.append(')');
		return result.toString();
	}

} //HadoopMasterImpl
