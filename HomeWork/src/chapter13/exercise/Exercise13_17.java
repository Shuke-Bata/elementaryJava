package chapter13.exercise;
import java.util.Scanner;

public class Exercise13_17
{
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first complex number : ");
        double r1 = input.nextDouble();
        double i1 = input.nextDouble();
        Complex complex1 = new Complex(r1, i1);

        System.out.print("Enter the second complex number : ");
        double r2 = input.nextDouble();
        double i2 = input.nextDouble();
        Complex complex2 = new Complex(r2, i2);

        String c1 = "(" + r1 + " + " + i1 + "i)";
        String c2 = "(" + r2 + " + " + i2 + "i)";
        System.out.println( c1 + " + " + c2 + " = " + complex1.add(complex2).toString());
        System.out.println( c1 + " - " + c2 + " = " + complex1.subtract(complex2).toString());
        System.out.println( c1 + " * " + c2 + " = " + complex1.multiply(complex2).toString());
        System.out.println( c1 + " / " + c2 + " = " + complex1.divide(complex2).toString());
        System.out.println( "|" + c1 + " + " + c2 + "| = " + complex1.abs());

    }
}
class Complex implements Cloneable
{
    private double realPart;
    private double imaginaryPart;

    public Complex()
    {
    }

    public Complex(double a)
    {
        this(a, 0);
    }

    public Complex(double a, double b)
    {
        this.realPart = a;
        this.imaginaryPart = b;
    }

    public double getRealPart()
    {
        return realPart;
    }

    public double getImaginaryPart()
    {
        return imaginaryPart;
    }

    public Complex add(Complex c)
    {
        double r = realPart + c.getRealPart();
        double i = imaginaryPart + c.getImaginaryPart();
        return new Complex(r, i);
    }

    public Complex subtract(Complex c)
    {
        double r = realPart - c.getRealPart();
        double i = imaginaryPart - c.getImaginaryPart();
        return new Complex(r, i);
    }

    public Complex multiply(Complex c)
    {
        double r = realPart * c.getRealPart() - imaginaryPart * c.getImaginaryPart();
        double i = realPart * c.getImaginaryPart() + imaginaryPart * c.getRealPart();

        return new Complex(r, i);
    }

    public Complex divide(Complex c)
    {
        double r = (realPart * c.getRealPart() + imaginaryPart * c.getImaginaryPart()) / 
            (c.getRealPart() * c.getRealPart() + c.getImaginaryPart() * c.getImaginaryPart());
        double i = (realPart * c.getImaginaryPart() - imaginaryPart * c.getRealPart()) /
            (c.getRealPart() * c.getRealPart() + c.getImaginaryPart() * c.getImaginaryPart());

        return new Complex(r, i);
    }

    public double abs()
    {
        return Math.sqrt(realPart * realPart + imaginaryPart * imaginaryPart);
    }

    @Override
    public String toString()
    {
        if (realPart == 0)
        {
            return imaginaryPart + "i";
        }
        else if (imaginaryPart == 0)
        {
            return realPart + "";
        }
        else
            return realPart + " + " + imaginaryPart + "i";
    }

    @Override
    public Object clone()
    {
        return new Complex(realPart, imaginaryPart);
    }
}


