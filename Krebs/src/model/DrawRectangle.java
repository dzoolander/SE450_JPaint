package model;

import java.awt.Color;
import java.awt.Graphics2D;

import controller.Point;
import controller.Shape;

public class DrawRectangle {
	private ShapeShadingType shadingType;
	private Color primaryColor;
	private Color secondaryColor;
	private ShapeType shapeType;
	private int height;
	private int width;
	private Point adjStartPoint;
	private Point adjEndPoint;
	private Graphics2D g;
	
	public DrawRectangle(Shape shape) {
		this.shadingType = shape.getShadingType();
		this.primaryColor = Color.BLACK; // how to get shape.getPrimaryColor() to convert to Color Type
		this.secondaryColor = Color.BLUE;
		this.shapeType = shape.getShapeType();
		this.height = shape.getHeight();
		this.width = shape.getWidth();
		this.adjStartPoint = shape.getAdjStartPoint();
		this.adjEndPoint = shape.getAdjEndPoint();
	}

	public void draw() {
		g = null;
		g.setColor(primaryColor);
		g.fillRect(adjStartPoint.getX(), adjEndPoint.getY(), width, height);
	}


}
