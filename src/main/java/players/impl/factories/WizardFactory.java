package players.impl.factories;

import exceptions.NotEnoughCoinsException;
import players.IUnit;
import players.IUnitFactory;
import players.impl.Wizard;

public class WizardFactory implements IUnitFactory {
    @Override
    public IUnit createUnit(int maxPrice) throws NotEnoughCoinsException {
        return new Wizard(maxPrice);
    }
}
