package controller;

import model.shapes.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mouseListener extends MouseAdapter{
    private final GraphicsObserver observer;
    private final Point origin = new Point(0,0);
    private final Point end = new Point(0,0);


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
        observer.runCommand(origin,end);
    }
}
