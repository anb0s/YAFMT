package cz.jpikl.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.TreeSearch;

public class NonInteractiveLabel extends Label {
    
    @Override
    public IFigure findFigureAt(int x, int y, TreeSearch search) {
        return null;
    }
    
}
