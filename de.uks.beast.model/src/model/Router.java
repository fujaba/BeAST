/**
 */
package model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Router</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.Router#getNetwork <em>Network</em>}</li>
 *   <li>{@link model.Router#getId <em>Id</em>}</li>
 *   <li>{@link model.Router#getIp <em>Ip</em>}</li>
 *   <li>{@link model.Router#getName <em>Name</em>}</li>
 *   <li>{@link model.Router#getExternalGateway <em>External Gateway</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getRouter()
 * @model
 * @generated
 */
public interface Router extends EObject
{

	/**
	 * Returns the value of the '<em><b>Network</b></em>' reference list.
	 * The list contents are of type {@link model.Network}.
	 * It is bidirectional and its opposite is '{@link model.Network#getRouter <em>Router</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Network</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Network</em>' reference list.
	 * @see model.ModelPackage#getRouter_Network()
	 * @see model.Network#getRouter
	 * @model opposite="Router" required="true"
	 * @generated
	 */
	EList<Network> getNetwork();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see model.ModelPackage#getRouter_Id()
	 * @model default="0"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link model.Router#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Ip</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ip</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ip</em>' attribute.
	 * @see #setIp(String)
	 * @see model.ModelPackage#getRouter_Ip()
	 * @model default="0"
	 * @generated
	 */
	String getIp();

	/**
	 * Sets the value of the '{@link model.Router#getIp <em>Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ip</em>' attribute.
	 * @see #getIp()
	 * @generated
	 */
	void setIp(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see model.ModelPackage#getRouter_Name()
	 * @model default="0"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link model.Router#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>External Gateway</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External Gateway</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External Gateway</em>' attribute.
	 * @see #setExternalGateway(String)
	 * @see model.ModelPackage#getRouter_ExternalGateway()
	 * @model default="0"
	 * @generated
	 */
	String getExternalGateway();

	/**
	 * Sets the value of the '{@link model.Router#getExternalGateway <em>External Gateway</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>External Gateway</em>' attribute.
	 * @see #getExternalGateway()
	 * @generated
	 */
	void setExternalGateway(String value);
} // Router
