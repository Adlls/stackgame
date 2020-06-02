package players;

import exceptions.NotEnoughPrice;

public interface IUnitFactory {
    IUnit createUnit(int maxPrice) throws NotEnoughPrice;
}
