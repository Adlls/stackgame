package players.impl;

import exceptions.NotEnoughCoinsException;
import players.BaseUnit;
import players.ISpecialAction;
import players.IUnit;

import java.util.List;

public class Healer extends BaseUnit implements ISpecialAction {

    private double HP;
    private double AD;
    private double DF;

    {
        AD = 5;
        DF = 18;
        HP = 100;
        COST = 160;
    }

    @Override
    public String toString() {
        return "Healer{" +
                "HP=" + HP +
                ", AD=" + AD +
                ", DF=" + DF +
                '}';
    }


    public Healer(int price) throws NotEnoughCoinsException {
        super(price);
    }

    public Healer(double HP, double AD, double DF, int price) throws NotEnoughCoinsException {
        super(price);
        this.HP = HP;
        this.AD = AD;
        this.DF = DF;
    }


    public Healer clone() {
        try {
            return new Healer(this.HP, this.AD, this.DF, COST);
        } catch (NotEnoughCoinsException e) {
            e.printStackTrace();
        }
        return null;
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
    }

    @Override
    public void doSpecialAction(List<IUnit> unitsArmy) {
            for (int i = 0; i < unitsArmy.size(); i++) {
                if (unitsArmy.get(i).equals(this)) {
                    if (i + 1 <= unitsArmy.size() - 1) unitsArmy.get(i + 1).setHP(10);
                    if (i - 1 >= 0) unitsArmy.get(i - 1).setHP(10);
                    break;
                }
            }
        }

    @Override
    public double SpecialStrengthGet() {
        return 0;
    }
}
