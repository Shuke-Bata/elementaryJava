package chapter15.code;

import chapter14.code.ClockPane14_21;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class DisplayResizableClock15_11 extends Application {

	@Override
	public void start(Stage primaryStage)  {
		//Create a clock and a label
		ClockPane14_21 clock = new ClockPane14_21();
		String timeString = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
		Label lblCurrentTime = new Label(timeString);
		
		//Palce clock and label in border pane
		BorderPane pane = new BorderPane();
		pane.setCenter(clock);
		pane.setBottom(lblCurrentTime);
		BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);
		
		//Create  a scene place it in the stage
		Scene scene = new Scene(pane,250,250);
		primaryStage.setTitle("DisplayClock");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		pane.widthProperty().addListener(ov -> clock.setW(pane.getWidth()));
		pane.heightProperty().addListener(ov -> clock.setH(pane.getHeight()));
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
