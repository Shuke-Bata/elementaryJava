package chapter13.code;

/**
 * @author 27315
 *
 */
public class SortRectangles13_10 {
	public static void main(String[] args) {
		ComparableRectangle13_9[] recttangles = {
				new ComparableRectangle13_9(3.4, 5.4),
				new ComparableRectangle13_9(13.24, 55.4),
				new ComparableRectangle13_9(7.4, 35.4),
				new ComparableRectangle13_9(1.4, 25.4),
		};
		java.util.Arrays.sort(recttangles);
		for (Rectangle rectangle : recttangles) {
			System.out.print(rectangle + " ");
			System.out.println();
		}
	}
}
