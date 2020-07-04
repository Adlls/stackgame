package menu;

import players.BaseUnit;
import players.IUnit;

import java.util.ArrayList;
import java.util.List;

public class UndoCommand extends Command {



    public UndoCommand() {
    }

    public List<BaseUnit> pop() {
        //printStack();
        if (!historyArmy.empty()) return historyArmy.pop(); else return null;
    }

    public void push(List<BaseUnit> army) {
        //printStack();
        List<BaseUnit> tempUserArmy = new ArrayList<>();
        if (army != null) {
            for (int i = 0; i < army.size(); i++) {
                tempUserArmy.add(army.get(i).clone());
            }
            historyArmy.push(tempUserArmy);
        } else {
            historyArmy.push(null);
        }
    }

    public void printStack() {
        System.out.println("stack history");
        for (List<BaseUnit> item: historyArmy) {
            System.out.println(item);
        }
    }
}
