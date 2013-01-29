package cz.jpikl.yafmt.ui.editors.fm.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.jface.viewers.ICellEditorValidator;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModelPackage;
import cz.jpikl.yafmt.ui.editors.fm.figures.FeatureFigure;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;
import cz.jpikl.yafmt.ui.editors.fm.model.Connection;
import cz.jpikl.yafmt.ui.editors.fm.policies.ConnectionCreationPolicy;
import cz.jpikl.yafmt.ui.editors.fm.policies.FeatureDirectEditPolicy;
import cz.jpikl.yafmt.ui.editors.fm.policies.FeatureEditPolicy;
import cz.jpikl.yafmt.ui.editors.fm.util.LabelDirectEditManager;

public class FeatureEditPart extends AbstractGraphicalEditPart implements NodeEditPart {

    private Feature feature;
    private Adapter featureAdapter;
    private LayoutData layoutData;
    
    public FeatureEditPart(Feature feature, LayoutData layoutData) {
        this.feature = feature;
        this.featureAdapter = new FeatureAdapter();
        this.layoutData = layoutData;
        setModel(feature);
    }
        
    @Override
    public void activate() {
        super.activate();
        feature.eAdapters().add(featureAdapter);
        refresLayoutData();
    }
    
    @Override
    public void deactivate() {
        feature.eAdapters().remove(featureAdapter);
        super.deactivate();
    }

    @Override
    protected IFigure createFigure() {
        return new FeatureFigure(feature.getName());
    }
    
    @Override
    protected void refreshVisuals() {
        ((FeatureFigure) getFigure()).getLabel().setText(feature.getName());
    }
    
    public LayoutData getLayoutData() {
        return layoutData;
    }
    
    private void refresLayoutData() {
        Rectangle bounds = layoutData.getMapping().get(feature);
        if(bounds == null)
            bounds = new Rectangle(0, 0, FeatureFigure.WIDTH, FeatureFigure.HEGHT);
        layoutData.getMapping().put(feature, bounds);
    }
    
    @Override
    protected List<Object> getModelSourceConnections() {
        if(feature.isOrphan() || feature.isRoot())
            return null;
        
        List<Object> connections = new ArrayList<Object>();
        connections.add(new Connection(feature.getParent(), feature));
        return connections;
    }
    
    @Override
    protected List<Object> getModelTargetConnections() {
        if(feature.getFeatures().isEmpty())
            return null;
        
        List<Object> connections = new ArrayList<Object>();
        for(Feature child: feature.getFeatures())
            connections.add(new Connection(feature, child));
        return connections;
    }
    
    @Override
    public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
        return new ChopboxAnchor(getFigure());
    }

    @Override
    public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
        return new ChopboxAnchor(getFigure());
    }

    @Override
    public ConnectionAnchor getSourceConnectionAnchor(Request request) {
        return new ChopboxAnchor(getFigure());
    }

    @Override
    public ConnectionAnchor getTargetConnectionAnchor(Request request) {
        return new ChopboxAnchor(getFigure());
    }

    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.COMPONENT_ROLE, new FeatureEditPolicy());
        installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new FeatureDirectEditPolicy());
        installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ConnectionCreationPolicy());
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
    
    private static class DirectInputValidator implements ICellEditorValidator {
        
        @Override
        public String isValid(Object value) {
            if((value == null) || ("".equals(value)))
                return "Empty input"; // Not displayed anywhere.
            return null;
        }
        
    }
    
    private class FeatureAdapter extends AdapterImpl {
        
        @Override
        public void notifyChanged(Notification notification) {
            switch(notification.getFeatureID(Feature.class)) {
                case FeatureModelPackage.FEATURE__NAME:
                    ((FeatureFigure) getFigure()).getLabel().setText(notification.getNewStringValue());
                    break;
                    
                case FeatureModelPackage.FEATURE__PARENT_FEATURE:
                case FeatureModelPackage.FEATURE__PARENT_GROUP:
                    refreshSourceConnections();
                    break;
                    
                    
                case FeatureModelPackage.FEATURE__FEATURES:
                case FeatureModelPackage.FEATURE__GROUPS:
                    refreshTargetConnections();
                    break;
            }
        }
        
    }

}
