package chapter13.code;

public class TestRational13_12 {
	public static void main(String[] args) {
		Rational r1 = new Rational(4, 2);
		Rational r2 = new Rational(2, 3);
		
		System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
		System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
		System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
		System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
		System.out.println(r2 + " is " + r2.doubleValue());
	}
}
@SuppressWarnings("serial")
class Rational extends Number implements Comparable<Rational> {
	private long numberator = 0;
	private long denominator = 1;
	
	public Rational() {
		// TODO Auto-generated constructor stub
	}
	
	public Rational(long numberator, long denominator) {
		super();
		long gcd = gcd(numberator, denominator);
		this.numberator = ((numberator > 0) ? 1 : -1) * numberator / gcd;
		this.denominator = Math.abs(denominator) / gcd;
	}
	
	private static long gcd(long n, long d) {
		long n1 = Math.abs(n);
		long n2 = Math.abs(d);
		int gcd = 1;
		
		for (int i = 1; i <=n1 && i <= n2; i++) {
			if (n1 % i == 0 && n2 % i ==0) {
				gcd = i;
			}
		}
		return gcd;
	}
	
	public long getNumberator() {
		return numberator;
	}

	public long getDenominator() {
		return denominator;
	}
	
	public Rational add(Rational secondRational) {
		long n = numberator * secondRational.getDenominator() + denominator * secondRational.getNumberator();
		long d = denominator * secondRational.getDenominator();
		return new Rational(n, d);
	}
	
	public Rational subtract(Rational secondRational) {
		long n = numberator * secondRational.getDenominator() - denominator * secondRational.getNumberator();
		long d = denominator * secondRational.getDenominator();
		return new Rational(n, d);
	}
	
	public Rational multiply(Rational secondRational) {
		long n = numberator * secondRational.getNumberator();
		long d = denominator * secondRational.getDenominator();
		return new Rational(n, d);
	}
	
	public Rational divide(Rational secondRational) {
		long n = numberator * secondRational.getDenominator();
		long d = denominator * secondRational.getNumberator();
		return new Rational(n, d);
	}
	
	@Override
	public String toString() {
		if (denominator == 1) {
			return numberator + "";
		} else {
			return numberator + "/" + denominator;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if ((this.subtract((Rational)(obj))).getNumberator() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public int compareTo(Rational o) {
		if (this.subtract(o).getNumberator() > 0) {
			return 1;
		} else if (this.subtract(o).getNumberator() < 0) {
			return -1;
		} else {
			return 0;
		}
	}
	@Override
	public double doubleValue() {
		return numberator * 1.0 / denominator;
	}
	@Override
	public float floatValue() {
		return (float)doubleValue();
	}
	@Override
	public int intValue() {
		return (int)doubleValue();
	}
	@Override
	public long longValue() {
		return (long)doubleValue();
	}
}
