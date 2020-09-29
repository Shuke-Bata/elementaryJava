package chapter05.exercise;

public class Exercise5_19 {

	public static void main(String[] args) {
		int line = 8;
		for (int i = 1; i <= line; i++) {
			for (int j = 0; j < line - i; j++) {
				System.out.print("\t");
			}
			for (int j = 1; j < Math.pow(2, i); j *= 2) {
				System.out.printf("%3d" + "\t", j);
			}
			for (int j = (int) Math.pow(2, i - 2); j > 0; j /= 2) {
				System.out.printf("%3d" + "\t", j);
			}
			System.out.println();
		}
	}

}
