package cz.jpikl.yafmt.ui.views.fm.decorations;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Image;

public class ImageDecoration extends ImageFigure implements IDecoration {

    private int alpha = 255;
    
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
    public Rectangle computeBounds(Rectangle parentBounds) {
        return null;
    }

    @Override
    public void setAlpha(int alpha) {
        if(this.alpha != alpha) {
            this.alpha = alpha;
            repaint();
        }
    }

    @Override
    public Integer getAlpha() {
        return alpha;
    }
    
    @Override
    public void paint(Graphics graphics) {
        graphics.setAlpha(alpha);
        super.paint(graphics);
    }
    
}
