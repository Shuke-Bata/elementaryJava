package chapter05.exercise;

import java.util.Scanner;

public class Exercise5_21 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Loan Amount:");
		int loan = input.nextInt();
		System.out.print("Number of years:");
		int years = input.nextInt();
		System.out.printf("%-5s%-5s%-5s%n", "Interest Rate", "Monthly Payment", "Total Payment");
		for (double annualInterestRate = 5.0; annualInterestRate <= 8.0; annualInterestRate = annualInterestRate
				+ 0.125) {
			double MonthlyPayment = loan * (annualInterestRate / 1200)
					/ (1 - 1 / Math.pow(1 + annualInterestRate / 1200, years * 12));
			double TotalPayment = MonthlyPayment * years * 12;
			System.out.printf("%-5.3f%s%s%5.2f%s%-5.2f%n", annualInterestRate, "%", "   ", MonthlyPayment, "       ",
					TotalPayment);
		}

		input.close();
	}
}
