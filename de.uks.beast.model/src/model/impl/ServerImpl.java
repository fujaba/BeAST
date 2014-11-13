/**
 */
package model.impl;

import java.util.Collection;
import model.ModelPackage;
import model.RoutingComponent;
import model.Server;

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
 * An implementation of the model object '<em><b>Server</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.ServerImpl#getIp <em>Ip</em>}</li>
 *   <li>{@link model.impl.ServerImpl#getCpuAmount <em>Cpu Amount</em>}</li>
 *   <li>{@link model.impl.ServerImpl#getCpuType <em>Cpu Type</em>}</li>
 *   <li>{@link model.impl.ServerImpl#getRam <em>Ram</em>}</li>
 *   <li>{@link model.impl.ServerImpl#getDiskSpace <em>Disk Space</em>}</li>
 *   <li>{@link model.impl.ServerImpl#getHost <em>Host</em>}</li>
 *   <li>{@link model.impl.ServerImpl#getType <em>Type</em>}</li>
 *   <li>{@link model.impl.ServerImpl#getRoutingComponents <em>Routing Components</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServerImpl extends MinimalEObjectImpl.Container implements Server
{
	/**
	 * The default value of the '{@link #getIp() <em>Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIp()
	 * @generated
	 * @ordered
	 */
	protected static final String	IP_EDEFAULT			= null;
	
	/**
	 * The cached value of the '{@link #getIp() <em>Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIp()
	 * @generated
	 * @ordered
	 */
	protected String				ip					= IP_EDEFAULT;
	
	/**
	 * The default value of the '{@link #getCpuAmount() <em>Cpu Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuAmount()
	 * @generated
	 * @ordered
	 */
	protected static final int		CPU_AMOUNT_EDEFAULT	= 0;
	
	/**
	 * The cached value of the '{@link #getCpuAmount() <em>Cpu Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuAmount()
	 * @generated
	 * @ordered
	 */
	protected int					cpuAmount			= CPU_AMOUNT_EDEFAULT;
	
	/**
	 * The default value of the '{@link #getCpuType() <em>Cpu Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuType()
	 * @generated
	 * @ordered
	 */
	protected static final String	CPU_TYPE_EDEFAULT	= null;
	
	/**
	 * The cached value of the '{@link #getCpuType() <em>Cpu Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuType()
	 * @generated
	 * @ordered
	 */
	protected String				cpuType				= CPU_TYPE_EDEFAULT;
	
	/**
	 * The default value of the '{@link #getRam() <em>Ram</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRam()
	 * @generated
	 * @ordered
	 */
	protected static final long		RAM_EDEFAULT		= 0L;
	
	/**
	 * The cached value of the '{@link #getRam() <em>Ram</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRam()
	 * @generated
	 * @ordered
	 */
	protected long					ram					= RAM_EDEFAULT;
	
	/**
	 * The default value of the '{@link #getDiskSpace() <em>Disk Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiskSpace()
	 * @generated
	 * @ordered
	 */
	protected static final long		DISK_SPACE_EDEFAULT	= 0L;
	
	/**
	 * The cached value of the '{@link #getDiskSpace() <em>Disk Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiskSpace()
	 * @generated
	 * @ordered
	 */
	protected long					diskSpace			= DISK_SPACE_EDEFAULT;
	
	/**
	 * The default value of the '{@link #getHost() <em>Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHost()
	 * @generated
	 * @ordered
	 */
	protected static final String	HOST_EDEFAULT		= null;
	
	/**
	 * The cached value of the '{@link #getHost() <em>Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHost()
	 * @generated
	 * @ordered
	 */
	protected String				host				= HOST_EDEFAULT;
	
	
	
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;



	/**
	 * The cached value of the '{@link #getRoutingComponents() <em>Routing Components</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoutingComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<RoutingComponent> routingComponents;



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServerImpl()
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
		return ModelPackage.Literals.SERVER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SERVER__IP, oldIp, ip));
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCpuAmount()
	{
		return cpuAmount;
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCpuAmount(int newCpuAmount)
	{
		int oldCpuAmount = cpuAmount;
		cpuAmount = newCpuAmount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SERVER__CPU_AMOUNT, oldCpuAmount, cpuAmount));
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCpuType()
	{
		return cpuType;
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCpuType(String newCpuType)
	{
		String oldCpuType = cpuType;
		cpuType = newCpuType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SERVER__CPU_TYPE, oldCpuType, cpuType));
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getRam()
	{
		return ram;
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRam(long newRam)
	{
		long oldRam = ram;
		ram = newRam;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SERVER__RAM, oldRam, ram));
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getDiskSpace()
	{
		return diskSpace;
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiskSpace(long newDiskSpace)
	{
		long oldDiskSpace = diskSpace;
		diskSpace = newDiskSpace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SERVER__DISK_SPACE, oldDiskSpace, diskSpace));
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHost()
	{
		return host;
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHost(String newHost)
	{
		String oldHost = host;
		host = newHost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SERVER__HOST, oldHost, host));
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType()
	{
		return type;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType)
	{
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SERVER__TYPE, oldType, type));
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RoutingComponent> getRoutingComponents()
	{
		if (routingComponents == null)
		{
			routingComponents = new EObjectWithInverseResolvingEList.ManyInverse<RoutingComponent>(RoutingComponent.class, this, ModelPackage.SERVER__ROUTING_COMPONENTS, ModelPackage.ROUTING_COMPONENT__SERVER);
		}
		return routingComponents;
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
			case ModelPackage.SERVER__ROUTING_COMPONENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRoutingComponents()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.SERVER__ROUTING_COMPONENTS:
				return ((InternalEList<?>)getRoutingComponents()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.SERVER__IP:
				return getIp();
			case ModelPackage.SERVER__CPU_AMOUNT:
				return getCpuAmount();
			case ModelPackage.SERVER__CPU_TYPE:
				return getCpuType();
			case ModelPackage.SERVER__RAM:
				return getRam();
			case ModelPackage.SERVER__DISK_SPACE:
				return getDiskSpace();
			case ModelPackage.SERVER__HOST:
				return getHost();
			case ModelPackage.SERVER__TYPE:
				return getType();
			case ModelPackage.SERVER__ROUTING_COMPONENTS:
				return getRoutingComponents();
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
			case ModelPackage.SERVER__IP:
				setIp((String)newValue);
				return;
			case ModelPackage.SERVER__CPU_AMOUNT:
				setCpuAmount((Integer)newValue);
				return;
			case ModelPackage.SERVER__CPU_TYPE:
				setCpuType((String)newValue);
				return;
			case ModelPackage.SERVER__RAM:
				setRam((Long)newValue);
				return;
			case ModelPackage.SERVER__DISK_SPACE:
				setDiskSpace((Long)newValue);
				return;
			case ModelPackage.SERVER__HOST:
				setHost((String)newValue);
				return;
			case ModelPackage.SERVER__TYPE:
				setType((String)newValue);
				return;
			case ModelPackage.SERVER__ROUTING_COMPONENTS:
				getRoutingComponents().clear();
				getRoutingComponents().addAll((Collection<? extends RoutingComponent>)newValue);
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
			case ModelPackage.SERVER__IP:
				setIp(IP_EDEFAULT);
				return;
			case ModelPackage.SERVER__CPU_AMOUNT:
				setCpuAmount(CPU_AMOUNT_EDEFAULT);
				return;
			case ModelPackage.SERVER__CPU_TYPE:
				setCpuType(CPU_TYPE_EDEFAULT);
				return;
			case ModelPackage.SERVER__RAM:
				setRam(RAM_EDEFAULT);
				return;
			case ModelPackage.SERVER__DISK_SPACE:
				setDiskSpace(DISK_SPACE_EDEFAULT);
				return;
			case ModelPackage.SERVER__HOST:
				setHost(HOST_EDEFAULT);
				return;
			case ModelPackage.SERVER__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ModelPackage.SERVER__ROUTING_COMPONENTS:
				getRoutingComponents().clear();
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
			case ModelPackage.SERVER__IP:
				return IP_EDEFAULT == null ? ip != null : !IP_EDEFAULT.equals(ip);
			case ModelPackage.SERVER__CPU_AMOUNT:
				return cpuAmount != CPU_AMOUNT_EDEFAULT;
			case ModelPackage.SERVER__CPU_TYPE:
				return CPU_TYPE_EDEFAULT == null ? cpuType != null : !CPU_TYPE_EDEFAULT.equals(cpuType);
			case ModelPackage.SERVER__RAM:
				return ram != RAM_EDEFAULT;
			case ModelPackage.SERVER__DISK_SPACE:
				return diskSpace != DISK_SPACE_EDEFAULT;
			case ModelPackage.SERVER__HOST:
				return HOST_EDEFAULT == null ? host != null : !HOST_EDEFAULT.equals(host);
			case ModelPackage.SERVER__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case ModelPackage.SERVER__ROUTING_COMPONENTS:
				return routingComponents != null && !routingComponents.isEmpty();
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
		result.append(", cpuAmount: ");
		result.append(cpuAmount);
		result.append(", cpuType: ");
		result.append(cpuType);
		result.append(", ram: ");
		result.append(ram);
		result.append(", diskSpace: ");
		result.append(diskSpace);
		result.append(", host: ");
		result.append(host);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}
	
} //ServerImpl
