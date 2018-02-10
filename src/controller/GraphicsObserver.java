package controller;

import model.shapes.IShape;
import model.shapes.ShapeCollection;

import java.util.List;

public class GraphicsObserver {
    private ShapeCollection collection= new ShapeCollection();

    public GraphicsObserver(){}
    public GraphicsObserver(List<IShape> shapeList){
        collection.setShapeCollection(shapeList);
    }


    public void setShapeCollection(List<IShape> shapeList){
        collection.setShapeCollection(shapeList);
    }
    public ShapeCollection getShapeCollection(){
        return collection;
    }
}
