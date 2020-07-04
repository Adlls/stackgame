package menu;

import army.IArmy;
import exceptions.NotEnoughCoinsException;
import players.BaseUnit;
import players.IUnit;

import java.util.List;

public interface IGame {
    List<BaseUnit> createArmy(IArmy army, int price) throws NotEnoughCoinsException;
    boolean turn();
    boolean turnToEnd();
}
