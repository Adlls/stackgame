package players.impl;

import com.sun.jdi.event.ExceptionEvent;
import exceptions.NotEnoughPrice;
import players.BaseUnit;
import players.IUnit;

public class Infantry extends BaseUnit implements IUnit {

    private double HP;
    private double AD;
    private double DF;
   // private static double COST = 100;

    {
        AD = 13;
        DF = 10;
        HP = 100;
        COST = 100;

    }

   public Infantry(int price) throws NotEnoughPrice {
        super(price);
   }

   public Infantry(double HP, double AD, double DF, int price) throws NotEnoughPrice {
        super(price);
        this.AD = AD;
        this.DF = DF;
        this.HP = HP;
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
