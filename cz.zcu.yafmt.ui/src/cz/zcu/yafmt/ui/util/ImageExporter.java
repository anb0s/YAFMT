package cz.zcu.yafmt.ui.util;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Drawable;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;

// Original code from from http://www.eclipse.org/forums/index.php/t/64088/
public class ImageExporter {

    public static final int[] SUPPORTED_FORMATS = { SWT.IMAGE_PNG, SWT.IMAGE_JPEG, SWT.IMAGE_BMP };
    public static final String[] FORMAT_EXTENSIONS = { "*.png", "*.jpeg", "*.bmp", };

    /*
    public static boolean save(IWorkbenchPart part, GraphicalViewer viewer, String fileName) {
        LayerManager rootEditPart = (LayerManager) viewer.getEditPartRegistry().get(LayerManager.ID);
        IFigure rootFigure = rootEditPart.getLayer(LayerConstants.PRINTABLE_LAYERS);
        Rectangle rootFigureBounds = rootFigure.getBounds();
        
        Image image = new Image(null, rootFigureBounds.width, rootFigureBounds.height);
        GC figureGC = new GC(viewer.getControl());
        GC imageGC = new GC(image); 
    }*/

    public static void save(Drawable component, IFigure figure, String filePath, int format) {
        Dimension size = figure.getSize();
        Image image = new Image(null, size.width, size.height);
        GC figureGC = new GC(component);
        GC imageGC = new GC(image);

        imageGC.setBackground(figureGC.getBackground());
        imageGC.setForeground(figureGC.getForeground());
        imageGC.setFont(figureGC.getFont());
        imageGC.setLineStyle(figureGC.getLineStyle());
        imageGC.setLineWidth(figureGC.getLineWidth());
        //imageGC.setXORMode(figureCanvasGC.getXORMode());

        Graphics imageGraphics = new SWTGraphics(imageGC);
        figure.paint(imageGraphics);

        ImageLoader imageLoader = new ImageLoader();
        imageLoader.data = new ImageData[] { image.getImageData() };
        imageLoader.save(filePath, format);

        figureGC.dispose();
        imageGC.dispose();
        image.dispose();
    }

}
