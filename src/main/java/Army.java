import players.IUnit;
import players.IUnitFactory;
import players.impl.InfantryFactory;

import java.util.ArrayList;
import java.util.List;

public class Army implements IArmy {

    private List<IUnit> army;
    private IUnitFactory unitFactory;
    public static final int minPrice = 50;


    public Army() {
        army = new ArrayList<>();
    }


    @Override
    public int getMinPrice() {
        return minPrice;
    }

    @Override
    public List<IUnit> createArmy(int price) {
        //int sizeArmy = (int) (Math.random() + price)/;
        unitFactory = new InfantryFactory();
        return null;
    }
}
