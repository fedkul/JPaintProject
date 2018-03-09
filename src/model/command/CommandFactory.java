package model.command;

import model.StartAndEndPointMode;
import model.shapes.IShape;
import model.shapes.Point;
import view.EventName;

import java.awt.*;

public class CommandFactory {
    public static ICommand getCommand(StartAndEndPointMode startAndEndPointMode,
                                      Graphics2D graphics, IShape shape,
                                      Point origin, Point end){
        ICommand command = null;
        switch (startAndEndPointMode){
            case DRAW:
                command = new DrawCommand(graphics, shape);
                break;
            case MOVE:
                command = new MoveCommand(origin, end);
                break;
            case SELECT:
                command = new SelectCommand(origin, end);
                break;
        }
        return command;
    }
    public static  ICommand getCommand(EventName name){
        ICommand command = null;
        switch (name){
            case COPY:
                command = new CopyCommand();
                break;
            case PASTE:
                command = new PasteCommand();
                break;
            case UNDO:
                command = new UndoCommand();
                break;
            case REDO:
                command = new RedoCommand();
                break;
            case DELETE:
                command = new DeleteCommand();
                break;
        }
        return command;
    }
}
