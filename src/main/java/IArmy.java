import exceptions.NotCreatedArmyException;
import exceptions.NotEnoughCoinsException;
import players.IUnit;

import java.util.List;

public interface IArmy {
    int getMinPrice();
    List<IUnit> createEnemyArmy(List<IUnit> armyUser) throws NotCreatedArmyException;
    List<IUnit> createArmy(int price);

}
