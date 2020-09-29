package version3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class WelcomeFrame extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		StackPane pane = new StackPane();
		
		Image image = new Image("image/timg.gif");
		ImageView imageView = new ImageView(image);
		
		pane.getChildren().add(imageView);
		
		Scene scene = new Scene(pane, 800, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}
}
