package chapter06.exercise;

import java.util.Scanner;

public class Exercise6_3 {

	public static int reverse(int number) {
		int newnumber = 0;

		while (number != 0) {
			newnumber *= 10;
			newnumber += number % 10;
			number /= 10;
		}

		return newnumber;
	}

	public static boolean isPalindrome(int number) {
		if (reverse(number) == number) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("输入一个整数:");
		int num = input.nextInt();

		System.out.println(num + " 是回文数? " + isPalindrome(num));

		input.close();
	}
}
