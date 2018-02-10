package view.gui;

import controller.GraphicsObserver;
import controller.mouseListener;
import view.interfaces.IPaintCanvas;

import javax.swing.JComponent;
import java.awt.*;

public class PaintCanvas extends JComponent implements IPaintCanvas {
    private Graphics2D graphics = (Graphics2D)getGraphics();
    private GraphicsObserver observer = new GraphicsObserver();
    public Graphics2D getGraphics2D() {
        this.addMouseListener(new mouseListener(graphics));
        return graphics;

    }
    public GraphicsObserver getGraphicsObserver(){
        return observer;
    }
}
