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
    private ShapeOptions shapeOptions;

    public MouseHandler(IApplicationState appState, ShapeList shapeList, ShapeOptions shapeOptions) {
        this.appState = appState;
        this.shapeList = shapeList;
        this.shapeOptions = shapeOptions;
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
        	//TODO
        	break;
        case MOVE:
        	//TODO
        	break;
    }
}
}
