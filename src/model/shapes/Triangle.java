package model.shapes;

import java.awt.*;
import java.util.Random;

public class Triangle implements IShape{
    private Point origin;
    private Point end;

    Triangle(){}

    Triangle(int x1, int y1, int x2, int y2){
        origin.setX(x1);
        origin.setY(y1);
        end.setX(x2);
        end.setY(y2);
    }

    @Override
    public void draw(Graphics2D graphics){
        Random rand = new Random();
        int int1 = rand.nextInt(100);
        int int2 = rand.nextInt(100);
        int int3 = rand.nextInt(100);

        graphics.drawPolygon( new int[] {int1,int2,int3}, new int[] {int1+10,int2+10,int3+10}, 3);
        System.out.println("Triangle");
    }

    @Override
    public Boolean equals(IShape shape) {
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
