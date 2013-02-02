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
    private Class<?> filteredType;
    protected Set<Object> visibleElements;
    private boolean hideAll;
    
    public SelectionBasedTypedFilter(Viewer viewer, Class<?> filteredType) {
        this.viewer = viewer;
        this.filteredType = filteredType;
        this.visibleElements = new HashSet<Object>();
        this.hideAll = false;
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
    
    @Override
    public boolean select(Viewer viewer, Object parentElement, Object element) {
        if((element == null) || (element.getClass() != filteredType))
            return true;
        return hideAll ? false : visibleElements.contains(element);
    }

}
