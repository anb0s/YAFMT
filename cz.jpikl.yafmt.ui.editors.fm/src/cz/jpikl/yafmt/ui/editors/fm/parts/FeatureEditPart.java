package cz.jpikl.yafmt.ui.editors.fm.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.jface.viewers.ICellEditorValidator;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.FeatureModelPackage;
import cz.jpikl.yafmt.model.util.ModelListener;
import cz.jpikl.yafmt.model.util.ModelListenerAdapter;
import cz.jpikl.yafmt.ui.editors.fm.figures.FeatureFigure;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutProvider;
import cz.jpikl.yafmt.ui.editors.fm.model.Connection;
import cz.jpikl.yafmt.ui.editors.fm.policies.FeatureConnectionEditPolicy;
import cz.jpikl.yafmt.ui.editors.fm.policies.FeatureDirectEditPolicy;
import cz.jpikl.yafmt.ui.editors.fm.policies.FeatureEditPolicy;
import cz.jpikl.yafmt.ui.editors.fm.util.LabelDirectEditManager;

public class FeatureEditPart extends AbstractGraphicalEditPart implements NodeEditPart, ModelListener {

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
        listenerAdapter.adapt(feature);
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
        LayoutProvider layoutProvider = (LayoutProvider) getParent();
        if(!layoutProvider.refreshObjectBounds(feature))
            layoutProvider.setObjectBounds(feature, new Rectangle(0, 0, 100, 25));
    }
    
    @Override
    protected List<Object> getModelSourceConnections() {
        EObject parent = feature.getParent();
        if((parent == null) || (parent instanceof FeatureModel))
            return null;
        
        List<Object> connections = new ArrayList<Object>();
        connections.add(new Connection(parent, feature));
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
        installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new FeatureConnectionEditPolicy());
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
        switch(notification.getEventType()) {
            case Notification.ADD:
            case Notification.ADD_MANY:
            case Notification.REMOVE:
            case Notification.REMOVE_MANY:
                refreshTargetConnections();
                break;
            
            case Notification.SET:
                switch(notification.getFeatureID(Feature.class)) {
                    case FeatureModelPackage.FEATURE__NAME:
                        ((FeatureFigure) getFigure()).getLabel().setText(notification.getNewStringValue());
                        break;
                        
                    case FeatureModelPackage.FEATURE__PARENT_FEATURE:
                    case FeatureModelPackage.FEATURE__PARENT_GROUP:
                        refreshSourceConnections();
                        break;
                }
                break;
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

}
