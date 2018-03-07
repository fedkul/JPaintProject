package controller;

import model.persistence.ApplicationState;
import model.shapes.IShape;
import model.shapes.Point;
import model.shapes.ShapeCollection;
import model.shapes.ShapeFactory;
import java.awt.*;

public class GraphicsObserver {
    private ShapeCollection collection ;
    private ApplicationState appState;
    private Graphics2D graphics;
    private final ShapeFactory shapeFactory = new ShapeFactory();

    public GraphicsObserver(ShapeCollection collection, ApplicationState state, Graphics2D graphics){
        this.collection = collection;
        this.graphics = graphics;
        appState = state;
    }
    public void addShape(Point origin, Point end){
        IShape shape = shapeFactory.getShape(
                        appState.getActiveShapeType(),
                        origin, end,
                        appState.getActivePrimaryColor(),
                        appState.getActiveSecondaryColor(),
                        appState.getActiveShapeShadingType());

        collection.addShape(shape);
        shape.draw(graphics);
        //collection.drawShapes(graphics);
    }
    private void drawCollection(){}
}
