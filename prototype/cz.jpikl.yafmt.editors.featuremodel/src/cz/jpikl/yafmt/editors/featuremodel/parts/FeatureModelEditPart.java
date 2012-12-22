package cz.jpikl.yafmt.editors.featuremodel.parts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import cz.jpikl.yafmt.editors.featuremodel.commands.CreateFeatureCommand;
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
				Object type = request.getNewObjectType();
				Rectangle bounds = (Rectangle) getConstraintFor(request);
				if (type == Feature.class)
					return new CreateFeatureCommand(getModel(), (Feature) request.getNewObject(), bounds, layoutStore);
				return null;
			}
			
			@Override
			protected Command createChangeConstraintCommand(ChangeBoundsRequest request, EditPart child, Object constraint) {
				return new MoveFeatureCommand((GraphicalEditPart) child, (Rectangle) constraint, layoutStore);
			}
		});
	}

	private String getNotificationTypeName(Notification notification) {
		switch(notification.getEventType()) {
			case Notification.SET: return "SET";
			case Notification.UNSET: return "UNSET";
			case Notification.ADD: return "ADD";
			case Notification.REMOVE: return "REMOVE";
			case Notification.ADD_MANY: return "ADD_MANY";
			case Notification.REMOVE_MANY: return "REMOVE_MANY";
			case Notification.MOVE: return "MOVE";
			case Notification.REMOVING_ADAPTER: return "REMOVING_ADAPTER";
			case Notification.RESOLVE: return "RESOLVE";
			case Notification.EVENT_TYPE_COUNT: return "EVENT_TYPE_COUNT";
			default: return "?";
		}
	}
	
	@Override
	public void modelChanged(Notification notification) {
		System.out.println("FeatureModelEditPart: model changed (" + getNotificationTypeName(notification) + ")");
		
		switch(notification.getEventType()) {
			case Notification.ADD:
				Object addedObject = notification.getNewValue();
				addChild(createChild(addedObject), 0);
				break;
				
			case Notification.REMOVE:
				Object removedObject = notification.getOldValue();
				@SuppressWarnings("unchecked")
				Map<Object, EditPart> partRegistry = getViewer().getEditPartRegistry();
				removeChild(partRegistry.get(removedObject));				
				break;
		}
	}

}
