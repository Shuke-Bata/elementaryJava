package chapter02.exercise;

import java.util.Scanner;

public class Exercise5 {

	/**
	 * 编程练习 2.5
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter the subtotal and a gratuity rate: ");
		int subtotal = input.nextInt();
		int gratuityrate = input.nextInt();

		double gratuity = subtotal * (gratuityrate / 100.0);
		double total = subtotal + gratuity;

		System.out.println("The gratuity is $" + gratuity + " and total is $" + total);

		input.close();
	}

}
