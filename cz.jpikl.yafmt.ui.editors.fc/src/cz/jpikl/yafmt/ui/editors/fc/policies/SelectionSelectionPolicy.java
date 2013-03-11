package cz.jpikl.yafmt.ui.editors.fc.policies;

import org.eclipse.gef.editpolicies.SelectionEditPolicy;

import cz.jpikl.yafmt.ui.editors.fc.figures.SelectionFigure;
import cz.jpikl.yafmt.ui.figures.FigureDecorator;

public class SelectionSelectionPolicy extends SelectionEditPolicy {

    private SelectionFigure getFigure() {
        return (SelectionFigure) ((FigureDecorator) getHostFigure()).getFigure();
    }
    
    @Override
    protected void showSelection() {
        getFigure().setHighlighted(true);
    }

    @Override
    protected void hideSelection() {
        getFigure().setHighlighted(false);
    }

}
