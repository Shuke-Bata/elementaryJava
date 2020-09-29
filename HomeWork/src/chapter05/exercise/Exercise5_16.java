package chapter05.exercise;

import java.util.Scanner;

public class Exercise5_16 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number of integer :");
		int number = input.nextInt();
		int i;
		for (i = 2; i <= number; i++) {
			while (number % i == 0) {
				number = number / i;
				if (number != 1) {
					System.out.print(i + "，");
				} else
					System.out.print(i);
			}
		}

		input.close();
	}

}
