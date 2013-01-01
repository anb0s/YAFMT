package cz.jpikl.yafmt.editors.featureconfig.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import cz.jpikl.yafmt.editors.featureconfig.editor.FeatureConfigurationManager;
import cz.jpikl.yafmt.models.featuremodel.Feature;

public class FeatureConfigEditPart extends AbstractGraphicalEditPart {

    FeatureConfigurationManager configManager;
    
    public FeatureConfigEditPart(FeatureConfigurationManager configManager) {
        this.configManager = configManager;
    }
    
    @Override
    protected List<Object> getModelChildren() {
        List<Object> objects = new ArrayList<Object>();
        Feature rootFeature = configManager.getFeatureConfiguration().getFeatureModel().getRootFeature();
        addSelectedFeaturesToList(rootFeature, objects);
        return objects;
    }
    
    private void addSelectedFeaturesToList(Feature feature, List<Object> list) {
        if(configManager.isFeatureSelected(feature))
            list.add(feature);
        else if(configManager.isFeatureSelected(feature.getParent()) && configManager.isFeatureSelectable(feature))
            list.add(feature);
        else
            return;
        
        for(Feature childFeature: feature.getChildren())
            addSelectedFeaturesToList(childFeature, list);
    }

    @Override
    protected IFigure createFigure() {
        IFigure figure = new FreeformLayer();
        figure.setBorder(new MarginBorder(3));
        figure.setLayoutManager(new FreeformLayout());
        return figure;
    }

    @Override
    protected void createEditPolicies() {
        
    }

}
