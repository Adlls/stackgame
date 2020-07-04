package menu.command;

import players.BaseUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReceiverCommand {

    private Stack<List<BaseUnit>> undoArmy = new Stack<>();
    private Stack<List<BaseUnit>> redoArmy = new Stack<>();

    public ReceiverCommand() { }

    public List<BaseUnit> popUndoArmy() {
        if (!undoArmy.empty()) {
            List<BaseUnit> units = undoArmy.pop();
            return units;
        }
        else return null;
    }

    public List<BaseUnit> popRedoArmy() {
        if (!redoArmy.empty()) {
            List<BaseUnit> units = redoArmy.pop();
            undoArmy.push(units);
            return units;
        }
        else {
            return undoArmy.peek();
        }
    }

    public void pushRedoArmy(List<BaseUnit> army) {
        List<BaseUnit> tempUserArmy = new ArrayList<>();
        if (army != null) {
            for (int i = 0; i < army.size(); i++) {
                tempUserArmy.add(army.get(i).clone());
            }
            redoArmy.push(tempUserArmy);
        }
    }

    public void pushUndoArmy(List<BaseUnit> army) {
        List<BaseUnit> tempUserArmy = new ArrayList<>();
        if (army != null) {
            for (int i = 0; i < army.size(); i++) {
                tempUserArmy.add(army.get(i).clone());
            }
            undoArmy.push(tempUserArmy);
        } else {
            undoArmy.push(null);
        }
    }


    public List<BaseUnit> undo() {
        return popUndoArmy();
    }

    public List<BaseUnit> redo() {
        return popRedoArmy();
    }
}
