package version2;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;
/**
 * HangMan 游戏版本2
 * @author 周明华
 *
 */
public class HangmanFrame extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane mainPane = new Pane();
		Pane personPane = new Pane();//放人的面板
		
		final double X = 200;
		Polyline line = new Polyline();
		ObservableList<Double> list = line.getPoints();

		list.add(X);
		list.add(3 * X);

		list.add(X);
		list.add(X / 3);

		list.add(2.5 * X);
		list.add(X / 3);
		
		Arc arc = new Arc(X, (X * 3 + X / 3), ((X / 3) * 2), (X / 3), 0, 180);
		arc.setFill(Color.WHITE);
		arc.setStroke(Color.BLACK);
		
		mainPane.getChildren().addAll(arc, line);
	
		Circle head = new Circle((2.5 * X), X, (X / 4));
		head.setFill(Color.WHITE);
		head.setStroke(Color.BLACK);
		
		Line headLine = new Line(head.getCenterX(), (X / 3), head.getCenterX(), head.getCenterY() - head.getRadius());
		
		Line leftHand = new Line((head.getCenterX() - head.getRadius() * Math.sin(45)), (head.getCenterY() + head.getRadius() * Math.cos(45)),
				(head.getCenterX() - head.getRadius() * 3), (head.getCenterY() + head.getRadius() * 2));
		
		Line rightHand = new Line((head.getCenterX() + head.getRadius() * Math.sin(45)), (head.getCenterY() + head.getRadius() * Math.cos(45)),
				(head.getCenterX() + head.getRadius() * 3), (head.getCenterY() + head.getRadius() * 2));
		
		Line body = new Line(head.getCenterX(), (head.getCenterY() + head.getRadius()),	head.getCenterX(), (head.getCenterY() + head.getRadius() * 3));
		
		Line leftLeg = new Line(head.getCenterX(), (head.getCenterY() + head.getRadius() * 3),
				(head.getCenterX() - head.getRadius() * 2), (head.getCenterY() + head.getRadius() * 5));
		
		Line rightLeg = new Line(head.getCenterX(), (head.getCenterY() + head.getRadius() * 3),
				(head.getCenterX() + head.getRadius() * 2), (head.getCenterY() + head.getRadius() * 5));
		
		personPane.getChildren().addAll(headLine, head, leftHand, body, rightHand, leftLeg, rightLeg);
		
		mainPane.getChildren().add(personPane);
		Scene scene = new Scene(mainPane, 900, 700);
		primaryStage.setScene(scene);
		primaryStage.setTitle("HangMan");
		primaryStage.show();
		primaryStage.setResizable(false);//界面大小固定
	}
	public static void main(String[] args) {
		launch(args);
	}
}
