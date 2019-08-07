package controller;

import java.awt.Graphics2D;

import model.ShapeList;
import model.ShapeOptions;
import model.interfaces.IApplicationState;
import view.gui.PaintCanvas;

public class MoveShapes implements ICommands{
	IApplicationState appState;
	ShapeList shapeList;
	ShapeList selectedShapeList;
	ShapeOptions shapeOptions;
	
	public MoveShapes (IApplicationState appState, ShapeList shapeList, ShapeList selectedShapeList, ShapeOptions shapeOptions) {
		this.appState = appState;
		this.shapeList = shapeList;
		this.selectedShapeList = selectedShapeList;
		this.shapeOptions = shapeOptions;
	}

	@Override
	public void execute() {
		int dx = appState.getEndPoint().getX() - appState.getStartPoint().getX();
		int dy = appState.getEndPoint().getY() - appState.getStartPoint().getY();
		
		for (IShapeActions selected : selectedShapeList.getShapesList()) {
			shapeList.remove(selected);
			selected.moveAdjustedStartPoint(dx, dy);
			selected.moveAdjustedEndPoint(dx, dy);
			shapeList.add(selected);
		}
		
		shapeList.clear();
		shapeList.drawList();
		
	}

}
