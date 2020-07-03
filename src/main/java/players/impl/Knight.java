package players.impl;

import exceptions.NotEnoughCoinsException;
import players.BaseUnit;

public class Knight extends BaseUnit {

    private double HP;
    private double AD;
    private double DF;
    private int price;

    {
        HP = 100;
        AD = 27;
        DF = 20;
        COST = 500;
    }

   public Knight(int price) throws NotEnoughCoinsException {
        super(price);
   }

    @Override
    public String toString() {
        return "Knight{" +
                "HP=" + HP +
                ", AD=" + AD +
                ", DF=" + DF +
                '}';
    }

    public Knight(double HP, double AD, double DF, int price) throws NotEnoughCoinsException {
        super(price);
        this.HP = HP;
        this.AD = AD;
        this.DF = DF;
        this.price = price;
    }


    /*
    public void showWear() {
        for(String wear: wears) {
            System.out.println(wear);
        }
    }
     */
    public Knight clone() {
        try {
            return new Knight(this.HP, this.AD, this.DF, COST);
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
        this.HP -= AD;
        proxyNotification.notificationDieUnity(this);

    }
}
