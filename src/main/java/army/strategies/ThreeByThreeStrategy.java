package army.strategies;

import logger.MessageGame;
import players.BaseUnit;

import java.util.ArrayList;
import java.util.List;

public class ThreeByThreeStrategy implements BattleTypeStrategy {

    private ContextBattleStrategy contextBattleStrategy;

    public ThreeByThreeStrategy() {
        contextBattleStrategy = new ContextBattleStrategy();
        contextBattleStrategy.setBattleTypeStrategy(new OneOnOneStrategy());
    }

    @Override
    public void createTypeBattle(List<BaseUnit> userArmy, List<BaseUnit> enemyArmy, BaseUnit currentUserUnit, BaseUnit currentEnemyUnit) {

        if (userArmy.size() >= 3 && enemyArmy.size() >= 3) {
            MessageGame.setMessage("Тройки начали сражаться!");
            System.out.println(" ");
            System.out.println("Тройка user army: ");
            //attack to enemy
            for (int i = 0; i < 3; i++) {
                if (userArmy.get(userArmy.size() - 1 - i).getHP() >= 0) {
                    enemyArmy.get(i).takeDanger(userArmy.get(userArmy.size() - 1 - i).getAD());
                    System.out.println(userArmy.get(userArmy.size() - 1) + " наносит удар!");
                }
            }

            int indexEnemyArmy = 0;

            System.out.println(" ");
            System.out.println("Тройка enemy army: ");
            //attack to user
            for (int j = userArmy.size() - 1; j > userArmy.size() - 4; j--) {
                if (enemyArmy.get(indexEnemyArmy).getHP() >= 0) {
                    userArmy.get(j).takeDanger(enemyArmy.get(indexEnemyArmy).getAD());
                    System.out.println(enemyArmy.get(indexEnemyArmy) + " наносит удар!");
                }

                indexEnemyArmy++;
            }

            System.out.println(" ");
            //remove the dead units
            for (int i = 0; i < userArmy.size(); i++) {
                if (userArmy.get(i).getHP() <= 0) {
                    userArmy.remove(i);
                }
            }
            for (int i = 0; i < enemyArmy.size(); i++) {
                if (enemyArmy.get(i).getHP() <= 0) {
                    enemyArmy.remove(i);
                }
            }
        } else {
            contextBattleStrategy.executeTypeBattle(userArmy, enemyArmy, currentUserUnit, currentEnemyUnit);
        }
    }
}
