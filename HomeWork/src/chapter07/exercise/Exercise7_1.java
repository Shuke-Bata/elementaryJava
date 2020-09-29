package chapter07.exercise;

import java.util.Scanner;

public class Exercise7_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of student: ");
		int num = input.nextInt();
		
		int[] student = new int[num];
		
		System.out.print("Enter " + num + " scores:");
		for (int i = 0; i < student.length; i++) {
			student[i] = input.nextInt();
		}
		
		int max = maxNumber(student);
		
		for (int i = 0; i < student.length; i++) {
			if (student[i] >= max-10) {
				System.out.println("Student " + i + " score is " + student[i] +" and grade is A");
			} else if (student[i] >= max-20) {
				System.out.println("Student " + i + " score is " + student[i] +" and grade is B");
			} else if (student[i] >= max-30) {
				System.out.println("Student " + i + " score is " + student[i] +" and grade is C");
			} else if (student[i] >= max-40) {
				System.out.println("Student " + i + " score is " + student[i] +" and grade is D");
			} else {
				System.out.println("Student " + i + " score is " + student[i] +" and grade is E");
			}
		}
		input.close();
	}
	public static int maxNumber(int[] s) {	
		int max = s[0];
		for (int i = 1; i < s.length; i++) {
			if(max < s[i]) {
				max = s[i];
			}
		}
		return max;
	}
}
