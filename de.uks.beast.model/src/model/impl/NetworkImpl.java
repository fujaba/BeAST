/**
 */
package model.impl;

import model.ModelPackage;
import model.Network;
import model.RoutingComponent;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Network</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.NetworkImpl#getRange <em>Range</em>}</li>
 *   <li>{@link model.impl.NetworkImpl#getSubnetmask <em>Subnetmask</em>}</li>
 *   <li>{@link model.impl.NetworkImpl#getGateway <em>Gateway</em>}</li>
 *   <li>{@link model.impl.NetworkImpl#getDns <em>Dns</em>}</li>
 *   <li>{@link model.impl.NetworkImpl#getRouter <em>Router</em>}</li>
 *   <li>{@link model.impl.NetworkImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NetworkImpl extends MinimalEObjectImpl.Container implements Network
{
	/**
	 * The default value of the '{@link #getRange() <em>Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRange()
	 * @generated
	 * @ordered
	 */
	protected static final String	RANGE_EDEFAULT		= null;
	
	/**
	 * The cached value of the '{@link #getRange() <em>Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRange()
	 * @generated
	 * @ordered
	 */
	protected String				range				= RANGE_EDEFAULT;
	
	/**
	 * The default value of the '{@link #getSubnetmask() <em>Subnetmask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubnetmask()
	 * @generated
	 * @ordered
	 */
	protected static final String	SUBNETMASK_EDEFAULT	= null;
	
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
	 * The default value of the '{@link #getDns() <em>Dns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDns()
	 * @generated
	 * @ordered
	 */
	protected static final String	DNS_EDEFAULT		= null;
	
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
	 * The cached value of the '{@link #getRouter() <em>Router</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRouter()
	 * @generated
	 * @ordered
	 */
	protected RoutingComponent		router;
	
	
	
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
	public String getRange()
	{
		return range;
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRange(String newRange)
	{
		String oldRange = range;
		range = newRange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.NETWORK__RANGE, oldRange, range));
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
	public RoutingComponent getRouter()
	{
		if (router != null && router.eIsProxy())
		{
			InternalEObject oldRouter = (InternalEObject)router;
			router = (RoutingComponent)eResolveProxy(oldRouter);
			if (router != oldRouter)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.NETWORK__ROUTER, oldRouter, router));
			}
		}
		return router;
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoutingComponent basicGetRouter()
	{
		return router;
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRouter(RoutingComponent newRouter, NotificationChain msgs)
	{
		RoutingComponent oldRouter = router;
		router = newRouter;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.NETWORK__ROUTER, oldRouter, newRouter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRouter(RoutingComponent newRouter)
	{
		if (newRouter != router)
		{
			NotificationChain msgs = null;
			if (router != null)
				msgs = ((InternalEObject)router).eInverseRemove(this, ModelPackage.ROUTING_COMPONENT__NETWORK, RoutingComponent.class, msgs);
			if (newRouter != null)
				msgs = ((InternalEObject)newRouter).eInverseAdd(this, ModelPackage.ROUTING_COMPONENT__NETWORK, RoutingComponent.class, msgs);
			msgs = basicSetRouter(newRouter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.NETWORK__ROUTER, newRouter, newRouter));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.NETWORK__TYPE, oldType, type));
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ModelPackage.NETWORK__ROUTER:
				if (router != null)
					msgs = ((InternalEObject)router).eInverseRemove(this, ModelPackage.ROUTING_COMPONENT__NETWORK, RoutingComponent.class, msgs);
				return basicSetRouter((RoutingComponent)otherEnd, msgs);
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
			case ModelPackage.NETWORK__ROUTER:
				return basicSetRouter(null, msgs);
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
			case ModelPackage.NETWORK__RANGE:
				return getRange();
			case ModelPackage.NETWORK__SUBNETMASK:
				return getSubnetmask();
			case ModelPackage.NETWORK__GATEWAY:
				return getGateway();
			case ModelPackage.NETWORK__DNS:
				return getDns();
			case ModelPackage.NETWORK__ROUTER:
				if (resolve) return getRouter();
				return basicGetRouter();
			case ModelPackage.NETWORK__TYPE:
				return getType();
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
		switch (featureID)
		{
			case ModelPackage.NETWORK__RANGE:
				setRange((String)newValue);
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
				setRouter((RoutingComponent)newValue);
				return;
			case ModelPackage.NETWORK__TYPE:
				setType((String)newValue);
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
			case ModelPackage.NETWORK__RANGE:
				setRange(RANGE_EDEFAULT);
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
				setRouter((RoutingComponent)null);
				return;
			case ModelPackage.NETWORK__TYPE:
				setType(TYPE_EDEFAULT);
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
			case ModelPackage.NETWORK__RANGE:
				return RANGE_EDEFAULT == null ? range != null : !RANGE_EDEFAULT.equals(range);
			case ModelPackage.NETWORK__SUBNETMASK:
				return SUBNETMASK_EDEFAULT == null ? subnetmask != null : !SUBNETMASK_EDEFAULT.equals(subnetmask);
			case ModelPackage.NETWORK__GATEWAY:
				return GATEWAY_EDEFAULT == null ? gateway != null : !GATEWAY_EDEFAULT.equals(gateway);
			case ModelPackage.NETWORK__DNS:
				return DNS_EDEFAULT == null ? dns != null : !DNS_EDEFAULT.equals(dns);
			case ModelPackage.NETWORK__ROUTER:
				return router != null;
			case ModelPackage.NETWORK__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
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
		result.append(" (range: ");
		result.append(range);
		result.append(", subnetmask: ");
		result.append(subnetmask);
		result.append(", gateway: ");
		result.append(gateway);
		result.append(", dns: ");
		result.append(dns);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}
	
} //NetworkImpl
