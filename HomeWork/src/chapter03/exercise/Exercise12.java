package chapter03.exercise;

import java.util.Scanner;

public class Exercise12 {

	/**
	 * 编程练习 3.12
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter a three-digit integer: ");
		int a = input.nextInt();

		if (a / 100 == a % 10) {
			System.out.println(a + " is a palindrome");
		} else {
			System.out.println(a + " is not a palindrome");
		}

		input.close();
	}

}
