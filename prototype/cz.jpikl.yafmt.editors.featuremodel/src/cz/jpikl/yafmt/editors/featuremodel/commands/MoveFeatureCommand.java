package cz.jpikl.yafmt.editors.featuremodel.commands;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;

import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutFactory;
import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutStore;
import cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds;
import cz.jpikl.yafmt.editors.featuremodel.parts.FeatureModelEditPart;
import cz.jpikl.yafmt.models.featuremodel.Feature;

public class MoveFeatureCommand extends Command {

    private FeatureModelEditPart modelPart;
    private Feature feature;
    private Rectangle newBounds;
    private Rectangle oldBounds;
    private ModelLayoutStore layoutStore;

    public MoveFeatureCommand(FeatureModelEditPart modelPart, Feature feature, Rectangle newBounds, ModelLayoutStore layoutStore) {
        this.modelPart = modelPart;
        this.feature = feature;
        this.newBounds = newBounds;
        this.layoutStore = layoutStore;
    }

    private void applyBounds(Rectangle bounds) {
        GraphicalEditPart editPart = modelPart.getEditPartForModel(feature);
        modelPart.setLayoutConstraint(editPart, editPart.getFigure(), bounds);

        ObjectBounds objectBounds = ModelLayoutFactory.eINSTANCE.createObjectBounds();
        objectBounds.setBounds(bounds);
        layoutStore.setObjectLayout((EObject) editPart.getModel(), objectBounds);
    }

    @Override
    public void execute() {
        GraphicalEditPart editPart = modelPart.getEditPartForModel(feature);
        oldBounds = new Rectangle(editPart.getFigure().getBounds());
        applyBounds(newBounds);
    }

    @Override
    public void undo() {
        applyBounds(oldBounds);
    }

}
