package cz.jpikl.yafmt.model.util;

import org.eclipse.emf.common.notify.Notification;

public class EMFUtil {

    public static void printNotification(Notification notification) {
        System.out.println("Notification: " + getNotificationTypeName(notification.getEventType()));
        System.out.println(" >  notifier: " + getObjectName(notification.getNotifier()));
        System.out.println(" >   feature: " + getObjectName(notification.getFeature()));
        System.out.println(" > old value: " + getObjectName(notification.getOldValue()));
        System.out.println(" > new value: " + getObjectName(notification.getNewValue()));
        System.out.println("");
    }
    
    @SuppressWarnings("deprecation")
    private static String getNotificationTypeName(int type) {
        switch(type) {
            case Notification.CREATE:           return "CREATE";
            case Notification.SET:              return "SET";
            case Notification.UNSET:            return "UNSET";
            case Notification.ADD:              return "ADD";
            case Notification.REMOVE:           return "REMOVE";
            case Notification.ADD_MANY:         return "ADD_MANY";
            case Notification.REMOVE_MANY:      return "REMOVE_MANY";
            case Notification.MOVE:             return "MOVE";
            case Notification.REMOVING_ADAPTER: return "REMOVING_ADAPTER";
            case Notification.RESOLVE:          return "RESOLVE";
            default:                            return "Unknown";
        }
    }
    
    private static String getObjectName(Object object) {
        if(object == null)
            return "null";
        return object.getClass().getSimpleName() + " (" + object.toString() + ")";
    }
    
}
