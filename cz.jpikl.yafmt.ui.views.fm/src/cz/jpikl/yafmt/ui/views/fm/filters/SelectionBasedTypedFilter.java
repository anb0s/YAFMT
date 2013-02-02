package cz.jpikl.yafmt.ui.views.fm.filters;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

// It only filters objects of the target type.
// Filtering is based on viewer selection.
public abstract class SelectionBasedTypedFilter extends ViewerFilter {

    private Viewer viewer;
    protected Set<Object> visibleElements = new HashSet<Object>();
    private boolean hideAll = false;
    
    public SelectionBasedTypedFilter(Viewer viewer) {
        this.viewer = viewer;
        update();
    }
    
    public void setHideAll(boolean value) {
        hideAll = value;
    }
        
    public void update() {
        visibleElements.clear();
        
        ISelection selection = viewer.getSelection();
        if(!(selection instanceof IStructuredSelection))
            return;
                
        for(Object element: ((IStructuredSelection) selection).toArray())
            processSelectedElement(element);
    }
    
    protected abstract void processSelectedElement(Object element);
    
    protected abstract boolean isTargetType(Object element);
    
    @Override
    public boolean select(Viewer viewer, Object parentElement, Object element) {
        if(!isTargetType(element))
            return true;
        return hideAll ? false : visibleElements.contains(element);
    }

}
