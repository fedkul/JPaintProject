package model.command;

import model.shapes.IShape;
import model.shapes.ShapeCollection;
import java.util.LinkedList;
import java.util.List;

public class CopyCommand implements ICommand, IUndoable {

    private final List<IShape> shapes = new LinkedList<>();

    @Override
    public void run() {
        ShapeCollection.copyShapes();
        shapes.addAll(ShapeCollection.getSelectedShapes());
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        ShapeCollection.clearCopy();
    }

    @Override
    public void redo() {
        ShapeCollection.setCopy(shapes);
    }
}
