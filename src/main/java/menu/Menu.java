package menu;

import army.IArmy;
import players.BaseUnit;
import user.BaseUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    private BufferedReader reader;
    private IArmy army;
    private GameField gameField;
    private BaseUser user;

    public Menu(IArmy army, BaseUser user) {
        logger.Logger.getLogger().writeClassInstanceLog(Menu.class);
        this.army  = army;
        this.user = user;
        this.gameField = new GameField(user);
        reader = new BufferedReader(new InputStreamReader(System.in));
        displayMenu(reader);
    }

    private void infoUser() {
        System.out.print("lvl: " + user.getLevel());
        System.out.print(" Progress: "+ user.getProgressLevel() + "/100");
        System.out.println(" coins: "+ user.getCoins());
        System.out.println("");
    }

    private void displayMenu(BufferedReader reader) {
        infoUser();
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
                System.exit(0);
                break;
            case 1:
                gameField.createArmy(army, user.getCoins());
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
                break;
            case 6:
                gameField.setWallToWallStrategy();
                displayMenu(reader);
                break;
            case 7:
                gameField.setOneOnOneStrategy();
                displayMenu(reader);
                break;
            case 8:
                gameField.setThreeByThreeStrategy();
                displayMenu(reader);
            case 9:
                 gameField.undoArmy();
                 displayMenu(reader);
                 break;
            case 10:
                gameField.redoArmy();
                displayMenu(reader);
                break;
            case 11:
                if (BaseUnit.notificationIsEnabled)
                    gameField.setNotification(false);
                else
                    gameField.setNotification(true);
                displayMenu(reader);
                break;
            default:
                System.out.println("Incorrect point menu. Please try again.");
                displayMenu(reader);
        }
    }

    private void printMenu() {
        System.out.println("0.  Exit");
        System.out.println("1.  Create army");
        System.out.println("2.  Turn");
        System.out.println("3.  Turn to end");
        System.out.println("4.  Show my army");
        System.out.println("5.  Show enemy army");
        System.out.println("6.  Wall on wall strategy");
        System.out.println("7.  One on one strategy (default)");
        System.out.println("8.  Three by three strategy");
        System.out.println("9.  Undo");
        System.out.println("10. Redo");
        if (BaseUnit.notificationIsEnabled) {
            System.out.println("11. Disable notification");
        } else {
            System.out.println("11. Enable notification");

        }
        System.out.println(" ");
    }

}
