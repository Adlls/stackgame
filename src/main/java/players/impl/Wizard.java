package players.impl;

import exceptions.NotEnoughCoinsException;
import players.ISpecialAction;
import players.IUnit;
import players.BaseUnit;
import java.util.List;

public class Wizard extends BaseUnit implements ISpecialAction {

    {
        HP = 100;
        AD = 20;
        DF = 18;
        COST = 400;
    }

    public Wizard(int price) throws NotEnoughCoinsException {
        super(price);
    }


    public Wizard(double HP, double AD, double DF, int price) throws NotEnoughCoinsException {
        super(price);
        this.HP = HP;
        this.AD = AD;
        this.DF = DF;
        this.price = price;
    }

    @Override
    public BaseUnit clone() {
        try {
            return new Wizard(this.HP, this.AD, this.DF, COST);
        } catch (NotEnoughCoinsException e) {
            e.printStackTrace();
        }
        return null;
    }


    private void cloneUnit(BaseUnit unit, List<BaseUnit> army) {
        if (!unit.isCloned()) {
            army.add(unit.clone());
            unit.setCloned(true);
        }
    }


    @Override
    public void doSpecialAction(List<BaseUnit> unitsArmy) {
        for (int i = 0; i < unitsArmy.size(); i++) {
            if (unitsArmy.get(i).equals(this)) {
                if ((i + 1 <= unitsArmy.size() - 1)) {
                    if (unitsArmy.get(i + 1) instanceof Knight
                            || unitsArmy.get(i + 1) instanceof Archer) {
                        cloneUnit(unitsArmy.get(i + 1), unitsArmy);
                    }
                } else if (i - 1 >= 0) {
                    if (unitsArmy.get(i - 1) instanceof Knight
                            || unitsArmy.get(i - 1) instanceof Archer) {
                        cloneUnit(unitsArmy.get(i - 1), unitsArmy);
                    }
                    break;
                }
            }
        }
    }

    @Override
    public double SpecialStrengthGet() {
        return 0;
    }
}
