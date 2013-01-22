package cz.jpikl.yafmt.ui.editors.fm.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.ui.views.properties.IPropertySource;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.provider.util.FeatureModelProviderUtil;
import cz.jpikl.yafmt.model.fm.provider.util.UnwrappingPropertySource;
import cz.jpikl.yafmt.ui.editors.fm.figures.FeatureFigure;

public class FeatureEditPart extends AbstractGraphicalEditPart {

    private Feature feature;
    private IPropertySource propertySource;
    
    public FeatureEditPart(Feature feature) {
        this.feature = feature;
        setModel(feature);
    }

    @Override
    protected IFigure createFigure() {
        return new FeatureFigure(feature.getName());
    }
    
    @Override
    protected void refreshVisuals() {
        FeatureModelEditPart featureModelEditPart = (FeatureModelEditPart) getParent();
        Rectangle bounds = featureModelEditPart.getFeatureBounds(feature);
        if(bounds == null) {
            bounds = new Rectangle(0, 0, 100, 24);
            featureModelEditPart.setFeatureBounds(feature, bounds);
        }
        featureModelEditPart.setLayoutConstraint(this, getFigure(), bounds);
    }

    @Override
    protected void createEditPolicies() {
    }
    
    // ======================================================================
    //  IAdaptable
    // ======================================================================
    
    @Override
    @SuppressWarnings("rawtypes")
    public Object getAdapter(Class type) {
        if(type == IPropertySource.class) {
            if(propertySource == null)
                propertySource = FeatureModelProviderUtil.getContentProvider().getPropertySource(feature);
            return propertySource;
        }
        return super.getAdapter(type);
    }

}
