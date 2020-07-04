package players;

        import exceptions.NotEnoughCoinsException;
        import players.impl.ProxyNotification;

        import java.util.ArrayList;
        import java.util.List;

public abstract class BaseUnit implements IUnit {
    protected static int COST;
    protected List<String> wears = new ArrayList<>();
    protected ProxyNotification proxyNotification = new ProxyNotification();
    public BaseUnit(int price) throws NotEnoughCoinsException {
        if (price < COST) throw new NotEnoughCoinsException();
    }

    public abstract BaseUnit clone();

    @Override
    public void putОn(String wear) {
        wears.add(wear);
    }

}
