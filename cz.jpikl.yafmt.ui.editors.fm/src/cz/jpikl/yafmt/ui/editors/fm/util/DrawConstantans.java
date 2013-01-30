package cz.jpikl.yafmt.ui.editors.fm.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

public class DrawConstantans {

    private static Font defaultFont;
    private static Font boldFont;
    private static Color backgroundColor;
    
    public static Font getFont() {
        return defaultFont;
    }
    
    public static Font getBoldFont() {
        return boldFont;
    }
    
    public static Color getBackgroundColor() {
        return backgroundColor;
    }
    
    public static void init() {
        Display display = Display.getDefault();
        
        defaultFont = display.getSystemFont();
        
        FontData[] fontData = defaultFont.getFontData();
        for(FontData data: fontData)
            data.setStyle(SWT.BOLD);
        boldFont = new Font(display, fontData);
        
        backgroundColor = new Color(display, 175, 201, 235);
    }
    
    public static void dispose() {
        boldFont.dispose();
        backgroundColor.dispose();
    }
    
}
