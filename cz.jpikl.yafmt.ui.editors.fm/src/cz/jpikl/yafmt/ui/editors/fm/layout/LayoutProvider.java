package cz.jpikl.yafmt.ui.editors.fm.layout;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;

public interface LayoutProvider {
    
    Rectangle getObjectBounds(EObject object);
    
    void setObjectBounds(EObject object, Rectangle bounds);
    
    boolean refreshObjectBounds(EObject object);
    
    Notifier getLayoutNotifier();
    
}
