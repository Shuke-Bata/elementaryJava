package chapter04.exercise;

import java.util.Scanner;

public class Exercise4_8 {

	/**
	 * 编程练习 4.8
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter an ASCII code: ");
		int ascii = input.nextInt();

		char c = (char) ascii;

		System.out.println("The character for ASCII cod " + ascii + " is " + c);

		input.close();
	}

}
