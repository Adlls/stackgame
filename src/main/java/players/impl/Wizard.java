package players.impl;

import exceptions.NotEnoughCoinsException;
import players.BaseUnit;
import players.ISpecialAction;
import players.IUnit;

import java.util.List;

public class Wizard extends BaseUnit implements ISpecialAction {

    private double HP;
    private double AD;
    private double DF;

    {
        HP = 100;
        AD = 20;
        DF = 18;
        COST = 400;
    }


    public Wizard(int price) throws NotEnoughCoinsException {
        super(price);
    }


    @Override
    public String toString() {
        return "Wizard{" +
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
            if (unitsArmy.get(i).equals(this)) {
                if ((i + 1 <= unitsArmy.size() - 1)) {
                    if (unitsArmy.get(i + 1) instanceof Knight) {
                           unitsArmy.add(((Knight) unitsArmy.get(i + 1)).clone());

                    } else if (unitsArmy.get(i + 1) instanceof Archer) {
                           unitsArmy.add(((Archer) unitsArmy.get(i + 1)).clone());
                    }
                } else if (i - 1 >= 0) {
                    if (unitsArmy.get(i - 1) instanceof Knight) {
                           unitsArmy.add(((Knight) unitsArmy.get(i - 1)).clone());
                    } else if (unitsArmy.get(i - 1) instanceof Archer) {
                           unitsArmy.add(((Archer) unitsArmy.get(i - 1)).clone());
                    }
                }
                break;
            }
        }
    }

    @Override
    public double SpecialStrengthGet() {
        return 0;
    }
}
