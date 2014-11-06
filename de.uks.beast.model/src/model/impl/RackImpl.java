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
 *   <li>{@link model.impl.RackImpl#getRouter <em>Router</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RackImpl extends MinimalEObjectImpl.Container implements Rack {
	/**
	 * The cached value of the '{@link #getServer() <em>Server</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServer()
	 * @generated
	 * @ordered
	 */
	protected EList<Server> server;

	/**
	 * The cached value of the '{@link #getRouter() <em>Router</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRouter()
	 * @generated
	 * @ordered
	 */
	protected RoutingComponent router;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RackImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.RACK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Server> getServer() {
		if (server == null) {
			server = new EObjectContainmentEList<Server>(Server.class, this, ModelPackage.RACK__SERVER);
		}
		return server;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoutingComponent getRouter() {
		if (router != null && router.eIsProxy()) {
			InternalEObject oldRouter = (InternalEObject)router;
			router = (RoutingComponent)eResolveProxy(oldRouter);
			if (router != oldRouter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.RACK__ROUTER, oldRouter, router));
			}
		}
		return router;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoutingComponent basicGetRouter() {
		return router;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRouter(RoutingComponent newRouter) {
		RoutingComponent oldRouter = router;
		router = newRouter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.RACK__ROUTER, oldRouter, router));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.RACK__SERVER:
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.RACK__SERVER:
				return getServer();
			case ModelPackage.RACK__ROUTER:
				if (resolve) return getRouter();
				return basicGetRouter();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.RACK__SERVER:
				getServer().clear();
				getServer().addAll((Collection<? extends Server>)newValue);
				return;
			case ModelPackage.RACK__ROUTER:
				setRouter((RoutingComponent)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.RACK__SERVER:
				getServer().clear();
				return;
			case ModelPackage.RACK__ROUTER:
				setRouter((RoutingComponent)null);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.RACK__SERVER:
				return server != null && !server.isEmpty();
			case ModelPackage.RACK__ROUTER:
				return router != null;
		}
		return super.eIsSet(featureID);
	}

} //RackImpl
