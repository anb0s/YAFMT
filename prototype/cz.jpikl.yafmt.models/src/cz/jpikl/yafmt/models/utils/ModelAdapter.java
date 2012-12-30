package cz.jpikl.yafmt.models.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

public class ModelAdapter implements Adapter {

    private Set<Notifier> targets;
    private ModelListener listener;

    public ModelAdapter(ModelListener listener) {
        this.targets = new HashSet<Notifier>();
        this.listener = listener;
    }

    public void connect(Notifier target) {
        if((target != null) && (!targets.contains(target))) {
            target.eAdapters().add(this);
            targets.add(target);
        }
    }

    public void connect(Collection<? extends EObject> targets) {
        for(EObject target: targets)
            connect(target);
    }

    public void connectToAllContents(EObject target) {
        connect(target);
        TreeIterator<EObject> it = target.eAllContents();
        while(it.hasNext())
            connect(it.next());
    }

    public void disconnect(Notifier target) {
        if(targets.remove(target))
            target.eAdapters().remove(this);
        
    }

    public void disconnect(Collection<? extends EObject> targets) {
        for(EObject target: targets)
            disconnect(target);
    }

    public void disconnectFromAllContents(EObject target) {
        disconnect(target);
        TreeIterator<EObject> it = target.eAllContents();
        while(it.hasNext())
            disconnect(it.next());
    }

    public void disconnectFromAll() {
        for(Notifier target: targets)
            target.eAdapters().remove(this);
        targets.clear();
    }

    @Override
    public void notifyChanged(Notification notification) {
        listener.modelChanged(notification);
    }

    @Override
    public Notifier getTarget() {
        return null;
    }

    @Override
    public void setTarget(Notifier newTarget) {
    }

    @Override
    public boolean isAdapterForType(Object type) {
        return false;
    }

}
