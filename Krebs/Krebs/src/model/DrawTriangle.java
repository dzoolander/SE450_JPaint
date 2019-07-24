package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import controller.IDrawShapes;
import controller.Point;

public class DrawTriangle implements IDrawShapes {
	
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
    private int[] x = new int[3];
    private int[] y = new int[3];
    
    public DrawTriangle (ShapeOptions shapeOptions) {
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
        this.x[0] = shapeOptions.getAdjustedEndPoint().getX();
        this.x[1] = shapeOptions.getAdjustedEndPoint().getX();
        this.x[2] = shapeOptions.getAdjustedStartPoint().getX();
        this.y[0] = shapeOptions.getAdjustedStartPoint().getY();
        this.y[1] = shapeOptions.getAdjustedEndPoint().getY();
        this.y[2] = shapeOptions.getAdjustedEndPoint().getY();
    }

	@Override
	public void draw(Graphics2D g) {
        switch(shadingType) {
        case OUTLINE:
        	g.setColor(primaryColor);
            g.setStroke(new BasicStroke(9));
            g.drawPolygon(x, y, 3);
        	break;
        case FILLED_IN:
        	g.setColor(primaryColor);
        	g.fillPolygon(x, y, 3);
        	break;
        case OUTLINE_AND_FILLED_IN:
        	g.setColor(secondaryColor);
            g.setStroke(new BasicStroke(10));
            g.drawPolygon(x, y, 3);
            g.setColor(primaryColor);
            g.fillPolygon(x, y, 3);
        	break;
        }

	}

}
