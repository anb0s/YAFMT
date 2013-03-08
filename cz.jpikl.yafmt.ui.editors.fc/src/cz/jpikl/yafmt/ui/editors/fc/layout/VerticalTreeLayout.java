package cz.jpikl.yafmt.ui.editors.fc.layout;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

import cz.jpikl.yafmt.ui.figures.MiddleSideAnchor;

public class VerticalTreeLayout extends TreeLayout {

    private static final int HORIZONTAL_SPACE = 10;
    private static final int VERTICAL_SPACE = 50;

    public VerticalTreeLayout(Helper helper) {
        super(helper);
    }

    @Override
    public String getName() {
        return "Vertical Tree";
    }

    @Override
    protected void doLayout(IFigure root) {
        Map<IFigure, Integer> subTreeWidth = new HashMap<IFigure, Integer>();
        calculateSubTreeWidth(subTreeWidth, root);
        layoutTree(subTreeWidth, root, HORIZONTAL_SPACE, HORIZONTAL_SPACE);
        setupConnectionAnchors();
    }

    private int calculateSubTreeWidth(Map<IFigure, Integer> subTreeWidth, IFigure figure) {
        int width = 0;
        for(IFigure child: helper.getTreeChildrenFigures(figure))
            width += calculateSubTreeWidth(subTreeWidth, child);
        if(width == 0)
            width = computeFigurePreferedSize(figure).width + HORIZONTAL_SPACE;
        subTreeWidth.put(figure, width);
        return width;
    }

    private void layoutTree(Map<IFigure, Integer> subTreeWidth, IFigure figure, int xOffset, int yOffset) {
        Dimension size = computeFigurePreferedSize(figure);
        int x = xOffset + (subTreeWidth.get(figure) - size.width) / 2;
        figure.setBounds(new Rectangle(new Point(x, yOffset), size));

        yOffset += size.height + VERTICAL_SPACE;
        for(IFigure child: helper.getTreeChildrenFigures(figure)) {
            layoutTree(subTreeWidth, child, xOffset, yOffset);
            xOffset += subTreeWidth.get(child);
        }
    }

    private void setupConnectionAnchors() {
        for(Connection connection: helper.getConnectionFigures()) {
            ((MiddleSideAnchor) connection.getSourceAnchor()).setStyle(SWT.TOP);
            ((MiddleSideAnchor) connection.getTargetAnchor()).setStyle(SWT.BOTTOM);
        }
    }

}
