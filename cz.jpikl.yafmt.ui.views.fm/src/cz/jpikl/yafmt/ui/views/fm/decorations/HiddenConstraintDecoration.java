package cz.jpikl.yafmt.ui.views.fm.decorations;

import org.eclipse.draw2d.Label;

import cz.jpikl.yafmt.ui.views.fm.FeatureModelVisualizerPlugin;

public class HiddenConstraintDecoration extends ImageDecoration {

    public HiddenConstraintDecoration() {
        super(FeatureModelVisualizerPlugin.getDefault().getImageRegistry().get("constraint-decoration"));
        setToolTip(new Label("There is a constraint affecting this feature."));
    }
    
}
