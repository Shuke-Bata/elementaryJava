package chapter07.exercise;

import java.util.Scanner;

public class Exercise7_8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double[] numList = new double[10]; 
		System.out.print("请输入10个数字：");
		for (int i = 0; i < numList.length; i++) {    
			numList[i] = scanner.nextDouble();   
			}   
		System.out.print("这10个数的平均值是：" + average(numList));
		
		scanner.close();
	}
	public static int average(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum+=array[i];
		}
		return sum/array.length;
	}
	public static double average(double[] array) {
		double sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum+=array[i];
		}
		return sum/array.length;
	}
}
