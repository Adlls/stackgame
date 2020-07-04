package army.strategies;

import players.BaseUnit;
import players.IUnit;

import java.util.List;

public interface BattleTypeStrategy {
    void createTypeBattle(List<BaseUnit> userArmy, List<BaseUnit> enemyArmy, BaseUnit currentUserUnit, BaseUnit currentEnemyUnit);
}
