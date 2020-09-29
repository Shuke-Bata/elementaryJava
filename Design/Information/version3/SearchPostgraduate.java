package version3;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import version2.Postgraduate;
/**
 * 查询研究生界面
 * @author 周明华
 *
 */
public class SearchPostgraduate extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Text text = new Text("请输入查询的姓名");
		
		TextField searchName = new TextField();
		searchName.setPromptText("姓名");
		searchName.setMaxSize(200, 50);
        
        Button searchButton = new Button("查询");
        searchButton.setMinSize(50, 20);
        searchButton.setOnAction(event -> {
        	PostgraduateTable postgraduateTable = new PostgraduateTable();
        	ArrayList<Postgraduate> list = new ArrayList<>();
        	ArrayList<Postgraduate> list2 = new ArrayList<>();
    		try {
    			list = postgraduateTable.readFile();
    		} catch (FileNotFoundException e1) {
    			e1.printStackTrace();
    		}
    		
    		for (Postgraduate postgraduate : list) {
    			if ((postgraduate.getName()).equals(searchName.getText())) {
					list2.add(postgraduate);
				}
			}
    		
    		ShowSearchPostgraduateTable showSearchPostgraduateTable = new ShowSearchPostgraduateTable();
        	primaryStage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(800);
    		newStage.setMinHeight(500);
    		
        	try {
        		showSearchPostgraduateTable.start(newStage, list2);;
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        Button backButton = new Button("返回");
        backButton.setMinSize(50, 20);
        backButton.setOnAction(event -> {
        	PostgraduateTable postgraduateTable = new PostgraduateTable();
        	
        	primaryStage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(1080);
    		newStage.setMinHeight(500);
    		
        	try {
        		postgraduateTable.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        HBox box = new HBox(100);
        box.getChildren().addAll(backButton, searchButton);
        box.setAlignment(Pos.CENTER);
        
        
        VBox addBox = new VBox(10);
        addBox.getChildren().addAll(text,searchName, box);
        addBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(addBox);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("研究生信息查询");
        primaryStage.show();
        primaryStage.setResizable(false);
	}
}
