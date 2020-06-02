import exceptions.NotEnoughPrice;
import players.IUnitFactory;

import java.lang.reflect.InvocationTargetException;

public class Demo {

    private static Application configureApplication() {
        Application app;
        IUnitFactory unitFactory;

        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NotEnoughPrice {
        Army army = new Army();
        army.createArmy(10000);

    }
}
