package version3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 利用JavaFX设计GUI，显示当前月份的日历。
 * 要求使用Calendar和GregorianCalendar获取月份、年份、月份的第一天、该月的总天数
 * @author 周明华
 * @version 3.0
 */
public class MyCalendar03 extends Application{

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		CalendarPane calendarPane =	new CalendarPane();
		
		Scene scene = new Scene(calendarPane, 500, 300);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}

}