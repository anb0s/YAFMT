package cz.jpikl.yafmt.models.utils;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

public class ModelAdapter implements Adapter {

	private Notifier target;
	private ModelListener listener;
	
	public static void addListener(Notifier target, ModelListener listener) {
		ModelAdapter adapter = new ModelAdapter(target, listener);
		target.eAdapters().add(adapter);
	}
	
	public static void addListenerToAllContents(EObject target, ModelListener listener) {
		ModelAdapter adapter = new ModelAdapter(target, listener);
		target.eAdapters().add(adapter);
		
		TreeIterator<EObject> it = target.eAllContents();
		while(it.hasNext())
			it.next().eAdapters().add(adapter);
	}
	
	public static void removeListener(Notifier target, ModelListener listener) {
		ModelAdapter adapter = new ModelAdapter(target, listener);
		target.eAdapters().remove(adapter);
	}
	
	public static void removeListenerFromAllContents(EObject target, ModelListener listener) {
		ModelAdapter adapter = new ModelAdapter(target, listener);
		target.eAdapters().add(adapter);
		
		TreeIterator<EObject> it = target.eAllContents();
		while(it.hasNext())
			it.next().eAdapters().remove(adapter);
	}
	
	private ModelAdapter(Notifier target, ModelListener listener) {
		this.target = target;
		this.listener = listener;
	}
	
	@Override
	public void notifyChanged(Notification notification) {
		listener.modelChanged(notification);
	}

	@Override
	public Notifier getTarget() {
		return target;
	}

	@Override
	public void setTarget(Notifier newTarget) {
		target = newTarget;		
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof ModelAdapter))
			return false;
		return ((ModelAdapter) obj).target == target;
	}
	
	@Override
	public int hashCode() {
		return target.hashCode();
	}

}
