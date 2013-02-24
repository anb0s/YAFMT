package cz.jpikl.yafmt.ui.editors.fc.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.ui.editors.fc.figures.FeatureConfigurationFigure;

public class FeatureConfigurationEditPart extends AbstractGraphicalEditPart {

    private FeatureConfiguration featureConfig;
    
    public FeatureConfigurationEditPart(FeatureConfiguration featureConfig) {
        this.featureConfig = featureConfig;
    }

    @Override
    protected IFigure createFigure() {
        return new FeatureConfigurationFigure();
    }

    @Override
    protected void createEditPolicies() {
        
    }

}
