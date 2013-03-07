package cz.jpikl.yafmt.ui.editors.fc.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import cz.jpikl.yafmt.model.fc.Selection;
import cz.jpikl.yafmt.ui.editors.fc.FeatureConfigurationManager;
import cz.jpikl.yafmt.ui.editors.fc.commands.SelectFeatureCommand;
import cz.jpikl.yafmt.ui.editors.fc.commands.UnselectFeatureCommand;
import cz.jpikl.yafmt.ui.editors.fc.figures.SelectionFigure;
import cz.jpikl.yafmt.ui.editors.fc.model.Connection;
import cz.jpikl.yafmt.ui.editors.fc.policies.SelectionSelectionPolicy;
import cz.jpikl.yafmt.ui.figures.MiddleSideAnchor;

public class SelectionEditPart extends AbstractGraphicalEditPart implements NodeEditPart {

    private FeatureConfigurationManager featureConfigManager;
    private Selection selection;

    public SelectionEditPart(FeatureConfigurationManager featureConfigManager, Selection selection) {
        this.featureConfigManager = featureConfigManager;
        this.selection = selection;
        setModel(selection);
    }

    @Override
    protected IFigure createFigure() {
        SelectionFigure figure = new SelectionFigure(selection);
        // Figure cannot obtain feature from selection itself if the selection is not added to the configuration.
        // So we need to update it manually.
        figure.initContents(featureConfigManager.getFeatureModel().getFeatureById(selection.getId()));
        return figure;
    }
    
    @Override
    protected void refreshVisuals() {
        // TODO Detect errors.
        ((SelectionFigure) getFigure()).setErrorMessages(null);
        getFigure().repaint();
    }
    
    @Override
    public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
        return new MiddleSideAnchor(getFigure());
    }

    @Override
    public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
        return new MiddleSideAnchor(getFigure());
    }

    @Override
    public ConnectionAnchor getSourceConnectionAnchor(Request request) {
        return new MiddleSideAnchor(getFigure());
    }

    @Override
    public ConnectionAnchor getTargetConnectionAnchor(Request request) {
        return new MiddleSideAnchor(getFigure());
    }

    @Override
    @SuppressWarnings("rawtypes")
    protected List getModelSourceConnections() {
        List<Object> connections = new ArrayList<Object>();
        Selection parentSelection = featureConfigManager.getParentSelection(selection);
        if(parentSelection != null)
            connections.add(new Connection(parentSelection, selection));
        return connections;
    }
    
    @Override
    @SuppressWarnings("rawtypes")
    protected List getModelTargetConnections() {
        List<Object> connections = new ArrayList<Object>();
        for(Selection childSelection: featureConfigManager.getChildrenSelections(selection))
            connections.add(new Connection(selection, childSelection));
        return connections;
    }
    
    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new SelectionSelectionPolicy());
    }
    
    @Override
    public void performRequest(Request request) {
        if(request.getType().equals(REQ_OPEN)) {
            CommandStack commandStack = getViewer().getEditDomain().getCommandStack();
            
            if(selection.getParent() == null)
                commandStack.execute(new SelectFeatureCommand(featureConfigManager, selection));
            else
                commandStack.execute(new UnselectFeatureCommand(featureConfigManager, selection));
        }
    }

}
