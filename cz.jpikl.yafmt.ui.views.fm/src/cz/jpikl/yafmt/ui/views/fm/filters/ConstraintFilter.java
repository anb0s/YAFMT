package cz.jpikl.yafmt.ui.views.fm.filters;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.Feature;

public class ConstraintFilter extends ViewerFilter {
    
    private Set<Constraint> visibleConstraints = new HashSet<Constraint>();
    private boolean enabled = true;
    
    public ConstraintFilter(boolean enabled) {
        setEnabled(enabled);
    }
        
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public boolean isEnabled() {
        return enabled;
    }
    
    public void update(ISelection selection) {
        visibleConstraints.clear();
        
        if(!(selection instanceof IStructuredSelection))
            return;

        for(Object element: ((IStructuredSelection) selection).toArray()) {
            if(element instanceof Constraint) {
                visibleConstraints.add((Constraint) element);
            }
            else if(element instanceof Feature) {
                // TODO Add constraints that affect that feature.
            }
        }
    }
        
    @Override
    public boolean select(Viewer viewer, Object parentElement, Object element) {
        if(!(element instanceof Constraint))
            return true;
        return enabled ? visibleConstraints.contains(element) : false;
    }

}
