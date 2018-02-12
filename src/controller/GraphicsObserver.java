package controller;

import model.persistence.ApplicationState;
import model.shapes.IShape;
import model.shapes.Point;
import model.shapes.ShapeCollection;
import model.shapes.ShapeFactory;
import java.awt.*;

public class GraphicsObserver {
    private ShapeCollection collection = new ShapeCollection();
    private ApplicationState appState;
    private Graphics2D graphics;
    private final ShapeFactory shapeFactory = new ShapeFactory();

    public GraphicsObserver(){}
    public GraphicsObserver(ShapeCollection collection, ApplicationState state){
        this.collection = collection;
        appState = state;
    }
    public void addShape(Point origin, Point end){
        IShape shape = shapeFactory.getShape(appState.getActiveShapeType());
        shape.setOrigin(origin.getX(), origin.getY());
        shape.setEnd(end.getX(),end.getY());
        collection.addShape(shape);
        drawCollection();
    }


    public void setShapeCollection(ShapeCollection collection){
        this.collection = collection;
    }
    //Add a reference to the Graphics obj
    public void addGraphics(Graphics2D graphics){
        this.graphics=graphics;
    }
    public ShapeCollection getShapeCollection(){
        return collection;
}
    private void drawCollection(){collection.drawShapes(graphics);}
}
