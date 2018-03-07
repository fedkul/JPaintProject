package controller;

import model.shapes.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mouseListener extends MouseAdapter{
    private GraphicsObserver observer;
    private Point origin = new Point(0,0);
    private Point end = new Point(0,0);


    public mouseListener(GraphicsObserver observer){
        this.observer=observer;
    }
    @Override
    public void mousePressed(MouseEvent e){
        origin.setX(e.getX());
        origin.setY(e.getY());
    }
    @Override
    public void mouseDragged(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e){
        end.setX(e.getX());
        end.setY(e.getY());
        rearrangePoints();
        observer.addShape(origin,end);
    }
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
