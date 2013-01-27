package cz.jpikl.yafmt.ui.editors.fm.policies;

import org.eclipse.gef.editpolicies.SelectionEditPolicy;

import cz.jpikl.yafmt.ui.editors.fm.figures.ConnectionFigure;

public class ConnectionSelectionPolicy extends SelectionEditPolicy {

    @Override
    protected void showSelection() {
        ((ConnectionFigure) getHostFigure()).highlight(true);
    }
    
    @Override
    protected void hideSelection() {
        ((ConnectionFigure) getHostFigure()).highlight(false);
    }
    
}
