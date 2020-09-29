package chapter09.exercise;

import java.util.Random;

public class Exercise9_4 {
	public static void main(String[] args){

		Random random1 = new Random(1000);

		System.out.println("From random 1:");

		for(int i = 0; i < 50; i++){

			System.out.print(random1.nextInt(100) + " ");

		}
		
	}

}
