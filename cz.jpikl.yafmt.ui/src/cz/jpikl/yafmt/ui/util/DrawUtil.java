package cz.jpikl.yafmt.ui.util;

import org.eclipse.draw2d.Graphics;


public class DrawUtil {

    public static void fixZoomedFigureLocation(Graphics graphics) {
        double scale = graphics.getAbsoluteScale(); 
        if(scale >= 2.0)
            graphics.translate(0.5f, 0.5f);
        else if(scale >= 1.5)
            graphics.translate(0.25f, 0.25f);
    }
    
}
