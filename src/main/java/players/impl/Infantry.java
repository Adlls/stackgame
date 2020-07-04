package players.impl;

import exceptions.NotEnoughCoinsException;
import players.ISpecialAction;
import players.IUnit;
import players.impl.decorator.Accouter;
import players.impl.decorator.AccouterDecorator;
import players.impl.decorator.HelmetAccouterDecorator;
import players.impl.decorator.HorseAccouterDecorator;
import players.BaseUnit;
import java.util.List;

public class Infantry extends BaseUnit implements ISpecialAction {

    {
        AD = 13;
        DF = 10;
        HP = 100;
        COST = 100;
    }

   public Infantry(int price) throws NotEnoughCoinsException {
        super(price);
   }

   public Infantry(double HP, double AD, double DF, int price) throws NotEnoughCoinsException {
        super(price);
        this.AD = AD;
        this.DF = DF;
        this.HP = HP;
    }

    @Override
    public BaseUnit clone() {
        try {
            return new Infantry(this.HP, this.AD, this.DF, COST);
        } catch (NotEnoughCoinsException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public void doSpecialAction(List<BaseUnit> unitsArmy) {
            for (int i = 0; i < unitsArmy.size(); i++) {
                if (unitsArmy.get(i).equals(this) && (i - 1) >= 0 && (i + 1) <= unitsArmy.size() - 1) {
                    if (unitsArmy.get(i - 1) instanceof Knight) {
                        if (unitsArmy.get(i - 1).getWears().isEmpty()) {
                            AccouterDecorator accouter =
                                    new HorseAccouterDecorator(new HelmetAccouterDecorator(new Accouter()));
                            accouter.toDress(unitsArmy.get(i - 1));
                            //устанавливаем только новую броню
                            unitsArmy.get(i - 1).setDF(unitsArmy.get(i - 1).getDF());
                        }
                        break;
                    } else if (unitsArmy.get(i + 1) instanceof Knight) {
                        if (unitsArmy.get(i + 1).getWears().isEmpty()) {
                            AccouterDecorator accouter =
                                    new HorseAccouterDecorator(new HelmetAccouterDecorator(new Accouter()));
                            accouter.toDress(unitsArmy.get(i + 1));
                            //устанавливаем только новую броню
                            unitsArmy.get(i + 1).setDF(unitsArmy.get(i + 1).getDF());
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
