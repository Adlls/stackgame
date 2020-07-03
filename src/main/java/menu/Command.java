package menu;

import players.IUnit;

import java.util.List;
import java.util.Stack;

public abstract class Command {
    protected List<IUnit> army;
    protected Stack<List<IUnit>> historyArmy = new Stack<>();

   public Command(List<IUnit> army) {
        this.army = army;
    }

    public abstract List<IUnit> pop();

    public abstract void push(List<IUnit> army);

    public abstract List<IUnit> execute();
}
