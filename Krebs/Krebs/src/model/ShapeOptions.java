package model;

import controller.Point;

public class ShapeOptions {
    private ShapeColor primaryShapeColor;
    private ShapeColor secondaryShapeColor;
    private Point startPoint;
    private Point endPoint;
    private ShapeShadingType shadingType;
    private ShapeType shapeType;
    
    public void setPrimaryShapeColor(ShapeColor primaryShapeColor) {
        this.primaryShapeColor = primaryShapeColor;
    }

    public void setSecondaryShapeColor(ShapeColor secondaryShapeColor) {
        this.secondaryShapeColor = secondaryShapeColor;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public void setShadingType(ShapeShadingType shadingType) {
        this.shadingType = shadingType;
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    
    public ShapeColor getPrimaryShapeColor() {
        return primaryShapeColor;
    }

    public ShapeColor getSecondaryShapeColor() {
        return secondaryShapeColor;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public ShapeShadingType getShadingType() {
        return shadingType;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }


    public Point getAdjustedStartPoint() {
        int xStart = Math.min(startPoint.getX(), endPoint.getX());
        int yStart = Math.min(startPoint.getY(), endPoint.getY());
        return new Point(xStart, yStart);
    }

    public Point getAdjustedEndPoint() {
        int xEnd = Math.max(startPoint.getX(), endPoint.getX());
        int yEnd = Math.max(startPoint.getY(), endPoint.getY());
        return new Point(xEnd, yEnd);
    }

    public int getWidth() {
        Point adjustedStart = getAdjustedStartPoint();
        Point adjustedEnd = getAdjustedEndPoint();
        return adjustedEnd.getX() - adjustedStart.getX();
    }

    public int getHeight() {
        Point adjustedStart = getAdjustedStartPoint();
        Point adjustedEnd = getAdjustedEndPoint();
        return adjustedEnd.getY() - adjustedStart.getY();
    }
}
