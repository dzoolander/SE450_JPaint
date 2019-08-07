package controller;

import java.awt.Color;
import java.util.ArrayList;

import model.*;
import model.interfaces.IApplicationState;

public class SelectShape implements ICommands {
	IApplicationState appState;
	ShapeList shapeList;
	ShapeList selectedShapeList;
	ShapeOptions shapeOptions;
	ShapeFactory shapeFactory = new ShapeFactory();

	public SelectShape(IApplicationState appState, ShapeList shapeList, ShapeList selectedShapeList, ShapeOptions shapeOptions) {
		this.appState = appState;
		this.shapeList = shapeList;
		this.shapeOptions = shapeOptions;
		this.selectedShapeList = selectedShapeList;
	}
	
	public ShapeList getSelectedShapeList() {
		return selectedShapeList;
	}

	
//Collision detection algorithm reference: https://developer.mozilla.org/en-US/docs/Games/Techniques/2D_collision_detection
	@Override
	public void execute() {
		selectedShapeList.empty();
		shapeOptions = appState.getCurrentState();
		for (IShapeActions shape : shapeList.getShapesList()) {
			//If collision, add shape to selected shapes list
			if (shape.getAdjustedStartPoint().getX() < shapeOptions.getAdjustedStartPoint().getX() + shapeOptions.getWidth() &&
					shape.getAdjustedStartPoint().getX() + shape.getWidth() > shapeOptions.getAdjustedStartPoint().getX() && 
					shape.getAdjustedStartPoint().getY() < shapeOptions.getAdjustedStartPoint().getY() + shapeOptions.getHeight() &&
					shape.getAdjustedStartPoint().getY() + shape.getHeight() > shapeOptions.getAdjustedStartPoint().getY()) {
						selectedShapeList.add(shape);
					}
		}
		//Why is the outlining only the first shape then throwing a ConcurrentModificationException
		for (IShapeActions shape : selectedShapeList.getShapesList()) {
			ShapeOptions shapeOptions = shape.getShapeOptions();
			shapeOptions.setShadingType(ShapeShadingType.OUTLINE);
			shapeOptions.setPrimaryShapeColor(ShapeColor.BLACK);
			IShapeActions outline = shapeFactory.createShape(shapeOptions);
			outline.moveAdjustedStartPoint(-5, -5);
			outline.increaseHeight(10);
			outline.increaseWidth(10);
			selectedShapeList.add(outline);//Do I need to create another shapeList to hold onto the outlines?
		}
		
	}

}
