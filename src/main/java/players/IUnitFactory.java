package players;

import exceptions.NotEnoughCoinsException;

public interface IUnitFactory {
    IUnit createUnit(int maxPrice) throws NotEnoughCoinsException;
}
