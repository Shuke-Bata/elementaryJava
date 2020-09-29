package chapter15.exercise;
//可以实现圆上任意三点在圆上移动，并且显示三点形成三角形的各个角度数
//三角函数使用的是弧度制
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
//移动相连的三个圆
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Exercise15_21 extends Application
{
  @Override
  public void start(Stage primaryStage)
  {
      double height = 400;
      double width = 500;

      TriangleInACirclePane pane = new TriangleInACirclePane(height, width);
      Circle circle1 = pane.getCircle1();
      Circle circle2 = pane.getCircle2();
      Circle circle3 = pane.getCircle3();
      //移动是对每个圆的拖拽
      circle1.setOnMouseDragged(e -> {
          pane.moveCircle1(e.getX(), e.getY());
      });
      circle2.setOnMouseDragged(e -> {
          pane.moveCircle2(e.getX(), e.getY());
      });

      circle3.setOnMouseDragged(e -> {
          pane.moveCircle3(e.getX(), e.getY());
      });

      Scene scene = new Scene(pane, width, height);
      primaryStage.setTitle("MoveThreeCircles");
      primaryStage.setScene(scene);
      primaryStage.show();
  }
} 

class TriangleInACirclePane extends Pane
{
  private Circle circleBorder;
  private Circle circle1;
  private Circle circle2;
  private Circle circle3;
  private double angle1;
  private double angle2;
  private double angle3;
  private double pointAngle1;;
  private double pointAngle2;
  private double pointAngle3;
  private Line line1;
  private Line line2;
  private Line line3;
  private Text text1;
  private Text text2;
  private Text text3;
  private double width;
  private double height;
  private double edge;
  private double radius;

  public TriangleInACirclePane()
  {
      this(300, 400);
  }


  public TriangleInACirclePane(double width, double height)
  {   
      this.width = width;
      this.height = height;
      edge = Math.min(height, width);
      radius = edge / 2 * 0.8;
      circleBorder = new Circle();
      circle1 = new Circle();
      circle2 = new Circle();
      circle3 = new Circle();

      line1 = new Line();
      line2 = new Line();
      line3 = new Line();

      text1 = new Text();
      text2 = new Text();
      text3 = new Text();
      //初始化的三角形式一个等边三角形，高取给定宽度、高度较小的0.6
      //显示出最初的各个变量
      paint();
  }

  public Circle getCircle1()
  {
      return circle1;
  }

  public Circle getCircle2()
  {
      return circle2;
  }

  public Circle getCircle3()
  {
      return circle3;
  }

  //计算出围成三角形的各个角度（度数）
  private void setAngle()
  {
      double d1 = distance(circle2.getCenterX(), circle2.getCenterY(),
          circle3.getCenterX(), circle3.getCenterY());
      double d2 = distance(circle1.getCenterX(), circle1.getCenterY(),
          circle3.getCenterX(), circle3.getCenterY());
      double d3 = distance(circle1.getCenterX(), circle1.getCenterY(),
          circle2.getCenterX(), circle2.getCenterY());
      angle3 = Math.acos((d1 * d1 + d2 * d2 - d3 * d3) / (2 * d1 *d2));
      angle2 = Math.acos((d1 * d1 + d3 * d3 - d2 * d2) / (2 * d1 *d3));
      angle1 = Math.acos((d3 * d3 + d2 * d2 - d1 * d1) / (2 * d3 *d2));
  }

  //根据鼠标点，结合circleBorder中心点和一个起始点，找到需要旋转的角度
  public double getAngle(double eX, double eY)
  {
      double d1 = distance(edge / 2 + radius, edge / 2, eX, eY);
      double d2 = distance(circleBorder.getCenterX(), circleBorder.getCenterY(), eX, eY);
      double d3 = distance(circleBorder.getCenterX(), circleBorder.getCenterY(),
          edge / 2 + radius, edge / 2);
      double angle = Math.acos((d2 * d2 + d3 * d3 - d1 * d1) / (2 * d2 *d3));

      if (eY > edge / 2)
      {
          return -angle;
      }
      else
          return angle;
  }

  //计算两点之间的距离
  private double distance(double x1, double y1, double x2, double y2)
  {
      return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
  }

  //分别移动circle1, ciecle2, circle3
  public void moveCircle1(double eX, double eY)
  {
      pointAngle1 = getAngle(eX, eY);

      double centerX = edge / 2 + radius * Math.cos(pointAngle1);
      double centerY = edge / 2 - radius * Math.sin(pointAngle1);
//    System.out.println("P" + pointAngle1);
//    System.out.println(centerX);
//    System.out.println(centerY);
      //各个变量（圆、文本和直线）初始化之后，只要移动初始点，就是对各个变量的移动
      circle1.setCenterX(centerX);
      circle1.setCenterY(centerY);
      //选择的是从上到下从左到右的顺序，标记各个圆和直线的始末
      line3.setEndX(centerX);
      line3.setEndY(centerY);
      line2.setStartX(centerX);
      line2.setStartY(centerY);
      setAngle();
      text1.setX(centerX + 10);
      text1.setY(centerY);
      text1.setText(String.format("%.2f", (angle1 / Math.PI * 180)));
      text2.setText(String.format("%.2f", (angle2 / Math.PI * 180)));
      text3.setText(String.format("%.2f", (angle3 / Math.PI * 180)));
  }
  public void moveCircle2(double eX, double eY)
  {
      pointAngle2 = getAngle(eX, eY);
      double centerX = edge / 2 + radius * Math.cos(pointAngle2);
      double centerY = edge / 2 - radius * Math.sin(pointAngle2);
      circle2.setCenterX(centerX);
      circle2.setCenterY(centerY);
      line3.setStartX(centerX);
      line3.setStartY(centerY);
      line1.setStartX(centerX);
      line1.setStartY(centerY);
      setAngle();
      text2.setX(centerX + 10);
      text2.setY(centerY);
      text1.setText(String.format("%.2f", (angle1 / Math.PI * 180)));
      text2.setText(String.format("%.2f", (angle2 / Math.PI * 180)));
      text3.setText(String.format("%.2f", (angle3 / Math.PI * 180)));
  }
  public void moveCircle3(double eX, double eY)
  {
      pointAngle3 = getAngle(eX, eY);
      double centerX = edge / 2 + radius * Math.cos(pointAngle3);
      double centerY = edge / 2 - radius * Math.sin(pointAngle3);
      circle3.setCenterX(centerX);
      circle3.setCenterY(centerY);
      line1.setEndX(centerX);
      line1.setEndY(centerY);
      line2.setEndX(centerX);
      line2.setEndY(centerY);
      setAngle();
      text3.setX(centerX + 10);
      text3.setY(centerY);
      text1.setText(String.format("%.2f", (angle1 / Math.PI * 180)));
      text2.setText(String.format("%.2f", (angle2 / Math.PI * 180)));
      text3.setText(String.format("%.2f", (angle3 / Math.PI * 180)));
  }

  //显示出最初的各个变量
  private void paint()
  {
      circleBorder.setCenterX(edge / 2);
      circleBorder.setCenterY(edge / 2);
      circleBorder.setRadius(radius);
      circleBorder.setFill(Color.WHITE);
      circleBorder.setStroke(Color.BLACK);
      //在圆上随机生成三个圆
      pointAngle1 = Math.random() * 360;
      pointAngle2 = Math.random() * 360;
      pointAngle3 = Math.random() * 360;

      circle1.setCenterX(edge / 2 + radius * Math.cos(pointAngle1));
      circle1.setCenterY(edge / 2 - radius * Math.sin(pointAngle1));
      circle1.setRadius(10);
      circle2.setCenterX(edge / 2 + radius * Math.cos(pointAngle2));
      circle2.setCenterY(edge / 2 - radius * Math.sin(pointAngle2));
      circle2.setRadius(10);
      circle3.setCenterX(edge / 2 + radius * Math.cos(pointAngle3));
      circle3.setCenterY(edge / 2 - radius * Math.sin(pointAngle3));
      circle3.setRadius(10);

      super.getChildren().addAll(circleBorder, circle1, circle2, circle3);
      setAngle();
      //选择的是从上到下从左到右的顺序，标记各个圆和直线的始末
      line1.setStartX(circle2.getCenterX());
      line1.setStartY(circle2.getCenterY());
      line1.setEndX(circle3.getCenterX());
      line1.setEndY(circle3.getCenterY());

      line2.setStartX(circle1.getCenterX());
      line2.setStartY(circle1.getCenterY());
      line2.setEndX(circle3.getCenterX());
      line2.setEndY(circle3.getCenterY());

      line3.setStartX(circle2.getCenterX());
      line3.setStartY(circle2.getCenterY());
      line3.setEndX(circle1.getCenterX());
      line3.setEndY(circle1.getCenterY());

      text1.setX(circle1.getCenterX() + 10);
      text1.setY(circle1.getCenterY());
      text1.setText(String.format("%.2f", angle1));
      text2.setX(circle2.getCenterX() + 10);
      text2.setY(circle2.getCenterY());
      text2.setText(String.format("%.2f", angle2));
      text3.setX(circle3.getCenterX() + 10);
      text3.setY(circle3.getCenterY());
      text3.setText(String.format("%.2f", angle3));

      super.getChildren().addAll(line1, line2, line3, text1, text2, text3);
  }
}

