package controller;

import model.*;

public class PasteShapesCommand implements ICommands{
	ShapeList shapeList;
	ShapeList copiedShapeList;
	ShapeFactory shapeFactory = new ShapeFactory();
	
	public PasteShapesCommand(ShapeList shapeList, ShapeList copiedShapeList) {
		this.shapeList = shapeList;
		this.copiedShapeList = copiedShapeList;
	}

	@Override
	public void execute() {
		for (IShapeActions shape : copiedShapeList.getShapesList()) {
			ShapeOptions shapeOptions = shape.getShapeOptions();
			IShapeActions copiedShape = shapeFactory.createShape(shapeOptions);
			copiedShape.moveAdjustedStartPoint(100, 100);
			copiedShape.moveAdjustedEndPoint(100, 100);
			shapeList.add(copiedShape);
		}
		shapeList.clear();
		shapeList.drawList();
		
	}

}
