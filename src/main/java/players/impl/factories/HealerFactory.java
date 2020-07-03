package players.impl.factories;

import exceptions.NotEnoughCoinsException;
import players.IUnit;
import players.IUnitFactory;
import players.impl.Healer;

public class HealerFactory implements IUnitFactory {
    @Override
    public IUnit createUnit(int maxPrice) throws NotEnoughCoinsException {
        return new Healer(maxPrice);
    }
}
