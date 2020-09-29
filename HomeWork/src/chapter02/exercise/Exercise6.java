package chapter02.exercise;

import java.util.Scanner;

public class Exercise6 {

	/**
	 * 编程练习 2.6
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter a number between 0 and 1000: ");
		int a = input.nextInt();

		int sum = 0;
		while (a / 10 != 0) {
			sum += a % 10;
			a = a / 10;
		}
		sum += a;

		System.out.println("THe sum of the digits is " + sum);

		input.close();
	}

}
