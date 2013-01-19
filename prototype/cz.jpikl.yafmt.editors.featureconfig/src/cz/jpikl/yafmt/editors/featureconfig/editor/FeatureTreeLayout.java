package cz.jpikl.yafmt.editors.featureconfig.editor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.jpikl.yafmt.editors.featureconfig.figures.TreeNodeFigure;

public class FeatureTreeLayout extends AbstractLayout {

    private static final int RECTANGLE_WIDTH = 100;
    private static final int RECTANGLE_HEIGHT = 25;
    private static final int BORDER_SIZE = 10;
    private static final int LEVEL_SPACE = 50;
    

    private boolean horizonal;
    
    public FeatureTreeLayout(boolean horizonal) {
        this.horizonal = horizonal;
    }
    
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
        if(horizonal)
            layoutTreeHorizontal(subTreeWidth, root, BORDER_SIZE, BORDER_SIZE);
        else
            layoutTreeVertical(subTreeWidth, root, BORDER_SIZE, BORDER_SIZE);
    }
    
    private int calculateSubTreeWidth(Map<IFigure, Integer> subTreeWidth, TreeNodeFigure figure) {
        int width = 0;
        for(TreeNodeFigure child: figure.getTreeNodeChildern())
            width += calculateSubTreeWidth(subTreeWidth, child);
        if(width == 0)
            width = (horizonal ? RECTANGLE_WIDTH : RECTANGLE_HEIGHT) + BORDER_SIZE;
        subTreeWidth.put(figure, width);
        return width;
    }
    
    private void layoutTreeHorizontal(Map<IFigure, Integer> subTreeWidth, TreeNodeFigure figure, int xOffset, int yOffset) {
        int x = xOffset + (subTreeWidth.get(figure) - RECTANGLE_WIDTH) / 2;
        figure.setBounds(new Rectangle(x, yOffset, RECTANGLE_WIDTH, RECTANGLE_HEIGHT));
        
        yOffset += LEVEL_SPACE + RECTANGLE_HEIGHT;
        for(TreeNodeFigure child: figure.getTreeNodeChildern()) {
            layoutTreeHorizontal(subTreeWidth, child, xOffset, yOffset);
            xOffset += subTreeWidth.get(child);
        }
    }
    
    private void layoutTreeVertical(Map<IFigure, Integer> subTreeWidth, TreeNodeFigure figure, int xOffset, int yOffset) {
        int y = yOffset + (subTreeWidth.get(figure) - RECTANGLE_HEIGHT) / 2;
        figure.setBounds(new Rectangle(xOffset, y, RECTANGLE_WIDTH, RECTANGLE_HEIGHT));
        
        xOffset += LEVEL_SPACE + RECTANGLE_WIDTH;
        for(TreeNodeFigure child: figure.getTreeNodeChildern()) {
            layoutTreeVertical(subTreeWidth, child, xOffset, yOffset);
            yOffset += subTreeWidth.get(child);
        }
    }

    @Override
    protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
        return null;
    }

}
