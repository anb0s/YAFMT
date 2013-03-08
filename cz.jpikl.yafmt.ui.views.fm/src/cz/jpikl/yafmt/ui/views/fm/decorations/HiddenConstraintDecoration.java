package cz.jpikl.yafmt.ui.views.fm.decorations;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.jpikl.yafmt.ui.views.fm.FeatureModelVisualizerPlugin;

public class HiddenConstraintDecoration extends ImageDecoration {

    public HiddenConstraintDecoration() {
        super(FeatureModelVisualizerPlugin.getDefault().getImageRegistry().get("constraint-decoration"));
        setToolTip(new Label("There is a constraint affecting this feature."));
    }

    @Override
    public Rectangle computeBounds(Rectangle parentBounds) {
        int x = parentBounds.x - bounds.width + 2;
        int y = parentBounds.y - bounds.height + 2;
        return new Rectangle(x, y, bounds.width, bounds.height);
    }

}
