package cz.jpikl.yafmt.ui.views.fm.decorations;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.jpikl.yafmt.ui.views.fm.FeatureModelVisualizerPlugin;

public class AttributeDecoration extends ImageDecoration {

    public AttributeDecoration(int attributesCount) {
        super(FeatureModelVisualizerPlugin.getDefault().getImageRegistry().get("attribute-decoration"));

        if(attributesCount > 1)
            setToolTip(new Label("Feature has " + attributesCount + " attributes."));
        else
            setToolTip(new Label("Feature has an attribute."));
    }
    
    @Override
    public Rectangle computeBounds(Rectangle parentBounds) {
        int x = parentBounds.x + parentBounds.width - 2;
        int y = parentBounds.y + parentBounds.height - 2;
        return new Rectangle(x, y, bounds.width, bounds.height);
    }

}
