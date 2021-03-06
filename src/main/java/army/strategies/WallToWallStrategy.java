package army.strategies;

import logger.MessageGame;
import players.BaseUnit;

import java.util.List;

public class WallToWallStrategy implements BattleTypeStrategy {

    @Override
    public void createTypeBattle(List<BaseUnit> userArmy, List<BaseUnit> enemyArmy, BaseUnit currentUserUnit, BaseUnit currentEnemyUnit) {

        //attack to enemy
        MessageGame.setMessage("Начинает стенка пользователя: ");
        for (int i = 0; i < userArmy.size(); i++) {
            if (i <= enemyArmy.size() - 1) {
                if (userArmy.get(i).getHP() >= 0) {
                    enemyArmy.get(i).takeDanger(userArmy.get(i).getAD());
                    System.out.println(userArmy.get(i).toString() + " Наносит удар!");
                }
            } else {
                break;
            }
        }
        //attack to user
        MessageGame.setMessage("Начинает стенка противника: ");
        for (int i = 0; i < enemyArmy.size(); i++) {
            if (i <= userArmy.size() - 1) {
                if (enemyArmy.get(i).getHP() >= 0) {
                    userArmy.get(i).takeDanger(enemyArmy.get(i).getAD());
                    System.out.println(enemyArmy.get(i).toString() + " Наносит удар!");
                }
            } else {
                break;
            }
        }

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

    }
}
