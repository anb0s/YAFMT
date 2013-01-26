/**
 */
package cz.jpikl.yafmt.model.fm.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
import org.eclipse.emf.edit.provider.ItemPropertyDescriptorDecorator;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModelFactory;
import cz.jpikl.yafmt.model.fm.FeatureModelPackage;

/**
 * This is the item provider adapter for a {@link cz.jpikl.yafmt.model.fm.Feature} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FeatureItemProvider
    extends ItemProviderAdapter
    implements
        IEditingDomainItemProvider,
        IStructuredItemContentProvider,
        ITreeItemContentProvider,
        IItemLabelProvider,
        IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    private String getGeneralGroupName(Object feature) {
        // Space at the end is used for categories sorting trick.
        return ((((Feature) feature).getAttributes().isEmpty()) ? null : (getString("_UI_PropertyGroup_Feature_General")) + " ");
    }
    
    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        itemPropertyDescriptors = new ArrayList<IItemPropertyDescriptor>();

        addIdPropertyDescriptor(object);
        addNamePropertyDescriptor(object);
        addDescriptionPropertyDescriptor(object);
        
        Feature feature = (Feature) object;
        if(!feature.isRoot()) {
            addLowerPropertyDescriptor(object);
            addUpperPropertyDescriptor(object);
        }
        
        int i = 0;
        for(final Attribute attribute: feature.getAttributes()) {
            IItemPropertySource source = (IItemPropertySource) adapterFactory.adapt(attribute, IItemPropertySource.class);
            final int index = i++; 
            for(IItemPropertyDescriptor descriptor: source.getPropertyDescriptors(attribute)) {
                itemPropertyDescriptors.add(new ItemPropertyDescriptorDecorator(attribute, descriptor) {
                    @Override
                    public String getCategory(Object thisObject) {
                        return getString("_UI_PropertyGroup_Feature_Attribute", new Object[] { index + 1 });
                    }
                    @Override
                    public String getId(Object thisObject) {
                        return "attribute[" + index + "]." + super.getId(thisObject);
                    }
                });
            }
        }
        
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Id feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected void addIdPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_Feature_id_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_Feature_id_feature", "_UI_Feature_type"),
                 FeatureModelPackage.Literals.FEATURE__ID,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 getGeneralGroupName(object),
                 null));
    }

    /**
     * This adds a property descriptor for the Name feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected void addNamePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_Feature_name_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_Feature_name_feature", "_UI_Feature_type"),
                 FeatureModelPackage.Literals.FEATURE__NAME,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 getGeneralGroupName(object),
                 null));
    }

    /**
     * This adds a property descriptor for the Description feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected void addDescriptionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_Feature_description_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_Feature_description_feature", "_UI_Feature_type"),
                 FeatureModelPackage.Literals.FEATURE__DESCRIPTION,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 getGeneralGroupName(object),
                 null));
    }

    /**
     * This adds a property descriptor for the Lower feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected void addLowerPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_Feature_lower_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_Feature_lower_feature", "_UI_Feature_type"),
                 FeatureModelPackage.Literals.FEATURE__LOWER,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 getGeneralGroupName(object),
                 null));
    }

    /**
     * This adds a property descriptor for the Upper feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected void addUpperPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_Feature_upper_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_Feature_upper_feature", "_UI_Feature_type"),
                 FeatureModelPackage.Literals.FEATURE__UPPER,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 getGeneralGroupName(object),
                 null));
    }

    /**
     * This adds a property descriptor for the Root feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated 
     */
    protected void addRootPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_Feature_root_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_Feature_root_feature", "_UI_Feature_type"),
                 FeatureModelPackage.Literals.FEATURE__ROOT,
                 false,
                 false,
                 false,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Orphan feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOrphanPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_Feature_orphan_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_Feature_orphan_feature", "_UI_Feature_type"),
                 FeatureModelPackage.Literals.FEATURE__ORPHAN,
                 false,
                 false,
                 false,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Parent feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addParentPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_Feature_parent_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_Feature_parent_feature", "_UI_Feature_type"),
                 FeatureModelPackage.Literals.FEATURE__PARENT,
                 false,
                 false,
                 false,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Feature Model feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addFeatureModelPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_Feature_featureModel_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_Feature_featureModel_feature", "_UI_Feature_type"),
                 FeatureModelPackage.Literals.FEATURE__FEATURE_MODEL,
                 false,
                 false,
                 false,
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
     * @generated NOT
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
        if (childrenFeatures == null) {
            super.getChildrenFeatures(object);
            childrenFeatures.add(FeatureModelPackage.Literals.FEATURE__ATTRIBUTES);
            childrenFeatures.add(FeatureModelPackage.Literals.FEATURE__FEATURES);
            childrenFeatures.add(FeatureModelPackage.Literals.FEATURE__GROUPS);
        }
        return childrenFeatures;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature(Object object, Object child) {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

    /**
     * This returns Feature.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Object getImage(Object object) {
        Feature feature = (Feature) object;
        if(feature.isRoot())
            return getResourceLocator().getImage("feature-root.png");
        else if(feature.isMandatory())
            return getResourceLocator().getImage("feature-man.png");
        else if(feature.isOptional())
            return getResourceLocator().getImage("feature-opt.png");
        else
            return getResourceLocator().getImage("feature.png");
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public String getText(Object object) {
        Feature feature = (Feature) object;
        String label = feature.getName();
        if(feature.isClonable()) {
            int lower = feature.getLower();
            int upper = feature.getUpper();
            label += " [" + lower + ".." + ((upper == -1) ? "*" : upper) + "]";
        }
        return label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void notifyChanged(Notification notification) {
        updateChildren(notification);

        switch (notification.getFeatureID(Feature.class)) {
            case FeatureModelPackage.FEATURE__ID:
            case FeatureModelPackage.FEATURE__NAME:
            case FeatureModelPackage.FEATURE__DESCRIPTION:
            case FeatureModelPackage.FEATURE__LOWER:
            case FeatureModelPackage.FEATURE__UPPER:
            case FeatureModelPackage.FEATURE__ROOT:
            case FeatureModelPackage.FEATURE__ORPHAN:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case FeatureModelPackage.FEATURE__ATTRIBUTES:
            case FeatureModelPackage.FEATURE__FEATURES:
            case FeatureModelPackage.FEATURE__GROUPS:
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
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);

        newChildDescriptors.add
            (createChildParameter
                (FeatureModelPackage.Literals.FEATURE__ATTRIBUTES,
                 FeatureModelFactory.eINSTANCE.createAttribute()));

        newChildDescriptors.add
            (createChildParameter
                (FeatureModelPackage.Literals.FEATURE__FEATURES,
                 FeatureModelFactory.eINSTANCE.createFeature()));

        newChildDescriptors.add
            (createChildParameter
                (FeatureModelPackage.Literals.FEATURE__GROUPS,
                 FeatureModelFactory.eINSTANCE.createGroup()));
    }

    /**
     * Return the resource locator for this item provider's resources.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return FeatureModelEditPlugin.INSTANCE;
    }

}
