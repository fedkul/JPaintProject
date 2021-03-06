package model.shapes;

import java.awt.*;

public interface IShape{

    //method for outputting shape into jpaint
    void draw(Graphics2D graphics);
    Boolean equals(IShape shape);
    void setOrigin(int x, int y);
    void setEnd(int x, int y);
    Point getOrigin();
    Point getEnd();


}
