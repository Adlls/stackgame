package menu;

import players.BaseUnit;
import players.IUnit;

import java.util.List;
import java.util.Stack;

public abstract class Command {

    public Stack<List<BaseUnit>> historyArmy = new Stack<>();

    public Command() { }


}
