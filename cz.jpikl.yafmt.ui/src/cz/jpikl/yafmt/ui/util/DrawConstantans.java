package cz.jpikl.yafmt.ui.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

public class DrawConstantans {
    
    public static final Font DEFAULT_FONT = getDefaultFont();
    public static Font BOLD_FONT = getModifiedFont(DEFAULT_FONT, SWT.DEFAULT, SWT.BOLD);
    public static Color LIGHT_BLUE_COLOR = getColor(175, 201, 235);
    public static Color LIGHT_RED_COLOR = getColor(255, 192, 192);
        
    private static Font getDefaultFont() {
        return Display.getDefault().getSystemFont();
    }
    
    private static Font getModifiedFont(Font originalFont, int height, int style) {
        FontData[] fontData = originalFont.getFontData();
        for(FontData data: fontData) {
            if(height != SWT.DEFAULT)
                data.setHeight(height);
            if(style != SWT.DEFAULT)
                data.setStyle(style);
        }
        return new Font(Display.getDefault(), fontData);
    }
    
    private static Color getColor(int r, int g, int b) {
        return new Color(Display.getDefault(), r, g, b);
    }
    
    public static void dispose() {
        BOLD_FONT.dispose();
        LIGHT_BLUE_COLOR.dispose();
        LIGHT_RED_COLOR.dispose();
    }
    
}
