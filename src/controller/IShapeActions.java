package controller;

import java.awt.*;

import model.ShapeOptions;
import model.ShapeType;

public interface IShapeActions {
    void draw(Graphics2D g);

	Point getAdjustedStartPoint();
	
	Point getAdjustedEndPoint();
	
	ShapeOptions getShapeOptions();
	
	ShapeType getShapeType();

	int getWidth();
	
	int getHeight();
	
	void increaseWidth(int w);
	
	void increaseHeight(int h);
	
	//public void setAdjustedStartPoint(Point point);
	
	//public void setAdjustedEndPoint(Point point);
	
	public void moveAdjustedStartPoint(int dx, int dy);
	
	public void moveAdjustedEndPoint(int dx, int dy);
	
}
