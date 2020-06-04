import exceptions.NotEnoughPriceException;
import players.IUnitFactory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Demo {

    private static Application configureApplication() {
        Application app;
        IUnitFactory unitFactory;

        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NotEnoughPriceException, IOException {
        Logger.getLogger().writeClassInstanceLog(Demo.class);
        Army army = new Army();
        army.createArmy(10000);

    }
}
