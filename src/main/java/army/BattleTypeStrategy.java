package army;

import players.IUnit;

import java.util.List;

public interface BattleTypeStrategy {
    void createTypeBattle(List<IUnit> userArmy, List<IUnit> enemyArmy, IUnit currentUserUnit, IUnit currentEnemyUnit);
}
