package cz.jpikl.yafmt.ui.views.fm.filters;

import org.eclipse.jface.viewers.Viewer;

import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.Feature;

public class ConstraintFilter extends SelectionBasedFilter {

    private boolean enabled = true;
    
    public ConstraintFilter(Viewer viewer) {
        super(viewer);
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    @Override
    protected void processSelectionElement(Object element) {
        if(element instanceof Constraint) {
            visibleElements.add(element);
        }
        else if(element instanceof Feature) {
            // TODO Add constraints that affect that feature.
        }
    }
    
    @Override
    public boolean select(Viewer viewer, Object parentElement, Object element) {
        if(!(element instanceof Constraint))
            return true;
        return enabled ? super.select(viewer, parentElement, element) : false;
    }

}
