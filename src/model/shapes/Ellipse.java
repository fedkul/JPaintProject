package model.shapes;

import java.awt.*;

public class Ellipse implements IShape {
    private Point origin  = new Point(0,0);
    private Point end  = new Point(0,0);

    Ellipse(){}

    Ellipse(int x1, int y1, int x2, int y2){
        origin.setX(x1);
        origin.setY(y1);
        end.setX(x2);
        end.setY(y2);
    }

    @Override
    public void draw(Graphics2D graphics){
        graphics.drawOval(origin.getX(), origin.getY(),
                end.getX()-origin.getX(),end.getY()-origin.getY());
        System.out.println("Ellipse");
    }
    @Override
    public Boolean equals(IShape shape){
        return shape.getOrigin().equals(origin) &&
                shape.getEnd().equals(end);
    }

    @Override
    public void setOrigin(int x, int y) {
        origin.setX(x);
        origin.setY(y);
    }

    @Override
    public void setEnd(int x, int y) {
        end.setX(x);
        end.setY(y);
    }

    @Override
    public Point getOrigin() {
        return origin;
    }

    @Override
    public Point getEnd() {
        return end;
    }
}
