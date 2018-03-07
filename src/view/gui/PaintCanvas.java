package view.gui;

import controller.GraphicsObserver;
import controller.mouseListener;
import model.persistence.ApplicationState;
import model.shapes.ShapeCollection;
import view.interfaces.IPaintCanvas;
import javax.swing.JComponent;
import java.awt.*;

public class PaintCanvas extends JComponent implements IPaintCanvas {
    private Graphics2D graphics;

    public Graphics2D getGraphics2D() {
        graphics = (Graphics2D)getGraphics();
        return graphics;

    }
    public void addMouseListener(GraphicsObserver graphicsObserver){
        this.addMouseListener(new mouseListener(graphicsObserver));
    }
}
