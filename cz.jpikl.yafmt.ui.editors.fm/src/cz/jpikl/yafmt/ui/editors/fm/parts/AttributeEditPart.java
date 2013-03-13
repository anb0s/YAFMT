package cz.jpikl.yafmt.ui.editors.fm.parts;

import static cz.jpikl.yafmt.model.fm.FeatureModelPackage.ATTRIBUTE__ID;
import static cz.jpikl.yafmt.model.fm.FeatureModelPackage.ATTRIBUTE__NAME;
import static cz.jpikl.yafmt.model.fm.FeatureModelPackage.ATTRIBUTE__TYPE;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.TextUtilities;
import org.eclipse.draw2d.geometry.Point;
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
import cz.jpikl.yafmt.model.validation.fm.FeatureModelValidator;
import cz.jpikl.yafmt.ui.directediting.ComboDirectEditManager;
import cz.jpikl.yafmt.ui.directediting.LabelDirectEditManager;
import cz.jpikl.yafmt.ui.editors.fm.figures.AttributeFigure;
import cz.jpikl.yafmt.ui.editors.fm.policies.AttributeDirectEditPolicy;
import cz.jpikl.yafmt.ui.editors.fm.policies.AttributeEditPolicy;
import cz.jpikl.yafmt.ui.editors.fm.util.AttributeTypeCellEditor;
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

    // ===================================================================
    //  Initialization
    // ===================================================================
    
    @Override
    public void activate() {
        super.activate();
        attribute.eAdapters().add(attributeAdapter);
        revalidateModel();
        refreshVisuals();
    }

    @Override
    public void deactivate() {
        problemStore.clearProblems(attribute);
        attribute.eAdapters().remove(attributeAdapter);
        super.deactivate();
    }
    
    // ===================================================================
    //  Visuals
    // ===================================================================

    @Override
    protected IFigure createFigure() {
        return new AttributeFigure(attribute);
    }
    
    public AttributeFigure getFigure() {
        return (AttributeFigure) super.getFigure();
    }
    
    @Override
    protected void refreshVisuals() {
        AttributeFigure figure = getFigure();
        figure.setErrors(problemStore.getProblems(attribute));
        figure.refresh();
    }
    
    // ===================================================================
    //  Model
    // ===================================================================
    
    private void revalidateModel() {
        problemStore.clearProblems(attribute);
        BasicDiagnostic diagnostic = new BasicDiagnostic();
        if(!FeatureModelValidator.INSTANCE.validate(attribute, diagnostic))
            problemStore.readProblems(diagnostic);
    }
    
    // ===================================================================
    //  Policies and requests
    // ===================================================================

    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.COMPONENT_ROLE, new AttributeEditPolicy());
        installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new AttributeDirectEditPolicy());
    }

    @Override
    public void performRequest(Request request) {
        if(REQ_OPEN.equals(request.getType()))
            performDirectEditing(((SelectionRequest) request).getLocation());
    }

    private void performDirectEditing(Point mouseLocation) {
        String attributeName = attribute.getName();
        AttributeType attributeType = attribute.getType();

        double scale = ((ScalableFreeformRootEditPart) getRoot()).getZoomManager().getZoom();
        Label label = ((AttributeFigure) getFigure());
        Rectangle labelBounds = label.getBounds().getCopy();
        label.translateToAbsolute(labelBounds);
        
        int attributeNameWidth = TextUtilities.INSTANCE.getStringExtents(attributeName + ": ", label.getFont()).width;
        int attributeTypeX = labelBounds.x + (int) (scale * attributeNameWidth);
        int mouseX = mouseLocation.x;

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
    
    // ===================================================================
    //  Events
    // ===================================================================

    protected class AttributeAdapter extends AdapterImpl {

        @Override
        public void notifyChanged(Notification msg) {
            switch(msg.getFeatureID(Attribute.class)) {
                case ATTRIBUTE__ID:
                case ATTRIBUTE__NAME:
                    revalidateModel();
                    refreshVisuals();
                    break;
                    
                case ATTRIBUTE__TYPE:
                    refreshVisuals();
                    break;
            }
        }
        
    }

}
