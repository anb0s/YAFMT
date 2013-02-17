package cz.jpikl.yafmt.ui.editors.fm;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;

import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.FeatureModelPackage;

public class ConstraintsEditorProvider implements IStructuredContentProvider {

    private TableViewer viewer;
    private FeatureModel featureModel;
    private Adapter featureModelAdapter = new Adapter();
    
    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        this.viewer = (TableViewer) viewer;
        if(featureModel != null)
            featureModel.getConstraints().remove(featureModelAdapter);
        if(newInput instanceof FeatureModel) {
            featureModel = (FeatureModel) newInput;
            featureModel.eAdapters().add(featureModelAdapter);
        }
    }
    
    @Override
    public void dispose() {
        if(featureModel != null)
            featureModel.eAdapters().remove(featureModelAdapter);
    }

    @Override
    public Object[] getElements(Object input) {
        if(featureModel == null)
            return null;
        
        List<Constraint> constraints = featureModel.getConstraints();
        Object[] elements = constraints.toArray(new Object[constraints.size() + 1]);
        elements[elements.length - 1] = new Object(); // Empty object for the last entry used as a add button.
        return elements;
    }
    
    private class Adapter extends EContentAdapter {
        
        @Override
        protected void addAdapter(Notifier notifier) {
            if((notifier instanceof Constraint) || (notifier instanceof FeatureModel))
                super.addAdapter(notifier);
        }
        
        @Override
        protected void removeAdapter(Notifier notifier) {
            super.removeAdapter(notifier);
        }
        
        @Override
        public void notifyChanged(Notification notification) {
            if(notification.getFeatureID(FeatureModel.class) == FeatureModelPackage.FEATURE_MODEL__CONSTRAINTS) {
                viewer.refresh();
            }
            else if(notification.getFeatureID(Constraint.class) == FeatureModelPackage.CONSTRAINT__VALUE) {
                viewer.update(notification.getNotifier(), null);
            }
        }
        
    }

}
