package menu;

import army.ContextBattleStrategy;
import army.IArmy;
import army.OneOnOneStrategy;
import army.WallToWallStrategy;
import exceptions.NotCreatedArmyException;
import players.ISpecialAction;
import players.IUnit;
import players.impl.Archer;
import players.impl.Healer;
import players.impl.Infantry;
import players.impl.Wizard;

import java.util.List;

public class GameField implements IGame {

    private List<IUnit> armyImpl;
    private List<IUnit> enemyArmyImpl;
    private ContextBattleStrategy contextBattleStrategy;
    private Command commandUndoUserArmy;
    private Command commandUndoEnemyArmy;

    GameField() {
        logger.Logger.getLogger().writeClassInstanceLog(Menu.class);
        contextBattleStrategy = new ContextBattleStrategy();
        contextBattleStrategy.setBattleTypeStrategy(new OneOnOneStrategy());
    }

    @Override
    public List<IUnit> createArmy(IArmy army, int price) {
        if (armyImpl == null) {
            armyImpl = army.createArmy(price);
            System.out.println("Army created");
            try {
                enemyArmyImpl = army.createEnemyArmy(armyImpl);
                System.out.println("Your army: ");
                showArmyUser();
                System.out.println("Enemy army: ");
                showEnemyArmy();
            } catch (NotCreatedArmyException e) {
                e.printStackTrace();
            }
            commandUndoUserArmy = new UndoCommand(armyImpl);
            commandUndoEnemyArmy = new UndoCommand(enemyArmyImpl);
            commandUndoUserArmy.push(armyImpl);
            commandUndoEnemyArmy.push(enemyArmyImpl);
        }
        else {
            System.out.println("You already render army");
        }

        return armyImpl;
    }

    public void undoArmy() {
        if (armyImpl != null) {
           armyImpl = commandUndoUserArmy.pop();
           enemyArmyImpl = commandUndoEnemyArmy.pop();
        } else {
            System.out.println("army is empty");
        }
    }

    public boolean setOneOnOneStrategy() {
        if (armyImpl == null) {
            System.out.println("You still not generate army");
            return false;
        } else {
            contextBattleStrategy.setBattleTypeStrategy(new OneOnOneStrategy());
            System.out.println("Strategy one on one activated");
            return true;
        }
    }

    public boolean setWallToWallStrategy() {
        if (armyImpl == null) {
            System.out.println("You still not generate army");
            return false;
        } else {
            contextBattleStrategy.setBattleTypeStrategy(new WallToWallStrategy());
            System.out.println("Strategy wall to wall activated");
            return true;
        }
    }

    private void choiceSpecialActions(
            List<IUnit> userArmy,
            List<IUnit> enemyArmy,
            int startIndexUserArmy,
            int endIndexUserArmy,
            int startIndexEnemyArmy,
            int endIndexEnemyArmy,
            IUnit currentUserUnit,
            IUnit currentEnemyUnit) {
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
    }


    public void doTurn(List<IUnit> userArmy, List<IUnit> enemyArmy) {

        int startIndexUserArmy = (int) (Math.random() * (userArmy.size()));
        int endIndexUserArmy = (int) (startIndexUserArmy + Math.random() * (userArmy.size() - startIndexUserArmy));

        int startIndexEnemyArmy = (int) (Math.random() * (enemyArmy.size()));
        int endIndexEnemyArmy = (int) (startIndexEnemyArmy +  Math.random() * (enemyArmy.size() - startIndexEnemyArmy));

        IUnit currentUserUnit = userArmy.get(userArmy.size() - 1);
        IUnit currentEnemyUnit = enemyArmy.get(0);

        choiceSpecialActions(
                userArmy,
                enemyArmy,
                startIndexUserArmy,
                endIndexUserArmy,
                startIndexEnemyArmy,
                endIndexEnemyArmy,
                currentUserUnit,
                currentEnemyUnit);

        contextBattleStrategy.executeTypeBattle(userArmy, enemyArmy, currentUserUnit, currentEnemyUnit);
        commandUndoUserArmy.push(userArmy);
        commandUndoEnemyArmy.push(enemyArmy);
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

    @Override
    public boolean turn() {
        if (armyImpl == null) {
            System.out.println("You still not render army");
            return false;
        } else {
            doTurn(armyImpl, enemyArmyImpl);
            System.out.println("===================");
            System.out.println("Ваши соратники: ");
            showArmyUser();
            System.out.println("Ваши противники: ");
            showEnemyArmy();
            System.out.println("===================");

            return true;
        }
    }

    @Override
    public boolean turnToEnd() {
        if (armyImpl == null) {
            System.out.println("You still not render army");
            return false;
        } else {
            System.out.println("play to the end...");
            doTurnToEnd(armyImpl, enemyArmyImpl);
            return true;
        }
    }
}

