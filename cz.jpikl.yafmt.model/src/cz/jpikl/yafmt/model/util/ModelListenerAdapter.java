package cz.jpikl.yafmt.model.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;

public class ModelListenerAdapter {

    private IModelListener listener;
    private Adapter adapter;
    
    public ModelListenerAdapter(IModelListener listener) {
        if(listener == null)
            throw new IllegalArgumentException("Argument cannot be null");
        this.listener = listener;
    }
    
    public void connect(Notifier target) {
        dispose(target);
        if(target == null)
            return;
        
        adapter = new AdapterImpl() {
            @Override
            public void notifyChanged(Notification notification) {
                listener.modelChanged(notification);
            };
        };
        target.eAdapters().add(adapter);
    }
    
    public void connectContents(Notifier target) {
        dispose(target);
        if(target == null)
            return;
        
        adapter = new EContentAdapter() {
            @Override
            public void notifyChanged(Notification notification) {
                listener.modelChanged(notification);
            };
        };
        target.eAdapters().add(adapter);
    }
    
    private void dispose(Notifier newTarget) {
        if(adapter == null)
            return;
        
        Notifier oldTarget = adapter.getTarget();
        if((oldTarget == null) || (newTarget == oldTarget))
            return;
        
        oldTarget.eAdapters().remove(adapter);
    }
    
    public void dispose() {
        dispose(null);
        adapter = null;
    }
    
}
