package model;

public class ShapeOptions {
	private ShapeColor primaryColor;
	private ShapeColor secondaryColor;
	private ShapeShadingType shadingType;
	private ShapeType shapeType;
	
//Getters//
	public ShapeColor getPrimaryColor() {
		return primaryColor;
	}
	
	public ShapeColor getSecondaryColor() {
		return secondaryColor;
	}
	
	public ShapeShadingType getShadingType() {
		return shadingType;
	}
	
	public ShapeType getShapeType() {
		return shapeType;
	}

//Setters//
	public void setPrimaryColor(ShapeColor primaryColor) {
		this.primaryColor = primaryColor;
	}
	
	public void setSecondaryColor(ShapeColor secondaryColor) {
		this.secondaryColor = secondaryColor;
	}
	
	public void setShadingType(ShapeShadingType shadingType) {
		this.shadingType = shadingType;
	}
	
	public void setShapeType(ShapeType shapeType) {
		this.shapeType = shapeType;
	}

}
