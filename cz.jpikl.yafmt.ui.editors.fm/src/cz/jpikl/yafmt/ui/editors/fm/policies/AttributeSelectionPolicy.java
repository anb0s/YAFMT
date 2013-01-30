package cz.jpikl.yafmt.ui.editors.fm.policies;

import org.eclipse.gef.editpolicies.SelectionEditPolicy;

import cz.jpikl.yafmt.ui.editors.fm.figures.AttributeFigure;

public class AttributeSelectionPolicy extends SelectionEditPolicy {

    @Override
    protected void showSelection() {
        ((AttributeFigure) getHostFigure()).setHighlighted(true);
    }
    
    @Override
    protected void hideSelection() {
        ((AttributeFigure) getHostFigure()).setHighlighted(false);
    }

}
