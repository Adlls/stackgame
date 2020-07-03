package players.impl;

import players.INotification;
import players.IUnit;

public class ProxyNotification implements INotification {
    private Notification notification;


    @Override
    public void notificationDieUnity(IUnit unit) {
        lazyNotification();
        notification.notificationDieUnity(unit);
    }

    public void lazyNotification() {
        if (notification == null) {
            notification = new Notification();
        }
    }
}
