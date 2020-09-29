package chapter08.exercise;

public class Exercise8_4 {
	public static void main(String[] args){

		int[][] time = {

				{2,4,3,4,5,8,8},

				{7,3,4,3,3,4,4},

				{3,3,4,3,3,2,2},

				{9,3,4,7,3,4,1},

				{3,5,4,3,6,3,8},

				{3,4,4,6,3,4,4},

				{3,7,4,8,3,8,4},

				{6,3,5,9,2,7,9}

		};

		

		int[] temp = null;

		

		for(int i = 0; i < 7; ++i){

			for(int j = i+1; j < 8; ++j){

				if(time[i][6] < time[j][6]){

					temp = time[i];

					time[i] = time[j];

					time[j] = temp;

				}

			}

		}

		

		for(int i = 0; i < 8; ++i){

			for(int j = 0; j < 7; ++j){

				System.out.print(time[i][j] + " ");

			}

			System.out.println();

		}

		

	}

}