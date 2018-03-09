package model.command;

import model.shapes.IShape;
import model.shapes.ShapeCollection;

import java.util.LinkedList;
import java.util.List;

public class DeleteCommand implements ICommand, IUndoable {

    private final List<IShape> shapes = new LinkedList<>();

    @Override
    public void run() {
        for (IShape shape:
                ShapeCollection.getSelectedShapes()) {

            ShapeCollection.removeShape(shape);
            shapes.add(shape);
        }
        ShapeCollection.redrawShapes();
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for (IShape shape:
             shapes) {
            ShapeCollection.addShape(shape);
        }
        ShapeCollection.redrawShapes();
    }

    @Override
    public void redo() {
        for (IShape shape:
                shapes) {
            ShapeCollection.removeShape(shape);
        }
        ShapeCollection.redrawShapes();
    }
}
