package cz.jpikl.yafmt.ui.editors.fm.util;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IEditorPart;

// Original code from from http://www.eclipse.org/forums/index.php/t/64088/
public class ImageExporter {
    
    private static final int[] SUPPORTED_FORMATS = { SWT.IMAGE_PNG, SWT.IMAGE_JPEG, SWT.IMAGE_BMP };
    private static final String[] FORMAT_EXTENSIONS = { "*.png", "*.jpeg", "*.bmp",  };
    
    public static boolean save(IEditorPart editorPart, GraphicalViewer viewer, String fileName) {
        FileDialog fileDialog = new FileDialog(editorPart.getEditorSite().getShell(), SWT.SAVE);
        fileDialog.setFilterExtensions(FORMAT_EXTENSIONS);
        fileDialog.setFileName(fileName);
        String filePath = fileDialog.open();
        if (filePath == null)
            return false;

        int index = fileDialog.getFilterIndex();
        int format = (index > 0) ? SUPPORTED_FORMATS[index] : SUPPORTED_FORMATS[0];
        for(int i = 0; i < FORMAT_EXTENSIONS.length; i++) {
            if(filePath.endsWith(FORMAT_EXTENSIONS[i])) {
                format = SUPPORTED_FORMATS[i];
                break;
            }
        }
        
        LayerManager rootEditPart = (LayerManager) viewer.getEditPartRegistry().get(LayerManager.ID);
        IFigure rootFigure = rootEditPart.getLayer(LayerConstants.PRINTABLE_LAYERS);
        Rectangle rootFigureBounds = rootFigure.getBounds();
        
        Image image = new Image(null, rootFigureBounds.width, rootFigureBounds.height);
        GC figureGC = new GC(viewer.getControl());
        GC imageGC = new GC(image);
        
        imageGC.setBackground(figureGC.getBackground());
        imageGC.setForeground(figureGC.getForeground());
        imageGC.setFont(figureGC.getFont());
        imageGC.setLineStyle(figureGC.getLineStyle());
        imageGC.setLineWidth(figureGC.getLineWidth());
        //imageGC.setXORMode(figureCanvasGC.getXORMode());
        
        Graphics imageGraphics = new SWTGraphics(imageGC);
        rootFigure.paint(imageGraphics);
        
        ImageLoader imageLoader = new ImageLoader();
        imageLoader.data = new ImageData[] { image.getImageData() };
        imageLoader.save(filePath, format);
        
        figureGC.dispose();
        imageGC.dispose();
        image.dispose();
        
        return true;
    }
}
