package chapter13.exercise;

import java.util.Scanner;

public class Exercise13_5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Create the first Rectangle (enter width, height): ");
		double firstWidth = input.nextDouble();
		double firstHeight = input.nextDouble();

		System.out.print("Crate the second Rectangle (enter width, height): ");
		double secondWidth = input.nextDouble();
		double secondHeight = input.nextDouble();

		CompareMyRectangle rectangle1 = new CompareMyRectangle(firstWidth, firstHeight);
		CompareMyRectangle rectangle2 = new CompareMyRectangle(secondWidth, secondHeight);

		System.out.println(CompareGeometricObject.max(rectangle1, rectangle2).toString());
		// 可以看出此处的 max 返回的是 CompareMyRectangle 的一个实例
	}
}

abstract class CompareGeometricObject implements Comparable<CompareGeometricObject> {
	private String color;
	private boolean filled;
	private java.util.Date dateCreated;

	protected CompareGeometricObject() {
		dateCreated = new java.util.Date();
	}

	protected CompareGeometricObject(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
		dateCreated = new java.util.Date();
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
		return "Created on " + dateCreated + "\nColor : " + color + "\n and Filled : " + filled;
	}

	@Override
	public int compareTo(CompareGeometricObject o) {
		if (getArea() < o.getArea()) {
			return -1;
		} else if (getArea() > o.getArea()) {
			return 1;
		} else
			return 0;
	}

	public static CompareGeometricObject max(CompareGeometricObject o1, CompareGeometricObject o2) {
		if (o1.compareTo(o2) > 0) {
			return o1;
		} else
			return o2;
	}

	public abstract double getArea();

	public abstract double getPerimeter();
}

class CompareMyRectangle extends CompareGeometricObject {
	private double width;
	private double height;

	public CompareMyRectangle() {
	}

	public CompareMyRectangle(double width, double height) {
		this(width, height, "white", false);
	}

	public CompareMyRectangle(double width, double height, String color, boolean filled) {
		super(color, filled);
		this.width = width;
		this.height = height;
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

	@Override
	public String toString() {
		return super.toString() + "\nMy Rectangle Width : " + getWidth() + " Height : " + getHeight();
	}
}
