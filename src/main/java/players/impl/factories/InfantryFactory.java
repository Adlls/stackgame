package players.impl.factories;

import exceptions.NotEnoughCoinsException;
import players.IUnit;
import players.IUnitFactory;
import players.impl.Infantry;

public class InfantryFactory implements IUnitFactory {

    @Override
    public IUnit createUnit(int maxPrice) throws NotEnoughCoinsException {
        return new Infantry(maxPrice);
    }
}
