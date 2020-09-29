package chapter06.exercise;

import java.util.Scanner;

public class Exercise6_30 {

	private static int count = 0;

	public static void main(String[] args) {

		int num1 = (int) (Math.random() * 6) + 1;

		int num2 = (int) (Math.random() * 6) + 1;

		System.out.println("你投出了" + num1 + "+" + num2 + "=" + (num1 + num2));

		isWin(num1, num2);

		System.out.print("总共投掷了" + count + "次");

	}

	private static void isWin(int num1, int num2) {

		int sum = num1 + num2;

		if (sum == 2 || sum == 3 || sum == 12) {

			System.out.println("你输了！");

			count++;

		} else if (sum == 7 || sum == 11) {

			System.out.println("你赢了！");

			count++;

		} else {

			count++;

			int result = 0;

			Scanner input = new Scanner(System.in);
			
			while (result == 0) {

				System.out.print("请回车继续！");

				input.nextLine();

				result = playAgain(num1, num2);

				count++;
			}
			input.close();
		}
	}

	private static int playAgain(int num1, int num2) {

		int sum = num1 + num2;

		int num1_new = (int) (Math.random() * 6) + 1;

		int num2_new = (int) (Math.random() * 6) + 1;

		System.out.println("你投出了" + num1_new + "+" + num2_new + "=" + (num1_new + num2_new));

		if (num1_new + num2_new == sum) {

			System.out.println("你赢了！");

			return 1;

		} else if (num1_new + num2_new == 7) {

			System.out.println("你输了！");

			return 1;

		} else {

			return 0;

		}

	}

}
