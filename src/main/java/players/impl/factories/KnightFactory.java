package players.impl.factories;

import exceptions.NotEnoughCoinsException;
import players.IUnit;
import players.IUnitFactory;
import players.impl.Knight;

public class KnightFactory implements IUnitFactory {


    @Override
    public IUnit createUnit(int maxPrice) throws NotEnoughCoinsException {
        return new Knight(maxPrice);
    }
}
