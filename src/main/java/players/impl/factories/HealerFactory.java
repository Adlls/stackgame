package players.impl.factories;

import exceptions.NotEnoughCoinsException;
import players.BaseUnit;
import players.IUnit;
import players.IUnitFactory;
import players.impl.Healer;

public class HealerFactory implements IUnitFactory {
    @Override
    public BaseUnit createUnit(int maxPrice) throws NotEnoughCoinsException {
        return new Healer(maxPrice);
    }
}
