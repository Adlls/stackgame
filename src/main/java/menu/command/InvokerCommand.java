package menu.command;

import players.BaseUnit;

import java.util.List;

public class InvokerCommand {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public List<BaseUnit> executeCommand() {
       return command.execute();
    }
}
