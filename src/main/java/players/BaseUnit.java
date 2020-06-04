package players;

import exceptions.NotEnoughPriceException;

public abstract class BaseUnit {
    protected static int COST;
    public BaseUnit(int price) throws NotEnoughPriceException {
        if (price < COST) throw new NotEnoughPriceException();
    }
}
