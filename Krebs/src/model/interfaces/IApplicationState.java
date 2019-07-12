package model.interfaces;

import controller.Point;
import model.ShapeColor;
import model.ShapeOptions;
import model.ShapeShadingType;
import model.ShapeType;
import model.StartAndEndPointMode;

public interface IApplicationState {
    void setActiveShape();

    void setActivePrimaryColor();

    void setActiveSecondaryColor();

    void setActiveShadingType();

    void setActiveStartAndEndPointMode();
    
    void setStartPoint(Point point);
    
    void setEndPoint(Point point);

    ShapeType getActiveShapeType();

    ShapeColor getActivePrimaryColor();

    ShapeColor getActiveSecondaryColor();

    ShapeShadingType getActiveShapeShadingType();

    StartAndEndPointMode getActiveStartAndEndPointMode();
    
    Point getStartPoint();
    
    Point getEndPoint();
    
    public ShapeOptions getShapeOptions ();

}
