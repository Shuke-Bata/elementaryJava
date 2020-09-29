package chapter07.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise7_3 {
	public static void main(String[] args) {
		int[] num = createArrays();
		Arrays.sort(num);
		System.out.println("数据升序排列后为：" + Arrays.toString(num));
		for (int i = 0; i < num.length; i++) {
			if (i == 0 || (num[i] != num[i - 1])) {
				System.out.println(num[i] + "在数组中出现了" + getCount(num[i], num) + "次");
			}
		}
	}

	private static int[] createArrays() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入1~100之间的整数（以0作为结束）：");
		int[] num = new int[100];
		int i = 0;
		int input;
		while (i >= 0) {
			input = scanner.nextInt();
			if (input != 0) {
				num[i] = input;
				i++;
			} else {
				break;
			}
		}
		scanner.close();
		
		int zeroIndex = getZeroIndex(num);
		int[] newNum = new int[zeroIndex];
		System.arraycopy(num, 0, newNum, 0, zeroIndex);

		return newNum;
	}

	private static int getZeroIndex(int[] num) {
		for (int i = 0; i < num.length; i++) {
			if (num[i] == 0) {
				return i;
			}
		}
		return -1;
	}

	private static int getCount(int indexNum, int[] num) {
		int count = 0;
		for (int i = 0; i < num.length; i++) {
			if (indexNum == num[i]) {
				count++;
			}
		}
		return count;
	}

}
