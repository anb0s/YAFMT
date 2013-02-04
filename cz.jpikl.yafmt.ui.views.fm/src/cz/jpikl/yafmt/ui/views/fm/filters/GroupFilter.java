package cz.jpikl.yafmt.ui.views.fm.filters;

import org.eclipse.jface.viewers.Viewer;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.Group;

public class GroupFilter extends SelectionBasedFilter {

    private boolean enabled = true;
    
    public GroupFilter(Viewer viewer) {
        super(viewer);
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    @Override
    protected void processSelectionElement(Object element) {
        if(element instanceof Group) {
            visibleElements.add(element);
        }
        else if(element instanceof Feature) {
            Feature feature = (Feature) element;
            if(feature.getParentGroup() != null)
                visibleElements.add(feature.getParentGroup());
            visibleElements.addAll(feature.getGroups());
        }
    }
    
    @Override
    public boolean select(Viewer viewer, Object parentElement, Object element) {
        if(!(element instanceof Group))
            return true;
        return enabled ? super.select(viewer, parentElement, element) : false;
    }
   
}
