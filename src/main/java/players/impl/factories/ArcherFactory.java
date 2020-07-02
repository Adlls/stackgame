package players.impl.factories;

import exceptions.NotEnoughCoinsException;
import players.IUnit;
import players.IUnitFactory;
import players.impl.Archer;

public class ArcherFactory implements IUnitFactory {


    @Override
    public IUnit createUnit(int maxPrice) throws NotEnoughCoinsException {
        return new Archer(maxPrice);
    }
}
