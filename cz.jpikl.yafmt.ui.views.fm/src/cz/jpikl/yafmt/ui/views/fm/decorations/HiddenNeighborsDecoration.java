package cz.jpikl.yafmt.ui.views.fm.decorations;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

public class HiddenNeighborsDecoration extends Label {
    
    private static Font tinyFont;
    
    private static Font getTinyFont() {
        if(tinyFont == null) {
            Display display = Display.getDefault();
            Font systemFont = display.getSystemFont();
            FontData[] fontData = systemFont.getFontData();
            for(FontData data: fontData)
                data.setHeight(8);
            tinyFont = new Font(display, fontData);
        }
        return tinyFont;
    }
    
    public static void disposeFonts() {
        if(tinyFont != null) {
            tinyFont.dispose();
            tinyFont = null;
        }
    }
    
    public HiddenNeighborsDecoration(int hiddenNeighborsCount) {
        super(Integer.toString(hiddenNeighborsCount));
        setFont(getTinyFont());
        setForegroundColor(ColorConstants.white);
        setToolTip(new Label("This feature has " + hiddenNeighborsCount + " hidden neighbors."));
        setSize(16, 16);
    }
    
    @Override
    public void paint(Graphics graphics) {
        graphics.setBackgroundColor(ColorConstants.darkBlue);
        graphics.fillOval(bounds.getCopy().resize(-1, -1));
        super.paint(graphics);
    }

}
