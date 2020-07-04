package menu.command;

import players.BaseUnit;
import players.IUnit;

import java.util.List;

public class RedoCommand extends Command {

    private ReceiverCommand receiverCommand;

    public RedoCommand(ReceiverCommand receiverCommand) {
        super(receiverCommand);
        this.receiverCommand = receiverCommand;
    }

    @Override
    public List<BaseUnit> execute() {
        return receiverCommand.redo();
    }
}
