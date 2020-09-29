package chapter12.code;

public class CirclewithException12_7 {
	private double radius;
	
	private static int numbersOfObjects = 0;
	public CirclewithException12_7() {
		this(1.0);
	}
	public CirclewithException12_7(double radius) {
		setRadius(radius);
		numbersOfObjects++;
	}
	
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) throws IllegalArgumentException {
		if (radius >= 0) {
			this.radius = radius;
		}else {
			throw new IllegalArgumentException("Radius cannot be negative");
		}
	}
	
	public static int getNumbersOfObjects() {
		return numbersOfObjects;
	}
	
	public double findArea() {
		return radius * radius * Math.PI;
	}
	
}
