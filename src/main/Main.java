package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.shapes.IShape;
import model.persistence.ApplicationState;
import model.shapes.ShapeCollection;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

import java.util.*;

public class Main {
    public static void main(String[] args){
        ShapeCollection shapeList = new ShapeCollection(new LinkedList<>());

        PaintCanvas paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();

        paintCanvas.setupGraphicsObserver(shapeList, appState);
        paintCanvas.getGraphics2D();

        /*ShapeFactory shapeFactory = new ShapeFactory();
        IShape testShape1 = shapeFactory.getShape(ShapeType.ELLIPSE);
        IShape testShape2 = shapeFactory.getShape(ShapeType.RECTANGLE);
        IShape testShape3 = shapeFactory.getShape(ShapeType.TRIANGLE);

        shapeList.add(testShape1);
        shapeList.add(testShape2);
        shapeList.add(testShape3);

        for (IShape shape : shapeList) {shape.draw(graphics);}

        shapeList.remove(0);

        for (IShape shape : shapeList) {shape.draw(graphics);}*/
    }
}
