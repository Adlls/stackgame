package army.strategies;

import logger.MessageGame;
import players.BaseUnit;

import java.util.List;

public class OneOnOneStrategy implements BattleTypeStrategy {

    @Override
    public void createTypeBattle(List<BaseUnit> userArmy, List<BaseUnit> enemyArmy, BaseUnit currentUserUnit, BaseUnit currentEnemyUnit) {

        MessageGame.setMessage("user unit: " + currentUserUnit.toString() + " vs enemy unit: " + currentEnemyUnit.toString());

        MessageGame.setMessage("Делает ход user unit: " +  currentUserUnit.toString());
        currentEnemyUnit.takeDanger(currentUserUnit.getAD());

        if (currentEnemyUnit.getHP() > 0) {
            MessageGame.setMessage("Делает ход enemy unit: " + currentEnemyUnit.toString());
            currentUserUnit.takeDanger(currentEnemyUnit.getAD());
        }

        //swap units and check for hp == 0
        if (currentUserUnit.getHP() <= 0) {
            userArmy.remove(userArmy.size() - 1);
        } else {
            BaseUnit swapUnit = userArmy.remove(userArmy.size() - 1);
            userArmy.add(0, swapUnit);
        }
        if (currentEnemyUnit.getHP() <= 0) {
            enemyArmy.remove(0);
        } else {
            BaseUnit swapUnit = enemyArmy.remove(0);
            enemyArmy.add(swapUnit);
        }

    }
}
