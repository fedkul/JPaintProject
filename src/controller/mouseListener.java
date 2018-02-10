package controller;

import model.ShapeType;
import model.shapes.ShapeFactory;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mouseListener extends MouseAdapter{
    private Graphics2D graphics = null;
    ShapeFactory shapeFactory = new ShapeFactory();


    public mouseListener(){}
    public mouseListener(Graphics2D graphics){
        this.graphics=graphics;
    }
    @Override
    public void mousePressed(MouseEvent e){

    }
    @Override
    public void mouseDragged(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e){

    }
}
