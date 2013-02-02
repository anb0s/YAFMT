package cz.jpikl.yafmt.ui.views.fm.filters;

import org.eclipse.jface.viewers.Viewer;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.Group;

public class GroupFilter extends SelectionBasedTypedFilter {

    public GroupFilter(Viewer viewer) {
        super(viewer, Group.class);
    }

    @Override
    protected void processSelectedElement(Object element) {
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

   
}
