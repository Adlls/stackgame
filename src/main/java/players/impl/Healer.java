package players.impl;

import exceptions.NotEnoughCoinsException;
import players.BaseUnit;
import players.ISpecialAction;
import players.IUnit;

import java.util.List;

public class Healer extends BaseUnit implements ISpecialAction {
    {
        AD = 5;
        DF = 18;
        HP = 100;
        COST = 160;
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

    @Override
    public BaseUnit clone() {
        try {
            return new Healer(this.HP, this.AD, this.DF, COST);
        } catch (NotEnoughCoinsException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void doSpecialAction(List<BaseUnit> unitsArmy) {
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
