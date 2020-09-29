package chapter12.exercise;

import java.util.Scanner;

public class Exercise12_5 {
    @SuppressWarnings("resource")
	public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Enter three sides for a triangle: ");
            try {
                double side1 = input.nextDouble();
                double side2 = input.nextDouble();
                double side3 = input.nextDouble();
                TriangleUseIllegalTrianglException triangle = 
                    new TriangleUseIllegalTrianglException(side1, side2, side3);
                System.out.println("The area is " + triangle.getArea());
                System.out.println("The perimeter is " + triangle.getPerimeter());
            }
            catch (IllegalTriangleException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Try again.");
            }
            input.nextLine();
        }

    }
}
@SuppressWarnings("serial")
class IllegalTriangleException extends Exception {
    private double side1;
    private double side2;
    private double side3;

    public IllegalTriangleException(double side1, double side2, double side3) {
        super("Invaoide sides " + side1 + " " + side2 + " " + side3);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }
}
// 异常类在书写的时候就是一个正常的类

class TriangleUseIllegalTrianglException {
    private double side1;
    private double side2;
    private double side3;

    public TriangleUseIllegalTrianglException()
        throws IllegalTriangleException {
        this(1.0, 1.0, 1.0);
    }

    public TriangleUseIllegalTrianglException(double side1, double side2, double side3)
        throws IllegalTriangleException {
        setSides(side1, side2, side3);
    }

    public void setSides(double side1, double side2, double side3)
        throws IllegalTriangleException {
        if ((side1 + side2 <= side3) || (side1 - side2 >= side3)) {
            throw new IllegalTriangleException(side1, side2, side3);
        } else {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }   
    }

    public void setSide1(double side1) throws IllegalTriangleException {
        setSides(side1, this.side2, this.side3);
    }

    public void setSide2(double side2) throws IllegalTriangleException {
        setSides(this.side1, side2, this.side3);
    }

    public void setSide3(double side3) throws IllegalTriangleException {
        setSides(this.side1, this.side2, side3);
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double getPerimeter() {
        return (side1 + side2 + side3);
    }
}

