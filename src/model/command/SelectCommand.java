package model.command;

import model.shapes.Point;
import model.shapes.ShapeCollection;

public class SelectCommand implements ICommand, IUndoable {

    private final Point origin;
    private final Point end;

    public  SelectCommand(Point origin, Point end){
        this.origin = new Point(origin); this.end = new Point(end);
        rearrangePoints();
    }

    @Override
    public void run() {
        ShapeCollection.selectShapes(origin, end);
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        ShapeCollection.clearSelect();
    }

    @Override
    public void redo() {
        ShapeCollection.selectShapes(origin, end);
    }
    //set origin to upper left and end to lower right to function alongside shapes
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
