import exceptions.NotEnoughPriceException;
import players.IUnitFactory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Demo {

    private static Application configureApplication() throws IllegalAccessException, InvocationTargetException, InstantiationException, IOException, NoSuchMethodException, ClassNotFoundException, NotEnoughPriceException {
        Application app;
        IArmy army;
        army = new Army();
        app = new Application(army, 1000);
        return app;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NotEnoughPriceException, IOException {
        Logger.getLogger().writeClassInstanceLog(Demo.class);
        Application app = configureApplication();
    }
}
