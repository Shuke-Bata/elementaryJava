package chapter13.exercise;
import java.util.Scanner;

public class Exercise13_1
{
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter side1 : ");
        double side1 = input.nextDouble();
        System.out.print("Enter side2 : ");
        double side2 = input.nextDouble();
        System.out.print("Enter side3 : ");
        double side3 = input.nextDouble();

        System.out.print("Enter a color : ");
        String color = input.next();
        System.out.print("Is filled ? ");
        boolean filled = input.nextBoolean();

        try
        {
            Triangle triangle = new Triangle(side1, side2, side3, color, filled);
            System.out.println("Area : " + triangle.getArea());
            System.out.println("Perimeter : " + triangle.getPerimeter());
        }
        catch (TriangleException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}

abstract class GeometricObject
{
    private String color;
    private boolean filled;
    private java.util.Date dateCreated;

    protected GeometricObject()
    {
        dateCreated = new java.util.Date();
    }

    protected GeometricObject(String color, boolean isFilled)
    {
        this.color = color;
        this.filled = filled;
        dateCreated = new java.util.Date();
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public boolean isFilled()
    {
        return filled;
    }

    public void setFilled(boolean filled)
    {
        this.filled = filled;
    }

    public java.util.Date getDateCreated()
    {
        return dateCreated;
    }

    @Override
    public String toString()
    {
        return "created on " + dateCreated + "\ncolor: " + color + "\nand filled: " + filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}

class TriangleException extends Exception
{
    private double side1;
    private double side2;
    private double side3;

    public TriangleException(double side1, double side2, double side3)
    {
        super("Can't create a triangle.");
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1()
    {
        return side1;
    }

    public double getSide2()
    {
        return side2;
    }

    public double getSide3()
    {
        return side3;
    }
}
//为了练习异常的声明，写了一个TriangleException，其实没必要，只要用 if 判断给出错误信息就好
class Triangle extends GeometricObject
{
 private double side1;
 private double side2;
 private double side3;

 public Triangle()
 {
 }

 public Triangle(double side1, double side2, double side3) throws TriangleException
 {
     this(side1, side2, side3, "white", false);
 }

 public Triangle(double side1, double side2, double side3, String color, boolean filled)
     throws TriangleException
 {
     super(color, filled);
     this.side1 = side1;
     this.side2 = side2;
     this.side3 = side3;
     judge(side1, side2, side3);
 }

 public double getSide1()
 {
     return side1;
 }

 public void setSide1(double side1)
 {
     this.side1 = side1;
 }

 public double getSide2()
 {
     return side2;
 }

 public void setSide2(double side2)
 {
     this.side2 = side2;
 }

 public double getSide3()
 {
     return side3;
 }

 public void setSide3(double side3)
 {
     this.side3 = side3;
 }

 @Override
 public double getArea()
 {
     double side = (side1 + side2 + side3) / 2;
     double area = Math.sqrt(side * (side - side1) * (side - side2) * (side - side3));
     return area;
 }

 @Override
 public double getPerimeter()
 {
     return (side1 + side2 + side3);
 }

 private void judge(double side1, double side2, double side3) throws TriangleException
 {
     if ((side1 + side2 <= side3) || (side1 - side2 >= side3))
     {
         throw new TriangleException(side1, side2, side3);
     }
 }
}
