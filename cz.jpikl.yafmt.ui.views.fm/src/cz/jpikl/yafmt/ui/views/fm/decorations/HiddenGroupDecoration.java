package cz.jpikl.yafmt.ui.views.fm.decorations;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.jpikl.yafmt.ui.views.fm.FeatureModelVisualizerPlugin;

public class HiddenGroupDecoration extends ImageDecoration {

    public HiddenGroupDecoration() {
        super(FeatureModelVisualizerPlugin.getDefault().getImageRegistry().get("group-decoration"));
        setToolTip(new Label("Feature is part of a group."));
    }
    
    @Override
    public Rectangle computeBounds(Rectangle parentBounds) {
        int x = parentBounds.x - bounds.width + 2;
        int y = parentBounds.y + parentBounds.height - 2;
        return new Rectangle(x, y, bounds.width, bounds.height);
    }

}
