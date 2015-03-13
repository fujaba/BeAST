/**
 */
package model.provider;


import java.util.Collection;
import java.util.List;

import model.ModelFactory;
import model.ModelPackage;
import model.Server;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link model.Server} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ServerItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource
{
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServerItemProvider(AdapterFactory adapterFactory)
	{
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
	{
		if (itemPropertyDescriptors == null)
		{
			super.getPropertyDescriptors(object);

			addIpPropertyDescriptor(object);
			addCpuCoresPropertyDescriptor(object);
			addRamPropertyDescriptor(object);
			addDiskSpacePropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addNetworkPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Ip feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIpPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Server_ip_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Server_ip_feature", "_UI_Server_type"),
				 ModelPackage.Literals.SERVER__IP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Cpu Cores feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCpuCoresPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Server_cpuCores_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Server_cpuCores_feature", "_UI_Server_type"),
				 ModelPackage.Literals.SERVER__CPU_CORES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Ram feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRamPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Server_ram_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Server_ram_feature", "_UI_Server_type"),
				 ModelPackage.Literals.SERVER__RAM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Disk Space feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDiskSpacePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Server_diskSpace_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Server_diskSpace_feature", "_UI_Server_type"),
				 ModelPackage.Literals.SERVER__DISK_SPACE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Server_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Server_name_feature", "_UI_Server_type"),
				 ModelPackage.Literals.SERVER__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Network feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNetworkPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Server_network_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Server_network_feature", "_UI_Server_type"),
				 ModelPackage.Literals.SERVER__NETWORK,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object)
	{
		if (childrenFeatures == null)
		{
			super.getChildrenFeatures(object);
			childrenFeatures.add(ModelPackage.Literals.SERVER__SERVICE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child)
	{
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Server.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object)
	{
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Server"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object)
	{
		String label = ((Server)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Server_type") :
			getString("_UI_Server_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification)
	{
		updateChildren(notification);

		switch (notification.getFeatureID(Server.class))
		{
			case ModelPackage.SERVER__IP:
			case ModelPackage.SERVER__CPU_CORES:
			case ModelPackage.SERVER__RAM:
			case ModelPackage.SERVER__DISK_SPACE:
			case ModelPackage.SERVER__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ModelPackage.SERVER__SERVICE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
	{
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.SERVER__SERVICE,
				 ModelFactory.eINSTANCE.createHadoopMaster()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.SERVER__SERVICE,
				 ModelFactory.eINSTANCE.createHadoopSlave()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.SERVER__SERVICE,
				 ModelFactory.eINSTANCE.createMySQL()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.SERVER__SERVICE,
				 ModelFactory.eINSTANCE.createWordPress()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.SERVER__SERVICE,
				 ModelFactory.eINSTANCE.createCassandra()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.SERVER__SERVICE,
				 ModelFactory.eINSTANCE.createMongoDB()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.SERVER__SERVICE,
				 ModelFactory.eINSTANCE.createUbuntu()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.SERVER__SERVICE,
				 ModelFactory.eINSTANCE.createApache2()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.SERVER__SERVICE,
				 ModelFactory.eINSTANCE.createJenkins()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.SERVER__SERVICE,
				 ModelFactory.eINSTANCE.createMediaWiki()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.SERVER__SERVICE,
				 ModelFactory.eINSTANCE.createTomcat()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator()
	{
		return ModelEditPlugin.INSTANCE;
	}

}
