package players;

        import exceptions.NotEnoughCoinsException;
        import players.impl.ProxyNotification;

        import java.text.DecimalFormat;
        import java.util.ArrayList;
        import java.util.List;

public abstract class BaseUnit implements IUnit {

    protected double HP;
    protected double AD;
    protected double DF;
    protected int price;
    protected static int COST;
    protected boolean isCloned;
    public static boolean notificationIsEnabled;


    protected List<String> wears = new ArrayList<>();

    protected ProxyNotification proxyNotification = new ProxyNotification();
    public BaseUnit(int price) throws NotEnoughCoinsException {
        if (price < COST) throw new NotEnoughCoinsException();
    }

    public List<String> getWears() {
        return wears;
    }


    public void setCloned(boolean bool) {
        this.isCloned = bool;
    }

    public boolean isCloned() {
        return this.isCloned;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(this.getClass().getSimpleName()+"{" +
                "HP=" + new DecimalFormat("0.#").format(HP) +
                ", AD=" + AD +
                ", DF=" + DF +
                '}');
        if (!wears.isEmpty()) {
            output.append(" Одежда:");
            for (String wear : wears)
                output.append(" ").append(wear).append(",");

            output.delete(output.length() - 1, output.length());
        }
        return output.toString();
    }

    @Override
    public double getCost() {
        return COST;
    }

    @Override
    public double getHP() {
        return HP;
    }

    @Override
    public void setHP(double HP) {
        this.HP = HP;
        if (this.HP > 100) this.HP = 100;
        if (this.HP < 0) this.HP = 0;
    }

    @Override
    public double getAD() {
        return AD;
    }

    @Override
    public void setAD(double AD) {
        this.AD = AD;
    }

    @Override
    public double getDF() {
        return DF;
    }

    @Override
    public void setDF(double DF) {
        this.DF = DF;
        if (wears.contains("Броня")) this.DF += 10;
        if (wears.contains("Лошадь")) this.DF += 15;
        if (wears.contains("Шлем")) this.DF += 10;
    }

    @Override
    public void takeDanger(double AD) {
        int randomIndexWear = (int) (Math.random() * 4);
        int randomDestroyWear = (int) (Math.random() * 15);
        if (randomIndexWear <= wears.size() - 1) {
            if (randomDestroyWear >= 13) {
                String wear = wears.remove(randomIndexWear);
                if (wear.equals("Броня")) this.DF -= 10;
                if (wear.equals("Лошадь")) this.DF -= 15;
                if (wear.equals("Шлем")) this.DF -= 10;
            }
        }

        this.HP -= ((AD * DF/100 + 20));

        if (notificationIsEnabled) {
            proxyNotification.notificationDieUnity(this);
        }
    }

    public abstract BaseUnit clone();

    @Override
    public void putОn(String wear) {
        wears.add(wear);
    }

}
