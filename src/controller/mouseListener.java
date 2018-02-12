package controller;

import model.shapes.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mouseListener extends MouseAdapter{
    private GraphicsObserver observer;
    private Point origin = new Point(0,0);
    private Point end = new Point(0,0);


    public mouseListener(){}
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
        //not occurring
        end.setX(e.getX());
        end.setY(e.getY());

    }
    @Override
    public void mouseReleased(MouseEvent e){
        end.setX(e.getX());
        end.setY(e.getY());
        observer.addShape(origin,end);
    }
}
