package controller;

import model.*;
import model.interfaces.IApplicationState;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {
    private Point startPoint;
    private Point endPoint;
    private IApplicationState appState;
    private ShapeList shapeList;
    private ShapeList selectedShapeList;
    private ShapeOptions shapeOptions;

    public MouseHandler(IApplicationState appState, ShapeList shapeList, ShapeList selectedShapeList, ShapeOptions shapeOptions) {
        this.appState = appState;
        this.shapeList = shapeList;
        this.shapeOptions = shapeOptions;
        this.selectedShapeList = selectedShapeList;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = new Point(e.getX(), e.getY());
        appState.setStartPoint(startPoint);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endPoint = new Point(e.getX(), e.getY());
        appState.setEndPoint(endPoint);
        
        switch(appState.getActiveStartAndEndPointMode()) {
        case DRAW:
        	GenerateShape newShape = new GenerateShape(appState, shapeList, shapeOptions);
        	newShape.execute();
        	break;
        case SELECT:
        	SelectShape selectShape = new SelectShape(appState, shapeList, selectedShapeList, shapeOptions);
        	selectShape.execute();
        	break;
        case MOVE:
        	MoveShapes moveShapes = new MoveShapes(appState, shapeList, selectedShapeList, shapeOptions);
        	moveShapes.execute();
        	break;
    }
}
}
