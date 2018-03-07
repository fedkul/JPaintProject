package controller;

import model.persistence.ApplicationState;
import model.shapes.ShapeCollection;

import java.awt.*;

public class GraphicsObserverBuilder {
    private ShapeCollection collection;
    private ApplicationState appState;
    private Graphics2D graphics;

    public GraphicsObserverBuilder(){

    }

    public GraphicsObserver makeGraphicsObserver(){
        return new GraphicsObserver(collection, appState, graphics);
    }

    public void addShapeCollection(ShapeCollection collection){
        this.collection = collection;
    }
    public void addApplicationState(ApplicationState appState){
        this.appState = appState;
    }
    public void addGraphics2D(Graphics2D graphics){
        this.graphics=graphics;
    }
}
