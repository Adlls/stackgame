import army.IArmy;
import logger.Logger;
import menu.Menu;
import user.BaseUser;

public class Application {


    public Application(IArmy army, BaseUser user) {
        Logger.getLogger().writeClassInstanceLog(Application.class);
        Menu menu = new Menu(army, user);
    }

}
