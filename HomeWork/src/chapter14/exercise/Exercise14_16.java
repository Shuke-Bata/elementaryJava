package chapter14.exercise;
//将窗体划分成九宫格，水平线是蓝色，垂直线是红色

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Exercise14_16 extends Application
{
  @Override
  public void start(Stage primaryStage)
  {
      Pane pane = new Pane();
      DoubleProperty x1 = new SimpleDoubleProperty();
      x1.bind(pane.widthProperty().divide(3));
      DoubleProperty x2 = new SimpleDoubleProperty();
      x2.bind(pane.widthProperty().multiply(2).divide(3));
      DoubleProperty y1 = new SimpleDoubleProperty();
      y1.bind(pane.heightProperty().divide(3));
      DoubleProperty y2 = new SimpleDoubleProperty();
      y2.bind(pane.heightProperty().multiply(2).divide(3));

      Line lineX1 = new Line();
      lineX1.setStroke(Color.RED);
      lineX1.startXProperty().bind(x1);
      lineX1.setStartY(0.0);
      lineX1.endXProperty().bind(x1);
      lineX1.endYProperty().bind(pane.heightProperty());
      Line lineX2 = new Line();
      lineX2.setStroke(Color.RED);
      lineX2.startXProperty().bind(x2);
      lineX2.setStartY(0.0);
      lineX2.endXProperty().bind(x2);
      lineX2.endYProperty().bind(pane.heightProperty());
      Line lineY1 = new Line();
      lineY1.setStroke(Color.BLUE);
      lineY1.setStartX(0.0);
      lineY1.startYProperty().bind(y1);
      lineY1.endXProperty().bind(pane.widthProperty());
      lineY1.endYProperty().bind(y1);
      Line lineY2 = new Line();
      lineY2.setStroke(Color.BLUE);
      lineY2.setStartX(0.0);
      lineY2.startYProperty().bind(y2);
      lineY2.endXProperty().bind(pane.widthProperty());
      lineY2.endYProperty().bind(y2);

      pane.getChildren().addAll(lineX1, lineX2, lineY1, lineY2);

      Scene scene = new Scene(pane);
      primaryStage.setTitle("DivideLine");
      primaryStage.setScene(scene);
      primaryStage.show();
  }
}
