package cz.jpikl.yafmt.ui.editors.fm.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.jface.viewers.ICellEditorValidator;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModelPackage;
import cz.jpikl.yafmt.model.util.IModelListener;
import cz.jpikl.yafmt.model.util.ModelListenerAdapter;
import cz.jpikl.yafmt.ui.editors.fm.figures.FeatureFigure;
import cz.jpikl.yafmt.ui.editors.fm.layout.IModelLayoutProvider;
import cz.jpikl.yafmt.ui.editors.fm.policies.FeatureDirectEditPolicy;
import cz.jpikl.yafmt.ui.editors.fm.policies.FeatureEditPolicy;
import cz.jpikl.yafmt.ui.editors.fm.util.LabelDirectEditManager;

public class FeatureEditPart extends AbstractGraphicalEditPart implements IModelListener {

    private Feature feature;
    private ModelListenerAdapter listenerAdapter;
    private boolean firstRefresh;
    
    public FeatureEditPart(Feature feature) {
        this.feature = feature;
        this.listenerAdapter = new ModelListenerAdapter(this);
        this.firstRefresh = true;
        setModel(feature);
    }
    
    @Override
    public void activate() {
        super.activate();
        listenerAdapter.connect(feature);
    }
    
    @Override
    public void deactivate() {
        listenerAdapter.dispose();
        super.deactivate();
    }

    @Override
    protected IFigure createFigure() {
        return new FeatureFigure(feature.getName());
    }
    
    @Override
    protected void refreshVisuals() {
        ((FeatureFigure) getFigure()).getLabel().setText(feature.getName());
        
        if(firstRefresh) {
            loadModelLayout();
            firstRefresh = false;
        }
    }
    
    private void loadModelLayout() {
        IModelLayoutProvider layoutProvider = (IModelLayoutProvider) getParent();
        Rectangle bounds = layoutProvider.getObjectBounds(feature);
        if(bounds == null)
            bounds = new Rectangle(0, 0, 100, 25);
        layoutProvider.setObjectBounds(feature, bounds);
    }

    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.COMPONENT_ROLE, new FeatureEditPolicy());
        installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new FeatureDirectEditPolicy());
    }
    
    @Override
    public void performRequest(Request request) {
        if(REQ_OPEN.equals(request.getType())) {
            Label label = ((FeatureFigure) getFigure()).getLabel();
            LabelDirectEditManager manager = new LabelDirectEditManager(this, label);
            manager.setValidator(new DirectInputValidator());
            manager.show();
        }
    }

    @Override
    public void modelChanged(Notification notification) {
        if(notification.getFeatureID(Feature.class) == FeatureModelPackage.FEATURE__NAME)
           ((FeatureFigure) getFigure()).getLabel().setText(notification.getNewStringValue());
    }
    
    private static class DirectInputValidator implements ICellEditorValidator {
        
        @Override
        public String isValid(Object value) {
            if((value == null) || ("".equals(value)))
                return "Empty input"; // Not displayed anywhere.
            return null;
        }
        
    }

}
