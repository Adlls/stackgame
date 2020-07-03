package menu;

import army.IArmy;
import exceptions.NotCreatedArmyException;
import players.ISpecialAction;
import players.IUnit;
import players.impl.Archer;
import players.impl.Healer;
import players.impl.Infantry;
import players.impl.Wizard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Menu implements IGame {

    private BufferedReader reader;
    private IArmy army;
    private int coins;
    private List<IUnit> armyImpl;
    private List<IUnit> enemyArmyImpl;

    public Menu(IArmy army, int coins) {
        logger.Logger.getLogger().writeClassInstanceLog(Menu.class);
        this.army  = army;
        this.coins = coins;
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
                createArmy(army, coins);
                break;
            case 2:
                turn();
                break;
            case 3:
                turnToEnd();
                break;
            case 4:
                showArmyUser();
                displayMenu(reader);
                break;
            case 5:
                showEnemyArmy();
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
    }


    @Override
    public List<IUnit> createArmy(IArmy army, int price) {
        if (armyImpl == null) {
            armyImpl = army.createArmy(price);
            System.out.println("army.Army created");
            try {
                enemyArmyImpl = army.createEnemyArmy(armyImpl);
                System.out.println("Your army: ");
                showArmyUser();
                System.out.println("Enemy army: ");
                showEnemyArmy();
            } catch (NotCreatedArmyException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("You already render army");
        }


        displayMenu(reader);
        return armyImpl;
    }

    public void doTurn(List<IUnit> userArmy, List<IUnit> enemyArmy) {

        //generate random index for special actions
        int startIndexUserArmy = (int) (Math.random() * (userArmy.size()));
        int endIndexUserArmy = (int) (startIndexUserArmy + Math.random() * (userArmy.size() - startIndexUserArmy));

        int startIndexEnemyArmy = (int) (Math.random() * (enemyArmy.size()));
        int endIndexEnemyArmy = (int) (startIndexEnemyArmy +  Math.random() * (enemyArmy.size() - startIndexEnemyArmy));

        IUnit currentUserUnit = userArmy.get(userArmy.size() - 1);
        IUnit currentEnemyUnit = enemyArmy.get(0);

        System.out.println("==================================");
        System.out.println("user unit: " + currentUserUnit.toString() + " vs enemy unit: " + currentEnemyUnit.toString());
        System.out.println("================================== \n");

        System.out.println("==================================");
        System.out.println("Делает ход user unit: " +  currentUserUnit.toString());
        currentEnemyUnit.takeDanger(currentUserUnit.getAD());

        System.out.println("==================================");
        if (currentEnemyUnit.getHP() > 0) {
            System.out.println("==================================");
            System.out.println("Делает ход enemy unit: " + currentEnemyUnit.toString());
            currentUserUnit.takeDanger(currentEnemyUnit.getAD());
            System.out.println("==================================");
        }


        //choice specialAction for userArmy
        for (int i = startIndexUserArmy; i < endIndexUserArmy; i++) {
            if (userArmy.get(i) instanceof ISpecialAction && !userArmy.get(i).equals(currentUserUnit)) {

                if (userArmy.get(i) instanceof Wizard) {
                    ((ISpecialAction) userArmy.get(i)).doSpecialAction(userArmy);
                    System.out.println("==================================");
                    System.out.println("Ваши волшебники склонировали наших товарищей!");
                    System.out.println("==================================");
                }

                if (userArmy.get(i) instanceof Archer) {
                    ((ISpecialAction) userArmy.get(i)).doSpecialAction(enemyArmy);
                    System.out.println("==================================");
                    System.out.println("Ваши лучники воспользовались стрелами!");
                    System.out.println("==================================");

                }
                if (userArmy.get(i) instanceof Healer) {
                    ((ISpecialAction) userArmy.get(i)).doSpecialAction(userArmy);
                    System.out.println("==================================");
                    System.out.println("Ваши соратники излечились!");
                    System.out.println("==================================");

                }

                if (userArmy.get(i) instanceof Infantry) {
                    ((ISpecialAction) userArmy.get(i)).doSpecialAction(userArmy);
                    System.out.println("==================================");
                    System.out.println("Ваши соратники оделись!");
                    System.out.println("==================================");

                }

            }
        }

        //choice specialAction for enemyArmy
        for (int i = startIndexEnemyArmy; i < endIndexEnemyArmy; i++) {
            if (enemyArmy.get(i) instanceof ISpecialAction && !enemyArmy.get(i).equals(currentEnemyUnit)) {

                if (enemyArmy.get(i) instanceof Wizard) {
                    ((ISpecialAction) enemyArmy.get(i)).doSpecialAction(enemyArmy);
                    System.out.println("==================================");
                    System.out.println("Волшебники противников склонировали своих бойцов!");
                    System.out.println("==================================");
                }


                if (enemyArmy.get(i) instanceof Archer) {
                    ((Archer) enemyArmy.get(i)).doSpecialAction(userArmy);
                    System.out.println("==================================");
                    System.out.println("Противники воспользовались лучниками!");
                    System.out.println("==================================");


                }
                if (enemyArmy.get(i) instanceof Healer) {
                    ((Healer) enemyArmy.get(i)).doSpecialAction(enemyArmy);
                    System.out.println("==================================");
                    System.out.println("Противники излечили своих товарищей!");
                    System.out.println("==================================");

                }

                if (enemyArmy.get(i) instanceof Infantry) {
                    ((Infantry) enemyArmy.get(i)).doSpecialAction(enemyArmy);
                    System.out.println("==================================");
                    System.out.println("Противники оделись!");
                    System.out.println("==================================");

                }
            }
        }


        //swap units and check for hp = 0
        if (currentUserUnit.getHP() <= 0) {
            userArmy.remove(userArmy.size() - 1);
        } else {
            IUnit swapUnit = userArmy.remove(userArmy.size() - 1);
            userArmy.add(0, swapUnit);
        }
        if (currentEnemyUnit.getHP() <= 0) {
             enemyArmy.remove(0);
        } else {
            IUnit swapUnit = enemyArmy.remove(0);
            enemyArmy.add(swapUnit);
        }

    }

    public void doTurnToEnd(List<IUnit> userArmy, List<IUnit> enemyArmy) {
        while (userArmy.size() != 0 && enemyArmy.size() != 0) {
            doTurn(userArmy, enemyArmy);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("===================");
            System.out.println("Ваши соратники: ");
            showArmyUser();
            System.out.println("Ваши противники: ");
            showEnemyArmy();
            System.out.println("===================");
        }
        if (userArmy.size() != 0) System.out.println("You win!");
        if (enemyArmy.size() != 0) System.out.println("You lost");

    }

    public void showArmyUser() {
        String outArmyLog = "";
        if (armyImpl == null) {
            System.out.println("You still not render army");
        } else {
            for (IUnit unit: armyImpl) {
                outArmyLog += "[" + unit.toString() + "]\n";
            }

            System.out.println(outArmyLog);
        }

    }

    public void showEnemyArmy() {
        String outEnemyArmyLog = "";
        if (enemyArmyImpl == null) {
            System.out.println("You still not render army");
        } else {
            for (IUnit unit: enemyArmyImpl) {
                outEnemyArmyLog += "[" + unit.toString() + "] \n";
            }
            System.out.println(outEnemyArmyLog);
        }
    }

    @Override
    public void turn() {
        if (armyImpl == null) {
            System.out.println("You still not render army");
        } else {
            System.out.println("Сделан один ход");
            doTurn(armyImpl, enemyArmyImpl);
        }
        displayMenu(reader);
    }

    @Override
    public void turnToEnd() {
        if (armyImpl == null) {
            System.out.println("You still not render army");
            displayMenu(reader);
        } else {
            System.out.println("play to the end...");
            doTurnToEnd(armyImpl, enemyArmyImpl);
        }
    }
}
