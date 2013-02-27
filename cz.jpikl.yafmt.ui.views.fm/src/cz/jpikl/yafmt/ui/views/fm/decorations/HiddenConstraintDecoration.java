package cz.jpikl.yafmt.ui.views.fm.decorations;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.jpikl.yafmt.ui.views.fm.FeatureModelVisualizerPlugin;

public class HiddenConstraintDecoration extends ImageDecoration implements IDecoration {

    public HiddenConstraintDecoration() {
        super(FeatureModelVisualizerPlugin.getDefault().getImageRegistry().get("constraint-decoration"));
        setToolTip(new Label("There is a constraint affecting this feature."));
    }

    @Override
    public boolean isAutoPositioned() {
        return true;
    }

    @Override
    public boolean isOnTop() {
        return true;
    }

    @Override
    public Rectangle computeNewPosition(Rectangle parentBounds) {
        return null;
    }
    
}
