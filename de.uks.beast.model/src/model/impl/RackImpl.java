/**
 */
package model.impl;

import java.util.Collection;

import model.ModelPackage;
import model.Rack;
import model.RoutingComponent;
import model.Server;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rack</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.RackImpl#getServer <em>Server</em>}</li>
 *   <li>{@link model.impl.RackImpl#getId <em>Id</em>}</li>
 *   <li>{@link model.impl.RackImpl#getType <em>Type</em>}</li>
 *   <li>{@link model.impl.RackImpl#getRouter <em>Router</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RackImpl extends MinimalEObjectImpl.Container implements Rack
{
	/**
	 * The cached value of the '{@link #getServer() <em>Server</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServer()
	 * @generated
	 * @ordered
	 */
	protected EList<Server>		server;
	
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
	 * The cached value of the '{@link #getRouter() <em>Router</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRouter()
	 * @generated
	 * @ordered
	 */
	protected EList<RoutingComponent>	router;



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RackImpl()
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
		return ModelPackage.Literals.RACK;
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
			server = new EObjectContainmentEList<Server>(Server.class, this, ModelPackage.RACK__SERVER);
		}
		return server;
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RoutingComponent> getRouter()
	{
		if (router == null)
		{
			router = new EObjectContainmentEList<RoutingComponent>(RoutingComponent.class, this, ModelPackage.RACK__ROUTER);
		}
		return router;
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getId()
	{
		return id;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(int newId)
	{
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.RACK__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.RACK__TYPE, oldType, type));
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
			case ModelPackage.RACK__SERVER:
				return ((InternalEList<?>)getServer()).basicRemove(otherEnd, msgs);
			case ModelPackage.RACK__ROUTER:
				return ((InternalEList<?>)getRouter()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.RACK__SERVER:
				return getServer();
			case ModelPackage.RACK__ID:
				return getId();
			case ModelPackage.RACK__TYPE:
				return getType();
			case ModelPackage.RACK__ROUTER:
				return getRouter();
		}
		return super.eGet(featureID, resolve, coreType);
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings ("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ModelPackage.RACK__SERVER:
				getServer().clear();
				getServer().addAll((Collection<? extends Server>)newValue);
				return;
			case ModelPackage.RACK__ID:
				setId((Integer)newValue);
				return;
			case ModelPackage.RACK__TYPE:
				setType((String)newValue);
				return;
			case ModelPackage.RACK__ROUTER:
				getRouter().clear();
				getRouter().addAll((Collection<? extends RoutingComponent>)newValue);
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
			case ModelPackage.RACK__SERVER:
				getServer().clear();
				return;
			case ModelPackage.RACK__ID:
				setId(ID_EDEFAULT);
				return;
			case ModelPackage.RACK__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ModelPackage.RACK__ROUTER:
				getRouter().clear();
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
			case ModelPackage.RACK__SERVER:
				return server != null && !server.isEmpty();
			case ModelPackage.RACK__ID:
				return id != ID_EDEFAULT;
			case ModelPackage.RACK__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case ModelPackage.RACK__ROUTER:
				return router != null && !router.isEmpty();
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
		result.append(" (id: ");
		result.append(id);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}
	
} //RackImpl
