package controller;

import model.*;
import model.interfaces.IApplicationState;


public class GenerateShape implements ICommands {
    ShapeFactory shapeFactory = new ShapeFactory();
    private final IApplicationState appState;
    private ShapeOptions shapeOptions;
    private ShapeList shapeList;
    private IDrawShapes shape;

    public GenerateShape(IApplicationState appState, ShapeList shapeList, ShapeOptions shapeOptions) {
        this.appState = appState;
        this.shapeList = shapeList;
        this.shapeOptions = shapeOptions;
    }

    public void execute() {
        shapeOptions = appState.getCurrentState();
        shape = shapeFactory.createShape(shapeOptions);
        this.shapeList.add(shape);
    }
}
