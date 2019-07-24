package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import controller.IDrawShapes;
import controller.Point;

public class DrawEllipse implements IDrawShapes {
	
	private ShapeOptions shapeOptions;
    private ShapeShadingType shadingType;
    private Color primaryColor;
    private Color secondaryColor;
    private int width;
    private int height;
    private Point adjustedStartPoint;
    private Point adjustedEndPoint;
    private Point startPoint;
    private Point endPoint;
    private ShapeType shapeType;
    
    public DrawEllipse (ShapeOptions shapeOptions) {
    	this.shapeOptions = shapeOptions;
        this.shadingType = shapeOptions.getShadingType();
        this.primaryColor = ColorMap.getColor(shapeOptions.getPrimaryShapeColor());
        this.secondaryColor = ColorMap.getColor(shapeOptions.getSecondaryShapeColor());
        this.width = shapeOptions.getWidth();
        this.height = shapeOptions.getHeight();
        this.adjustedStartPoint = shapeOptions.getAdjustedStartPoint();
        this.adjustedEndPoint = shapeOptions.getAdjustedEndPoint();
        this.startPoint = shapeOptions.getStartPoint();
        this.endPoint = shapeOptions.getEndPoint();
        this.shapeType = shapeOptions.getShapeType();
    }

	@Override
	public void draw(Graphics2D g) {
        switch(shadingType) {
        case OUTLINE:
        	g.setColor(primaryColor);
            g.setStroke(new BasicStroke(9));
            g.drawOval(adjustedStartPoint.getX(), adjustedStartPoint.getY(), width, height);
        	break;
        case FILLED_IN:
        	g.setColor(primaryColor);
            g.fillOval(adjustedStartPoint.getX(), adjustedStartPoint.getY(), width, height);
        	break;
        case OUTLINE_AND_FILLED_IN:
        	g.setColor(secondaryColor);
            g.setStroke(new BasicStroke(10));
            g.drawOval(adjustedStartPoint.getX(), adjustedStartPoint.getY(), width, height);
            g.setColor(primaryColor);
            g.fillOval(adjustedStartPoint.getX(), adjustedStartPoint.getY(), width, height);
        	break;
        }

	}

}
