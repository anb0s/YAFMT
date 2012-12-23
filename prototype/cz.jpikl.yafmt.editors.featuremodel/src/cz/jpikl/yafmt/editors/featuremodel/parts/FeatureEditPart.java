package cz.jpikl.yafmt.editors.featuremodel.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.ui.views.properties.IPropertySource;

import cz.jpikl.yafmt.editors.featuremodel.commands.CreateConnectionCommand;
import cz.jpikl.yafmt.editors.featuremodel.commands.DeleteFeatureCommand;
import cz.jpikl.yafmt.editors.featuremodel.commands.RenameFeatureCommand;
import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutFactory;
import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutStore;
import cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds;
import cz.jpikl.yafmt.editors.featuremodel.utils.Connection;
import cz.jpikl.yafmt.editors.featuremodel.utils.LabelDirectEditManager;
import cz.jpikl.yafmt.editors.featuremodel.utils.UnwrappingPropertySource;
import cz.jpikl.yafmt.models.featuremodel.Feature;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;
import cz.jpikl.yafmt.models.featuremodel.provider.util.FeatureModelProviderUtil;
import cz.jpikl.yafmt.models.utils.ModelAdapter;
import cz.jpikl.yafmt.models.utils.ModelListener;

public class FeatureEditPart extends AbstractGraphicalEditPart implements ModelListener, NodeEditPart, IAdaptable {
	
	private IPropertySource propertySource;
	private ModelLayoutStore layoutStore;
	private ModelAdapter modelAdapter;
	
	public FeatureEditPart(Feature feature, ModelLayoutStore layoutStore) {
		System.out.println("FeatureEditPart: constructor");
		setModel(feature);
		this.propertySource = new UnwrappingPropertySource(feature, FeatureModelProviderUtil.getFeatureItemProvider());
		this.layoutStore = layoutStore;
		this.modelAdapter = new ModelAdapter(this);
	}
	
	public Feature getModel() {
		return (Feature) super.getModel();
	}
	
	// Returns connection to parent feature.
	@Override
	protected List<Connection> getModelSourceConnections() {
		if(getModel().getParent() == null)
			return null;
		List<Connection> connections = new ArrayList<Connection>();
		connections.add(new Connection(getModel().getParent(), getModel()));
		return connections;
	}
	
	// Returns connections to all children features.
	@Override
	protected List<Connection> getModelTargetConnections() {
		List<Connection> connections = new ArrayList<Connection>();
		for(Feature child: getModel().getChildren())
			connections.add(new Connection(getModel(), child));
		return connections;
	}
	
	// Activate part, register itself as a model listener.
	@Override
	public void activate() {
		super.activate();
		modelAdapter.connect(getModel());
	}
	
	// Deactivate part, unregister itself as a model listener.
	@Override
	public void deactivate() {
		modelAdapter.disconnectFromAll();
		super.deactivate();
	}
	
	// Create feature figure.
	@Override
	protected IFigure createFigure() {
		System.out.println("FeatureEditPart: creating figure");
		Label figure = new Label(getModel().getName()); 
		figure.setBorder(new LineBorder());
		figure.setBackgroundColor(ColorConstants.white);
		figure.setOpaque(true);
		return figure;
	}
	
	// Returns source connection anchor object.
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return new ChopboxAnchor(getFigure());
	}

	// Returns target connection anchor object.
	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return new ChopboxAnchor(getFigure());
	}

	// Returns source connection anchor object (called when creating connection between features).
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return new ChopboxAnchor(getFigure());
	}

	// Returns target connection anchor object (called when creating connection between features).
	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return new ChopboxAnchor(getFigure());
	}
	
	// Restore features position and size from model layout.
	@Override
	protected void refreshVisuals() {
		System.out.println("FeatureEditPart: refreshing visuals");
		GraphicalEditPart editPart = (GraphicalEditPart) getParent();
		
		ObjectBounds bounds = (ObjectBounds) layoutStore.getObjectLayout(getModel());
		if(bounds != null) {
			editPart.setLayoutConstraint(this, getFigure(), bounds.getBounds());
		}
		else {
			editPart.setLayoutConstraint(this, getFigure(), new Rectangle(0, 0, 100, 25));
			bounds = ModelLayoutFactory.eINSTANCE.createObjectBounds();
			bounds.setBounds(new Rectangle(0, 0, 100, 25));
			layoutStore.setObjectLayout(getModel(), bounds);
		}
		
		super.refreshVisuals();
	}
	
	// Edit policies.
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy() {
			// Called when deleting feature
			@Override
			protected Command createDeleteCommand(GroupRequest deleteRequest) {
				Feature feature = getModel();
				FeatureModel featureModel = (FeatureModel) getParent().getModel();
				if(feature == featureModel.getRootFeature())
					return null;
				return new DeleteFeatureCommand(featureModel, feature);
			}
		});
		
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new GraphicalNodeEditPolicy() {
			// Called when starting connecting features (user clicked on source feature).
			@Override
			protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
				request.setStartCommand(new CreateConnectionCommand(getModel()));
				return request.getStartCommand();
			}
			
			// Called when finishing connecting features (user clicked on destination feature).
			@Override
			protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
				CreateConnectionCommand command = (CreateConnectionCommand) request.getStartCommand();
				if(command.setDestination(getModel()))
					return command;
				return null;
			}		
			
			// Called when reconnecting source feature of a connection (not used).
			@Override
			protected Command getReconnectSourceCommand(ReconnectRequest request) {
				return null;
			}
			
			// Called when reconnecting destination feature of a connection (not used).
			@Override
			protected Command getReconnectTargetCommand(ReconnectRequest request) {
				return null;
			}
		});
		
		// Direct editing of feature name.
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new DirectEditPolicy() {
			// Called when renaming of feature is done (user confirmed input).
			@Override
			protected Command getDirectEditCommand(DirectEditRequest request) {
				System.out.println("Get direct edit command");
				return new RenameFeatureCommand(getModel(), (String) request.getCellEditor().getValue());
			}
			
			// Updates figure label text during editing.
			@Override
			protected void showCurrentEditValue(DirectEditRequest request) {
				System.out.println("Show current edit value");
				((Label) getFigure()).setText((String) request.getCellEditor().getValue());
			}
		});
	}
		
	// Custom requests.
	@Override
	public void performRequest(Request request) {
		// REQ_OPEN is send when user double-clicked on edit part figure.
		if(request.getType() == RequestConstants.REQ_OPEN) {
			// Handle direct edit request - initialize and show direct edit manager.
			DirectEditManager manager = new LabelDirectEditManager(this, (Label) getFigure());
			manager.show();
		}
	}
	
	// Notify root edit part and refresh all connections.
	@Override
	public void modelChanged(Notification notification) {
		switch(notification.getEventType()) {
			case Notification.ADD:
			case Notification.ADD_MANY:
			case Notification.REMOVE:
			case Notification.REMOVE_MANY:
				// Notify root edit part.
				if(getParent() != null)
					((ModelListener) getParent()).modelChanged(notification);
				break;
				
			case Notification.SET:
			case Notification.UNSET:
				// Update label (name change).
				((Label) getFigure()).setText(getModel().getName());
				break;
		}
		
		// Refresh connections.
		if(getParent() != null) {
			refreshTargetConnections();
			refreshSourceConnections();
		}
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class key) {
		if(key == IPropertySource.class)
			return propertySource;
		return super.getAdapter(key);
	}

}
