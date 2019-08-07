package controller;

import model.ShapeList;

public class CopyShapesCommand implements ICommands {
	ShapeList selectedShapeList;
	ShapeList copiedShapeList;
	
	public CopyShapesCommand (ShapeList selectedShapeList, ShapeList copiedShapeList) {
		this.selectedShapeList = selectedShapeList;
		this.copiedShapeList = copiedShapeList;
		
	}

	@Override
	public void execute() {
		for (IShapeActions shape : selectedShapeList.getShapesList()) {
			copiedShapeList.add(shape);
		}
	}

}
