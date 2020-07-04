package players.impl;

import exceptions.NotEnoughCoinsException;
import players.ISpecialAction;
import players.IUnit;
import players.BaseUnit;
import java.util.List;

public class Archer extends BaseUnit implements ISpecialAction {
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
    public BaseUnit clone() {
        try {
            return new Archer(this.HP, this.AD, this.DF, COST);
        } catch (NotEnoughCoinsException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void doSpecialAction(List<BaseUnit> unitsArmy) {
        int maxIndexArmy = unitsArmy.size() - 1;
        int targetIndexShot =  (int) (Math.random() * 6);

        if (targetIndexShot < maxIndexArmy) {
            unitsArmy.get(targetIndexShot).takeDanger(SpecialStrengthGet());
        } else {
            try {
                unitsArmy.get((targetIndexShot + 1) % (maxIndexArmy + 1)).takeDanger(SpecialStrengthGet());
            } catch (ArithmeticException e) {
            }
        }

    }

    @Override
    public double SpecialStrengthGet() {
        return this.AD + 30;
    }
}
