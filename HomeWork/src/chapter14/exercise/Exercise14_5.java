package chapter14.exercise;
//圆形显示一个字符串，并且每个单词也要指向圆心
//初中数学，找坐标和角度关系
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.layout.Pane;

public class Exercise14_5 extends Application
{
  @Override
  public void start(Stage primaryStage)
  {
      Pane pane = new Pane();
      String str = "WELCOM TO JAVA";
      int length = str.length();
      final double centerX = 200, centerY = 200, radius = 100;
      double divide = 2 * Math.PI / length;

      for (int i = 0; i < length; i++)
      {
          double newX = centerX + radius * Math.cos(i * divide);
          double newY = centerY + radius * Math.sin(i * divide);
          Text t = new Text(newX, newY, str.charAt(i) + "");
          t.setFill(Color.RED);
          //Text中的setFont(Font)
          t.setFont(Font.font("MyFont", FontWeight.BOLD, FontPosture.ITALIC, 15));
          //旋转字体
          int r = (int)((Math.PI / 2 + i * divide) / (2 * Math.PI) * 360);
          t.setRotate(r);
          pane.getChildren().add(t);
      }

      Scene scene = new Scene(pane, 400, 400);
      primaryStage.setTitle("ShowString");
      primaryStage.setScene(scene);
      primaryStage.show();
  }
  public static void main(String[] args) {
	launch(args);
}
}

