package model.shapes;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

public class ShapeFactory {

    //use getShape to get the object
    public IShape getShape(ShapeType shapeType, Point origin, Point end, ShapeColor pColor, ShapeColor sColor, ShapeShadingType shading){
        IShape shape = null;
        switch (shapeType){
            case ELLIPSE:
                shape = new Ellipse(origin, end, pColor, sColor, shading);
                break;
            case TRIANGLE:
                shape = new Triangle(origin, end, pColor, sColor, shading);
                break;
            case RECTANGLE:
                shape = new Rectangle(origin, end, pColor, sColor, shading);
                break;
        }
        return shape;
    }
}
