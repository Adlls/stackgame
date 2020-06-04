package players;

import exceptions.NotEnoughPriceException;

public interface IUnitFactory {
    IUnit createUnit(int maxPrice) throws NotEnoughPriceException;
}
