package cz.jpikl.yafmt.editors.featuremodel.utils;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

public class ModelAdapter implements Adapter {

	private Notifier target;
	private ModelListener listener;
	
	public static void addListener(Notifier target, ModelListener listener) {
		target.eAdapters().add(new ModelAdapter(target, listener));
	}
	
	public static void removeListener(Notifier target, ModelListener listener) {
		for(Adapter adapter: target.eAdapters()) {
			if((adapter instanceof ModelAdapter) && (((ModelAdapter) adapter).listener == listener)) {
				target.eAdapters().remove(adapter);
				break;
			}
		}
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

}
