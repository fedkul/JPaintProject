package model.shapes;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class ShapeCollection {
    private List<IShape> shapeList = new LinkedList<>();
    public void addShape(IShape shape){
        shapeList.add(shape);
    }
    public void removeShape(IShape shape){
        shapeList.remove(shape);
    }
    public void drawShapes(Graphics2D graphics){
        for (IShape shape : shapeList) {shape.draw(graphics);}
    }
    public void setShapeCollection(List<IShape> shapeList){
        this.shapeList = shapeList;
    }
    public List<IShape> getShapeCollection(){
        return shapeList;
    }
}
