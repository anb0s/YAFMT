package cz.jpikl.yafmt.ui.editors.fc.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.FeatureConfigurationFactory;
import cz.jpikl.yafmt.model.fc.Selection;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.ui.editors.fc.figures.FeatureConfigurationFigure;
import cz.jpikl.yafmt.ui.editors.fc.model.SelectionPair;

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
        
        Feature rootFeature = featureConfig.getFeatureModelCopy().getRoot();
        Selection rootSelection = featureConfig.getRoot();
        modelChildren.add(rootSelection);
        contributeModelChildren(modelChildren, rootFeature, rootSelection);
        
        return modelChildren;
    }
        
    private void contributeModelChildren(List<Object> modelChildren, Feature feature, Selection selection) {
        for(Feature childFeature: feature.getFeatures()) {
            contributeSolitaryModelChildren(modelChildren, childFeature, selection);
        }
        for(Group group: feature.getGroups()) {
            for(Feature childFeature: group.getFeatures())
                contributeSolitaryModelChildren(modelChildren, childFeature, selection);
        }
    }
    
    private void contributeSolitaryModelChildren(List<Object> modelChildren, Feature childFeature, Selection selection) {
        String id = childFeature.getId();
        int count = 0;
        
        for(Selection childSelection: selection.getSelections()) {
            if(childSelection.getId().equals(id)) {
                modelChildren.add(childSelection);
                contributeModelChildren(modelChildren, childFeature, childSelection);
                count++;
            }
        }
        /*
        if(count < childFeature.getUpper()) {
            // use feature cofiguration util to create selection
            Selection childSelection = FeatureConfigurationFactory.eINSTANCE.createSelection();
            childSelection.setId(id);
            modelChildren.add(new SelectionPair(selection, childSelection));
        }*/
    }

    @Override
    protected void createEditPolicies() {
        
    }

}
