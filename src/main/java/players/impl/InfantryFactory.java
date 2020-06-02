package players.impl;

import exceptions.NotEnoughPrice;
import players.IUnit;
import players.IUnitFactory;
import players.impl.Infantry;

public class InfantryFactory implements IUnitFactory {


    @Override
    public IUnit createUnit(int maxPrice) throws NotEnoughPrice {
        return new Infantry(maxPrice);
    }
}
