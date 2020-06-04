import exceptions.NotEnoughPriceException;
import players.IUnit;

import java.util.List;

public interface IGame {
    List<IUnit> createArmy(IArmy army, int price) throws NotEnoughPriceException;
    void turn();
    void turnToEnd();
}
