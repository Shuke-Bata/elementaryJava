package chapter14.code;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class DisplayClock14_20 extends Application {
	@Override
	public void start (Stage primparyStage) {
		ClockPane14_21 clock = new ClockPane14_21();
		String timeString = clock.getHour() + ":" + clock.getMinute() + ";" + clock.getSecond();
		Label lblCurrentTimeLabel = new Label(timeString);
		
		BorderPane pane = new BorderPane();
		pane.setCenter(clock);
		pane.setBottom(lblCurrentTimeLabel);
		BorderPane.setAlignment(lblCurrentTimeLabel, Pos.TOP_CENTER);
		
		Scene scene = new Scene(pane,250,250);
		primparyStage.setTitle("DisplayClock");
		primparyStage.setScene(scene);
		primparyStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
