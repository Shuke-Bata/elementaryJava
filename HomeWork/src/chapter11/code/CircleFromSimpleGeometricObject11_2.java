package chapter11.code;

public class CircleFromSimpleGeometricObject11_2 extends SimpleGeometricObject {
	private double radius;
	
	public CircleFromSimpleGeometricObject11_2() {
				
	}
	
	public CircleFromSimpleGeometricObject11_2(double radius) {
		super();
		this.radius = radius;
	}

	public CircleFromSimpleGeometricObject11_2(double radius, String color, boolean filled) {
		this.radius = radius;
		setColor(color);
		setFilled(filled);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return radius * radius *Math.PI;
	}
	
	public double getDiameter() {
		return 2 * radius;
	}
	
	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}
	
	public void printCircle() {
		System.out.println("The circle is create " + getDiameter() + " and the radius is " + radius);
	}
	
}

class SimpleGeometricObject {
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreateDate;
	
	public SimpleGeometricObject() {
		dateCreateDate = new java.util.Date();
	}
	
	public SimpleGeometricObject(String color, boolean filled) {
		dateCreateDate = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}
	
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean isFilled() {
		return filled;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	public java.util.Date getDateCreateDate() {
		return dateCreateDate;
	}
	
	@Override
	public String toString() {
		return "created on " + dateCreateDate + "\ncolor: " + color + " and filled: " + filled;
	}	
}