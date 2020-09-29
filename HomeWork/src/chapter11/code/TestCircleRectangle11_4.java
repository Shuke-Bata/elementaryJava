package chapter11.code;

public class TestCircleRectangle11_4 {

	public static void main(String[] args) {
		CircleFromSimpleGeometricObject11_2 circle = new CircleFromSimpleGeometricObject11_2(1);
		System.out.println("A circle " + circle.toString());
		System.out.println("The color is " + circle.getColor());
		System.out.println("The radius is " + circle.getRadius());
		System.out.println("The area is " + circle.getArea());
		System.out.println("The diameter is " + circle.getDiameter());
		
		
		RectangleFromSimpleGeometricObject rectangle = new RectangleFromSimpleGeometricObject(2, 4);
		System.out.println("\nA rectangle " + rectangle.toString());
		System.out.println("The area is " + rectangle.getArea());
		System.out.println("The perimeter is " + rectangle.getPerimeter());
	}
}

class RectangleFromSimpleGeometricObject extends SimpleGeometricObject {
	private double width;
	private double height;
	
	public RectangleFromSimpleGeometricObject() {
		
	}
	
	public RectangleFromSimpleGeometricObject(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	public RectangleFromSimpleGeometricObject(double width, double height, String color, boolean filled) {
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
	
	public double getArea() {
		return width * height;
	}
	
	public double getPerimeter() {
		return 2 * (width + height);
	}
	
}
