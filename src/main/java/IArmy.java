import players.IUnit;

import java.util.List;

public interface IArmy {
    int getMinPrice();
    List<IUnit> createArmy(int price);
}
