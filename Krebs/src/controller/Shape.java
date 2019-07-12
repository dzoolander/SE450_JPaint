package controller;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

public class Shape {
	private ShapeColor primaryColor;
	private ShapeColor secondaryColor;
	private ShapeShadingType shadingType;
	private ShapeType shapeType;
	private Point startPoint;
	private Point endPoint;
	private Point adjStartPoint;
	private Point adjEndPoint;
	private int height;
	private int width;
	
	private Point adjustStartPoint() {
		int xStart = Math.min(startPoint.getX(), endPoint.getX());
		int yStart = Math.min(startPoint.getY(), endPoint.getY());
		return new Point(xStart, yStart);
	}
	
	private Point adjustEndPoint() {
		int xStart = Math.max(startPoint.getX(), endPoint.getX());
		int yStart = Math.max(startPoint.getY(), endPoint.getY());
		return new Point(xStart, yStart);		
	}
	
	public Shape(ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shadingType, ShapeType shapeType, Point startPoint, Point endPoint) {
		this.primaryColor = primaryColor;
		this.secondaryColor = secondaryColor;
		this.shadingType = shadingType;
		this.shapeType = shapeType;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		
		adjStartPoint = adjustStartPoint();
		adjEndPoint = adjustEndPoint();
		
		height = adjEndPoint.getY() - adjStartPoint.getY();
		width = adjEndPoint.getX() - adjStartPoint.getX();		
	}
	
	

	public ShapeColor getPrimaryColor() {
		return primaryColor;
	}

	public ShapeColor getSecondaryColor() {
		return secondaryColor;
	}

	public ShapeShadingType getShadingType() {
		return shadingType;
	}

	public ShapeType getShapeType() {
		return shapeType;
	}

	public Point getAdjStartPoint() {
		return adjStartPoint;
	}

	public Point getAdjEndPoint() {
		return adjEndPoint;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	
	

}
