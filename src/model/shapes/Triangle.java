package model.shapes;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

import java.awt.*;
import java.lang.reflect.Field;

public class Triangle implements IShape{
    private final Point origin;
    private final Point end;
    private final ShapeColor pColor;
    private final ShapeColor sColor;
    private final ShapeShadingType shading;
    private final ShapeType type = ShapeType.TRIANGLE;

    Triangle(Point origin, Point end, ShapeColor pColor, ShapeColor sColor, ShapeShadingType shading){
        this.origin = new Point(origin); this.end = new Point(end);
        rearrangePoints();
        this.pColor = pColor; this.sColor = sColor;
        this.shading = shading;
    }

    @Override
    public void draw(Graphics2D graphics){
        if (shading.equals(ShapeShadingType.FILLED_IN)
                || shading.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {fill(graphics);}
        if (shading.equals(ShapeShadingType.OUTLINE)
                || shading.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {border(graphics);}
    }

    @Override
    public void border(Graphics2D graphics) {
        Color color;
        String pOrS;
        if(shading.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) pOrS = sColor.toString();
        else pOrS = pColor.toString();
        try{
            Field field = Color.class.getField(pOrS);
            color = (Color)field.get(null);
        }catch(Exception e) {
            color = null; // Not defined
        }
        graphics.setColor(color);
        int x1,x2,x3;
        int y1,y2;
        x1=origin.getX();
        x3=end.getX();
        x2=(x3-((x3-x1)/2));

        y1=end.getY();
        y2=origin.getY();

        graphics.drawPolygon( new int[] {x1,x2,x3}, new int[] {y1,y2,y1}, 3);
    }

    @Override
    public void fill(Graphics2D graphics) {
        Color color;
        try{
            Field field = Color.class.getField(sColor.toString());
            color = (Color)field.get(null);
        }catch(Exception e) {
            color = null; // Not defined
        }
        graphics.setColor(color);
        int x1,x2,x3;
        int y1,y2;
        x1=origin.getX();
        x3=end.getX();
        x2=(x3-((x3-x1)/2));

        y1=end.getY();
        y2=origin.getY();

        graphics.fillPolygon( new int[] {x1,x2,x3}, new int[] {y1,y2,y1}, 3);
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

    //get access to fields for recreation
    @Override
    public Point getOrigin() {
        return origin;
    }
    @Override
    public Point getEnd() {
        return end;
    }
    @Override
    public ShapeType getType() {
        return type;
    }
    @Override
    public ShapeColor getPColor() {return pColor;}
    @Override
    public ShapeColor getSColor() {return sColor;}
    @Override
    public ShapeShadingType getShading() {return shading;}

    //set origin to upper left and end to lower right
    private void rearrangePoints(){
        int x1=origin.getX(),y1=origin.getY(),x2=end.getX(),y2=end.getY();
        if(x1>x2) {
            origin.setX(x2);
            end.setX(x1);
        }
        if(y1>y2){
            origin.setY(y2);
            end.setY(y1);
        }
    }
}
