package players;

import java.util.List;

public interface ISpecialAction {
    void doSpecialAction(List<BaseUnit> unitsArmy);
    double SpecialStrengthGet();
}
