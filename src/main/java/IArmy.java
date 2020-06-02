import exceptions.NotEnoughPrice;
import players.IUnit;
import players.IUnitFactory;

import java.util.List;

public interface IArmy {
    int getMinPrice();
    List<IUnit> createArmy(int price) throws NotEnoughPrice;
}
