package main;

import controller.*;
import model.*;
import model.persistence.*;
import view.gui.*;
import view.interfaces.*;

public class Main {
    public static void main(String[] args){
        PaintCanvasBase paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        DrawShapes drawShapes = new DrawShapes(paintCanvas, appState);
        ShapeList shapeList = new ShapeList(drawShapes);
        ShapeList selectedShapeList = new ShapeList(drawShapes);
        ShapeList copiedShapeList = new ShapeList(drawShapes);
        ShapeOptions shapeOptions = new ShapeOptions();
        
        IJPaintController controller = new JPaintController(uiModule, appState, shapeList, selectedShapeList, copiedShapeList);
        controller.setup();
        
        MouseHandler mouseHandler = new MouseHandler(appState, shapeList, selectedShapeList, shapeOptions);
        paintCanvas.addMouseListener(mouseHandler);
    }

}
