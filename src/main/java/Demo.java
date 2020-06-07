import exceptions.NotEnoughCoinsException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Demo {

    private static Application configureApplication() throws IllegalAccessException, InvocationTargetException, InstantiationException, IOException, NoSuchMethodException, ClassNotFoundException, NotEnoughCoinsException {
        Application app;
        IArmy army;
        army = new Army();
        app = new Application(army, 1000);
        return app;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NotEnoughCoinsException, IOException {
        Logger.getLogger().writeClassInstanceLog(Demo.class);
        Application app = configureApplication();
    }
}
