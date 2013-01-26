package cz.jpikl.yafmt.ui.editors.fm.layout;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;

public interface IModelLayoutProvider {

    Rectangle getObjectBounds(EObject object);
    
    void setObjectBounds(EObject object, Rectangle bounds);
    
}
