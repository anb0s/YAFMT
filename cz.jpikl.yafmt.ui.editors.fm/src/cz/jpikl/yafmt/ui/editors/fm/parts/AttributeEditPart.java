package cz.jpikl.yafmt.ui.editors.fm.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.TextUtilities;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.swt.SWT;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.AttributeType;
import cz.jpikl.yafmt.model.fm.FeatureModelPackage;
import cz.jpikl.yafmt.model.validation.fm.FeatureModelValidator;
import cz.jpikl.yafmt.ui.directediting.ComboDirectEditManager;
import cz.jpikl.yafmt.ui.directediting.LabelDirectEditManager;
import cz.jpikl.yafmt.ui.editors.fm.figures.AttributeFigure;
import cz.jpikl.yafmt.ui.editors.fm.policies.AttributeDirectEditPolicy;
import cz.jpikl.yafmt.ui.editors.fm.policies.AttributeEditPolicy;
import cz.jpikl.yafmt.ui.editors.fm.util.AttributeTypeCellEditor;
import cz.jpikl.yafmt.ui.figures.ErrorDecoration;
import cz.jpikl.yafmt.ui.figures.FigureDecorator;
import cz.jpikl.yafmt.ui.util.NonEmptyCellEditorValidator;
import cz.jpikl.yafmt.ui.validation.IProblemStore;

public class AttributeEditPart extends AbstractGraphicalEditPart {

    private Attribute attribute;
    private Adapter attributeAdapter;
    private IProblemStore problemStore;

    public AttributeEditPart(Attribute attribute, IProblemStore problemStore) {
        this.attribute = attribute;
        this.attributeAdapter = new AttributeAdapter();
        this.problemStore = problemStore;
        setModel(attribute);
    }

    @Override
    public void activate() {
        super.activate();
        attribute.eAdapters().add(attributeAdapter);
    }

    @Override
    public void deactivate() {
        attribute.eAdapters().remove(attributeAdapter);
        super.deactivate();
    }

    private void revalidateModel() {
        problemStore.clearProblems(attribute);
        BasicDiagnostic diagnostic = new BasicDiagnostic();
        if(!FeatureModelValidator.INSTANCE.validate(attribute, diagnostic))
            problemStore.readProblems(diagnostic);
        getErrorDecoration().setErrors(problemStore.getProblems(attribute));
    }
    
    @Override
    protected IFigure createFigure() {
        FigureDecorator figure = new FigureDecorator(new AttributeFigure(attribute), 0);
        figure.addDecoration(new ErrorDecoration(problemStore.getProblems(attribute)));
        return figure;
    }
    
    private AttributeFigure getAttributeFigure() {
        return (AttributeFigure) ((FigureDecorator) getFigure()).getFigure();
    }
    
    private ErrorDecoration getErrorDecoration() {
        return (ErrorDecoration) ((FigureDecorator) getFigure()).getDecorations().get(0);
    }

    @Override
    protected void refreshVisuals() {
        getAttributeFigure().refresh(); // Called when direct edit input is cancelled.
        getErrorDecoration().setErrors(problemStore.getProblems(attribute));
    }

    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.COMPONENT_ROLE, new AttributeEditPolicy());
        installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new AttributeDirectEditPolicy());
    }

    @Override
    public void performRequest(Request request) {
        if(REQ_OPEN.equals(request.getType())) {
            String attributeName = attribute.getName();
            AttributeType attributeType = attribute.getType();

            double scale = ((ScalableFreeformRootEditPart) getRoot()).getZoomManager().getZoom();
            Label label = ((AttributeFigure) getFigure());
            Rectangle labelBounds = label.getBounds().getCopy();
            label.translateToAbsolute(labelBounds);
            
            int attributeNameWidth = TextUtilities.INSTANCE.getStringExtents(attributeName + ": ", label.getFont()).width;
            int attributeTypeX = labelBounds.x + (int) (scale * attributeNameWidth);
            int mouseX = ((SelectionRequest) request).getLocation().x;

            // Name direct edit
            if(mouseX <= attributeTypeX) {
                LabelDirectEditManager manager = new LabelDirectEditManager(this, label, attributeName);
                manager.setValidator(new NonEmptyCellEditorValidator());
                manager.setAlignment(SWT.LEFT | SWT.CENTER);
                manager.show();
            }
            // Type direct edit.
            else {
                ComboDirectEditManager manager = new ComboDirectEditManager(this, AttributeTypeCellEditor.class, label, attributeType);
                manager.setAlignment(SWT.LEFT | SWT.CENTER);
                manager.setXOffset(attributeNameWidth); // Offset must not be scaled
                manager.show();
            }
        }
    }

    private class AttributeAdapter extends AdapterImpl {

        @Override
        public void notifyChanged(Notification notification) {
            switch(notification.getFeatureID(Attribute.class)) {
                case FeatureModelPackage.ATTRIBUTE__NAME:
                case FeatureModelPackage.ATTRIBUTE__TYPE:
                    refreshVisuals();
            }
            
            // Revalidate model when basic properties change.
            revalidateModel();
        }

    }

}
