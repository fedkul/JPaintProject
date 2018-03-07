package model.shapes;

import model.ShapeColor;
import model.ShapeShadingType;
import java.awt.*;
import java.lang.reflect.Field;

public class Ellipse implements IShape {
    private Point origin;
    private Point end;
    private ShapeColor pColor;
    private ShapeColor sColor;
    private ShapeShadingType shading;

    Ellipse(Point origin, Point end, ShapeColor pColor, ShapeColor sColor, ShapeShadingType shading){
        this.origin = origin; this.end = end;
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
        try{
            Field field = Color.class.getField(pColor.toString());
             color = (Color)field.get(null);
        }catch(Exception e) {
            color = null; // Not defined
        }
        graphics.setColor(color);
        graphics.drawOval(origin.getX(), origin.getY(),
                end.getX()-origin.getX(),end.getY()-origin.getY());
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
        graphics.fillOval(origin.getX(), origin.getY(),
                end.getX()-origin.getX(),end.getY()-origin.getY());
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
