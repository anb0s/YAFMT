package cz.jpikl.yafmt.ui.views.fm.decorations;

import org.eclipse.draw2d.Label;

import cz.jpikl.yafmt.ui.views.fm.FeatureModelVisualizerPlugin;

public class AttributeDecoration extends ImageDecoration {

    public AttributeDecoration(int attributesCount) {
        super(FeatureModelVisualizerPlugin.getDefault().getImageRegistry().get("attribute-decoration"));
        
        if(attributesCount > 1)
            setToolTip(new Label("Feature has " + attributesCount + " attributes."));
        else
            setToolTip(new Label("Feature has an attribute."));
    }

}
