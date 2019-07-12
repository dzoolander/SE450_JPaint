package controller;

import java.util.ArrayList;

public class ShapeList {
	private final ArrayList<Shape> shapeList;
	
	public ShapeList() {
		shapeList = new ArrayList<Shape>();
	}
	
	public void add (Shape shape) {
		shapeList.add(shape);
	}
	
	public void remove (Shape shape) {
		shapeList.remove(shape);
	}
	
	public ArrayList<Shape> getShapeList() {
		return shapeList;
	}
	
}
