package players.impl.decorator;

import players.IAccouter;
import players.IUnit;

public class AccouterDecorator implements IAccouter {
    protected IAccouter accouter;

    AccouterDecorator(IAccouter accouter) {
        this.accouter = accouter;
    }

    @Override
    public void toDress(IUnit unit) {
        accouter.toDress(unit);
    }
}
