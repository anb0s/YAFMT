package cz.jpikl.yafmt.ui.editors.fm.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.model.util.IModelListener;
import cz.jpikl.yafmt.model.util.ModelListenerAdapter;
import cz.jpikl.yafmt.ui.editors.fm.figures.GroupFigure;
import cz.jpikl.yafmt.ui.editors.fm.figures.MiddlePointAnchor;
import cz.jpikl.yafmt.ui.editors.fm.layout.IModelLayoutProvider;
import cz.jpikl.yafmt.ui.editors.fm.model.Connection;

public class GroupEditPart extends AbstractGraphicalEditPart implements NodeEditPart, IModelListener {

    private static final int SIZE = 40;
    
    private Group group;
    private ModelListenerAdapter listenerAdapter = new ModelListenerAdapter(this);
    private boolean firstRefresh;
    
    public GroupEditPart(Group group) {
        this.group = group;
        this.firstRefresh = true;
        setModel(group);
    }
    
    @Override
    public void activate() {
        super.activate();
        listenerAdapter.connect(group);
    }
    
    @Override
    public void deactivate() {
        listenerAdapter.dispose();
        super.deactivate();
    }
    
    @Override
    protected IFigure createFigure() {
        return new GroupFigure();
    }
    
    @Override
    protected void refreshVisuals() {
        if(firstRefresh) {
            loadModelLayout();
            firstRefresh = false;
        }
    }
        
    private void loadModelLayout() {
        IModelLayoutProvider layoutProvider = (IModelLayoutProvider) getParent();
        Rectangle bounds = layoutProvider.getObjectBounds(group);
        if(bounds == null) {
            Rectangle parentBounds = layoutProvider.getObjectBounds(group.getParent());
            if(parentBounds == null) {
                bounds = new Rectangle(50 - SIZE / 2, 25 - SIZE / 2, SIZE, SIZE);
            }
            else {
                int x = parentBounds.x + (parentBounds.width - SIZE) / 2;
                int y = parentBounds.y + parentBounds.height - (SIZE / 2);
                bounds = new Rectangle(x, y, SIZE, SIZE);
            }
        }
        layoutProvider.setObjectBounds(group, bounds);
    }

    @Override
    protected List<Object> getModelTargetConnections() {
        if(group.getFeatures().isEmpty())
            return null;
        
        List<Object> connections = new ArrayList<Object>();
        for(Feature child: group.getFeatures())
            connections.add(new Connection(group, child));
        return connections;
    }
    
    @Override
    public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
        //return new EllipseAnchor(getFigure());
        return new MiddlePointAnchor(getFigure());
    }

    @Override
    public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
        return new MiddlePointAnchor(getFigure());
    }

    @Override
    public ConnectionAnchor getSourceConnectionAnchor(Request request) {
        return new MiddlePointAnchor(getFigure());
    }

    @Override
    public ConnectionAnchor getTargetConnectionAnchor(Request request) {
        return new MiddlePointAnchor(getFigure());
    }

    @Override
    protected void createEditPolicies() {
    }

    @Override
    public void modelChanged(Notification notification) {
        switch(notification.getEventType()) {
            case Notification.ADD:
            case Notification.ADD_MANY:
            case Notification.REMOVE:
            case Notification.REMOVE_MANY:
                refreshTargetConnections();
                break;
        }
    }

}
