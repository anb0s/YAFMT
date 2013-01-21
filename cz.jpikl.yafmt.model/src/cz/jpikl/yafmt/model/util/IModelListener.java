package cz.jpikl.yafmt.model.util;

import org.eclipse.emf.common.notify.Notification;

public interface IModelListener {

    void modelChanged(Notification notification);
    
}
