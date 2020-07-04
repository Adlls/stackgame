package players.impl;
import players.BaseUnit;
import exceptions.NotEnoughCoinsException;
import players.IUnit;

public class Knight extends BaseUnit {

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
        this.price = price;
    }

    @Override
    public BaseUnit clone() {
        try {
            return new Knight(this.HP, this.AD, this.DF, COST);
        } catch (NotEnoughCoinsException e) {
            e.printStackTrace();
        }
        return null;
    }


}
