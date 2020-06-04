import exceptions.NotEnoughPriceException;
import players.IUnit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Application implements IGame {

    private BufferedReader reader;
    private IArmy army;
    private int coins;

    public Application(IArmy army, int coins) throws IOException, NotEnoughPriceException {
        Logger.getLogger().writeClassInstanceLog(Application.class);
        this.army  = army;
        this.coins = coins;
        reader = new BufferedReader(new InputStreamReader(System.in));
        printMenu();
        System.out.println("Please input point menu >> ");
        //System.out.print(">> ");
        int pointMenuInput = Integer.parseInt(reader.readLine());
        choosePointMenu(pointMenuInput);

    }

    private void choosePointMenu(int point) throws NotEnoughPriceException {
        switch (point) {
            case 1:
                createArmy(army, coins);
                break;
            case 2:
                turn();
                break;
            case 3:
                turnToEnd();
                break;
            default:
                System.out.println("Incorrect point menu. Please try again.");
        }
    }

    private void printMenu() {
        System.out.println("1. Create Army");
        System.out.println("2. Turn");
        System.out.println("3. Turn to end");
    }

    @Override
    public List<IUnit> createArmy(IArmy army, int price) throws NotEnoughPriceException {
        return army.createArmy(price);
    }

    @Override
    public void turn() {

        System.out.println("Сделан один ход");
    }

    @Override
    public void turnToEnd() {
        System.out.println("Играем до конца...");
    }
}
