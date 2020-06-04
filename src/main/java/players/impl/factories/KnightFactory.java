package players.impl.factories;

import exceptions.NotEnoughPriceException;
import players.IUnit;
import players.IUnitFactory;
import players.impl.Knight;

public class KnightFactory implements IUnitFactory {


    @Override
    public IUnit createUnit(int maxPrice) throws NotEnoughPriceException {
        return new Knight(maxPrice);
    }
}
