package cz.jpikl.yafmt.ui.editors.fm.parts;

import static cz.jpikl.yafmt.model.fm.FeatureModelPackage.ATTRIBUTE__ID;
import static cz.jpikl.yafmt.model.fm.FeatureModelPackage.FEATURE__ATTRIBUTES;
import static cz.jpikl.yafmt.model.fm.FeatureModelPackage.FEATURE__FEATURES;
import static cz.jpikl.yafmt.model.fm.FeatureModelPackage.FEATURE__GROUPS;
import static cz.jpikl.yafmt.model.fm.FeatureModelPackage.FEATURE__LOWER;
import static cz.jpikl.yafmt.model.fm.FeatureModelPackage.FEATURE__NAME;
import static cz.jpikl.yafmt.model.fm.FeatureModelPackage.FEATURE__PARENT_FEATURE;
import static cz.jpikl.yafmt.model.fm.FeatureModelPackage.FEATURE__PARENT_GROUP;
import static cz.jpikl.yafmt.model.fm.FeatureModelPackage.FEATURE__UPPER;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.swt.SWT;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.validation.fm.FeatureModelValidator;
import cz.jpikl.yafmt.ui.directediting.LabelDirectEditManager;
import cz.jpikl.yafmt.ui.editors.fm.figures.FeatureFigure;
import cz.jpikl.yafmt.ui.editors.fm.figures.ShrinkedChopboxAnchor;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;
import cz.jpikl.yafmt.ui.editors.fm.model.Connection;
import cz.jpikl.yafmt.ui.editors.fm.policies.ConnectionCreationPolicy;
import cz.jpikl.yafmt.ui.editors.fm.policies.FeatureDirectEditPolicy;
import cz.jpikl.yafmt.ui.editors.fm.policies.FeatureEditPolicy;
import cz.jpikl.yafmt.ui.editors.fm.policies.FeatureLayoutPolicy;
import cz.jpikl.yafmt.ui.util.NonEmptyCellEditorValidator;
import cz.jpikl.yafmt.ui.validation.IProblemStore;

public class FeatureEditPart extends AbstractGraphicalEditPart implements NodeEditPart {

    private Feature feature;
    private Adapter featureAdapter;
    private LayoutData layoutData;
    private IProblemStore problemStore;

    public FeatureEditPart(Feature feature, LayoutData layoutData, IProblemStore problemStore) {
        this.feature = feature;
        this.featureAdapter = new FeatureAdapter();
        this.layoutData = layoutData;
        this.problemStore = problemStore;
        setModel(feature);
    }
    
    // ===================================================================
    //  Initialization
    // ===================================================================

    @Override
    public void activate() {
        super.activate();
        feature.eAdapters().add(featureAdapter);
        revalidateModelRecursive();
        refreshLayoutData();
        refreshVisuals();
    }

    @Override
    public void deactivate() {
        feature.eAdapters().remove(featureAdapter);
        super.deactivate();
    }
    
    // ===================================================================
    //  Visuals
    // ===================================================================
    
    @Override
    protected IFigure createFigure() {
        return new FeatureFigure(feature);
    }

    public FeatureFigure getFeatureFigure() {
        return (FeatureFigure) super.getFigure();
    }
    
    @Override
    protected void refreshVisuals() {
        FeatureFigure figure = getFeatureFigure();
        figure.setErrors(problemStore.getProblems(feature));
        figure.refresh();
    }
    
    protected void refreshVisualsRecursive() {
        refreshVisuals();
        for(Object child: getChildren())
            ((EditPart) child).refresh();
    }
    
    @Override
    public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
        return new ShrinkedChopboxAnchor(getFigure(), 1);
    }

    @Override
    public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
        return new ShrinkedChopboxAnchor(getFigure(), 1);
    }

    @Override
    public ConnectionAnchor getSourceConnectionAnchor(Request request) {
        return new ShrinkedChopboxAnchor(getFigure(), 1);
    }

    @Override
    public ConnectionAnchor getTargetConnectionAnchor(Request request) {
        return new ShrinkedChopboxAnchor(getFigure(), 1);
    }
    
    // ===================================================================
    //  Layout
    // ===================================================================
    
    public LayoutData getLayoutData() {
        return layoutData;
    }

    private void refreshLayoutData() {
        Rectangle bounds = layoutData.get(feature);
        if(bounds == null)
            bounds = createInitialLayoutData();
        layoutData.set(feature, bounds);
    }
    
    private Rectangle createInitialLayoutData() {
        return new Rectangle(0, 0, FeatureFigure.INITIAL_WIDTH, FeatureFigure.INITIAL_HEGHT);
    }
    
    // ===================================================================
    //  Model
    // ===================================================================
    
    private void revalidateModel() {
        problemStore.clearProblems(feature);
        BasicDiagnostic diagnostic = new BasicDiagnostic();
        if(!FeatureModelValidator.INSTANCE.validate(feature, diagnostic))
            problemStore.readProblems(diagnostic);
    }
    
    private void revalidateModelRecursive() {
        problemStore.clearProblems(feature);
        for(Attribute attribute: feature.getAttributes())
            problemStore.clearProblems(attribute);
        BasicDiagnostic diagnostic = new BasicDiagnostic();
        if(!FeatureModelValidator.INSTANCE.validateRecursive(feature, diagnostic))
            problemStore.readProblems(diagnostic);
    }

    @Override
    protected List<?> getModelChildren() {
        return feature.getAttributes();
    }

    @Override
    protected List<Object> getModelSourceConnections() {
        EObject parent = feature.getParent();
        if((parent == null) || (parent instanceof FeatureModel))
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

    // ===================================================================
    //  Policies and requests
    // ===================================================================

    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.COMPONENT_ROLE, new FeatureEditPolicy());
        installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new FeatureDirectEditPolicy());
        installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ConnectionCreationPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, new FeatureLayoutPolicy());
    }

    @Override
    public void performRequest(Request request) {
        if(REQ_OPEN.equals(request.getType()))
            performDirectEditing();
    }

    private void performDirectEditing() {
        Label label = ((FeatureFigure) getFigure()).getLabel();
        LabelDirectEditManager manager = new LabelDirectEditManager(this, label);
        manager.setValidator(new NonEmptyCellEditorValidator());
        manager.setAlignment(SWT.CENTER);
        manager.show();
    }
    
    // ===================================================================
    //  Events
    // ===================================================================
    
    private class FeatureAdapter extends EContentAdapter {

        @Override
        protected void addAdapter(Notifier notifier) {
            // Listen only to feature attributes.
            if(notifier instanceof Attribute)
                super.addAdapter(notifier);
        }
        
        @Override
        public void notifyChanged(Notification msg) {
            if(msg.getNotifier() instanceof Feature)
                notifyChangedFromFeature(msg);
            else
                notifyChangedFromAttribute(msg);            
        }

        private void notifyChangedFromFeature(Notification msg) {
            switch(msg.getFeatureID(Feature.class)) {
                case FEATURE__NAME:
                case FEATURE__LOWER:
                case FEATURE__UPPER:
                    revalidateModel();
                    refreshVisuals();
                    break;

                case FEATURE__PARENT_FEATURE:
                case FEATURE__PARENT_GROUP:
                    refreshSourceConnections();
                    break;

                case FEATURE__FEATURES:
                case FEATURE__GROUPS:
                    refreshTargetConnections();
                    break;
                
                case FEATURE__ATTRIBUTES:
                    revalidateModelRecursive();
                    refreshChildren();
                    break;
            }
        }

        private void notifyChangedFromAttribute(Notification msg) {
            switch(msg.getFeatureID(Attribute.class)) {
                case ATTRIBUTE__ID:
                    revalidateModelRecursive();
                    refreshVisualsRecursive();
                    break;
            }
        }

    }

}
