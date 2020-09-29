package chapter12.code;

@SuppressWarnings("serial")
public class InvalidRadiusException12_10 extends Exception {
	private double radius;
	public InvalidRadiusException12_10(double radius) {
		super("Invalid radius " + radius);
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
}
