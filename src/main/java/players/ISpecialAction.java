package players;

import java.util.List;

public interface ISpecialAction {
    void doSpecialAction(List<IUnit> unitsArmy);
    double SpecialStrengthGet();
}
