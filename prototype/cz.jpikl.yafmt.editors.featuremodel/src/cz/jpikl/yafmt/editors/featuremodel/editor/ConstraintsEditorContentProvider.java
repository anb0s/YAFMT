package cz.jpikl.yafmt.editors.featuremodel.editor;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import cz.jpikl.yafmt.models.featuremodel.Constraint;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;
import cz.jpikl.yafmt.models.featuremodel.FeatureModelPackage;
import cz.jpikl.yafmt.models.utils.ModelAdapter;
import cz.jpikl.yafmt.models.utils.ModelListener;

public class ConstraintsEditorContentProvider implements IStructuredContentProvider, ModelListener {

    private Viewer viewer;
    private ModelAdapter adapter = new ModelAdapter(this);

    // =================================================================
    //  IStructuredContentProvider
    // =================================================================

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        this.viewer = viewer;

        adapter.disconnectFromAll();
        if(newInput != null) {
            adapter.connect((FeatureModel) newInput);
            adapter.connect(((FeatureModel) newInput).getConstraints());
        }
    }

    @Override
    public void dispose() {
        adapter.disconnectFromAll();
        adapter = null;
        viewer = null;
    }

    @Override
    public Object[] getElements(Object inputElement) {
        return ((FeatureModel) inputElement).getConstraints().toArray();
    }

    // =================================================================
    //  ModelListener
    // =================================================================

    @SuppressWarnings("unchecked")
    @Override
    public void modelChanged(Notification notification) {
        Object newValue = notification.getNewValue();
        Object oldValue = notification.getOldValue();

        switch(notification.getEventType()) {
            case Notification.ADD:
                if(newValue instanceof Constraint)
                    adapter.connect((Constraint) newValue);
                viewer.refresh();
                break;

            case Notification.ADD_MANY:
                List<EObject> newObjects = (List<EObject>) newValue;
                if(!newObjects.isEmpty() && (newObjects.get(0) instanceof Constraint))
                    adapter.connect(newObjects);
                viewer.refresh();
                break;

            case Notification.REMOVE:
                if(oldValue instanceof Constraint)
                    adapter.disconnect((Constraint) oldValue);
                viewer.refresh();
                break;

            case Notification.REMOVE_MANY:
                List<EObject> oldObjects = (List<EObject>) oldValue;
                if(!oldObjects.isEmpty() && (oldObjects.get(0) instanceof Constraint))
                    adapter.disconnect(oldObjects);
                viewer.refresh();
                break;

            case Notification.SET:
                if(notification.getFeatureID(Constraint.class) == FeatureModelPackage.CONSTRAINT__VALUE)
                    viewer.refresh();
                break;
        }
    }

}
