public class Application {


    public Application(IArmy army, int coins) {
        Logger.getLogger().writeClassInstanceLog(Application.class);
        Menu menu = new Menu(army, coins);
    }

}
