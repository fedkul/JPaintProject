package model.command;

import model.shapes.IShape;
import model.shapes.ShapeCollection;

import java.awt.*;

public class DrawCommand implements ICommand, IUndoable {

    private final Graphics2D graphics;
    private final IShape shape;

    public DrawCommand(Graphics2D graphics, IShape shape){
        this.graphics = graphics;
        this.shape = shape;
    }

    @Override
    public void run() {
        ShapeCollection.addShape(shape);
        shape.draw(graphics);
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        ShapeCollection.removeShape(shape);
        ShapeCollection.redrawShapes();
    }

    @Override
    public void redo() {
        ShapeCollection.addShape(shape);
        ShapeCollection.redrawShapes();
    }
}
