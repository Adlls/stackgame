package players.impl.factories;

import exceptions.NotEnoughPriceException;
import players.IUnit;
import players.IUnitFactory;
import players.impl.Infantry;

public class InfantryFactory implements IUnitFactory {


    @Override
    public IUnit createUnit(int maxPrice) throws NotEnoughPriceException {
        return new Infantry(maxPrice);
    }
}
