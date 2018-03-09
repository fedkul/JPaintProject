package model.shapes;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class ShapeCollection {
    private static List<IShape> shapeList = new LinkedList<>();
    private static List<IShape> copyList = new LinkedList<>();
    private static List<IShape> selectList = new LinkedList<>();
    private static Graphics2D graphics2D;


    public static void addGraphics(Graphics2D graphics){graphics2D = graphics;}
    public static void addShape(IShape shape){
        shapeList.add(shape);
    }

    public static void selectShapes(Point origin, Point end){
        int oX, oY, eX, eY;
        oX = origin.getX(); oY = origin.getY();
        eX = end.getX(); eY = end.getY();
        selectList = new LinkedList<>();
        for (IShape shape:shapeList){
            if(
                    oX < shape.getOrigin().getX() &&
                            oY < shape.getOrigin().getY()&&
                            eX > shape.getEnd().getX() &&
                            eY > shape.getEnd().getY()
                    ) {selectList.add(shape);}
        }
    }
    public static void clearSelect(){selectList = new LinkedList<>();}
    public static List<IShape> getSelectedShapes(){return selectList;}

    public static void copyShapes(){
        for (IShape shape:selectList) {
            IShape tmp = ShapeFactory.getShape(
                    shape.getType(), shape.getOrigin(), shape.getEnd(),
                    shape.getPColor(), shape.getSColor(),
                    shape.getShading());
            copyList.add(tmp);
        }
    }
    public static void clearCopy(){copyList = new LinkedList<>();}
    public static List<IShape> getCopyShapes(){return copyList;}
    public static void setCopy(List<IShape> shapes){
        clearCopy();
        copyList.addAll(shapes);
    }

    public static void removeShape(IShape shape){
        shapeList.remove(shape);
    }
    public static void redrawShapes(){
        graphics2D.clearRect(0,0,2000,2000);
        for (IShape shape : shapeList) {shape.draw(graphics2D);}
    }


}
