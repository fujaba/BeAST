/**
 */
package model.impl;

import java.util.Collection;
import model.ModelPackage;
import model.Network;
import model.Router;

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
 * An implementation of the model object '<em><b>Router</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.RouterImpl#getNetwork <em>Network</em>}</li>
 *   <li>{@link model.impl.RouterImpl#getId <em>Id</em>}</li>
 *   <li>{@link model.impl.RouterImpl#getIp <em>Ip</em>}</li>
 *   <li>{@link model.impl.RouterImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.impl.RouterImpl#getExternalGateway <em>External Gateway</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RouterImpl extends MinimalEObjectImpl.Container implements Router
{
	/**
	 * The cached value of the '{@link #getNetwork() <em>Network</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetwork()
	 * @generated
	 * @ordered
	 */
	protected EList<Network> network;
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;
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
	 * The default value of the '{@link #getIp() <em>Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIp()
	 * @generated
	 * @ordered
	 */
	protected static final String IP_EDEFAULT = null;
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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;
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
	 * The default value of the '{@link #getExternalGateway() <em>External Gateway</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalGateway()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTERNAL_GATEWAY_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getExternalGateway() <em>External Gateway</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalGateway()
	 * @generated
	 * @ordered
	 */
	protected String externalGateway = EXTERNAL_GATEWAY_EDEFAULT;



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RouterImpl()
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
		return ModelPackage.Literals.ROUTER;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Network> getNetwork() {
		if (network == null) {
			network = new EObjectWithInverseResolvingEList.ManyInverse<Network>(Network.class, this, ModelPackage.ROUTER__NETWORK, ModelPackage.NETWORK__ROUTER);
		}
		return network;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ROUTER__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ROUTER__IP, oldIp, ip));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ROUTER__NAME, oldName, name));
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExternalGateway() {
		return externalGateway;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExternalGateway(String newExternalGateway) {
		String oldExternalGateway = externalGateway;
		externalGateway = newExternalGateway;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ROUTER__EXTERNAL_GATEWAY, oldExternalGateway, externalGateway));
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.ROUTER__NETWORK:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNetwork()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.ROUTER__NETWORK:
				return ((InternalEList<?>)getNetwork()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.ROUTER__NETWORK:
				return getNetwork();
			case ModelPackage.ROUTER__ID:
				return getId();
			case ModelPackage.ROUTER__IP:
				return getIp();
			case ModelPackage.ROUTER__NAME:
				return getName();
			case ModelPackage.ROUTER__EXTERNAL_GATEWAY:
				return getExternalGateway();
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
			case ModelPackage.ROUTER__NETWORK:
				getNetwork().clear();
				getNetwork().addAll((Collection<? extends Network>)newValue);
				return;
			case ModelPackage.ROUTER__ID:
				setId((String)newValue);
				return;
			case ModelPackage.ROUTER__IP:
				setIp((String)newValue);
				return;
			case ModelPackage.ROUTER__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.ROUTER__EXTERNAL_GATEWAY:
				setExternalGateway((String)newValue);
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
			case ModelPackage.ROUTER__NETWORK:
				getNetwork().clear();
				return;
			case ModelPackage.ROUTER__ID:
				setId(ID_EDEFAULT);
				return;
			case ModelPackage.ROUTER__IP:
				setIp(IP_EDEFAULT);
				return;
			case ModelPackage.ROUTER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.ROUTER__EXTERNAL_GATEWAY:
				setExternalGateway(EXTERNAL_GATEWAY_EDEFAULT);
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
			case ModelPackage.ROUTER__NETWORK:
				return network != null && !network.isEmpty();
			case ModelPackage.ROUTER__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ModelPackage.ROUTER__IP:
				return IP_EDEFAULT == null ? ip != null : !IP_EDEFAULT.equals(ip);
			case ModelPackage.ROUTER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.ROUTER__EXTERNAL_GATEWAY:
				return EXTERNAL_GATEWAY_EDEFAULT == null ? externalGateway != null : !EXTERNAL_GATEWAY_EDEFAULT.equals(externalGateway);
		}
		return super.eIsSet(featureID);
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", ip: ");
		result.append(ip);
		result.append(", name: ");
		result.append(name);
		result.append(", externalGateway: ");
		result.append(externalGateway);
		result.append(')');
		return result.toString();
	}
	
} //RouterImpl
