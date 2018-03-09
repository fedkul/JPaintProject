package controller;

import model.command.CommandFactory;
import model.command.ICommand;
import model.persistence.ApplicationState;
import model.shapes.IShape;
import model.shapes.Point;
import model.shapes.ShapeCollection;
import model.shapes.ShapeFactory;
import java.awt.*;

public class GraphicsObserver {
    private final ApplicationState appState;
    private final Graphics2D graphics;

    public GraphicsObserver(ApplicationState state, Graphics2D graphics){
        this.graphics = graphics;
        appState = state;
        ShapeCollection.addGraphics(graphics);
    }
    public void runCommand(Point origin, Point end){
        IShape shape = ShapeFactory.getShape(
                        appState.getActiveShapeType(),
                        origin, end,
                        appState.getActivePrimaryColor(),
                        appState.getActiveSecondaryColor(),
                        appState.getActiveShapeShadingType());

        ICommand command = CommandFactory.getCommand(appState.getActiveStartAndEndPointMode(), graphics, shape, origin, end);
        command.run();
    }
}
