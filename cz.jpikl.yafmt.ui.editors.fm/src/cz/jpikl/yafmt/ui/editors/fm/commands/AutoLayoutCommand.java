package cz.jpikl.yafmt.ui.editors.fm.commands;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.ui.editors.fm.figures.GroupFigure;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;

public class AutoLayoutCommand extends Command {

    private static final int HORIZONTAL_SPACE = 20;
    private static final int VERTICAL_SPACE = 100;

    private FeatureModel featureModel;
    private LayoutData layoutData;
    private Map<EObject, Rectangle> oldLayout;
    private Map<EObject, Rectangle> newLayout;

    public AutoLayoutCommand(FeatureModel featureModel, LayoutData layoutData) {
        this.featureModel = featureModel;
        this.layoutData = layoutData;
    }

    @Override
    public void execute() {
        oldLayout = new HashMap<EObject, Rectangle>(layoutData.getMapping().map());
        newLayout = new HashMap<EObject, Rectangle>();

        Map<EObject, Integer> subTreeWidth = new HashMap<EObject, Integer>();
        calculateSubTreeWidth(subTreeWidth);
        calculateLayout(subTreeWidth);

        redo();
    }

    @Override
    public void redo() {
        layoutData.getMapping().putAll(newLayout);
    }

    @Override
    public void undo() {
        layoutData.getMapping().putAll(oldLayout);
    }

    private int calculateSubTreeWidth(Map<EObject, Integer> subTreeWidth) {
        int width = 0;

        width += calculateSubTreeWidth(subTreeWidth, featureModel.getRoot());
        for(Feature orphan: featureModel.getOrphans())
            width += calculateSubTreeWidth(subTreeWidth, orphan);

        return width;
    }

    private int calculateSubTreeWidth(Map<EObject, Integer> subTreeWidth, Feature feature) {
        int width = 0;

        for(Group group: feature.getGroups()) {
            int groupWidth = 0;
            for(Feature child: group.getFeatures())
                groupWidth += calculateSubTreeWidth(subTreeWidth, child);
            subTreeWidth.put(group, groupWidth);
            width += groupWidth;
        }

        for(Feature child: feature.getFeatures())
            width += calculateSubTreeWidth(subTreeWidth, child);

        if(width == 0)
            width = oldLayout.get(feature).width;
        width += HORIZONTAL_SPACE;

        subTreeWidth.put(feature, width);
        return width;
    }

    private void calculateLayout(Map<EObject, Integer> subTreeWidth) {
        int x = HORIZONTAL_SPACE;
        int y = HORIZONTAL_SPACE;

        calculateLayout(subTreeWidth, featureModel.getRoot(), x, y);
        x += subTreeWidth.get(featureModel.getRoot());

        for(Feature orphan: featureModel.getOrphans()) {
            calculateLayout(subTreeWidth, orphan, x, y);
            x += subTreeWidth.get(orphan);
        }
    }

    private void calculateLayout(Map<EObject, Integer> subTreeWidth, Feature feature, int xBase, int yBase) {
        xBase += HORIZONTAL_SPACE / 2;
        Rectangle bounds = oldLayout.get(feature).getCopy();
        bounds.x = xBase + (subTreeWidth.get(feature) - bounds.width) / 2;
        bounds.y = yBase;
        newLayout.put(feature, bounds);

        int y = yBase + bounds.height + VERTICAL_SPACE;
        int x = xBase;

        for(Group group: feature.getGroups()) {
            double rx = (x - xBase + 0.5 * subTreeWidth.get(group)) / (double) subTreeWidth.get(feature);
            int gx = (int) (bounds.x + rx * bounds.width - GroupFigure.SIZE / 2);
            int gy = bounds.bottom() - GroupFigure.SIZE / 2;
            newLayout.put(group, new Rectangle(gx, gy, GroupFigure.SIZE, GroupFigure.SIZE));

            for(Feature child: group.getFeatures()) {
                calculateLayout(subTreeWidth, child, x, y);
                x += subTreeWidth.get(child);
            }
        }

        for(Feature child: feature.getFeatures()) {
            calculateLayout(subTreeWidth, child, x, y);
            x += subTreeWidth.get(child);
        }
    }

}
