package players.impl.decorator;

import players.IAccouter;
import players.IUnit;

public class Accouter implements IAccouter {
    @Override
    public void toDress(IUnit unit) {
        unit.putОn("Броня");
    }
}
