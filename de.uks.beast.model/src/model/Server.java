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
 *   <li>{@link model.Server#getCpuCores <em>Cpu Cores</em>}</li>
 *   <li>{@link model.Server#getRam <em>Ram</em>}</li>
 *   <li>{@link model.Server#getDiskSpace <em>Disk Space</em>}</li>
 *   <li>{@link model.Server#getName <em>Name</em>}</li>
 *   <li>{@link model.Server#getNetwork <em>Network</em>}</li>
 *   <li>{@link model.Server#getService <em>Service</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getServer()
 * @model
 * @generated
 */
public interface Server extends EObject
{
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
	 * @see model.ModelPackage#getServer_Ip()
	 * @model default="0"
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
	 * Returns the value of the '<em><b>Cpu Cores</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cpu Cores</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cpu Cores</em>' attribute.
	 * @see #setCpuCores(int)
	 * @see model.ModelPackage#getServer_CpuCores()
	 * @model
	 * @generated
	 */
	int getCpuCores();



	/**
	 * Sets the value of the '{@link model.Server#getCpuCores <em>Cpu Cores</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cpu Cores</em>' attribute.
	 * @see #getCpuCores()
	 * @generated
	 */
	void setCpuCores(int value);



	/**
	 * Returns the value of the '<em><b>Ram</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ram</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ram</em>' attribute.
	 * @see #setRam(int)
	 * @see model.ModelPackage#getServer_Ram()
	 * @model
	 * @generated
	 */
	int getRam();
	
	
	
	/**
	 * Sets the value of the '{@link model.Server#getRam <em>Ram</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ram</em>' attribute.
	 * @see #getRam()
	 * @generated
	 */
	void setRam(int value);



	/**
	 * Returns the value of the '<em><b>Disk Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Disk Space</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Disk Space</em>' attribute.
	 * @see #setDiskSpace(int)
	 * @see model.ModelPackage#getServer_DiskSpace()
	 * @model
	 * @generated
	 */
	int getDiskSpace();
	
	
	
	/**
	 * Sets the value of the '{@link model.Server#getDiskSpace <em>Disk Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disk Space</em>' attribute.
	 * @see #getDiskSpace()
	 * @generated
	 */
	void setDiskSpace(int value);



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
	 * @see model.ModelPackage#getServer_Name()
	 * @model default="0"
	 * @generated
	 */
	String getName();



	/**
	 * Sets the value of the '{@link model.Server#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);



	/**
	 * Returns the value of the '<em><b>Network</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link model.Network#getServer <em>Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Network</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Network</em>' reference.
	 * @see #setNetwork(Network)
	 * @see model.ModelPackage#getServer_Network()
	 * @see model.Network#getServer
	 * @model opposite="Server"
	 * @generated
	 */
	Network getNetwork();



	/**
	 * Sets the value of the '{@link model.Server#getNetwork <em>Network</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Network</em>' reference.
	 * @see #getNetwork()
	 * @generated
	 */
	void setNetwork(Network value);



	/**
	 * Returns the value of the '<em><b>Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service</em>' containment reference.
	 * @see #setService(Service)
	 * @see model.ModelPackage#getServer_Service()
	 * @model containment="true"
	 * @generated
	 */
	Service getService();



	/**
	 * Sets the value of the '{@link model.Server#getService <em>Service</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service</em>' containment reference.
	 * @see #getService()
	 * @generated
	 */
	void setService(Service value);
	
} // Server
