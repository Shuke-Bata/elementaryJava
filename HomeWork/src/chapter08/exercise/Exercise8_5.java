package chapter08.exercise;

import java.util.Scanner;

public class Exercise8_5 {
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		double[][] matrix1 = new double[3][3];

		double[][] matrix2 = new double[3][3];

		System.out.print("Enter matrix1:");

		for(int i = 0; i < 3; ++i)

			for(int j = 0; j < 3; ++j)

				matrix1[i][j] = input.nextDouble();

		System.out.print("Enter matrix2:");

		for(int i = 0; i < 3; ++i)

			for(int j = 0; j < 3; ++j)

				matrix2[i][j] = input.nextDouble();

		matrix1 = addMatrix(matrix1,matrix2);

		for(int i = 0; i < 3; ++i){

			for(int j = 0; j < 3; ++j){

				System.out.print(matrix1[i][j] + " ");
			}

			System.out.println();
		}
		input.close();
}
	public static double[][] addMatrix(double[][] a, double[][] b){

		for(int i = 0; i < 3; ++i)

			for(int j = 0; j < 3; ++j)

				a[i][j] += b[i][j];

		return a;

	}
}
