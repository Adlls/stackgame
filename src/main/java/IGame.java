import players.IUnit;

import java.util.List;

public interface IGame {
    List<IUnit> createArmy(int price);
    void turn();
    void turnToEnd();
}
