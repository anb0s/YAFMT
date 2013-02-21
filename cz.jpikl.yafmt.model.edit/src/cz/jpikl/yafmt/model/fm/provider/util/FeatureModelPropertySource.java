package cz.jpikl.yafmt.model.fm.provider.util;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

import cz.jpikl.yafmt.model.fm.FeatureModelPackage;
import cz.jpikl.yafmt.model.validation.IPropertySourceValidator;
import cz.jpikl.yafmt.model.validation.ValidatingPropertySource;

public class FeatureModelPropertySource extends ValidatingPropertySource {

    private static IPropertySourceValidator validator = new FeatureModelPropertySourceValidator();
    
    public FeatureModelPropertySource(Object object, IItemPropertySource itemPropertySource) {
        super(object, itemPropertySource, validator);
    }
    
    @Override
    protected IPropertyDescriptor createPropertyDescriptor(IItemPropertyDescriptor itemPropertyDescriptor) {
        // Use custom property descriptor for constraint value.
        // It can use language custom editor from extension point. 
        if(itemPropertyDescriptor.getFeature(null) == FeatureModelPackage.Literals.CONSTRAINT__VALUE)
            return new ConstraintValuePropertyDescriptor(object, itemPropertyDescriptor, validator);
        // Default descriptor for others.
        return super.createPropertyDescriptor(itemPropertyDescriptor);
    }
    
}
