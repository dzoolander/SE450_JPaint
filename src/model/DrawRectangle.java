package model;

import controller.IShapeActions;
import controller.Point;

import java.awt.*;

public class DrawRectangle implements IShapeActions {
	
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

    public DrawRectangle(ShapeOptions shapeOptions) {
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

    public void draw(Graphics2D g) {
        switch(shadingType) {
        case OUTLINE:
        	g.setColor(primaryColor);
            g.setStroke(new BasicStroke(5));
            g.drawRect(adjustedStartPoint.getX(), adjustedStartPoint.getY(), width, height);
        	break;
        case FILLED_IN:
        	g.setColor(primaryColor);
            g.fillRect(adjustedStartPoint.getX(), adjustedStartPoint.getY(), width, height);
        	break;
        case OUTLINE_AND_FILLED_IN:
        	g.setColor(secondaryColor);
            g.setStroke(new BasicStroke(5));
            g.drawRect(adjustedStartPoint.getX(), adjustedStartPoint.getY(), width, height);
            g.setColor(primaryColor);
            g.fillRect(adjustedStartPoint.getX(), adjustedStartPoint.getY(), width, height);
        	break;
        }
    }
    
    @Override 
	public ShapeType getShapeType() {
		return shapeType;
	}
	
	@Override
	public ShapeOptions getShapeOptions() {
		return shapeOptions;
	}

	@Override
	public Point getAdjustedStartPoint() {
		return adjustedStartPoint;
	}

	@Override
	public Point getAdjustedEndPoint() {
		return adjustedEndPoint;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}
	
	@Override
	public void increaseWidth(int w) {
		width = width + w;
	}
	
	@Override
	public void increaseHeight(int h) {
		height = height + h;
	}
	
	public void moveAdjustedStartPoint(int dx, int dy) {
		adjustedStartPoint.setX(adjustedStartPoint.getX() + dx);
		adjustedStartPoint.setY(adjustedStartPoint.getY() + dy);
	}
	
	public void moveAdjustedEndPoint(int dx, int dy) {
		adjustedEndPoint.setX(adjustedEndPoint.getX() + dx);
		adjustedEndPoint.setY(adjustedEndPoint.getY() + dy);
	}

}
