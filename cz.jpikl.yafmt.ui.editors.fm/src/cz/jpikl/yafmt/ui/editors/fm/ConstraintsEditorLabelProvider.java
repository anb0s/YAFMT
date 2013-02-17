package cz.jpikl.yafmt.ui.editors.fm;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import cz.jpikl.yafmt.model.fm.Constraint;

public class ConstraintsEditorLabelProvider extends ColumnLabelProvider {

    private Image constraintImage = FeatureModelEditorPlugin.getDefault().getImageRegistry().get("constraint");
    private Image addImage = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ADD);
    
    @Override
    public Image getImage(Object element) {
        if(element instanceof Constraint)
            return constraintImage;
        return addImage;
    }

    @Override
    public String getText(Object element) {
        if(element instanceof Constraint)
            return ((Constraint) element).getValue();
        return "Add new constraint";
    }
    
}
