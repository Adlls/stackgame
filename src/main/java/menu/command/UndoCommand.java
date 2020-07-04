package menu.command;

import players.BaseUnit;

import java.util.List;

public class UndoCommand extends Command {


    public UndoCommand(ReceiverCommand receiverCommand) {
        super(receiverCommand);
    }

    @Override
    public List<BaseUnit> execute() {
        return receiverCommand.undo();
    }

}
