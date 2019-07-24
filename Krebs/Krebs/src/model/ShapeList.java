package model;

import controller.*;
import java.util.ArrayList;

public class ShapeList {
    private final ArrayList<IDrawShapes> shapesList;
    private DrawShapes drawShapes;

    public ShapeList(DrawShapes drawShapes) {
        this.drawShapes = drawShapes;
        shapesList = new ArrayList<IDrawShapes>();
    }

    public void add(IDrawShapes shape) {
        shapesList.add(shape);
        drawShapes.draw(this);

    }

    public void remove(IDrawShapes shape) {
        shapesList.remove(shape);
        //drawShapes.draw(this);
    }

    public ArrayList<IDrawShapes> getShapesList() {
        return shapesList;
    }
}
