package chapter14.code;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ShowCircle14_4 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Circle circle = new Circle();
		circle.setCenterX(100);
		circle.setCenterY(100);
		circle.setRadius(50);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.WHITE);

		Pane pane = new Pane();
		pane.getChildren().add(circle);

		Scene scene = new Scene(pane, 200, 200);
		primaryStage.setTitle("ShowCircle");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
