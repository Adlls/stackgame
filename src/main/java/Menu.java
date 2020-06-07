import exceptions.NotEnoughCoinsException;
import players.IUnit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Menu implements IGame {

    private BufferedReader reader;
    private IArmy army;
    private int coins;
    private List<IUnit> armyImpl;

    public Menu(IArmy army, int coins) {
        Logger.getLogger().writeClassInstanceLog(Menu.class);
        this.army  = army;
        this.coins = coins;
        reader = new BufferedReader(new InputStreamReader(System.in));
        displayMenu(reader);
    }

    private void displayMenu(BufferedReader reader) {
        printMenu();
        System.out.println("Please input point menu >> ");
        try {
            int pointMenuInput = Integer.parseInt(reader.readLine());
            choosePointMenu(pointMenuInput);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void choosePointMenu(int point) {
        switch (point) {
            case 0:
                System.out.println("bye");
                break;
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
                displayMenu(reader);
        }
    }

    private void printMenu() {
        System.out.println("0. Exit");
        System.out.println("1. Create Army");
        System.out.println("2. Turn");
        System.out.println("3. Turn to end");
    }


    @Override
    public List<IUnit> createArmy(IArmy army, int price) {
        if (armyImpl == null) {
            armyImpl = army.createArmy(price);
            System.out.println("Army created");
            displayMenu(reader);
        }
        else {
            System.out.println("You already render army");
            displayMenu(reader);
        }
        return armyImpl;
    }

    @Override
    public void turn() {
        if (armyImpl == null) {
            System.out.println("You still not render army");
        } else {
            System.out.println("Сделан один ход");
        }
        displayMenu(reader);
    }

    @Override
    public void turnToEnd() {
        if (armyImpl == null) {
            System.out.println("You still not render army");
            displayMenu(reader);
        } else {
            System.out.println("Играем до конца...");
        }
    }
}
