package model;

import controller.Shape;
import model.interfaces.IApplicationState;

public class ShapeFactory {
	private ShapeType shapeType;
	private Shape shape;
	
	

	public Shape createShape(IApplicationState appState) {
		shapeType = appState.getActiveShapeType();
		switch(shapeType) {
		case RECTANGLE:
			shape = new Shape(appState.getActivePrimaryColor(), appState.getActiveSecondaryColor(), appState.getActiveShapeShadingType(), appState.getActiveShapeType(), appState.getStartPoint(), appState.getEndPoint());
			DrawRectangle drawRectangle = new DrawRectangle(shape);
			drawRectangle.draw();
			break;
		case ELLIPSE:
			//TODO
			break;
		case TRIANGLE:
			//TODO
			break;
		}
		return shape;
	}


}
