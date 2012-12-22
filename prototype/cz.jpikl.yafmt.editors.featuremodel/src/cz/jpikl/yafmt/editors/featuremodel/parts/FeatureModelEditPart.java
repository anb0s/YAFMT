package cz.jpikl.yafmt.editors.featuremodel.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import cz.jpikl.yafmt.editors.featuremodel.commands.MoveFeatureCommand;
import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutStore;
import cz.jpikl.yafmt.editors.featuremodel.utils.ModelAdapter;
import cz.jpikl.yafmt.editors.featuremodel.utils.ModelListener;
import cz.jpikl.yafmt.models.featuremodel.Feature;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;

public class FeatureModelEditPart extends AbstractGraphicalEditPart implements ModelListener {

	private ModelLayoutStore layoutStore;
	
	public FeatureModelEditPart(FeatureModel model, ModelLayoutStore layoutStore) {
		System.out.println("FeatureModelEditPart: constructor");
		setModel(model);
		this.layoutStore = layoutStore; 
	}
	
	public FeatureModel getModel() {
		return (FeatureModel) super.getModel();
	}
	
	@Override
	protected List<Object> getModelChildren() {
		System.out.println("FeatureModelEditPart: getting model children");
		List<Object> children = new ArrayList<Object>();
		TreeIterator<EObject> it = getModel().eAllContents();
		while(it.hasNext()) {
			EObject obj = it.next();
			if(obj instanceof Feature)
				children.add(obj);
		}
		return children;
	}
	
	@Override
	public void activate() {
		System.out.println("FeatureModelEditPart: activating");
		super.activate();
		ModelAdapter.addListener(getModel(), this);
	}
	
	@Override
	public void deactivate() {
		System.out.println("FeatureModelEditPart: deactivating");
		ModelAdapter.removeListener(getModel(), this);
		super.deactivate();
	}
	
	@Override
	protected IFigure createFigure() {
		System.out.println("FeatureModelEditPart: creating figure");
		IFigure figure = new FreeformLayer();
		figure.setBorder(new MarginBorder(3));
		figure.setLayoutManager(new FreeformLayout());
		return figure;
	}

	@Override
	protected void createEditPolicies() {
		
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new XYLayoutEditPolicy() {
			
			@Override
			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
			
			@Override
			protected Command createChangeConstraintCommand(EditPart child, Object constraint) {
				return new MoveFeatureCommand((GraphicalEditPart) child, (Rectangle) constraint, layoutStore);
			}

		});
	}

	@Override
	public void modelChanged(Notification notification) {
		System.out.println("FeatureModelEditPart: model changed (" + notification.getEventType() + ")");
	}

}
