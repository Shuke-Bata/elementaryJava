package version1;

import java.util.Scanner;

/**
 * 提示用户输入年份和该年的第一天是星期几，然后输出该年的日历
 * @version 1.0
 * @author 周明华
 *
 */
public class MyCalendar01 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		do {
			try {
				System.out.print("请输入年份、以及该年第一天是星期几：");		
				int year = input.nextInt();//存放年份
				int count = input.nextInt();//存放该年第一天是星期几
				
				flag = false;
				printCalendar(year, count);
			} catch (Exception e) {
				System.out.println("非法输入 !");
				input.nextLine();
			}
		} while (flag);
		
		input.close();
	}
	
	/**
	 * 打印指定年份的日历
	 * @param year 年份
	 * @param count 第一天是星期几
	 */
	public static void printCalendar(int year, int count) {
		int[] month = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if (isLeapYear(year)) {
			month[2] = 29;
		}
		
		for (int i = 1; i <= 12; i++) {
			System.out.println("============" + i + "月" + "============");
			System.out.println("日    一    二   三    四    五    六");
			
			//打印空格
			for (int j = 4 * count; j > 0; j--) {
				System.out.print(" ");				
			}
			//打印日历
			for (int j = 1; j <= month[i]; j++) {
				System.out.printf("%-4d", j);
				if ((count + j) % 7 == 0) {
					System.out.println();
				}
			}
			System.out.println("\n\n");
			//计算空格个数
			count = (count + month[i]) % 7;
		}
		
	}
	
	/**
	 * 判断给定年份是否为闰年？
	 * @param year 年份
	 * @return
	 */
	public static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
	
}
