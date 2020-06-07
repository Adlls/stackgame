import exceptions.NotEnoughCoinsException;
import players.IUnit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Application {


    public Application(IArmy army, int coins) {
        Logger.getLogger().writeClassInstanceLog(Application.class);
        Menu menu = new Menu(army, coins);
    }

}
