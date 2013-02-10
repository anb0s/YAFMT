package cz.jpikl.yafmt.model.fm.provider.util;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

import cz.jpikl.yafmt.model.fm.FeatureModelPackage;
import cz.jpikl.yafmt.model.provider.util.IPropertySourceValidator;
import cz.jpikl.yafmt.model.provider.util.ValidatingPropertySource;

public class FeatureModelPropertySource extends ValidatingPropertySource {

    private static IPropertySourceValidator validator;
    
    private static IPropertySourceValidator getValidator() {
        if(validator == null)
            validator = new FeatureModelPropertySourceValidator();
        return validator;
    }
    
    public FeatureModelPropertySource(Object object, IItemPropertySource itemPropertySource) {
        super(object, itemPropertySource, getValidator());
    }
    
    @Override
    protected IPropertyDescriptor createPropertyDescriptor(IItemPropertyDescriptor itemPropertyDescriptor) {
        if(itemPropertyDescriptor.getFeature(null) == FeatureModelPackage.Literals.CONSTRAINT__VALUE)
            return new ConstraintValuePropertyDescriptor(object, itemPropertyDescriptor, getValidator());
        return super.createPropertyDescriptor(itemPropertyDescriptor);
    }
    
}
