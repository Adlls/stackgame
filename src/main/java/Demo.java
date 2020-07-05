import army.Army;
import army.IArmy;
import exceptions.NotEnoughCoinsException;
import logger.Logger;
import players.IUnit;
import user.BaseUser;
import user.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Demo {

    private static Application configureApplication() throws IllegalAccessException, InvocationTargetException, InstantiationException, IOException, NoSuchMethodException, ClassNotFoundException, NotEnoughCoinsException {
        Application app;
        BaseUser user = new User();
        IArmy army = new Army();
        app = new Application(army, user);
        return app;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NotEnoughCoinsException, IOException {

        Logger.getLogger().writeClassInstanceLog(Demo.class);
        Application app = configureApplication();

    }
}
