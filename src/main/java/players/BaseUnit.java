package players;

import exceptions.NotEnoughPrice;

public abstract class BaseUnit {
    protected static int COST;
    public BaseUnit(int price) throws NotEnoughPrice {
        if (price < COST) throw new NotEnoughPrice();
    }
}
