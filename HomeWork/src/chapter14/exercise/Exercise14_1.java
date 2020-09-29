package chapter14.exercise;
//将image文件夹中的照片加载出来
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class Exercise14_1 extends Application
{
  @Override
  public void start(Stage primaryStage)
  {
      GridPane pane = new GridPane();
      pane.setPadding(new Insets(5, 5, 5, 5));
      pane.setHgap(10);
      pane.setVgap(10);
      ImageView p1 = new ImageView("image/flag5.gif");
      ImageView p2 = new ImageView("image/flag3.gif");
      ImageView p3 = new ImageView("image/flag2.gif");
      ImageView p4 = new ImageView("image/flag6.gif");

      pane.add(p1, 0, 0);
      pane.add(p2, 1, 0);
      pane.add(p3, 0, 1);
      pane.add(p4, 1, 1);

      Scene scene = new Scene(pane);
      primaryStage.setTitle("ShowFlag");
      primaryStage.setScene(scene);
      primaryStage.show();
  }
}
