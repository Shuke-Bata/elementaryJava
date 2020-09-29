package chapter13.code;

public class ComparableRectangle13_9 extends Rectangle implements Comparable<ComparableRectangle13_9> {
	
	public ComparableRectangle13_9(double width, double height) {
		super(width, height);
	}

	@Override
	public int compareTo(ComparableRectangle13_9 o) {
		if (getArea() > o.getArea()) {
			return 1;
		} else if (getArea() < o.getArea()) {
			return -1;
		} else {
			return 0;
		}
	}
	@Override
	public String toString() {
		return super.toString() + " Area: " + getArea();
	}
}