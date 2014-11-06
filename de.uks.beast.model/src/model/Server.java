/**
 */
package model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Server</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.Server#getIp <em>Ip</em>}</li>
 *   <li>{@link model.Server#getCpuAmount <em>Cpu Amount</em>}</li>
 *   <li>{@link model.Server#getCpuType <em>Cpu Type</em>}</li>
 *   <li>{@link model.Server#getRam <em>Ram</em>}</li>
 *   <li>{@link model.Server#getDiskSpace <em>Disk Space</em>}</li>
 *   <li>{@link model.Server#getHost <em>Host</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getServer()
 * @model
 * @generated
 */
public interface Server extends EObject {
	/**
	 * Returns the value of the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ip</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ip</em>' attribute.
	 * @see #setIp(String)
	 * @see model.ModelPackage#getServer_Ip()
	 * @model
	 * @generated
	 */
	String getIp();

	/**
	 * Sets the value of the '{@link model.Server#getIp <em>Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ip</em>' attribute.
	 * @see #getIp()
	 * @generated
	 */
	void setIp(String value);

	/**
	 * Returns the value of the '<em><b>Cpu Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cpu Amount</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cpu Amount</em>' attribute.
	 * @see #setCpuAmount(int)
	 * @see model.ModelPackage#getServer_CpuAmount()
	 * @model
	 * @generated
	 */
	int getCpuAmount();

	/**
	 * Sets the value of the '{@link model.Server#getCpuAmount <em>Cpu Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cpu Amount</em>' attribute.
	 * @see #getCpuAmount()
	 * @generated
	 */
	void setCpuAmount(int value);

	/**
	 * Returns the value of the '<em><b>Cpu Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cpu Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cpu Type</em>' attribute.
	 * @see #setCpuType(String)
	 * @see model.ModelPackage#getServer_CpuType()
	 * @model
	 * @generated
	 */
	String getCpuType();

	/**
	 * Sets the value of the '{@link model.Server#getCpuType <em>Cpu Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cpu Type</em>' attribute.
	 * @see #getCpuType()
	 * @generated
	 */
	void setCpuType(String value);

	/**
	 * Returns the value of the '<em><b>Ram</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ram</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ram</em>' attribute.
	 * @see #setRam(long)
	 * @see model.ModelPackage#getServer_Ram()
	 * @model
	 * @generated
	 */
	long getRam();

	/**
	 * Sets the value of the '{@link model.Server#getRam <em>Ram</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ram</em>' attribute.
	 * @see #getRam()
	 * @generated
	 */
	void setRam(long value);

	/**
	 * Returns the value of the '<em><b>Disk Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Disk Space</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Disk Space</em>' attribute.
	 * @see #setDiskSpace(long)
	 * @see model.ModelPackage#getServer_DiskSpace()
	 * @model
	 * @generated
	 */
	long getDiskSpace();

	/**
	 * Sets the value of the '{@link model.Server#getDiskSpace <em>Disk Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disk Space</em>' attribute.
	 * @see #getDiskSpace()
	 * @generated
	 */
	void setDiskSpace(long value);

	/**
	 * Returns the value of the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Host</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Host</em>' attribute.
	 * @see #setHost(String)
	 * @see model.ModelPackage#getServer_Host()
	 * @model
	 * @generated
	 */
	String getHost();

	/**
	 * Sets the value of the '{@link model.Server#getHost <em>Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Host</em>' attribute.
	 * @see #getHost()
	 * @generated
	 */
	void setHost(String value);

} // Server