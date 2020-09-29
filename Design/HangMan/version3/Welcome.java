package version3;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * 游戏开始界面
 * @author 周明华
 *
 */
public class Welcome extends Application {
	static int num = 0;
	@Override
	public void start(Stage primaryStage) throws Exception {
		StackPane pane = new StackPane();
		
		Image image = new Image("image/hangman.gif");
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(1000);
		imageView.setFitHeight(1000);
		
		Text text = new Text("Weclome\nHangMan");
		text.setFill(Color.RED);
		
		//动画事件
		EventHandler<ActionEvent> eventHandler = e -> {
			text.setFont(new Font("SimSun", num * 10));
			num++;
		};
				
		Timeline animation = new Timeline(
						new KeyFrame(Duration.millis(60), eventHandler));
		animation.setCycleCount(16);
		animation.play();
		
		pane.getChildren().addAll(imageView, text);
		
		Scene scene = new Scene(pane, 800, 800);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}
}
