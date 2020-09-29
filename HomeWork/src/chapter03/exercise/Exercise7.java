package chapter03.exercise;

import java.util.Scanner;

public class Exercise7 {

	/**
	 * 编程练习 3.7
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Receive the amount
		System.out.print("Enter an amount in double, for example 11.56: ");
		double amount = input.nextDouble();

		int remainingAmount = (int) (amount * 100);

		// Find the number of one dollars
		int numberOfOneDollars = remainingAmount / 100;
		remainingAmount = remainingAmount % 100;

		// Find the number of quarters in the remaining amount
		int numberOfQuarters = remainingAmount / 25;
		remainingAmount = remainingAmount % 25;

		int numberOfDimes = remainingAmount / 10;
		remainingAmount = remainingAmount % 10;

		int numberOfNickels = remainingAmount / 5;
		remainingAmount = remainingAmount % 5;

		int numberOfPennies = remainingAmount;

		// Display results
		System.out.println("Your amount " + amount + " consists of");

		if (numberOfOneDollars == 1) {
			System.out.println("	" + numberOfOneDollars + " dollar");
		} else if (numberOfOneDollars >= 2) {
			System.out.println("	" + numberOfOneDollars + " dollars");
		}

		if (numberOfQuarters == 1) {
			System.out.println("	" + numberOfQuarters + " quarter");
		} else if (numberOfQuarters >= 2) {
			System.out.println("	" + numberOfQuarters + " quarters");
		}

		if (numberOfDimes == 1) {
			System.out.println("	" + numberOfDimes + " dime");
		} else if (numberOfDimes >= 2) {
			System.out.println("	" + numberOfDimes + " dimes");
		}

		if (numberOfNickels == 1) {
			System.out.println("	" + numberOfNickels + " nickel");
		} else if (numberOfNickels >= 2) {
			System.out.println("	" + numberOfNickels + " nickels");
		}

		if (numberOfPennies == 1) {
			System.out.println("	" + numberOfPennies + " pennie");
		} else if (numberOfPennies >= 2) {
			System.out.println("	" + numberOfPennies + " pennies");
		}

		input.close();
	}
}
