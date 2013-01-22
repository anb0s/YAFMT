package cz.jpikl.yafmt.ui.editors.fm.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.util.IModelListener;
import cz.jpikl.yafmt.model.util.ModelListenerAdapter;
import cz.jpikl.yafmt.ui.editors.fm.figures.FeatureModelFigure;
import cz.jpikl.yafmt.ui.editors.fm.layout.ModelLayout;
import cz.jpikl.yafmt.ui.editors.fm.policies.FeatureModelLayoutPolicy;

public class FeatureModelEditPart extends AbstractGraphicalEditPart implements IModelListener {

    private FeatureModel featureModel;
    private ModelLayout modelLayout;
    private ModelListenerAdapter modelAdapter;
    
    public FeatureModelEditPart(FeatureModel featureModel, ModelLayout modelLayout) {
        this.featureModel = featureModel;
        this.modelLayout = modelLayout;
        this.modelAdapter = new ModelListenerAdapter(this);
        setModel(featureModel);
    }
    
    @Override
    public void activate() {
        super.activate();
        modelAdapter.connectContents(featureModel);
    }
    
    @Override
    public void deactivate() {
        modelAdapter.dispose();
    }

    @Override
    protected IFigure createFigure() {
        return new FeatureModelFigure();
    }

    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.LAYOUT_ROLE, new FeatureModelLayoutPolicy());
    }

    @Override
    protected List<Object> getModelChildren() {
        List<Object> modelChildren = new ArrayList<Object>();
        modelChildren.add(featureModel.getRoot());
        return modelChildren;
    }
        
    public Rectangle getFeatureBounds(Feature feature) {
        return modelLayout.getMapping().get(feature);
    }
    
    public void setFeatureBounds(Feature feature, Rectangle bounds) {
        GraphicalEditPart featureEditPart = (GraphicalEditPart) getViewer().getEditPartRegistry().get(feature);
        setLayoutConstraint(featureEditPart, featureEditPart.getFigure(), bounds);
        modelLayout.getMapping().put(feature, bounds);
    }
    
    // ======================================================================
    //  IModelListener
    // ======================================================================
    
    @Override
    public void modelChanged(Notification notification) {
    }
    
}
