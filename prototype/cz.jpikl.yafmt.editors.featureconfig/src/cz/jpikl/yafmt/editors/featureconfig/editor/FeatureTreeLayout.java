package cz.jpikl.yafmt.editors.featureconfig.editor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.jpikl.yafmt.editors.featureconfig.figures.TreeNodeFigure;

public class FeatureTreeLayout extends AbstractLayout {

    private static final int RECTANGLE_WIDTH = 100;
    private static final int RECTANGLE_HEIGHT = 25;
    private static final int BORDER_SIZE = 25;
    private static final int LEVEL_HEIGHT = 75;

    @Override
    public void layout(IFigure container) {
        Map<IFigure, Integer> subTreeWidth = new HashMap<IFigure, Integer>();
        
        TreeNodeFigure root = (TreeNodeFigure) container.getChildren().get(0);
        TreeNodeFigure parent = root.getTreeNodeParent();
        
        while(parent != null) {
            root = parent;
            parent = parent.getTreeNodeParent();
        }

        calculateSubTreeWidth(subTreeWidth, root);
        layoutTree(subTreeWidth, root, BORDER_SIZE, BORDER_SIZE);
    }
    
    private int calculateSubTreeWidth(Map<IFigure, Integer> subTreeWidth, TreeNodeFigure figure) {
        int width = 0;
        for(TreeNodeFigure child: figure.getTreeNodeChildern())
            width += calculateSubTreeWidth(subTreeWidth, child);
        if(width == 0)
            width = RECTANGLE_WIDTH + BORDER_SIZE;
        subTreeWidth.put(figure, width);
        return width;
    }
    
    private void layoutTree(Map<IFigure, Integer> subTreeWidth, TreeNodeFigure figure, int xOffset, int yOffset) {
        int x = xOffset + (subTreeWidth.get(figure) - RECTANGLE_WIDTH) / 2;
        figure.setBounds(new Rectangle(x, yOffset, RECTANGLE_WIDTH, RECTANGLE_HEIGHT));
        
        yOffset += LEVEL_HEIGHT;
        for(TreeNodeFigure child: figure.getTreeNodeChildern()) {
            layoutTree(subTreeWidth, child, xOffset, yOffset);
            xOffset += subTreeWidth.get(child);
        }
    }

    @Override
    protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
        return null;
    }

}
