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
	
	// Returns all model children
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
	
	// Activate part, register itself as a model listener.
	@Override
	public void activate() {
		System.out.println("FeatureModelEditPart: activating");
		super.activate();
		ModelAdapter.addListener(getModel(), this);
	}
	
	// Deactivate part, unregister itself as a model listener.
	@Override
	public void deactivate() {
		System.out.println("FeatureModelEditPart: deactivating");
		ModelAdapter.removeListener(getModel(), this);
		super.deactivate();
	}
	
	// Return root figure.
	@Override
	protected IFigure createFigure() {
		System.out.println("FeatureModelEditPart: creating figure");
		IFigure figure = new FreeformLayer();
		figure.setBorder(new MarginBorder(3));
		figure.setLayoutManager(new FreeformLayout());
		return figure;
	}

	// Edit policies.
	@Override
	protected void createEditPolicies() {
		
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new XYLayoutEditPolicy() {
			// Called when adding new feature from palette 
			@Override
			protected Command getCreateCommand(CreateRequest request) {
				Object type = request.getNewObjectType();
				Rectangle bounds = (Rectangle) getConstraintFor(request);
				if (type == Feature.class)
					return new CreateFeatureCommand(getModel(), (Feature) request.getNewObject(), bounds, layoutStore);
				return null;
			}
			
			// Called when moving or resizing feature
			@Override
			protected Command createChangeConstraintCommand(ChangeBoundsRequest request, EditPart child, Object constraint) {
				return new MoveFeatureCommand(FeatureModelEditPart.this, (Feature) child.getModel(), (Rectangle) constraint, layoutStore);
			}
		});
	}

	// Returns name of a notification type.
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
	
	// Called when model changed.
	@Override
	public void modelChanged(Notification notification) {
		System.out.println("FeatureModelEditPart: model changed (" + getNotificationTypeName(notification) + ")");
		
		switch(notification.getEventType()) {
			// Feature/connection was added.
			case Notification.ADD:
				// Create edit part only for new features (not those wose parent was changed).
				Object addedObject = notification.getNewValue();
				if(getEditPartForModel(addedObject) == null) 
					addChild(createChild(addedObject), 0);
				break;
				
			// Feature/connection was removed.
			case Notification.REMOVE:
				Object removedObject = notification.getOldValue();
				// Remove edit part only for deleted features (not those wose parent was changed).
				if(removedObject instanceof Feature) {
					Feature feature = (Feature) removedObject;
					if((feature.getParent() == null) && !getModel().getOrphanedFeatures().contains(feature))
						removeChild(getEditPartForModel(removedObject));
				}
				else {
					removeChild(getEditPartForModel(removedObject));
				}
				break;
				
			// Ignore ADD_MANY, REMOVE_MANY - they are called only when feature parent is changed.
		}
		
	}
	
	public GraphicalEditPart getEditPartForModel(Object model) {
		return (GraphicalEditPart) getViewer().getEditPartRegistry().get(model);
	}

}
