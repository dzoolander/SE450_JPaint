package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.ShapeOptions;
import model.interfaces.IApplicationState;
import model.StartAndEndPointMode;

public class MouseHandler extends MouseAdapter {
	private Point startPoint;
	private Point endPoint;
	private IApplicationState appState;
	private ShapeOptions shapeOptions;
	private ShapeList shapeList;
	
	public MouseHandler(IApplicationState appState, ShapeOptions shapeOptions, ShapeList shapeList) {
		this.appState = appState;
		this.shapeOptions = shapeOptions;
		this.shapeList = shapeList;
	}
	
	@Override
	public void mousePressed (MouseEvent e) {
		startPoint = new Point (e.getX(), e.getY());
		appState.setStartPoint(startPoint);
	}
	
	@Override
	public void mouseReleased (MouseEvent e) {
		endPoint = new Point (e.getX(), e.getY());
		appState.setEndPoint(endPoint);
		StartAndEndPointMode mode = appState.getActiveStartAndEndPointMode();
		switch(mode) {
		case DRAW:
			GenerateShape newShape = new GenerateShape(appState, shapeList);
			newShape.generate();
			break;
		case SELECT:
			//TODO
			break;
		case MOVE:
			//TODO
		}
		
		
	}

}
