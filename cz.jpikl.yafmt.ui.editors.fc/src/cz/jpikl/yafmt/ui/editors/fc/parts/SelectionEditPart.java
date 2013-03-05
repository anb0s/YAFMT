package cz.jpikl.yafmt.ui.editors.fc.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import cz.jpikl.yafmt.model.fc.Selection;
import cz.jpikl.yafmt.ui.editors.fc.figures.MiddleSideAnchor;
import cz.jpikl.yafmt.ui.editors.fc.figures.SelectionFigure;
import cz.jpikl.yafmt.ui.editors.fc.model.Connection;

public class SelectionEditPart extends AbstractGraphicalEditPart implements NodeEditPart {

    private Selection selection;

    public SelectionEditPart(Selection selection) {
        this.selection = selection;
    }

    @Override
    protected IFigure createFigure() {
        return new SelectionFigure(selection);
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
        Selection parent = selection.getParent();
        if(parent != null)
            connections.add(new Connection(parent, selection));
        return connections;
    }
    
    @Override
    @SuppressWarnings("rawtypes")
    protected List getModelTargetConnections() {
        List<Object> connections = new ArrayList<Object>();
        for(Selection child: selection.getSelections())
            connections.add(new Connection(selection, child));
        return connections;
    }
    
    @Override
    protected void createEditPolicies() {
    }

}
