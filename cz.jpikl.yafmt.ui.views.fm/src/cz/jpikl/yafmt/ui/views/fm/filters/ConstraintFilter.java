package cz.jpikl.yafmt.ui.views.fm.filters;

import org.eclipse.jface.viewers.Viewer;

import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.Feature;

public class ConstraintFilter extends SelectionBasedTypedFilter {

    public ConstraintFilter(Viewer viewer) {
        super(viewer, Constraint.class);
    }

    @Override
    protected void processSelectedElement(Object element) {
        if(element instanceof Constraint) {
            visibleElements.add(element);
        }
        else if(element instanceof Feature) {
            // TODO implement visible constraints selection.
        }
    }

}
