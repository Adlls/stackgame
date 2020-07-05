package menu;

import army.strategies.ContextBattleStrategy;
import army.IArmy;
import army.strategies.OneOnOneStrategy;
import army.strategies.ThreeByThreeStrategy;
import army.strategies.WallToWallStrategy;
import exceptions.NotCreatedArmyException;
import logger.MessageGame;
import menu.command.*;
import players.BaseUnit;
import players.ISpecialAction;
import players.IUnit;
import players.impl.Archer;
import players.impl.Healer;
import players.impl.Infantry;
import players.impl.Wizard;
import user.BaseUser;
import user.User;

import java.io.IOException;
import java.util.List;

public class GameField implements IGame {

    private List<BaseUnit> armyImpl;
    private List<BaseUnit> enemyArmyImpl;
    private ContextBattleStrategy contextBattleStrategy;
    private BaseUser user;

    private Command undoCommandUserArmy;
    private Command redoCommandUserArmy;
    private Command undoCommandEnemyArmy;
    private Command redoCommandEnemyArmy;

    private ReceiverCommand receiverCommandUserArmy;
    private ReceiverCommand receiverCommandEnemyArmy;



    GameField(BaseUser user) {
        logger.Logger.getLogger().writeClassInstanceLog(Menu.class);
        this.user = user;

        contextBattleStrategy = new ContextBattleStrategy();
        contextBattleStrategy.setBattleTypeStrategy(new OneOnOneStrategy());
        receiverCommandUserArmy = new ReceiverCommand();
        receiverCommandEnemyArmy = new ReceiverCommand();

        undoCommandUserArmy = new UndoCommand(receiverCommandUserArmy);
        redoCommandUserArmy = new RedoCommand(receiverCommandUserArmy);

        undoCommandEnemyArmy = new UndoCommand(receiverCommandEnemyArmy);
        redoCommandEnemyArmy = new RedoCommand(receiverCommandEnemyArmy);
    }

    @Override
    public List<BaseUnit> createArmy(IArmy army, int price) {
        if (armyImpl == null) {
            armyImpl = army.createArmy(price);
            MessageGame.setMessage("Army created");
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
            MessageGame.setMessage("You already render army");
        }
        return armyImpl;
    }

    public void setNotification(Boolean bool) {
        BaseUnit.notificationIsEnabled = bool;
    }

    public void undoArmy() {
        if (armyImpl != null) {
            receiverCommandUserArmy.pushRedoArmy(armyImpl);
            receiverCommandEnemyArmy.pushRedoArmy(enemyArmyImpl);
            armyImpl = undoCommandUserArmy.execute();
            enemyArmyImpl = undoCommandEnemyArmy.execute();
            System.out.println("Ваши соратники: ");
            showArmyUser();
            System.out.println("Ваши противники: ");
            showEnemyArmy();
        } else {
            MessageGame.setMessage("army is empty");
        }
    }

    public void redoArmy() {
            armyImpl = redoCommandUserArmy.execute();
            enemyArmyImpl = redoCommandEnemyArmy.execute();
            System.out.println("Ваши соратники: ");
            showArmyUser();
            System.out.println("Ваши противники: ");
            showEnemyArmy();
    }

    public boolean setOneOnOneStrategy() {
        if (armyImpl == null) {
            MessageGame.setMessage("You still not generate army");
            return false;
        } else {
            contextBattleStrategy.setBattleTypeStrategy(new OneOnOneStrategy());
            MessageGame.setMessage("Strategy one on one activated");
            return true;
        }
    }

    public boolean setWallToWallStrategy() {
        if (armyImpl == null) {
            MessageGame.setMessage("You still not generate army");
            return false;
        } else {
            contextBattleStrategy.setBattleTypeStrategy(new WallToWallStrategy());
            MessageGame.setMessage("Strategy wall to wall activated");
            return true;
        }
    }

    public boolean setThreeByThreeStrategy() {
        if (armyImpl == null) {
            MessageGame.setMessage("You still not generate army");
            return false;
        } else {
            contextBattleStrategy.setBattleTypeStrategy(new ThreeByThreeStrategy());
            MessageGame.setMessage("Strategy three by three activated");
            return true;
        }
    }

    private void choiceSpecialActions(
            List<BaseUnit> userArmy,
            List<BaseUnit> enemyArmy,
            int startIndexUserArmy,
            int endIndexUserArmy,
            int startIndexEnemyArmy,
            int endIndexEnemyArmy,
            BaseUnit currentUserUnit,
            BaseUnit currentEnemyUnit) {
        //choice specialAction for userArmy
        for (int i = startIndexUserArmy; i < endIndexUserArmy; i++) {
            if (userArmy.get(i) instanceof ISpecialAction && !userArmy.get(i).equals(currentUserUnit)) {

                if (userArmy.get(i) instanceof Wizard) {
                    ((ISpecialAction) userArmy.get(i)).doSpecialAction(userArmy);
                    MessageGame.setMessage("Ваши волшебники склонировали наших товарищей!");
                }

                if (userArmy.get(i) instanceof Archer) {
                    ((ISpecialAction) userArmy.get(i)).doSpecialAction(enemyArmy);
                    MessageGame.setMessage("Ваши лучники воспользовались стрелами!");
                }
                if (userArmy.get(i) instanceof Healer) {
                    ((ISpecialAction) userArmy.get(i)).doSpecialAction(userArmy);
                    MessageGame.setMessage("Ваши соратники излечились!");
                }

                if (userArmy.get(i) instanceof Infantry) {
                    ((ISpecialAction) userArmy.get(i)).doSpecialAction(userArmy);
                    MessageGame.setMessage("Ваши соратники вооружились!");

                }

            }
        }

        //choice specialAction for enemyArmy
        for (int i = startIndexEnemyArmy; i < endIndexEnemyArmy; i++) {
            if (enemyArmy.get(i) instanceof ISpecialAction && !enemyArmy.get(i).equals(currentEnemyUnit)) {

                if (enemyArmy.get(i) instanceof Wizard) {
                    ((ISpecialAction) enemyArmy.get(i)).doSpecialAction(enemyArmy);
                    MessageGame.setMessage("Противники склонировали своих бойцов!");
                }


                if (enemyArmy.get(i) instanceof Archer) {
                    ((Archer) enemyArmy.get(i)).doSpecialAction(userArmy);
                    MessageGame.setMessage("Противники воспользовались лучниками!");
                }
                if (enemyArmy.get(i) instanceof Healer) {
                    ((Healer) enemyArmy.get(i)).doSpecialAction(enemyArmy);
                    MessageGame.setMessage("Противники излечились!");
                }

                if (enemyArmy.get(i) instanceof Infantry) {
                    ((Infantry) enemyArmy.get(i)).doSpecialAction(enemyArmy);
                    MessageGame.setMessage("Противники вооружились!");
                }
            }
        }
    }

    public void doTurn(List<BaseUnit> userArmy, List<BaseUnit> enemyArmy) {

        receiverCommandUserArmy.pushUndoArmy(userArmy);
        receiverCommandEnemyArmy.pushUndoArmy(enemyArmy);

        int startIndexUserArmy = (int) (Math.random() * (userArmy.size()));
        int endIndexUserArmy = (int) (startIndexUserArmy + Math.random() * (userArmy.size() - startIndexUserArmy));

        int startIndexEnemyArmy = (int) (Math.random() * (enemyArmy.size()));
        int endIndexEnemyArmy = (int) (startIndexEnemyArmy +  Math.random() * (enemyArmy.size() - startIndexEnemyArmy));

        BaseUnit currentUserUnit = userArmy.get(userArmy.size() - 1);
        BaseUnit currentEnemyUnit = enemyArmy.get(0);

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
    }

    public void showArmyUser() {
        String outArmyLog = "";
        if (armyImpl == null) {
            MessageGame.setMessage("You still not render army");
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
            MessageGame.setMessage("You still not render army");
        } else {
            for (IUnit unit: enemyArmyImpl) {
                outEnemyArmyLog += "[" + unit.toString() + "] \n";
            }
            System.out.println(outEnemyArmyLog);
        }
    }

    public void doTurnToEnd(List<BaseUnit> userArmy, List<BaseUnit> enemyArmy) {
        while (userArmy.size() != 0 && enemyArmy.size() != 0) {
            doTurn(userArmy, enemyArmy);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Ваши соратники: ");
            showArmyUser();
            System.out.println("Ваши противники: ");
            showEnemyArmy();
        }
        if (userArmy.size() != 0)  {
            MessageGame.setMessage("You win!");
            user.setCoins(user.getCoins() + 500);
            user.setProgressLevel(user.getProgressLevel() + 50);
        }
        if (enemyArmy.size() != 0) MessageGame.setMessage("You lost");

    }

    @Override
    public boolean turn() {
        if (armyImpl == null) {
            MessageGame.setMessage("You still not render army");
            return false;
        } else {
            doTurn(armyImpl, enemyArmyImpl);
            System.out.println("Ваши соратники: ");
            showArmyUser();
            System.out.println("Ваши противники: ");
            showEnemyArmy();

            return true;
        }
    }

    @Override
    public boolean turnToEnd() {
        if (armyImpl == null) {
            MessageGame.setMessage("You still not render army");
            return false;
        } else {
            MessageGame.setMessage("play to the end...");
            doTurnToEnd(armyImpl, enemyArmyImpl);
            return true;
        }
    }
}

