package players.impl;

import players.INotification;
import players.IUnit;

import java.awt.*;

public class Notification implements INotification {

    @Override
    public void notificationDieUnity(IUnit unit) {
        if (unit.getHP() <= 0) {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("Юнит пал в битве!");
        }
    }
}
