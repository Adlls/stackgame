package players.impl.factories;

import exceptions.NotEnoughCoinsException;
import players.BaseUnit;
import players.IUnit;
import players.IUnitFactory;
import players.impl.Archer;

public class ArcherFactory implements IUnitFactory {


    @Override
    public BaseUnit createUnit(int maxPrice) throws NotEnoughCoinsException {
        return new Archer(maxPrice);
    }
}
