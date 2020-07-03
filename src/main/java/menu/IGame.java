package menu;

import army.IArmy;
import exceptions.NotEnoughCoinsException;
import players.IUnit;

import java.util.List;

public interface IGame {
    List<IUnit> createArmy(IArmy army, int price) throws NotEnoughCoinsException;
    boolean turn();
    boolean turnToEnd();
}
