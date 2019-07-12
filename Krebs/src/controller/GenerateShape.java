package controller;

import model.ShapeFactory;
import model.interfaces.IApplicationState;

public class GenerateShape {
	
	private IApplicationState appState;
	private ShapeList shapeList;
	private Shape shape;
	ShapeFactory shapeFactory = new ShapeFactory();
	
	public GenerateShape(IApplicationState appState, ShapeList shapeList) {
		this.appState = appState;
		this.shapeList = shapeList;
	}
	
	public void generate() {
		shape = shapeFactory.createShape(appState);
		shapeList.add(shape);
	}

}
