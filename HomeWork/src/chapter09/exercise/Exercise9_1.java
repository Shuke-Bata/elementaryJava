package chapter09.exercise;

public class Exercise9_1 {
	public static void main(String[] args) {
		Rectangle rectangle1 = new Rectangle(4,40);
		Rectangle rectangle2 = new Rectangle(3.5,35.9);
		System.out.println("rectangle1 的面級：" + rectangle1.getArea()+"周長："+rectangle1.getPerimeter());
		System.out.println("rectangle2 的面級：" + rectangle2.getArea()+"周長："+rectangle2.getPerimeter());
		
	}
}
class Rectangle {
	
	 private double width = 1;
	 private double height = 1;


    /**
     * Default constructor
     */
    public Rectangle() {
    }

    public Rectangle(double width, double height) {
    	this.width = width;
    	this.height = height;
    }
    
    /**
     * 求面級
     * @return
     */
    public double getArea() {
        return width * height;
    }

    /**
     * 求周長
     * @return
     */
    public double getPerimeter() {
        return 2 * (width + height);
    }
}