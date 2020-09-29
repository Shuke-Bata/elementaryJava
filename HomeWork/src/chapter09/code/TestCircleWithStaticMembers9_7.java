package chapter09.code;

public class TestCircleWithStaticMembers9_7 {

	public static void main(String[] args) {
		System.out.println("Before creating objects");
		System.out.println("The number of Circle of objects is " + CircleWithStaticMembers.numberOfObjects);

		CircleWithStaticMembers c1 = new CircleWithStaticMembers();

		System.out.println("\nAfter creating c1");
//		System.out.println("c1: radius (" + c1.radius + ") and number of Cricle objects (" + c1.numberOfObjects + ")");

//		CircleWithStaticMembers c2 = new CircleWithStaticMembers(5);

		c1.radius = 9;

		System.out.println("\nAfter creating c2 and modifying c1");
//		System.out.println("c1: radius (" + c1.radius + ") and number of Cricle objects (" + c1.numberOfObjects + ")");

//		System.out.println("c2: radius (" + c2.radius + ") and number of Cricle objects (" + c2.numberOfObjects + ")");

	}

}

class CircleWithStaticMembers {
	double radius;
	static int numberOfObjects = 0;

	CircleWithStaticMembers() {
		radius = 1;
		numberOfObjects++;
	}

	CircleWithStaticMembers(double newRadius) {
		radius = newRadius;
		numberOfObjects++;
	}

	static int getNumberOfObjects() {
		return numberOfObjects;
	}

	double getArea() {
		return radius * radius * Math.PI;
	}

}
