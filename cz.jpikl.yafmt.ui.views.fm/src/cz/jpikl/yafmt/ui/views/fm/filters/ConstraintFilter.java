package cz.jpikl.yafmt.ui.views.fm.filters;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import cz.jpikl.yafmt.clang.ConstraintLanguageException;
import cz.jpikl.yafmt.clang.ConstraintLanguagePlugin;
import cz.jpikl.yafmt.clang.ConstraintLanguageRegistry;
import cz.jpikl.yafmt.clang.IConstraintLanguage;
import cz.jpikl.yafmt.clang.IEvaluator;
import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;

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
    
    public void update(ISelection selection, FeatureModel featureModel) {
        visibleConstraints.clear();
        
        if(!(selection instanceof IStructuredSelection))
            return;

        Set<Feature> selectedFeatures = new HashSet<Feature>();
        for(Object element: ((IStructuredSelection) selection).toArray()) {
            if(element instanceof Constraint)
                visibleConstraints.add((Constraint) element);
            else if(element instanceof Feature)
                selectedFeatures.add((Feature) element);
        }
        
        ConstraintLanguageRegistry registry = ConstraintLanguagePlugin.getDefault().getConstraintLanguageRegistry();
        for(Constraint constraint: featureModel.getConstraints()) {
            // No need to check already selected constraint.
            if(visibleConstraints.contains(constraint))
                continue;
            
            // Get constraint language.
            IConstraintLanguage langauge = registry.getLanguage(constraint.getLanguage());
            if(langauge == null)
                continue;
            
            try {
                // Check if constraint affects one of selected features.
                IEvaluator evaluator = langauge.createEvaluator(constraint.getValue());
                if(!Collections.disjoint(selectedFeatures, evaluator.getAffectedFeatures(featureModel)))
                    visibleConstraints.add(constraint);
            }
            catch(ConstraintLanguageException ex) {
                // Do nothing, just ignore the problematic constraint.
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
