package chapter04.exercise;

import java.util.Scanner;

public class Exercise4_13 {

	/**
	 * 编程练习 4.13
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter a letter: ");
		char letter = input.next().charAt(0);

		if (Character.isLetter(letter)) {
			if (letter == 'A' || letter == 'E' || letter == 'U' || letter == 'I' || letter == 'O' || letter == 'a'
					|| letter == 'e' || letter == 'u' || letter == 'i' || letter == 'o') {

				System.out.println(letter + " is a vowel");
			} else {
				System.out.println(letter + " is a consonant");
			}

		} else {
			System.out.println(letter + " is an invalid input");
		}

		input.close();
	}

}
