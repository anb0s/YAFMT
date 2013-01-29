package cz.jpikl.yafmt.ui.editors.fm.util;

import org.eclipse.draw2d.AncestorListener;
import org.eclipse.draw2d.IFigure;

// Removes target ancestor when other figure ancestor is removed.
public class AncestorRemover implements AncestorListener {

    private IFigure target;
    
    public AncestorRemover(IFigure target) {
        this.target = target;
    }
    
    @Override
    public void ancestorAdded(IFigure ancestor) {
    }

    @Override
    public void ancestorMoved(IFigure ancestor) {
    }

    @Override
    public void ancestorRemoved(IFigure ancestor) {
        IFigure parent = target.getParent();
        if(parent != null)
            parent.remove(target);
    }
    
}