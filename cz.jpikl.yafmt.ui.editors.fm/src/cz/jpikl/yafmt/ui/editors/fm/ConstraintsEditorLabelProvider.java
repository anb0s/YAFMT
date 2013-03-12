package cz.jpikl.yafmt.ui.editors.fm;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import cz.jpikl.yafmt.model.fm.Constraint;

public class ConstraintsEditorLabelProvider extends ColumnLabelProvider {

    private Image constraintImage = FeatureModelEditorPlugin.getAccess().getImage("constraint.png");
    private Image addImage = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ADD);

    @Override
    public Image getImage(Object element) {
        if(element == ConstraintsEditorContentProvider.ADD_CONSTRAINT_OBJECT)
            return addImage;
        return constraintImage;
    }

    @Override
    public String getText(Object element) {
        if(element == ConstraintsEditorContentProvider.ADD_CONSTRAINT_OBJECT)
            return "Add new constraint";
        return ((Constraint) element).getValue();
    }

}
