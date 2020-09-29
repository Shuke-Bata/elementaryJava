package chapter13.code;

public class House13_11 implements Cloneable, Comparable<House13_11> {
	private int id;
	private double area;
	private java.util.Date whenBuilt;
	
	public House13_11(int id, double area) {
		super();
		this.id = id;
		this.area = area;
		whenBuilt = new java.util.Date();
	}
	
	public int getId() {
		return id;
	}

	public double getArea() {
		return area;
	}

	public java.util.Date getWhenBuilt() {
		return whenBuilt;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(House13_11 o) {
		if (area > o.area) {
			return 1;
		} else if (area < o.area) {
			return -1;
		} else {
			return 0;
		}
	}
}
