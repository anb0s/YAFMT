package cz.jpikl.yafmt.ui.views.fm.decorations;

import org.eclipse.draw2d.Label;

import cz.jpikl.yafmt.ui.views.fm.FeatureModelVisualizerPlugin;

public class HiddenGroupDecoration extends ImageDecoration {

    public HiddenGroupDecoration() {
        super(FeatureModelVisualizerPlugin.getDefault().getImageRegistry().get("group-decoration"));
        setToolTip(new Label("This feature is part of a group."));
    }
    
}
