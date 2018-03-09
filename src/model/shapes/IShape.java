package model.shapes;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

import java.awt.*;

public interface IShape{

    //method for outputting shape into jpaint
    void draw(Graphics2D graphics);
    void border(Graphics2D graphics);
    void fill(Graphics2D graphics);
    Boolean equals(IShape shape);
    void setOrigin(int x, int y);
    void setEnd(int x, int y);
    Point getOrigin();
    Point getEnd();
    ShapeType getType();
    ShapeColor getPColor();
    ShapeColor getSColor();
    ShapeShadingType getShading();
}
