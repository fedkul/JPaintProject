package view.gui;

import controller.GraphicsObserver;
import controller.mouseListener;
import model.persistence.ApplicationState;
import model.shapes.ShapeCollection;
import view.interfaces.IPaintCanvas;
import javax.swing.JComponent;
import java.awt.*;

public class PaintCanvas extends JComponent implements IPaintCanvas {
    private Graphics2D graphics = (Graphics2D)getGraphics();
    private GraphicsObserver observer;
    public Graphics2D getGraphics2D() {
        graphics = (Graphics2D)getGraphics() ;
        observer.addGraphics(graphics);
        this.addMouseListener(new mouseListener(observer));
        return graphics;

    }
    public void setupGraphicsObserver(ShapeCollection shapeList, ApplicationState state){
        observer = new GraphicsObserver(shapeList, state);
    }
//    public GraphicsObserver getGraphicsObserver(){
//        return observer;
//    }
}
