package chapter02.code;

import java.util.Scanner;

public class ComputeLoan2_9 {
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		System.out.print("Enter annual interest rate, e.g., 7.25%: ");
		double annualInterestRate = input.nextDouble();

		// Obtain monthly interest rate
		double monthlyInterestRate = annualInterestRate / 1200;

		// Enter a number of years
		System.out.print("Enter nmber of year as an integer, e.g., 5: ");
		int numberOfYear = input.nextInt();

		// Enter loan amount
		System.out.print("Enter loan amount, e.g., 120000.95: ");
		double loanAmunt = input.nextDouble();

		// Calculate payment
		double monthlyPayment = loanAmunt * monthlyInterestRate
				/ (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYear * 12));
		double totalPayment = monthlyPayment * numberOfYear * 12;

		// Display results
		System.out.println("The monthly payment is $" + (int) (monthlyPayment * 100) / 100.0);
		System.out.println("The total payment is $" + (int) (totalPayment * 100) / 100.0);

		input.close();
	}

}
