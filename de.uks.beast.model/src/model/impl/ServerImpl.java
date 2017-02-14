/**
 */
package model.impl;

import model.ModelPackage;
import model.Network;
import model.Server;
import model.Service;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Server</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link model.impl.ServerImpl#getIp <em>Ip</em>}</li>
 *   <li>{@link model.impl.ServerImpl#getCpuCores <em>Cpu Cores</em>}</li>
 *   <li>{@link model.impl.ServerImpl#getRam <em>Ram</em>}</li>
 *   <li>{@link model.impl.ServerImpl#getDiskSpace <em>Disk Space</em>}</li>
 *   <li>{@link model.impl.ServerImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.impl.ServerImpl#getNetwork <em>Network</em>}</li>
 *   <li>{@link model.impl.ServerImpl#getId <em>Id</em>}</li>
 *   <li>{@link model.impl.ServerImpl#getService <em>Service</em>}</li>
 * </ul>
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
	protected static final String	IP_EDEFAULT			= "0";
	
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
	 * The default value of the '{@link #getCpuCores() <em>Cpu Cores</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuCores()
	 * @generated
	 * @ordered
	 */
	protected static final int CPU_CORES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCpuCores() <em>Cpu Cores</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuCores()
	 * @generated
	 * @ordered
	 */
	protected int cpuCores = CPU_CORES_EDEFAULT;

	/**
	 * The default value of the '{@link #getRam() <em>Ram</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRam()
	 * @generated
	 * @ordered
	 */
	protected static final int		RAM_EDEFAULT		= 0;
	
	/**
	 * The cached value of the '{@link #getRam() <em>Ram</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRam()
	 * @generated
	 * @ordered
	 */
	protected int					ram					= RAM_EDEFAULT;
	
	/**
	 * The default value of the '{@link #getDiskSpace() <em>Disk Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiskSpace()
	 * @generated
	 * @ordered
	 */
	protected static final int		DISK_SPACE_EDEFAULT	= 0;
	
	/**
	 * The cached value of the '{@link #getDiskSpace() <em>Disk Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiskSpace()
	 * @generated
	 * @ordered
	 */
	protected int					diskSpace			= DISK_SPACE_EDEFAULT;
	
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "0";

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
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getService() <em>Service</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getService()
	 * @generated
	 * @ordered
	 */
	protected Service service;



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
	public int getCpuCores()
	{
		return cpuCores;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCpuCores(int newCpuCores)
	{
		int oldCpuCores = cpuCores;
		cpuCores = newCpuCores;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SERVER__CPU_CORES, oldCpuCores, cpuCores));
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRam()
	{
		return ram;
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRam(int newRam) {
		int oldRam = ram;
		ram = newRam;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SERVER__RAM, oldRam, ram));
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDiskSpace()
	{
		return diskSpace;
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiskSpace(int newDiskSpace) {
		int oldDiskSpace = diskSpace;
		diskSpace = newDiskSpace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SERVER__DISK_SPACE, oldDiskSpace, diskSpace));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SERVER__NAME, oldName, name));
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Network getNetwork() {
		if (network != null && network.eIsProxy()) {
			InternalEObject oldNetwork = (InternalEObject)network;
			network = (Network)eResolveProxy(oldNetwork);
			if (network != oldNetwork) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.SERVER__NETWORK, oldNetwork, network));
			}
		}
		return network;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Network basicGetNetwork() {
		return network;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNetwork(Network newNetwork, NotificationChain msgs) {
		Network oldNetwork = network;
		network = newNetwork;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.SERVER__NETWORK, oldNetwork, newNetwork);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNetwork(Network newNetwork) {
		if (newNetwork != network) {
			NotificationChain msgs = null;
			if (network != null)
				msgs = ((InternalEObject)network).eInverseRemove(this, ModelPackage.NETWORK__SERVER, Network.class, msgs);
			if (newNetwork != null)
				msgs = ((InternalEObject)newNetwork).eInverseAdd(this, ModelPackage.NETWORK__SERVER, Network.class, msgs);
			msgs = basicSetNetwork(newNetwork, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SERVER__NETWORK, newNetwork, newNetwork));
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getId() {
		return id;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(int newId) {
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SERVER__ID, oldId, id));
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service getService()
	{
		return service;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetService(Service newService, NotificationChain msgs) {
		Service oldService = service;
		service = newService;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.SERVER__SERVICE, oldService, newService);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setService(Service newService)
	{
		if (newService != service) {
			NotificationChain msgs = null;
			if (service != null)
				msgs = ((InternalEObject)service).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.SERVER__SERVICE, null, msgs);
			if (newService != null)
				msgs = ((InternalEObject)newService).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.SERVER__SERVICE, null, msgs);
			msgs = basicSetService(newService, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SERVER__SERVICE, newService, newService));
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.SERVER__NETWORK:
				if (network != null)
					msgs = ((InternalEObject)network).eInverseRemove(this, ModelPackage.NETWORK__SERVER, Network.class, msgs);
				return basicSetNetwork((Network)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.SERVER__NETWORK:
				return basicSetNetwork(null, msgs);
			case ModelPackage.SERVER__SERVICE:
				return basicSetService(null, msgs);
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
			case ModelPackage.SERVER__IP:
				return getIp();
			case ModelPackage.SERVER__CPU_CORES:
				return getCpuCores();
			case ModelPackage.SERVER__RAM:
				return getRam();
			case ModelPackage.SERVER__DISK_SPACE:
				return getDiskSpace();
			case ModelPackage.SERVER__NAME:
				return getName();
			case ModelPackage.SERVER__NETWORK:
				if (resolve) return getNetwork();
				return basicGetNetwork();
			case ModelPackage.SERVER__ID:
				return getId();
			case ModelPackage.SERVER__SERVICE:
				return getService();
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
			case ModelPackage.SERVER__IP:
				setIp((String)newValue);
				return;
			case ModelPackage.SERVER__CPU_CORES:
				setCpuCores((Integer)newValue);
				return;
			case ModelPackage.SERVER__RAM:
				setRam((Integer)newValue);
				return;
			case ModelPackage.SERVER__DISK_SPACE:
				setDiskSpace((Integer)newValue);
				return;
			case ModelPackage.SERVER__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.SERVER__NETWORK:
				setNetwork((Network)newValue);
				return;
			case ModelPackage.SERVER__ID:
				setId((Integer)newValue);
				return;
			case ModelPackage.SERVER__SERVICE:
				setService((Service)newValue);
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
			case ModelPackage.SERVER__IP:
				setIp(IP_EDEFAULT);
				return;
			case ModelPackage.SERVER__CPU_CORES:
				setCpuCores(CPU_CORES_EDEFAULT);
				return;
			case ModelPackage.SERVER__RAM:
				setRam(RAM_EDEFAULT);
				return;
			case ModelPackage.SERVER__DISK_SPACE:
				setDiskSpace(DISK_SPACE_EDEFAULT);
				return;
			case ModelPackage.SERVER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.SERVER__NETWORK:
				setNetwork((Network)null);
				return;
			case ModelPackage.SERVER__ID:
				setId(ID_EDEFAULT);
				return;
			case ModelPackage.SERVER__SERVICE:
				setService((Service)null);
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
			case ModelPackage.SERVER__IP:
				return IP_EDEFAULT == null ? ip != null : !IP_EDEFAULT.equals(ip);
			case ModelPackage.SERVER__CPU_CORES:
				return cpuCores != CPU_CORES_EDEFAULT;
			case ModelPackage.SERVER__RAM:
				return ram != RAM_EDEFAULT;
			case ModelPackage.SERVER__DISK_SPACE:
				return diskSpace != DISK_SPACE_EDEFAULT;
			case ModelPackage.SERVER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.SERVER__NETWORK:
				return network != null;
			case ModelPackage.SERVER__ID:
				return id != ID_EDEFAULT;
			case ModelPackage.SERVER__SERVICE:
				return service != null;
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
		result.append(", cpuCores: ");
		result.append(cpuCores);
		result.append(", ram: ");
		result.append(ram);
		result.append(", diskSpace: ");
		result.append(diskSpace);
		result.append(", name: ");
		result.append(name);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}
	
} //ServerImpl
