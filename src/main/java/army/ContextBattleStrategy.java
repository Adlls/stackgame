package army;

import players.IUnit;

import java.util.List;

public class ContextBattleStrategy {
    private BattleTypeStrategy battleTypeStrategy;

    public void setBattleTypeStrategy(BattleTypeStrategy battleTypeStrategy) {
        this.battleTypeStrategy = battleTypeStrategy;
    }
    public void executeTypeBattle(List<IUnit> userArmy, List<IUnit> enemyArmy, IUnit currentUserUnit, IUnit currentEnemyUnit) {
        battleTypeStrategy.createTypeBattle(userArmy, enemyArmy, currentUserUnit, currentEnemyUnit);
    }
}
