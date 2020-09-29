package version3;

import java.util.Calendar;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * 日历面板
 * @author 周明华
 *
 */
public class CalendarPane extends Pane{  
    private int year;  
    private int month; 
    private int day;  
    private int firstDayOfWeek;  
    private int totalDayOfMonth;  

    public CalendarPane() {     	
        Calendar calendar = Calendar.getInstance(); //获取一个Calendar对象      
        year = calendar.get(Calendar.YEAR);          
        month = calendar.get(Calendar.MONTH) + 1;         
        day = calendar.get(Calendar.DAY_OF_MONTH);          
        totalDayOfMonth = calendar.getActualMaximum(Calendar.DATE);  
        calendar.set(Calendar.DAY_OF_MONTH, 1); 
        firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;  
        paint();  

    }  

    public void paint(){  
       
        String[] week = new String[]{"日\t", "一\t", "二\t", "三\t", "四\t", "五\t", "六\t"};  
        
        GridPane pane = new GridPane();  
        pane.setPadding(new Insets(20, 10, 20, 30));  
        pane.setVgap(10);
        pane.setHgap(10);

        Text text1 = new Text(year + "年" + month + "\n");  
        text1.setStroke(Color.BLUEVIOLET); 
        text1.setFont(new Font("kaishu", 20));

        pane.setAlignment(Pos.CENTER);  
        pane.add(text1, 0, 0);  

        GridPane.setColumnSpan(text1, 7);  //设置跨列
        GridPane.setHalignment(text1, HPos.CENTER);  //设置对齐方式

        //加一列星期
        for(int i = 0; i < 7; i++){  
            Label label = new Label(week[i]);  
            pane.add(label, i, 1);  
            pane.getColumnConstraints().add(new ColumnConstraints(60));  //设置列的宽度
            GridPane.setHalignment(label, HPos.CENTER);  
        }  
        
        //加载日期
        for(int j = 0; j < totalDayOfMonth; j++){  
            Label label = new Label(j + 1 +"");  
            if (j + 1 == day) {
            	label.setFont(Font.font("kaishu", FontWeight.BOLD, 20));  
            }
            int k = firstDayOfWeek + j;  
            pane.add(label, k % 7, 2 + (k / 7));  
            GridPane.setHalignment(label, HPos.CENTER);    
        }  
        
        getChildren().add(pane);    
    }
}  
