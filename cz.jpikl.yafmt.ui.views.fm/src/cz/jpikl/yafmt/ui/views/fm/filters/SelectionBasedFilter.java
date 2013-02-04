package cz.jpikl.yafmt.ui.views.fm.filters;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

// Filtering is based on viewer selection.
public abstract class SelectionBasedFilter extends ViewerFilter {

    private Viewer viewer;
    protected Set<Object> visibleElements = new HashSet<Object>();
    
    public SelectionBasedFilter(Viewer viewer) {
        this.viewer = viewer;
        update();
    }
    
    protected Viewer getViewer() {
        return viewer;
    }
            
    public void update() {
        visibleElements.clear();
        updateVisibleElements();
    }
    
    protected void updateVisibleElements() {
        ISelection selection = viewer.getSelection();
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
