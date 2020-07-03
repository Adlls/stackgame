package players.impl;

import exceptions.NotEnoughCoinsException;
import players.BaseUnit;
import players.ISpecialAction;
import players.IUnit;
import players.impl.decorator.Accouter;
import players.impl.decorator.AccouterDecorator;
import players.impl.decorator.HelmetAccouterDecorator;
import players.impl.decorator.HorseAccouterDecorator;

import java.util.List;

public class Infantry extends BaseUnit implements ISpecialAction {

    private double HP;
    private double AD;
    private double DF;

    {
        AD = 13;
        DF = 10;
        HP = 100;
        COST = 100;
    }

   public Infantry(int price) throws NotEnoughCoinsException {
        super(price);
   }

   public Infantry(double HP, double AD, double DF, int price) throws NotEnoughCoinsException {
        super(price);
        this.AD = AD;
        this.DF = DF;
        this.HP = HP;
    }

    public Infantry clone() {
        try {
            return new Infantry(this.HP, this.AD, this.DF, COST);
        } catch (NotEnoughCoinsException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public String toString() {
        return "Infantry{" +
                "HP=" + HP +
                ", AD=" + AD +
                ", DF=" + DF +
                '}';
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
    }

    @Override
    public void takeDanger(double AD) {
        this.HP -= AD;
        proxyNotification.notificationDieUnity(this);
    }

    @Override
    public void doSpecialAction(List<IUnit> unitsArmy) {
            for (int i = 0; i < unitsArmy.size(); i++) {
                if (unitsArmy.get(i).equals(this) && (i - 1) >= 0 && (i + 1) <= unitsArmy.size() - 1) {
                    if (unitsArmy.get(i - 1) instanceof Knight) {
                        AccouterDecorator accouter =
                                new HorseAccouterDecorator(new HelmetAccouterDecorator(new Accouter()));
                        accouter.toDress(unitsArmy.get(i - 1));
                        ((Knight) unitsArmy.get(i - 1)).showWear();
                        //устанавливаем только новую броню
                        unitsArmy.get(i - 1).setDF(getDF());
                        break;
                    } else if (unitsArmy.get(i + 1) instanceof Knight) {
                        AccouterDecorator accouter =
                                new HorseAccouterDecorator(new HelmetAccouterDecorator(new Accouter()));
                        accouter.toDress(unitsArmy.get(i + 1));
                        ((Knight) unitsArmy.get(i + 1)).showWear();
                        //устанавливаем только новую броню
                        unitsArmy.get(i - 1).setDF(getDF());
                        break;
                    }
                }
            }

        }

    @Override
    public double SpecialStrengthGet() {
        return 0;
    }
}
