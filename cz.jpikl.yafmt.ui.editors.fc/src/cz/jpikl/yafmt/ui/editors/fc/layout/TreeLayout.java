package cz.jpikl.yafmt.ui.editors.fc.layout;

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;

public abstract class TreeLayout extends AbstractLayout {

    protected Helper helper;
    
    public TreeLayout(Helper helper) {
        this.helper = helper;
    }

    @Override
    public void layout(IFigure container) {
        IFigure treeRootFigure = (IFigure) container.getChildren().get(0);
        if(treeRootFigure == null)
            return;
        
        IFigure treeParentFigure = helper.getTreeParentFigure(treeRootFigure);
        while(treeParentFigure != null) {
            treeRootFigure = treeParentFigure;
            treeParentFigure = helper.getTreeParentFigure(treeParentFigure);
        }
        
        doLayout(treeRootFigure);
    }
    
    protected abstract void doLayout(IFigure treeRootFigure);
    
    @Override
    protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
        return null;
    }
    
    public static interface Helper {
        
        IFigure getTreeParentFigure(IFigure figure);
        
        List<IFigure> getTreeChildrenFigures(IFigure figure);
        
    }

}
