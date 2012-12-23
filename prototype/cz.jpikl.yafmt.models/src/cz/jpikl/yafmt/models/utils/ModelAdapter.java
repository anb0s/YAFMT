package cz.jpikl.yafmt.models.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

public class ModelAdapter implements Adapter {

	private List<Notifier> targets;
	private ModelListener listener;
	
	public ModelAdapter(ModelListener listener) {
		this.targets = new ArrayList<Notifier>();
		this.listener = listener;
	}
	
	public void connect(Notifier target) {
		if(!target.eAdapters().contains(target)) {
			target.eAdapters().add(this);
			targets.add(target);
		}
	}
	
	public void connectToAllContents(EObject target) {
		connect(target);
		TreeIterator<EObject> it = target.eAllContents();
		while(it.hasNext())
			connect(it.next());
	}
	
	public void disconnect(Notifier target) {
		target.eAdapters().remove(this);
		targets.remove(target);
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
