package players.impl;

import exceptions.NotEnoughCoinsException;
import players.BaseUnit;
import players.IUnit;

public class Knight extends BaseUnit implements IUnit {

    private double HP;
    private double AD;
    private double DF;
   // public final static double COST = 500;

    {
        HP = 100;
        AD = 27;
        DF = 20;
        COST = 500;
    }

   public Knight(int price) throws NotEnoughCoinsException {
        super(price);
   }

   public Knight(double HP, double AD, double DF, int price) throws NotEnoughCoinsException {
        super(price);
        this.HP = HP;
        this.AD = AD;
        this.DF = DF;
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
    public void setHP(double HP) throws Exception {
        if (HP > 0 && HP <= 100) this.HP = HP;
        else throw new Exception("HP is incorrect");
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
    public void TakeDanger(double AD) {

    }
}
