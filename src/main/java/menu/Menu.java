package menu;

import army.IArmy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    private BufferedReader reader;
    private IArmy army;
    private int coins;
    private GameField gameField;

    public Menu(IArmy army, int coins) {
        logger.Logger.getLogger().writeClassInstanceLog(Menu.class);
        this.army  = army;
        this.coins = coins;
        this.gameField = new GameField();
        reader = new BufferedReader(new InputStreamReader(System.in));
        displayMenu(reader);
    }

    private void displayMenu(BufferedReader reader) {
        printMenu();
        System.out.println("Please input point menu >> ");
        try {
            int pointMenuInput = Integer.parseInt(reader.readLine().trim());
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
                gameField.createArmy(army, coins);
                displayMenu(reader);
                break;
            case 2:
                gameField.turn();
                displayMenu(reader);
                break;
            case 3:
                if (!gameField.turnToEnd()) displayMenu(reader);
                break;
            case 4:
                gameField.showArmyUser();
                displayMenu(reader);
                break;
            case 5:
                gameField.showEnemyArmy();
                displayMenu(reader);
            case 6:
                gameField.setWallToWallStrategy();
                displayMenu(reader);
            case 7:
                gameField.setOneOnOneStrategy();
                displayMenu(reader);
            case 8:
                 gameField.undoArmy();
                 displayMenu(reader);
            default:
                System.out.println("Incorrect point menu. Please try again.");
                displayMenu(reader);
        }
    }

    private void printMenu() {
        System.out.println("0. Exit");
        System.out.println("1. Create army");
        System.out.println("2. Turn");
        System.out.println("3. Turn to end");
        System.out.println("4. Show my army");
        System.out.println("5. Show enemy army");
        System.out.println("6. Wall on wall strategy");
        System.out.println("7. One on one strategy (default)");
        System.out.println("8. Undo");
    }

}
