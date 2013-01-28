package cz.jpikl.yafmt.ui.editors.fm.layout;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;

public interface LayoutProvider {
    
    Rectangle getBounds(EObject object);
    
    void setBounds(EObject object, Rectangle bounds);
    
    boolean refreshBounds(EObject object);
    
}
