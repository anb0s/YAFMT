package cz.jpikl.yafmt.ui.views.fm.filters;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

// Filtering is based on viewer selection.
public abstract class SelectionBasedFilter extends ViewerFilter {

    protected Set<Object> visibleElements = new HashSet<Object>();
               
    public void update(ISelection selection) {
        visibleElements.clear();
        updateVisibleElements(selection);
    }
        
    public void updateVisibleElements(ISelection selection) {
        if(!(selection instanceof IStructuredSelection))
            return;

        for(Object element: ((IStructuredSelection) selection).toArray())
            processSelectionElement(element);
    }
    
    protected abstract void processSelectionElement(Object element);
    
    @Override
    public boolean select(Viewer viewer, Object parentElement, Object element) {
        return visibleElements.contains(element);
    }

}
