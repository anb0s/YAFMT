package cz.jpikl.yafmt.ui.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

public class DrawConstantans {
    
    public static final Font DEFAULT_FONT = getDefaultFont();
    public static final Font BOLD_FONT = getModifiedFont(DEFAULT_FONT, SWT.DEFAULT, SWT.BOLD);
    public static final Font ITALIC_FONT = getModifiedFont(DEFAULT_FONT, SWT.DEFAULT, SWT.ITALIC);
    public static final Color LIGHT_BLUE_COLOR = getColor(175, 201, 235);
    public static final Color LIGHT_RED_COLOR = getColor(255, 192, 192);
    public static final float[] LINE_DASH = { 2, 2 }; 
        
    public static void dispose() {
        BOLD_FONT.dispose();
        ITALIC_FONT.dispose();
        LIGHT_BLUE_COLOR.dispose();
        LIGHT_RED_COLOR.dispose();
    }
    
    public static Font getDefaultFont() {
        return Display.getDefault().getSystemFont();
    }
    
    public static Font getModifiedFont(Font originalFont, int height, int style) {
        FontData[] fontData = originalFont.getFontData();
        for(FontData data: fontData) {
            if(height != SWT.DEFAULT)
                data.setHeight(height);
            if(style != SWT.DEFAULT)
                data.setStyle(style);
        }
        return new Font(Display.getDefault(), fontData);
    }
    
    public static Color getColor(int r, int g, int b) {
        return new Color(Display.getDefault(), r, g, b);
    }
    
    public static Color getModifiedColor(Color color, float change) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        
        r += (int) (r * change);
        g += (int) (g * change);
        b += (int) (b * change);
        
        r = (r > 255) ? 255 : ((r < 0) ? 0 : r);
        g = (g > 255) ? 255 : ((g < 0) ? 0 : r);
        b = (b > 255) ? 255 : ((b < 0) ? 0 : r);
        
        return getColor(r, g, b);
    }
    
}
