package cz.jpikl.yafmt.editors.featureconfig.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.swt.graphics.Color;

import cz.jpikl.yafmt.editors.featureconfig.editor.FeatureConfigurationManager;
import cz.jpikl.yafmt.editors.featureconfig.figures.TreeNodeFigure;
import cz.jpikl.yafmt.editors.featureconfig.utils.Connection;
import cz.jpikl.yafmt.models.featuremodel.Feature;

public class SelectionEditPart extends AbstractGraphicalEditPart implements NodeEditPart {

    private FeatureConfigurationManager configManager;
        
    public SelectionEditPart(FeatureConfigurationManager configManager, Feature feature) {
        this.configManager = configManager;
        setModel(feature);
    }
    
    @Override
    public Feature getModel() {
        return (Feature) super.getModel();
    }
    
    @Override
    protected List<Connection> getModelSourceConnections() {
        Feature feature = getModel();
        if(feature.getParent() == null)
            return null;
        
        List<Connection> connections = new ArrayList<Connection>();
        connections.add(new Connection(feature.getParent(), feature));
        return connections;
    }

    @Override
    protected List<Connection> getModelTargetConnections() {
        Feature feature = getModel();
        if(!configManager.isFeatureSelected(feature))
            return null;
        
        List<Connection> connections = new ArrayList<Connection>();
        for(Feature child: feature.getChildren()) {
            if(configManager.isFeatureSelected(child) || configManager.isFeatureSelectable(child))
                connections.add(new Connection(feature, child));
        }
        return connections;
    }

    @Override
    protected IFigure createFigure() {
        return new TreeNodeFigure(this, getModel().getName());
    }
    
    @Override
    protected void refreshVisuals() {
        super.refreshVisuals();
        
        Feature feature = getModel();
        Color color = ColorConstants.black;
        if(!configManager.isFeatureSelected(feature))
            color = ColorConstants.gray;
        else if(!configManager.isFeatureSelectable(feature))
            color = ColorConstants.red;
        
        IFigure figure = getFigure();
        figure.setForegroundColor(color);
        ((LineBorder) figure.getBorder()).setColor(color);
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
    protected void createEditPolicies() {
    }

}
