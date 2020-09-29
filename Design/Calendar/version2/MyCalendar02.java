package version2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 用户输入年份和月份，使用Calendar和GregorianCalendar类显示指定月份的月历
 * @version 2.0
 * @author 周明华
 *
 */
public class MyCalendar02 {
	
	public static void main(String[] args) throws ParseException {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入年份、月份(如:2019-2)：");
		
		String str = input.nextLine();
		
		printCalendar(str);
		
		input.close();
	}
	
	/**
	 * 打印指定年月的日历
	 * @param year 年份
	 * @param month 月份
	 * @throws ParseException 转化异常
	 */
	public static void printCalendar(String str) throws ParseException {
		/**
		 * 时间对象和指定格式的字符串进行转换
		 * DateFormat抽象类 SimpleDateFormat 实现类 
		 */
		DateFormat dFormat = new SimpleDateFormat("yyyy-MM");
		Date date = dFormat.parse(str);
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		
		//将天数设为当月的第一天
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		
		System.out.println("===========" + str + "===========");
		System.out.println("日    一    二   三    四    五    六");
		
		//打印空格
		//DAY_OF_WEEK一周的天数，1表示星期天
		for (int i = 0; i < 4 * (calendar.get(Calendar.DAY_OF_WEEK) - 1); i++) {
			System.out.print(" ");
		}
		
		//获取当月总的天数
		int days = calendar.getActualMaximum(Calendar.DATE);
		
		//打印月历
		for (int i = 1; i <= days; i++) {
			System.out.printf("%-4d", calendar.get(Calendar.DAY_OF_MONTH));
			
			//换行
			if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
				System.out.println();
			}
			
			//每打印一个，天数向后移一天
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}
		
	}
}
