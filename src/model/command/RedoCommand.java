package model.command;

public class RedoCommand implements ICommand{
    @Override
    public void run() {
        CommandHistory.redo();
    }
}
