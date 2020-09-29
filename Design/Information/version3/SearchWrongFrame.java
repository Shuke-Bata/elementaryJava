package version3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * 查询错误
 * @author 周明华
 *
 */
public class SearchWrongFrame extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Text text = new Text("查无此人!");
		text.setFont(new Font(30));
		text.setLayoutX(140);
		text.setLayoutY(100);
		
		Pane pane = new Pane();
		pane.getChildren().add(text);
		primaryStage.setScene(new Scene(pane));
		primaryStage.show();
	}
}
