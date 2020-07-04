package menu.command;

import menu.GameField;
import players.BaseUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReceiverCommand {

    private Stack<List<BaseUnit>> historyArmy = new Stack<>();
    private Stack<List<BaseUnit>> redoArmy = new Stack<>();

    public ReceiverCommand() { }

    public List<BaseUnit> popHistoryArmy() {
        //printStack();
        if (!historyArmy.empty()) {
            List<BaseUnit> units = historyArmy.pop();
            redoArmy.push(units);
            return units;
        }
        else return null;
    }

    public List<BaseUnit> popRedoArmy() {
        //printStack();
        if (!redoArmy.empty()) {
            List<BaseUnit> units = redoArmy.pop();
            historyArmy.push(units);
            return units;
        }
        else return null;
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


    public List<BaseUnit> undo() {
        return popHistoryArmy();
    }

    public List<BaseUnit> redo() {
        return popRedoArmy();
    }
}
