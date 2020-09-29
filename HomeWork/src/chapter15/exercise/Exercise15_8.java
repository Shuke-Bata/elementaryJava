package chapter15.exercise;
//显示鼠标的位置
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class Exercise15_8 extends Application
{
  @Override
  public void start(Stage primaryStage)
  {
      Pane pane = new Pane();

      Text coordinate = new Text();
      pane.setOnMousePressed(e -> {
          double x = e.getX();
          double y = e.getY();
          coordinate.setX(x);
          coordinate.setY(y);
          coordinate.setText("(" + x + "," + y + ")");
          pane.getChildren().add(coordinate);
      });

      pane.setOnMouseReleased(e -> {
          pane.getChildren().remove(coordinate);
      });

      Scene scene = new Scene(pane);
      primaryStage.setTitle("ShowMouseCoordinate");
      primaryStage.setScene(scene);
      primaryStage.show();
  }
}

