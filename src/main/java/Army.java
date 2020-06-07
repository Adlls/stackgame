import exceptions.NotEnoughCoinsException;
import players.IUnit;
import players.IUnitFactory;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Army implements IArmy {


    private List<IUnitFactory> currentUnits;
    public static final int minPrice = 50;

    public Army() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {
        Logger.getLogger().writeClassInstanceLog(Army.class);
        currentUnits = new ArrayList<>();
        getCurrentUnits(scanPathFactoriesForCurrentUnits(currentUnits));
    }

    private List<IUnitFactory> scanPathFactoriesForCurrentUnits(List<IUnitFactory> currentUnits) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String getScanPath = System.getProperty("user.dir") + "/src/main/java/players/impl/factories";
        String classname;
        File scanDirectory = new File(getScanPath);
        for (File item: scanDirectory.listFiles()) {
            classname = item.getName().substring(0, item.getName().indexOf("."));
            if (classname.toLowerCase().contains("factory"))
                currentUnits.add((IUnitFactory)
                        Class.forName("players.impl.factories."+classname)
                                .getDeclaredConstructor()
                                .newInstance());
        }
        return currentUnits;
    }

    private void getCurrentUnits(List<IUnitFactory> factories) {
        currentUnits = factories;
    }


    @Override
    public int getMinPrice() {
        return minPrice;
    }

    @Override
    public List<IUnit> createArmy(int price) {
        List<IUnit> army = new ArrayList<>();
        int sizeUnitFactory = currentUnits.size();
        int randomIndex;
        while (price >= getMinPrice()) {
            randomIndex = (int) (Math.random() * (sizeUnitFactory));
            try {
                IUnit unit = currentUnits.get(randomIndex).createUnit(price);
                army.add(unit);
                price -= unit.getCost();
            } catch (NotEnoughCoinsException ex) {
                System.out.println(ex.getMessage() + " for " + (army.size() - 1));
                break;
            }

        }
        return army;
    }
}
