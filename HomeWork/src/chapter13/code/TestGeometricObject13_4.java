package chapter13.code;

public class TestGeometricObject13_4 {
	public static void main(String[] args) {
		GeometricObject geometricObject1 = new Circle(5);
		GeometricObject geometricObject2 = new Rectangle(5, 3);
		System.out.println("The two objects have the same area? " + equalArea(geometricObject1, geometricObject2));
		
		displayGeometricObject(geometricObject1);
		displayGeometricObject(geometricObject2);
	}
	
	public static boolean equalArea(GeometricObject object1, GeometricObject object2) {
		return object1.getArea() == object2.getArea();
	}
	
	public static void displayGeometricObject(GeometricObject object) {
		System.out.println();
		System.out.println("The area is " + object.getArea());
		System.out.println("The perimeter is " + object.getPerimeter());
	}
}
abstract class GeometricObject {
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;
	
	public GeometricObject() {
		dateCreated = new java.util.Date();
	}

	public GeometricObject(String color, boolean filled) {
		super();
		dateCreated = new java.util.Date();
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

	public java.util.Date getDateCreated() {
		return dateCreated;
	}

	@Override
	public String toString() {
		return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
	}
	
	public abstract double getArea();
	
	public abstract double getPerimeter();
	
}
class Circle extends GeometricObject {

	private double radius;
	
	public Circle() {
	
	}
	
	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public Circle(double radius, String color, boolean filled) {
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
	
	@Override
	public double getArea() {
		return radius * radius *Math.PI;
	}
	
	public double getDiameter() {
		return 2 * radius;
	}
	
	@Override
	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}
	
	public void printCircle() {
		System.out.println("The circle is create " + getDiameter() + " and the radius is " + radius);
	}	
}
class Rectangle extends GeometricObject {
	private double width;
	private double height;
	
	public Rectangle() {
		
	}
	
	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	public Rectangle(double width, double height, String color, boolean filled) {
		this.width = width;
		this.height = height;
		
		setColor(color);
		setFilled(filled);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public double getArea() {
		return width * height;
	}
	
	@Override
	public double getPerimeter() {
		return 2 * (width + height);
	}
}
