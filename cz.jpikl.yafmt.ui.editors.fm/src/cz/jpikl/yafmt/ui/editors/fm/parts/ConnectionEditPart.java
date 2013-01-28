package cz.jpikl.yafmt.ui.editors.fm.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModelPackage;
import cz.jpikl.yafmt.model.util.ModelListener;
import cz.jpikl.yafmt.model.util.ModelListenerAdapter;
import cz.jpikl.yafmt.ui.editors.fm.figures.ConnectionFigure;
import cz.jpikl.yafmt.ui.editors.fm.model.Connection;
import cz.jpikl.yafmt.ui.editors.fm.policies.ConnectionEditPolicy;
import cz.jpikl.yafmt.ui.editors.fm.policies.ConnectionSelectionPolicy;

public class ConnectionEditPart extends AbstractConnectionEditPart implements ModelListener {

    private Connection connection;
    private ModelListenerAdapter listenerAdapter;
    
    public ConnectionEditPart(Connection connection) {
        this.connection = connection;
        this.listenerAdapter = new ModelListenerAdapter(this);
        setModel(connection);
    }
    
    @Override
    public void activate() {
        super.activate();
        listenerAdapter.adapt(connection.getTarget());
    }
    
    @Override
    public void deactivate() {
        listenerAdapter.dispose();
        super.deactivate();
    }
    
    @Override
    protected IFigure createFigure() {
        return new ConnectionFigure(connection.getTarget());
    }
                
    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new ConnectionSelectionPolicy());
        installEditPolicy(EditPolicy.CONNECTION_ROLE, new ConnectionEditPolicy());
        installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
    }

    @Override
    public void modelChanged(Notification notification) {
        switch(notification.getFeatureID(Feature.class)) {
            case FeatureModelPackage.FEATURE__LOWER:
            case FeatureModelPackage.FEATURE__UPPER:
                ((ConnectionFigure) getFigure()).updateDecoration(connection.getTarget());
                break;
        }            
    }

}
