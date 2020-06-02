package players.impl;

import exceptions.NotEnoughPrice;
import players.IUnit;
import players.IUnitFactory;

public class KnightFactory implements IUnitFactory {


    @Override
    public IUnit createUnit(int maxPrice) throws NotEnoughPrice {
        return new Knight(maxPrice);
    }
}
