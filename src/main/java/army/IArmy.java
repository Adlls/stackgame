package army;

import exceptions.NotCreatedArmyException;
import players.BaseUnit;
import players.IUnit;

import java.util.List;

public interface IArmy {
    int getMinPrice();
    List<BaseUnit> createEnemyArmy(List<BaseUnit> armyUser) throws NotCreatedArmyException;
    List<BaseUnit> createArmy(int price);

}
