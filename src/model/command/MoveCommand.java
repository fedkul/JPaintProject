package model.command;

import model.shapes.IShape;
import model.shapes.Point;
import model.shapes.ShapeCollection;

import java.util.List;

public class MoveCommand implements ICommand, IUndoable {

    private final List<IShape> collection;
    private final int xDist;
    private final int yDist;

    public  MoveCommand(Point origin, Point end){
        xDist = end.getX() - origin.getX();
        yDist = end.getY() - origin.getY();
        this.collection = ShapeCollection.getSelectedShapes();
    }

    @Override
    public void run() {
        for (IShape shape:
                collection) {
            shape.setOrigin(shape.getOrigin().getX() + xDist, shape.getOrigin().getY() + yDist);
            shape.setEnd(shape.getEnd().getX() + xDist, shape.getEnd().getY() + yDist);
        }
        ShapeCollection.redrawShapes();
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for (IShape shape:
                collection) {
            shape.setOrigin(shape.getOrigin().getX() - xDist, shape.getOrigin().getY() - yDist);
            shape.setEnd(shape.getEnd().getX() - xDist, shape.getEnd().getY() - yDist);
        }
        ShapeCollection.redrawShapes();
    }

    @Override
    public void redo() {
        for (IShape shape:
                collection) {
            shape.setOrigin(shape.getOrigin().getX() + xDist, shape.getOrigin().getY() + yDist);
            shape.setEnd(shape.getEnd().getX() + xDist, shape.getEnd().getY() + yDist);
        }
        ShapeCollection.redrawShapes();
    }
}
