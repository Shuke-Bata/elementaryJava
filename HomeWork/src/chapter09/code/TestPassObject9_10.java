package chapter09.code;

public class TestPassObject9_10 {

	public static void main(String[] args) {

		CircleWithPrivateDataFields myCircle = new CircleWithPrivateDataFields(1);

		int n = 5;
		printArea(myCircle, n);

		System.out.println("\n" + "Radius is" + myCircle.getRadius());
		System.out.println("n is" + n);
	}

	public static void printArea(CircleWithPrivateDataFields c, int time) {
		System.out.println("Radius \t\tArea");
		while (time >= 1) {
			System.out.println(c.getRadius() + "\t\t" + c.getArea());
			c.setRadius(c.getRadius() + 1);
			time--;
		}
	}

}

class CircleWithPrivateDataFields {
	private double radius = 1;

	private static int numberOfObjects = 0;

	public CircleWithPrivateDataFields() {
		numberOfObjects++;
	}

	public CircleWithPrivateDataFields(double newRadius) {
		radius = newRadius;
		numberOfObjects++;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double newRadius) {
		radius = (newRadius >= 0) ? newRadius : 0;
	}

	public static int getNumberOfObjects() {
		return numberOfObjects;
	}

	public double getArea() {
		return radius * radius * Math.PI;
	}

}
