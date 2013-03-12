package cz.jpikl.yafmt.ui.editors.fm.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.swt.SWT;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.FeatureModelPackage;
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
import cz.jpikl.yafmt.ui.figures.ErrorDecoration;
import cz.jpikl.yafmt.ui.figures.FigureDecorator;
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

    @Override
    public void activate() {
        super.activate();
        feature.eAdapters().add(featureAdapter);
        refreshLayoutData();
    }

    @Override
    public void deactivate() {
        feature.eAdapters().remove(featureAdapter);
        super.deactivate();
    }
    
    private void revalidateModel(boolean recursive) {
        problemStore.clearProblems(feature);
        if(recursive) {
            for(Attribute attribute: feature.getAttributes())
                problemStore.clearProblems(attribute);
        }
        BasicDiagnostic diagnostic = new BasicDiagnostic();
        if(!FeatureModelValidator.INSTANCE.validate(feature, diagnostic, recursive))
            problemStore.readProblems(diagnostic);
        getErrorDecoration().setErrors(problemStore.getProblems(feature));
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

    @Override
    protected IFigure createFigure() {
        FigureDecorator figure = new FigureDecorator(new FeatureFigure(feature));
        figure.addDecoration(new ErrorDecoration(problemStore.getProblems(feature)));
        return figure;
    }

    public FeatureFigure getFeatureFigure() {
        return (FeatureFigure) ((FigureDecorator) getFigure()).getFigure();
    }
    
    private ErrorDecoration getErrorDecoration() {
        return (ErrorDecoration) ((FigureDecorator) getFigure()).getDecorations().get(0);
    }
    
    @Override
    protected void refreshVisuals() {
        getFeatureFigure().refresh(); // Called when direct edit input is cancelled.
    }

    public LayoutData getLayoutData() {
        return layoutData;
    }

    private void refreshLayoutData() {
        Rectangle bounds = layoutData.get(feature);
        if(bounds == null)
            bounds = new Rectangle(0, 0, FeatureFigure.WIDTH, FeatureFigure.HEGHT);
        layoutData.set(feature, bounds);
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

    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.COMPONENT_ROLE, new FeatureEditPolicy());
        installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new FeatureDirectEditPolicy());
        installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ConnectionCreationPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, new FeatureLayoutPolicy());
    }

    @Override
    public void performRequest(Request request) {
        if(REQ_OPEN.equals(request.getType())) {
            Label label = ((FeatureFigure) getFigure()).getLabel();
            LabelDirectEditManager manager = new LabelDirectEditManager(this, label);
            manager.setValidator(new NonEmptyCellEditorValidator());
            manager.setAlignment(SWT.CENTER);
            manager.show();
        }
    }
    
    private class FeatureAdapter extends AdapterImpl {

        @Override
        public void notifyChanged(Notification notification) {

            switch(notification.getFeatureID(Feature.class)) {
                case FeatureModelPackage.FEATURE__NAME:
                case FeatureModelPackage.FEATURE__ID:
                case FeatureModelPackage.FEATURE__DESCRIPTION:
                    revalidateModel(false);
                    refreshVisuals();
                    break;
                    
                case FeatureModelPackage.FEATURE__LOWER:
                case FeatureModelPackage.FEATURE__UPPER:
                    revalidateModel(false);
                    break;

                case FeatureModelPackage.FEATURE__PARENT_FEATURE:
                case FeatureModelPackage.FEATURE__PARENT_GROUP:
                    refreshSourceConnections();
                    break;

                case FeatureModelPackage.FEATURE__FEATURES:
                case FeatureModelPackage.FEATURE__GROUPS:
                    refreshTargetConnections();
                    break;

                case FeatureModelPackage.FEATURE__ATTRIBUTES:
                    switch(notification.getEventType()) {
                        case Notification.ADD:
                        case Notification.REMOVE:
                        case Notification.MOVE:
                            revalidateModel(true);
                            refreshChildren();
                            break;
                    }
            }
            
        }

    }

}
