package main;

import controller.GraphicsObserver;
import controller.GraphicsObserverBuilder;
import controller.IJPaintController;
import controller.JPaintController;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
        GraphicsObserverBuilder gOBuilder = new GraphicsObserverBuilder();

        PaintCanvas paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        gOBuilder.addApplicationState(appState);
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();


        gOBuilder.addGraphics2D(paintCanvas.getGraphics2D());
        GraphicsObserver gObserver = gOBuilder.makeGraphicsObserver();
        paintCanvas.addMouseListener(gObserver);
    }
}
