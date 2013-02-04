package cz.jpikl.yafmt.ui.views.fm.filters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;

import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;

public class DistanceFilter extends SelectionBasedFilter {

    public static final int INFINITE_DISTACE = -1;
    
    private int distance = INFINITE_DISTACE;
    
    public DistanceFilter(Viewer viewer) {
        super(viewer);
    }
    
    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    public int getDistance() {
        return distance;
    }
    
    @Override
    protected void updateVisibleElements() {
        if(distance == INFINITE_DISTACE)
            return;
        
        super.updateVisibleElements();
        
        if(visibleElements.isEmpty()) {
            FeatureModel featureModel = (FeatureModel) getViewer().getInput();
            if(featureModel != null)
                processFeature(featureModel.getRoot(), 0);
        }
    }
    
    @Override
    protected void processSelectionElement(Object element) {
        if(element instanceof Feature)
            processFeature((Feature) element, 0);
        else if(element instanceof Group)            
            processGroup((Group) element, 0);
        else if(element instanceof Constraint)
            ;// TODO Add features affected by that constraint.
    }
    
    private void processFeature(Feature feature, int level) {
        if((level > distance) || visibleElements.contains(feature))
            return;
        
        visibleElements.add(feature);
        
        EObject parent = feature.getParent();
        if(parent instanceof Feature)
            processFeature((Feature) parent, level + 1);
        else if(parent instanceof Group)
            processFeature(((Group) parent).getParent(), level + 1);
            
        for(Feature child: feature.getFeatures())
            processFeature(child, level + 1);
        for(Group group: feature.getGroups())
            processGroup(group, level + 1);
    }
    
    private void processGroup(Group group, int level) {
        for(Feature feature: group.getFeatures())
            processFeature(feature, level);
    }
    
    @Override
    public boolean select(Viewer viewer, Object parentElement, Object element) {
        if((distance == INFINITE_DISTACE) || !(element instanceof Feature))
            return true;
        return super.select(viewer, parentElement, element);
    }

}
