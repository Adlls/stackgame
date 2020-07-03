package players;

import exceptions.NotEnoughCoinsException;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseUnit implements IUnit {
    protected static int COST;
    protected List<String> wears = new ArrayList<>();;
    public BaseUnit(int price) throws NotEnoughCoinsException {
        if (price < COST) throw new NotEnoughCoinsException();
    }

    @Override
    public void putОn(String wear) {
        wears.add(wear);
    }
}
