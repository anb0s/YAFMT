package cz.jpikl.yafmt.editors.featuremodel.parts;

import java.util.ArrayList;
import java.util.List;

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
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.requests.ReconnectRequest;

import cz.jpikl.yafmt.editors.featuremodel.commands.CreateConnectionCommand;
import cz.jpikl.yafmt.editors.featuremodel.commands.DeleteFeatureCommand;
import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutFactory;
import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutStore;
import cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds;
import cz.jpikl.yafmt.editors.featuremodel.utils.Connection;
import cz.jpikl.yafmt.editors.featuremodel.utils.ModelAdapter;
import cz.jpikl.yafmt.editors.featuremodel.utils.ModelListener;
import cz.jpikl.yafmt.models.featuremodel.Feature;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;

public class FeatureEditPart extends AbstractGraphicalEditPart implements ModelListener, NodeEditPart {

	private ModelLayoutStore layoutStore;
	
	public FeatureEditPart(Feature feature, ModelLayoutStore layoutStore) {
		System.out.println("FeatureEditPart: constructor");
		setModel(feature);
		this.layoutStore = layoutStore;
	}
	
	public Feature getModel() {
		return (Feature) super.getModel();
	}
	
	@Override
	protected List<Connection> getModelSourceConnections() {
		if(getModel().getParent() == null)
			return null;
		List<Connection> connections = new ArrayList<Connection>();
		connections.add(new Connection(getModel().getParent(), getModel()));
		return connections;
	}
	
	@Override
	protected List<Connection> getModelTargetConnections() {
		List<Connection> connections = new ArrayList<Connection>();
		for(Feature child: getModel().getChildren())
			connections.add(new Connection(getModel(), child));
		return connections;
	}
	
	@Override
	public void activate() {
		super.activate();
		ModelAdapter.addListener(getModel(), this);
	}
	
	@Override
	public void deactivate() {
		ModelAdapter.removeListener(getModel(), this);
		super.deactivate();
	}
	
	@Override
	protected IFigure createFigure() {
		System.out.println("FeatureEditPart: creating figure");
		Label figure = new Label(getModel().getName()); 
		figure.setBorder(new LineBorder());
		figure.setBackgroundColor(ColorConstants.white);
		return figure;
	}
	
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return new ChopboxAnchor(getFigure());
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return new ChopboxAnchor(getFigure());
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return new ChopboxAnchor(getFigure());
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return new ChopboxAnchor(getFigure());
	}
	
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
	
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy() {
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
			@Override
			protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
				request.setStartCommand(new CreateConnectionCommand(getModel()));
				return request.getStartCommand();
			}
			
			@Override
			protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
				CreateConnectionCommand command = (CreateConnectionCommand) request.getStartCommand();
				if(command.setDestination(getModel()))
					return command;
				return null;
			}		
			
			@Override
			protected Command getReconnectSourceCommand(ReconnectRequest request) {
				return null;
			}
			
			
			@Override
			protected Command getReconnectTargetCommand(ReconnectRequest request) {
				return null;
			}
		});
	}

	@Override
	public void modelChanged(Notification notification) {
		((ModelListener) getParent()).modelChanged(notification);
		refreshTargetConnections();
		refreshSourceConnections();
	}

}
