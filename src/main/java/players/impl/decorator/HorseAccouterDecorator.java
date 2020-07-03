package players.impl.decorator;

import players.IAccouter;
import players.IUnit;

public class HorseAccouterDecorator extends AccouterDecorator {
    public HorseAccouterDecorator(IAccouter accouter) {
        super(accouter);
    }

    @Override
    public void toDress(IUnit unit) {
        unit.putОn("Конь");
        super.toDress(unit);
    }
}
