/**
 */
package model.impl;

import java.util.Collection;

import model.ModelPackage;
import model.Network;
import model.Service;

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
 * An implementation of the model object '<em><b>Network</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link model.impl.NetworkImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.impl.NetworkImpl#getServices <em>Services</em>}</li>
 *   <li>{@link model.impl.NetworkImpl#getAtribute_0 <em>Atribute 0</em>}</li>
 *   <li>{@link model.impl.NetworkImpl#getAtribute_1 <em>Atribute 1</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NetworkImpl extends MinimalEObjectImpl.Container implements Network
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "network";

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
	 * The cached value of the '{@link #getServices() <em>Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServices()
	 * @generated
	 * @ordered
	 */
	protected EList<Service> services;

	/**
	 * The default value of the '{@link #getAtribute_0() <em>Atribute 0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtribute_0()
	 * @generated
	 * @ordered
	 */
	protected static final String ATRIBUTE_0_EDEFAULT = "0";

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
	protected static final String ATRIBUTE_1_EDEFAULT = "0";

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NetworkImpl()
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
		return ModelPackage.Literals.NETWORK;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.NETWORK__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Service> getServices()
	{
		if (services == null)
		{
			services = new EObjectWithInverseResolvingEList<Service>(Service.class, this, ModelPackage.NETWORK__SERVICES, ModelPackage.SERVICE__NETWORK);
		}
		return services;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.NETWORK__ATRIBUTE_0, oldAtribute_0, atribute_0));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.NETWORK__ATRIBUTE_1, oldAtribute_1, atribute_1));
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
			case ModelPackage.NETWORK__SERVICES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getServices()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.NETWORK__SERVICES:
				return ((InternalEList<?>)getServices()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.NETWORK__NAME:
				return getName();
			case ModelPackage.NETWORK__SERVICES:
				return getServices();
			case ModelPackage.NETWORK__ATRIBUTE_0:
				return getAtribute_0();
			case ModelPackage.NETWORK__ATRIBUTE_1:
				return getAtribute_1();
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
			case ModelPackage.NETWORK__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.NETWORK__SERVICES:
				getServices().clear();
				getServices().addAll((Collection<? extends Service>)newValue);
				return;
			case ModelPackage.NETWORK__ATRIBUTE_0:
				setAtribute_0((String)newValue);
				return;
			case ModelPackage.NETWORK__ATRIBUTE_1:
				setAtribute_1((String)newValue);
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
			case ModelPackage.NETWORK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.NETWORK__SERVICES:
				getServices().clear();
				return;
			case ModelPackage.NETWORK__ATRIBUTE_0:
				setAtribute_0(ATRIBUTE_0_EDEFAULT);
				return;
			case ModelPackage.NETWORK__ATRIBUTE_1:
				setAtribute_1(ATRIBUTE_1_EDEFAULT);
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
			case ModelPackage.NETWORK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.NETWORK__SERVICES:
				return services != null && !services.isEmpty();
			case ModelPackage.NETWORK__ATRIBUTE_0:
				return ATRIBUTE_0_EDEFAULT == null ? atribute_0 != null : !ATRIBUTE_0_EDEFAULT.equals(atribute_0);
			case ModelPackage.NETWORK__ATRIBUTE_1:
				return ATRIBUTE_1_EDEFAULT == null ? atribute_1 != null : !ATRIBUTE_1_EDEFAULT.equals(atribute_1);
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

} //NetworkImpl
