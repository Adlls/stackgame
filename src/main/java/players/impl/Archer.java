package players.impl;

import exceptions.NotEnoughCoinsException;
import players.BaseUnit;
import players.ISpecialAction;
import players.IUnit;

import java.util.List;

public class Archer extends BaseUnit implements ISpecialAction {

    private double HP;
    private double AD;
    private double DF;

    {
        AD = 10;
        DF = 15;
        HP = 100;
        COST = 120;
    }

   public Archer(int price) throws NotEnoughCoinsException {
        super(price);

    }

    public Archer(double HP, double AD, double DF, int price) throws NotEnoughCoinsException {
       super(price);
       this.HP = HP;
       this.AD = AD;
       this.DF = DF;
    }

    @Override
    public String toString() {
        return "Archer{" +
                "HP=" + HP +
                ", AD=" + AD +
                ", DF=" + DF +
                '}';
    }

    public Archer clone() {
        try {
            return new Archer(this.HP, this.AD, this.DF, COST);
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
    }

    @Override
    public void doSpecialAction(List<IUnit> unitsArmy) {
        int maxIndexArmy = unitsArmy.size() - 1;
        int targetIndexShot =  (int) (Math.random() * 6);

        if (targetIndexShot < maxIndexArmy) {
            unitsArmy.get(targetIndexShot).takeDanger(SpecialStrengthGet());
        } else {
            unitsArmy.get((targetIndexShot + 1) % (maxIndexArmy + 1)).takeDanger(SpecialStrengthGet());
        }

    }

    @Override
    public double SpecialStrengthGet() {
        return this.AD + 30;
    }
}