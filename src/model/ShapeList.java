package model;

import controller.*;
import java.util.ArrayList;

public class ShapeList {
    private final ArrayList<IShapeActions> shapesList;
    private DrawShapes drawShapes;

    public ShapeList(DrawShapes drawShapes) {
        this.drawShapes = drawShapes;
        shapesList = new ArrayList<IShapeActions>();
    }

    public void add(IShapeActions shape) {
        shapesList.add(shape);
        drawShapes.draw(this);//the selectedShapeList is drawing shapes every time it's added, but you can't see it. Fix this to separate out draw from add. 
    }

    public void remove(IShapeActions shape) {
        shapesList.remove(shape);
    }

    public ArrayList<IShapeActions> getShapesList() {
        return shapesList;
    }
    
    public void drawList() {
    	drawShapes.draw(this);
    }
    
    public void clear() {
    	drawShapes.clear();
    }

	public void empty() {
		for (IShapeActions shape : shapesList) {
			shapesList.remove(shape);
		}
		
	}
}
