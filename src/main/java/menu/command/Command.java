package menu.command;

import players.BaseUnit;

import java.util.List;

public abstract class Command {

    protected ReceiverCommand receiverCommand;

    public Command(ReceiverCommand receiverCommand) {
        this.receiverCommand = receiverCommand;
    }


    public abstract List<BaseUnit> execute();

}
