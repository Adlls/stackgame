package army.strategies;

import players.BaseUnit;

import java.util.List;

public class ContextBattleStrategy {
    private BattleTypeStrategy battleTypeStrategy;

    public void setBattleTypeStrategy(BattleTypeStrategy battleTypeStrategy) {
        this.battleTypeStrategy = battleTypeStrategy;
    }
    public void executeTypeBattle(List<BaseUnit> userArmy, List<BaseUnit> enemyArmy, BaseUnit currentUserUnit, BaseUnit currentEnemyUnit) {
        battleTypeStrategy.createTypeBattle(userArmy, enemyArmy, currentUserUnit, currentEnemyUnit);
    }
}
