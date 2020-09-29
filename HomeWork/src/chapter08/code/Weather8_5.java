package chapter08.code;

import java.util.Scanner;

public class Weather8_5 {
	public static void main(String[] agrs) {
		final int NUMBER_OF_DAYS = 10;
		final int NUMBER_OF_HOURS = 24;
		double[][][] data = new double[NUMBER_OF_DAYS][NUMBER_OF_HOURS][2];
		Scanner input = new Scanner(System.in);
		for (int k = 0; k < NUMBER_OF_HOURS * NUMBER_OF_DAYS; k++) {
			int day = input.nextInt();
			int hour = input.nextInt();
			double temperature = input.nextDouble();
			double humidity = input.nextDouble();
			data[day - 1][hour - 1][0] = temperature;
			data[day - 1][hour - 1][1] = humidity;
		}

		for (int i = 0; i < NUMBER_OF_DAYS; i++) {
			double dailyHumidityTotal = 0, daliyTemperatureTotal = 0;
			for (int j = 0; j < NUMBER_OF_HOURS; j++) {
				daliyTemperatureTotal += data[i][j][0];
				dailyHumidityTotal += data[i][j][1];
			}
			System.out.println("Day " + i + " s average temperature is " + daliyTemperatureTotal / NUMBER_OF_HOURS);
			System.out.println("Day " + i + "s average humidity is " + dailyHumidityTotal / NUMBER_OF_HOURS);

		}

		input.close();
	}

}
