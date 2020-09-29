package version3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * 退出界面
 * @author 周明华
 *
 */
public class ExitFrame extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = new Pane();
		Image image = new Image("image/goodBye.gif");
		ImageView imageView = new ImageView(image);
	/*	imageView.setFitWidth(300);
		imageView.setFitHeight(200);*/
		
		imageView.setLayoutX(100);
		imageView.setLayoutY(50);
		
		pane.getChildren().add(imageView);
		
		Scene scene = new Scene(pane, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}
}
