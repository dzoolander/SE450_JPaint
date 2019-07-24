package model;

import controller.IDrawShapes;
import controller.Point;

import java.awt.*;

public class DrawRectangle implements IDrawShapes {
	
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
            g.setStroke(new BasicStroke(9));
            g.drawRect(adjustedStartPoint.getX(), adjustedStartPoint.getY(), width, height);
        	break;
        case FILLED_IN:
        	g.setColor(primaryColor);
            g.fillRect(adjustedStartPoint.getX(), adjustedStartPoint.getY(), width, height);
        	break;
        case OUTLINE_AND_FILLED_IN:
        	g.setColor(secondaryColor);
            g.setStroke(new BasicStroke(10));
            g.drawRect(adjustedStartPoint.getX(), adjustedStartPoint.getY(), width, height);
            g.setColor(primaryColor);
            g.fillRect(adjustedStartPoint.getX(), adjustedStartPoint.getY(), width, height);
        	break;
        }
    }

}
