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
 *   <li>{@link model.impl.NetworkImpl#getIp <em>Ip</em>}</li>
 *   <li>{@link model.impl.NetworkImpl#getSubnetmask <em>Subnetmask</em>}</li>
 *   <li>{@link model.impl.NetworkImpl#getGateway <em>Gateway</em>}</li>
 *   <li>{@link model.impl.NetworkImpl#getDns <em>Dns</em>}</li>
 *   <li>{@link model.impl.NetworkImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.impl.NetworkImpl#getServices <em>Services</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NetworkImpl extends MinimalEObjectImpl.Container implements Network
{
	/**
	 * The default value of the '{@link #getIp() <em>Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIp()
	 * @generated
	 * @ordered
	 */
	protected static final String IP_EDEFAULT = "0.0.0.0";

	/**
	 * The cached value of the '{@link #getIp() <em>Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIp()
	 * @generated
	 * @ordered
	 */
	protected String ip = IP_EDEFAULT;

	/**
	 * The default value of the '{@link #getSubnetmask() <em>Subnetmask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubnetmask()
	 * @generated
	 * @ordered
	 */
	protected static final String SUBNETMASK_EDEFAULT = "0.0.0.0";

	/**
	 * The cached value of the '{@link #getSubnetmask() <em>Subnetmask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubnetmask()
	 * @generated
	 * @ordered
	 */
	protected String subnetmask = SUBNETMASK_EDEFAULT;

	/**
	 * The default value of the '{@link #getGateway() <em>Gateway</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGateway()
	 * @generated
	 * @ordered
	 */
	protected static final String GATEWAY_EDEFAULT = "0.0.0.0";

	/**
	 * The cached value of the '{@link #getGateway() <em>Gateway</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGateway()
	 * @generated
	 * @ordered
	 */
	protected String gateway = GATEWAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getDns() <em>Dns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDns()
	 * @generated
	 * @ordered
	 */
	protected static final String DNS_EDEFAULT = "0.0.0.0";

	/**
	 * The cached value of the '{@link #getDns() <em>Dns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDns()
	 * @generated
	 * @ordered
	 */
	protected String dns = DNS_EDEFAULT;

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
	public String getIp()
	{
		return ip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIp(String newIp)
	{
		String oldIp = ip;
		ip = newIp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.NETWORK__IP, oldIp, ip));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubnetmask()
	{
		return subnetmask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubnetmask(String newSubnetmask)
	{
		String oldSubnetmask = subnetmask;
		subnetmask = newSubnetmask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.NETWORK__SUBNETMASK, oldSubnetmask, subnetmask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGateway()
	{
		return gateway;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGateway(String newGateway)
	{
		String oldGateway = gateway;
		gateway = newGateway;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.NETWORK__GATEWAY, oldGateway, gateway));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDns()
	{
		return dns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDns(String newDns)
	{
		String oldDns = dns;
		dns = newDns;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.NETWORK__DNS, oldDns, dns));
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
			case ModelPackage.NETWORK__IP:
				return getIp();
			case ModelPackage.NETWORK__SUBNETMASK:
				return getSubnetmask();
			case ModelPackage.NETWORK__GATEWAY:
				return getGateway();
			case ModelPackage.NETWORK__DNS:
				return getDns();
			case ModelPackage.NETWORK__NAME:
				return getName();
			case ModelPackage.NETWORK__SERVICES:
				return getServices();
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
			case ModelPackage.NETWORK__IP:
				setIp((String)newValue);
				return;
			case ModelPackage.NETWORK__SUBNETMASK:
				setSubnetmask((String)newValue);
				return;
			case ModelPackage.NETWORK__GATEWAY:
				setGateway((String)newValue);
				return;
			case ModelPackage.NETWORK__DNS:
				setDns((String)newValue);
				return;
			case ModelPackage.NETWORK__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.NETWORK__SERVICES:
				getServices().clear();
				getServices().addAll((Collection<? extends Service>)newValue);
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
			case ModelPackage.NETWORK__IP:
				setIp(IP_EDEFAULT);
				return;
			case ModelPackage.NETWORK__SUBNETMASK:
				setSubnetmask(SUBNETMASK_EDEFAULT);
				return;
			case ModelPackage.NETWORK__GATEWAY:
				setGateway(GATEWAY_EDEFAULT);
				return;
			case ModelPackage.NETWORK__DNS:
				setDns(DNS_EDEFAULT);
				return;
			case ModelPackage.NETWORK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.NETWORK__SERVICES:
				getServices().clear();
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
			case ModelPackage.NETWORK__IP:
				return IP_EDEFAULT == null ? ip != null : !IP_EDEFAULT.equals(ip);
			case ModelPackage.NETWORK__SUBNETMASK:
				return SUBNETMASK_EDEFAULT == null ? subnetmask != null : !SUBNETMASK_EDEFAULT.equals(subnetmask);
			case ModelPackage.NETWORK__GATEWAY:
				return GATEWAY_EDEFAULT == null ? gateway != null : !GATEWAY_EDEFAULT.equals(gateway);
			case ModelPackage.NETWORK__DNS:
				return DNS_EDEFAULT == null ? dns != null : !DNS_EDEFAULT.equals(dns);
			case ModelPackage.NETWORK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.NETWORK__SERVICES:
				return services != null && !services.isEmpty();
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
		result.append(" (ip: ");
		result.append(ip);
		result.append(", subnetmask: ");
		result.append(subnetmask);
		result.append(", gateway: ");
		result.append(gateway);
		result.append(", dns: ");
		result.append(dns);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //NetworkImpl
