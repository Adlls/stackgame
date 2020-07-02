package players.impl;

import exceptions.NotEnoughCoinsException;
import players.BaseUnit;
import players.ISpecialAction;
import players.IUnit;

public class Archer extends BaseUnit implements IUnit, ISpecialAction {

    private double HP;
    private double AD;
    private double DF;
    private int price;

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
       this.price = price;
    }

    @Override
    public String toString() {
        return "Archer{" +
                "HP=" + HP +
                ", AD=" + AD +
                ", DF=" + DF +
                '}';
    }

    @Override
    public Archer clone() throws CloneNotSupportedException {
        return (Archer) super.clone();
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
    public void doSpecialAction() {
        System.out.println("Стреляет через головы");
    }

    @Override
    public double SpecialStrengthGet() {
        return this.AD + 30;
    }
}
