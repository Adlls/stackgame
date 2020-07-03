package army;

import players.IUnit;

import java.util.List;

public class OneOnOneStrategy implements BattleTypeStrategy {

    @Override
    public void createTypeBattle(List<IUnit> userArmy, List<IUnit> enemyArmy, IUnit currentUserUnit, IUnit currentEnemyUnit) {

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
}