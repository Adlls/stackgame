package menu;

import players.IUnit;

import java.util.List;
import java.util.Stack;

public class UndoCommand extends Command {

    public UndoCommand(List<IUnit> army) {
        super(army);
        historyArmy.push(null);
        System.out.println(historyArmy.size());
    }

    public List<IUnit> pop() {
        //System.out.println(historyArmy.size());
        printStack();
        return historyArmy.pop();
    }

    public void push(List<IUnit> army) {
       // System.out.println(historyArmy.size());
        printStack();
        historyArmy.push(army);
    }

    public void printStack() {
        System.out.println("stack history");
        for (List<IUnit> unit: historyArmy) {
            System.out.println(unit);
        }
    }

    @Override
    public List<IUnit> execute() {
        return pop();
    }
}
