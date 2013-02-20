package cz.jpikl.yafmt.ui.views.fm;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import cz.jpikl.yafmt.ui.views.fm.util.GraphDecorator;

public class FeatureModelDecorator extends GraphDecorator {
    
    private Font smallFont;
    private Image constraintImage;
    private Image groupImage;
        
    private Font getSmallFont() {
        if(smallFont == null) {
            Display display = Display.getDefault();
            Font systemFont = display.getSystemFont();
            FontData[] fontData = systemFont.getFontData();
            for(FontData data: fontData)
                data.setHeight(8);
            smallFont = new Font(display, fontData);
        }
        return smallFont;
    }
    
    public FeatureModelDecorator() {
        constraintImage = FeatureModelVisualizerPlugin.getDefault().getImageRegistry().get("constraint-decoration");
        groupImage = FeatureModelVisualizerPlugin.getDefault().getImageRegistry().get("group-decoration");
    }
    
    @Override
    public void dispose() {
        if(smallFont != null)
            smallFont.dispose();
        super.dispose();
    }
    
    @Override
    protected IFigure[] getDecorations(Object element) {
        return new IFigure[] { new NumberDecoration(3), new ImageDecoration(constraintImage), new ImageDecoration(groupImage) };
    }
    
    private class ImageDecoration extends ImageFigure {
        
        public ImageDecoration(Image image) {
            super(image);
            setSize(16, 16);
        }
        
    }
    
    private class NumberDecoration extends Figure {
             
        public NumberDecoration(int number) {
            ToolbarLayout layout = new ToolbarLayout();
            layout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
            setLayoutManager(new StackLayout());
            
            Label label = new Label(Integer.toString(number));
            label.setForegroundColor(ColorConstants.white);
            label.setFont(getSmallFont());
            add(label);
            
            setForegroundColor(ColorConstants.white);
            setSize(16, 16);
        }
        
        @Override
        public void paint(Graphics graphics) {
            graphics.setBackgroundColor(ColorConstants.darkBlue);
            graphics.fillOval(bounds.getCopy().resize(-1, -1));
            super.paint(graphics);
        }
        
    }
    
}
