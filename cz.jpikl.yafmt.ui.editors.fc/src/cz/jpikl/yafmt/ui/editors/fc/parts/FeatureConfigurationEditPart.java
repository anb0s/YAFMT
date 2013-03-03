package cz.jpikl.yafmt.ui.editors.fc.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.Selection;
import cz.jpikl.yafmt.ui.editors.fc.figures.FeatureConfigurationFigure;

public class FeatureConfigurationEditPart extends AbstractGraphicalEditPart {

    private FeatureConfiguration featureConfig;
    
    public FeatureConfigurationEditPart(FeatureConfiguration featureConfig) {
        this.featureConfig = featureConfig;
        setModel(featureConfig);
    }

    @Override
    protected IFigure createFigure() {
        return new FeatureConfigurationFigure();
    }
    
    @Override
    @SuppressWarnings("rawtypes")
    protected List getModelChildren() {
        List<Object> modelChildren = new ArrayList<Object>();
        modelChildren.add(featureConfig.getRoot());
        
        TreeIterator<EObject> it = featureConfig.getRoot().eAllContents();
        while(it.hasNext()) {
            EObject object = it.next();
            if(object instanceof Selection)
                modelChildren.add(object);
        }
           
        return modelChildren;
    }

    @Override
    protected void createEditPolicies() {
        
    }

}
