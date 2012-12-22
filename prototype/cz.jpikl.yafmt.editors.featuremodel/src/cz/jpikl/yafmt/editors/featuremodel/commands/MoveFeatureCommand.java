package cz.jpikl.yafmt.editors.featuremodel.commands;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;

import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutFactory;
import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutStore;
import cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds;

public class MoveFeatureCommand extends Command {

	private GraphicalEditPart editPart;
	private Rectangle newBounds;
	private Rectangle oldBounds;
	private ModelLayoutStore layoutStore;

	public MoveFeatureCommand(GraphicalEditPart editPart, Rectangle newBounds, ModelLayoutStore layoutStore) {
		this.editPart = editPart;
		this.newBounds = newBounds;
		this.layoutStore = layoutStore;
	}
	
	private void applyBounds(Rectangle bounds) {
		GraphicalEditPart parentPart = (GraphicalEditPart) editPart.getParent();
		parentPart.setLayoutConstraint(editPart, editPart.getFigure(), bounds);
		
		ObjectBounds objectBounds = ModelLayoutFactory.eINSTANCE.createObjectBounds();
		objectBounds.setBounds(bounds);
		layoutStore.setObjectLayout((EObject) editPart.getModel(), objectBounds);
	}

	@Override
	public void execute() {
		oldBounds = new Rectangle(editPart.getFigure().getBounds());
		applyBounds(newBounds);
	}
	
	@Override
	public void undo() {
		applyBounds(oldBounds);
	}
	
}
