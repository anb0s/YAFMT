package cz.jpikl.yafmt.editors.featureconfig.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import cz.jpikl.yafmt.editors.featureconfig.editor.FeatureConfigurationManager;
import cz.jpikl.yafmt.editors.featureconfig.editor.FeatureTreeLayout;
import cz.jpikl.yafmt.models.featuremodel.Feature;
import cz.jpikl.yafmt.models.utils.ModelAdapter;
import cz.jpikl.yafmt.models.utils.ModelListener;

public class FeatureConfigEditPart extends AbstractGraphicalEditPart implements ModelListener {

    private FeatureConfigurationManager configManager;
    private ModelAdapter modelAdapter;
    
    public FeatureConfigEditPart(FeatureConfigurationManager configManager) {
        this.configManager = configManager;
        this.modelAdapter = new ModelAdapter(this);
        modelAdapter.connect(configManager.getFeatureConfiguration());
    }
    
    @Override
    protected List<Object> getModelChildren() {
        List<Object> objects = new ArrayList<Object>();
        Feature rootFeature = configManager.getFeatureConfiguration().getFeatureModel().getRootFeature();
        addVisibleFeaturesToList(rootFeature, objects);
        return objects;
    }
    
    private void addVisibleFeaturesToList(Feature feature, List<Object> list) {
        if(configManager.isFeatureSelected(feature)) {
            list.add(feature);
            for(Feature childFeature: feature.getChildren())
                addVisibleFeaturesToList(childFeature, list);
        }
        else if(configManager.isFeatureSelectable(feature)) {
            list.add(feature);
        }
    }

    @Override
    protected IFigure createFigure() {
        IFigure figure = new FreeformLayer();
        figure.setBorder(new MarginBorder(3));
        figure.setLayoutManager(new FeatureTreeLayout());
        return figure;
    }

    @Override
    protected void createEditPolicies() {
        
    }

    @Override
    public void modelChanged(Notification notification) {
        refreshChildren();
        for(Object child: getChildren()) {
            if(child instanceof NodeEditPart)
                ((NodeEditPart) child).refresh();
        }
    }

}
