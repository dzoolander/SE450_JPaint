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
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();

        DrawShapes drawShapes = new DrawShapes(paintCanvas, appState);
        ShapeList shapeList = new ShapeList(drawShapes);
        ShapeOptions shapeOptions = new ShapeOptions();
        MouseHandler mouseHandler = new MouseHandler(appState, shapeList, shapeOptions);
        paintCanvas.addMouseListener(mouseHandler);
    }

}
