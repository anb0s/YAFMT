package cz.jpikl.yafmt.ui.views.fm.decorations;

import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Image;

public class ImageDecoration extends ImageFigure implements IDecoration {

    public ImageDecoration(Image image) {
        super(image);
        setSize(16, 16);
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
