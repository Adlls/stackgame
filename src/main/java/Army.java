import exceptions.NotEnoughPrice;
import players.IUnit;
import players.IUnitFactory;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Army implements IArmy {

    private List<IUnitFactory> currentUnits;
    public static final int minPrice = 50;


    public Army() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String getScanPath = System.getProperty("user.dir") + "/src/main/java/players/impl/";
        String classname;
        File scanDirectory = new File(getScanPath);
        currentUnits = new ArrayList<>();
        for (File item: scanDirectory.listFiles()) {
            classname = item.getName().substring(0, item.getName().indexOf("."));
            if (classname.toLowerCase().contains("factory"))
                currentUnits.add((IUnitFactory)
                        Class.forName("players.impl."+classname)
                                .getDeclaredConstructor()
                                .newInstance());
        }
    }


    @Override
    public int getMinPrice() {
        return minPrice;
    }

    @Override
    public List<IUnit> createArmy(int price) throws NotEnoughPrice {
        List<IUnit> army = new ArrayList<>();
        int sizeUnitFactory = currentUnits.size();
        int randomIndex;
        while (price >= getMinPrice()) {
            randomIndex = (int) (Math.random() * (sizeUnitFactory));
            System.out.println(randomIndex);
            IUnit unit = currentUnits.get(randomIndex).createUnit(price);
            army.add(unit);
            price -=  unit.getCost();
        }
        return army;
    }
}
