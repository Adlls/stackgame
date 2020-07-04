import army.Army;
import army.IArmy;
import exceptions.NotEnoughCoinsException;
import logger.Logger;
import players.IUnit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Demo {

    private static Application configureApplication() throws IllegalAccessException, InvocationTargetException, InstantiationException, IOException, NoSuchMethodException, ClassNotFoundException, NotEnoughCoinsException {
        System.out.println("Сколько у вас монеток?");
        BufferedReader  reader = new BufferedReader(new InputStreamReader(System.in));
        int coinsReader = Integer.parseInt(reader.readLine().trim());
        Application app;
        IArmy army;
        army = new Army();
        app = new Application(army, coinsReader);
        return app;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NotEnoughCoinsException, IOException {

        Logger.getLogger().writeClassInstanceLog(Demo.class);
        Application app = configureApplication();

    }
}
