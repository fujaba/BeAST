/**
 */
package model.impl;

import java.util.Collection;
import model.ModelPackage;
import model.Network;
import model.Router;
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
 * An implementation of the model object '<em><b>Network</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.NetworkImpl#getIp <em>Ip</em>}</li>
 *   <li>{@link model.impl.NetworkImpl#getSubnetmask <em>Subnetmask</em>}</li>
 *   <li>{@link model.impl.NetworkImpl#getGateway <em>Gateway</em>}</li>
 *   <li>{@link model.impl.NetworkImpl#getDns <em>Dns</em>}</li>
 *   <li>{@link model.impl.NetworkImpl#getRouter <em>Router</em>}</li>
 *   <li>{@link model.impl.NetworkImpl#getId <em>Id</em>}</li>
 *   <li>{@link model.impl.NetworkImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.impl.NetworkImpl#getServer <em>Server</em>}</li>
 * </ul>
 * </p>
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
	protected static final String IP_EDEFAULT = "0";

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
	protected static final String	SUBNETMASK_EDEFAULT	= "0";
	
	/**
	 * The cached value of the '{@link #getSubnetmask() <em>Subnetmask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubnetmask()
	 * @generated
	 * @ordered
	 */
	protected String				subnetmask			= SUBNETMASK_EDEFAULT;
	
	/**
	 * The default value of the '{@link #getGateway() <em>Gateway</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGateway()
	 * @generated
	 * @ordered
	 */
	protected static final String	GATEWAY_EDEFAULT	= "0";
	
	/**
	 * The cached value of the '{@link #getGateway() <em>Gateway</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGateway()
	 * @generated
	 * @ordered
	 */
	protected String				gateway				= GATEWAY_EDEFAULT;
	
	/**
	 * The default value of the '{@link #getDns() <em>Dns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDns()
	 * @generated
	 * @ordered
	 */
	protected static final String	DNS_EDEFAULT		= "0";
	
	/**
	 * The cached value of the '{@link #getDns() <em>Dns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDns()
	 * @generated
	 * @ordered
	 */
	protected String				dns					= DNS_EDEFAULT;
	
	/**
	 * The cached value of the '{@link #getRouter() <em>Router</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRouter()
	 * @generated
	 * @ordered
	 */
	protected EList<Router> router;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = "0";

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

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
	 * The cached value of the '{@link #getServer() <em>Server</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServer()
	 * @generated
	 * @ordered
	 */
	protected EList<Server> server;



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
	public String getIp() {
		return ip;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIp(String newIp) {
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
	public EList<Server> getServer() {
		if (server == null) {
			server = new EObjectWithInverseResolvingEList<Server>(Server.class, this, ModelPackage.NETWORK__SERVER, ModelPackage.SERVER__NETWORK);
		}
		return server;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Router> getRouter() {
		if (router == null) {
			router = new EObjectWithInverseResolvingEList.ManyInverse<Router>(Router.class, this, ModelPackage.NETWORK__ROUTER, ModelPackage.ROUTER__NETWORK);
		}
		return router;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.NETWORK__ID, oldId, id));
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID) {
			case ModelPackage.NETWORK__ROUTER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRouter()).basicAdd(otherEnd, msgs);
			case ModelPackage.NETWORK__SERVER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getServer()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.NETWORK__ROUTER:
				return ((InternalEList<?>)getRouter()).basicRemove(otherEnd, msgs);
			case ModelPackage.NETWORK__SERVER:
				return ((InternalEList<?>)getServer()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.NETWORK__IP:
				return getIp();
			case ModelPackage.NETWORK__SUBNETMASK:
				return getSubnetmask();
			case ModelPackage.NETWORK__GATEWAY:
				return getGateway();
			case ModelPackage.NETWORK__DNS:
				return getDns();
			case ModelPackage.NETWORK__ROUTER:
				return getRouter();
			case ModelPackage.NETWORK__ID:
				return getId();
			case ModelPackage.NETWORK__NAME:
				return getName();
			case ModelPackage.NETWORK__SERVER:
				return getServer();
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
		switch (featureID) {
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
			case ModelPackage.NETWORK__ROUTER:
				getRouter().clear();
				getRouter().addAll((Collection<? extends Router>)newValue);
				return;
			case ModelPackage.NETWORK__ID:
				setId((String)newValue);
				return;
			case ModelPackage.NETWORK__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.NETWORK__SERVER:
				getServer().clear();
				getServer().addAll((Collection<? extends Server>)newValue);
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
			case ModelPackage.NETWORK__ROUTER:
				getRouter().clear();
				return;
			case ModelPackage.NETWORK__ID:
				setId(ID_EDEFAULT);
				return;
			case ModelPackage.NETWORK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.NETWORK__SERVER:
				getServer().clear();
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
			case ModelPackage.NETWORK__IP:
				return IP_EDEFAULT == null ? ip != null : !IP_EDEFAULT.equals(ip);
			case ModelPackage.NETWORK__SUBNETMASK:
				return SUBNETMASK_EDEFAULT == null ? subnetmask != null : !SUBNETMASK_EDEFAULT.equals(subnetmask);
			case ModelPackage.NETWORK__GATEWAY:
				return GATEWAY_EDEFAULT == null ? gateway != null : !GATEWAY_EDEFAULT.equals(gateway);
			case ModelPackage.NETWORK__DNS:
				return DNS_EDEFAULT == null ? dns != null : !DNS_EDEFAULT.equals(dns);
			case ModelPackage.NETWORK__ROUTER:
				return router != null && !router.isEmpty();
			case ModelPackage.NETWORK__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ModelPackage.NETWORK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.NETWORK__SERVER:
				return server != null && !server.isEmpty();
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
		result.append(", id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}
	
} //NetworkImpl
