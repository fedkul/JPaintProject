package controller;

import model.persistence.ApplicationState;

import java.awt.*;

public class GraphicsObserverBuilder {
    private ApplicationState appState;
    private Graphics2D graphics;

    public GraphicsObserverBuilder(){

    }

    public GraphicsObserver makeGraphicsObserver(){
        return new GraphicsObserver(appState, graphics);
    }
    public void addApplicationState(ApplicationState appState){
        this.appState = appState;
    }
    public void addGraphics2D(Graphics2D graphics){
        this.graphics=graphics;
    }
}
