package chapter06.exercise;

import java.util.Scanner;

public class Exercise6_5 {

	public static void displaySortedNumbers(double num1, double num2, double num3) {
		double[] a = new double[3];
		a[0] = num1;
		a[1] = num2;
		a[2] = num3;

		for (int i = 0; i < 3; i++) {
			for (int j = 1; j < 3 - i; j++) {
				if (a[j - 1] > a[j]) {
					double num = a[j - 1];
					a[j - 1] = a[j];
					a[j] = num;
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			System.out.println(a[i]);
		}

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("输入三个数:");
		double num1 = input.nextDouble();
		double num2 = input.nextDouble();
		double num3 = input.nextDouble();

		displaySortedNumbers(num1, num2, num3);

		input.close();
	}

}
