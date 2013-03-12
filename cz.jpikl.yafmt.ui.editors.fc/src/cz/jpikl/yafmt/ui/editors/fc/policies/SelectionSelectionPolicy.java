package cz.jpikl.yafmt.ui.editors.fc.policies;

import org.eclipse.gef.editpolicies.SelectionEditPolicy;

import cz.jpikl.yafmt.ui.editors.fc.figures.SelectionFigure;

public class SelectionSelectionPolicy extends SelectionEditPolicy {
    
    @Override
    protected void showSelection() {
        ((SelectionFigure) getHostFigure()).setHighlighted(true);
    }

    @Override
    protected void hideSelection() {
        ((SelectionFigure) getHostFigure()).setHighlighted(false);
    }

}
