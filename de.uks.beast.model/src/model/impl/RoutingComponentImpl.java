/**
 */
package model.impl;

import java.util.Collection;
import model.ModelPackage;
import model.Network;
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
 * An implementation of the model object '<em><b>Routing Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.RoutingComponentImpl#getIp <em>Ip</em>}</li>
 *   <li>{@link model.impl.RoutingComponentImpl#getGateway <em>Gateway</em>}</li>
 *   <li>{@link model.impl.RoutingComponentImpl#getNetwork <em>Network</em>}</li>
 *   <li>{@link model.impl.RoutingComponentImpl#getType <em>Type</em>}</li>
 *   <li>{@link model.impl.RoutingComponentImpl#getServer <em>Server</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoutingComponentImpl extends MinimalEObjectImpl.Container implements RoutingComponent
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
	 * The default value of the '{@link #getGateway() <em>Gateway</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGateway()
	 * @generated
	 * @ordered
	 */
	protected static final String	GATEWAY_EDEFAULT	= null;
	
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
	 * The cached value of the '{@link #getNetwork() <em>Network</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetwork()
	 * @generated
	 * @ordered
	 */
	protected Network				network;
	
	
	
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
	protected RoutingComponentImpl()
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
		return ModelPackage.Literals.ROUTING_COMPONENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ROUTING_COMPONENT__IP, oldIp, ip));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ROUTING_COMPONENT__GATEWAY, oldGateway, gateway));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.ROUTING_COMPONENT__NETWORK, oldNetwork, network));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.ROUTING_COMPONENT__NETWORK, oldNetwork, newNetwork);
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
				msgs = ((InternalEObject)network).eInverseRemove(this, ModelPackage.NETWORK__ROUTER, Network.class, msgs);
			if (newNetwork != null)
				msgs = ((InternalEObject)newNetwork).eInverseAdd(this, ModelPackage.NETWORK__ROUTER, Network.class, msgs);
			msgs = basicSetNetwork(newNetwork, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ROUTING_COMPONENT__NETWORK, newNetwork, newNetwork));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ROUTING_COMPONENT__TYPE, oldType, type));
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Server> getServer()
	{
		if (server == null)
		{
			server = new EObjectWithInverseResolvingEList.ManyInverse<Server>(Server.class, this, ModelPackage.ROUTING_COMPONENT__SERVER, ModelPackage.SERVER__ROUTING_COMPONENTS);
		}
		return server;
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
			case ModelPackage.ROUTING_COMPONENT__NETWORK:
				if (network != null)
					msgs = ((InternalEObject)network).eInverseRemove(this, ModelPackage.NETWORK__ROUTER, Network.class, msgs);
				return basicSetNetwork((Network)otherEnd, msgs);
			case ModelPackage.ROUTING_COMPONENT__SERVER:
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
		switch (featureID)
		{
			case ModelPackage.ROUTING_COMPONENT__NETWORK:
				return basicSetNetwork(null, msgs);
			case ModelPackage.ROUTING_COMPONENT__SERVER:
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
		switch (featureID)
		{
			case ModelPackage.ROUTING_COMPONENT__IP:
				return getIp();
			case ModelPackage.ROUTING_COMPONENT__GATEWAY:
				return getGateway();
			case ModelPackage.ROUTING_COMPONENT__NETWORK:
				if (resolve) return getNetwork();
				return basicGetNetwork();
			case ModelPackage.ROUTING_COMPONENT__TYPE:
				return getType();
			case ModelPackage.ROUTING_COMPONENT__SERVER:
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
		switch (featureID)
		{
			case ModelPackage.ROUTING_COMPONENT__IP:
				setIp((String)newValue);
				return;
			case ModelPackage.ROUTING_COMPONENT__GATEWAY:
				setGateway((String)newValue);
				return;
			case ModelPackage.ROUTING_COMPONENT__NETWORK:
				setNetwork((Network)newValue);
				return;
			case ModelPackage.ROUTING_COMPONENT__TYPE:
				setType((String)newValue);
				return;
			case ModelPackage.ROUTING_COMPONENT__SERVER:
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
		switch (featureID)
		{
			case ModelPackage.ROUTING_COMPONENT__IP:
				setIp(IP_EDEFAULT);
				return;
			case ModelPackage.ROUTING_COMPONENT__GATEWAY:
				setGateway(GATEWAY_EDEFAULT);
				return;
			case ModelPackage.ROUTING_COMPONENT__NETWORK:
				setNetwork((Network)null);
				return;
			case ModelPackage.ROUTING_COMPONENT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ModelPackage.ROUTING_COMPONENT__SERVER:
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
		switch (featureID)
		{
			case ModelPackage.ROUTING_COMPONENT__IP:
				return IP_EDEFAULT == null ? ip != null : !IP_EDEFAULT.equals(ip);
			case ModelPackage.ROUTING_COMPONENT__GATEWAY:
				return GATEWAY_EDEFAULT == null ? gateway != null : !GATEWAY_EDEFAULT.equals(gateway);
			case ModelPackage.ROUTING_COMPONENT__NETWORK:
				return network != null;
			case ModelPackage.ROUTING_COMPONENT__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case ModelPackage.ROUTING_COMPONENT__SERVER:
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
		result.append(", gateway: ");
		result.append(gateway);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}
	
} //RoutingComponentImpl
