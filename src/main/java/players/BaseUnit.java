package players;

import exceptions.NotEnoughCoinsException;

public abstract class BaseUnit implements Cloneable {
    protected static int COST;
    public BaseUnit(int price) throws NotEnoughCoinsException {
        if (price < COST) throw new NotEnoughCoinsException();
    }

}
