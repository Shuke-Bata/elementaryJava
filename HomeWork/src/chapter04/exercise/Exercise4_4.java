package chapter04.exercise;

import java.util.Scanner;

public class Exercise4_4 {

	/**
	 * 编程练习 4.4
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter the side: ");
		double s = input.nextDouble();

		double area = (6 * Math.pow(s, 2)) / (4 * Math.tan(Math.PI / 6));

		System.out.printf("The area of the hexagon is %.2f", area);

		input.close();
	}

}
