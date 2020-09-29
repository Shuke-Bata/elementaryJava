package chapter02.exercise;

import java.util.Scanner;

public class Exercise4 {

	/**
	 * 编程练习 2.4
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter a number in pounds: ");
		double pounds = input.nextDouble();

		double kilograms = 0.454 * pounds;

		System.out.println(pounds + " pounds is " + kilograms + " kilograms");

		input.close();
	}

}
