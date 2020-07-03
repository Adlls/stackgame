package players.impl.decorator;

import players.IAccouter;
import players.IUnit;

public class HelmetAccouterDecorator extends AccouterDecorator {

    public HelmetAccouterDecorator(IAccouter accouter) {
        super(accouter);
    }

    @Override
    public void toDress(IUnit unit) {
        unit.putОn("Шлем");
        super.toDress(unit);

    }
}
