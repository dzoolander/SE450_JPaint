package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.interfaces.IApplicationState;

public class MouseHandler extends MouseAdapter {
	private Point startPoint;
	private Point endPoint;
	private IApplicationState appState;
	
	public MouseHandler(IApplicationState appState) {
		this.appState = appState;
	}
	
	@Override
	public void mousePressed (MouseEvent e) {
		startPoint = new Point (e.getX(), e.getY());
	}
	
	@Override
	public void mouseReleased (MouseEvent e) {
		endPoint = new Point (e.getX(), e.getY());
	}

}
